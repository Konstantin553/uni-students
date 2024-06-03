package bg.nbu.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Students_Implement implements Students_Interface {
    Connection con;
    @Override
    public void createStudent(Student stud) {
        con = DBConnection.createDBConnection();
        String query = "insert into student values(?,?,?,?)";
        try {
            //създавам statement обект с всички стойности (динамично query)
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setInt(1, stud.getId());
            pstatement.setString(2,stud.getName());
            pstatement.setString(3,stud.getProgram());
            pstatement.setInt(4, stud.getFacultyNo());
            int count = pstatement.executeUpdate();
            if (count != 0) {
                System.out.println("Student added successfully");
            }
        } catch(Exception ex){
            ex.fillInStackTrace();
        }
    }

    @Override
    public void showAllStudents() {
            con = DBConnection.createDBConnection();
            String query = "select * from student";
            System.out.println("Student details: ");
            System.out.println("-------------------------------------------------------------");
            System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "\tProgram", "\tFaculty No.");
            System.out.println("-------------------------------------------------------------");
            try {
                //тук използвам static query, само за извличане на информация
                Statement stat = con.createStatement();
                ResultSet result = stat.executeQuery(query);
                while (result.next()){//докато имаме резултат принтирай в определен формат студентите
                    System.out.format("%d\t%s\t%s\t %d\n",
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getInt(4));
                    System.out.println("-------------------------------------------------------------");
                }

            } catch(Exception ex){
                ex.fillInStackTrace();
            }
    }

    @Override
    public void showAllStudentsBasedOnID(int id) {
        con = DBConnection.createDBConnection();
        String query = "select * from student where id=" + id;
        try {
            Statement stat = con.createStatement();
            ResultSet result = stat.executeQuery(query);
            while (result.next()){
                System.out.println("-------------------------------------------------------------");
                System.out.format("%d\t%s \t%s\t %d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4));
                System.out.println("-------------------------------------------------------------");
            }
        } catch(Exception ex){
            ex.fillInStackTrace();
        }

    }

    @Override
    public void updateStudent(int id, String name, String program, int facultyNo) {
        con = DBConnection.createDBConnection();
        String query = "update student set name=?, program=?, facultyNo=? where id=?";
        try {
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setString(1,name);
            pstatement.setString(2, program);
            pstatement.setInt(3,facultyNo);
            pstatement.setInt(4, id);
            int count = pstatement.executeUpdate();
            if (count != 0) {
                System.out.println("Student details updated successfully");
            }
        }catch(Exception ex){
            ex.fillInStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        con = DBConnection.createDBConnection();
        String query = "delete from student where id=?";
        try{
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setInt(1, id);
            int count = pstatement.executeUpdate();
            if (count != 0) {
                System.out.println("Student deleted successfully "+id);
            }
        }catch (Exception ex){
            ex.fillInStackTrace();
        }
    }
}
