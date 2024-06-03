package bg.nbu.students;

import java.util.Scanner;

/**
 * Конзолно базирана апликация
 * В случая, ще използвам  do...while цикъл тъй като повтарям даден statement многократно
 */

public class Main {
    public static void main(String[] args) {
        int id;
        String name;
        String program;
        int facultyNo;

        Students_Implement intface = new Students_Implement();
        System.out.println("Welcome to Students management application");

        Scanner scan = new Scanner(System.in);//прочитаме входа
        do {
            System.out.println("1. Add Student\n" +
                    "2. Show All Students\n" +
                    "3. Show Student based on id\n" +
                    "4. Update the Studen\n" +
                    "5. Delete the Student\n");

            System.out.println("Enter choice: ");
            int choice = scan.nextInt();//прочитаме вход примитивен тип integer
            switch(choice){
                case 1:
                    Student stud = new Student();
                    System.out.println("Enter ID: ");
                    id = scan.nextInt();
                    System.out.println("Enter name: ");
                    name = scan.next();
                    System.out.println("Enter Program: ");
                    program = scan.next();
                    System.out.println("Enter Faculty Number: ");
                    facultyNo = scan.nextInt();
                    stud.setId(id);
                    stud.setName(name);
                    stud.setProgram(program);
                    stud.setFacultyNo(facultyNo);
                    intface.createStudent(stud);
                    break;
                case 2:
                    intface.showAllStudents();
                    break;
                case 3:
                    System.out.println("Enter id to show details: ");
                    int studId = scan.nextInt();
                    intface.showAllStudentsBasedOnID(studId);//прочитаме подаденото id
                case 4:
                    System.out.println("Enter id to update student details: ");
                    int studId1 = scan.nextInt();
                    System.out.println("Enter name: ");
                    name = scan.next();
                    System.out.println("Enter program: ");
                    program = scan.next();
                    System.out.println("Enter Faculty Number: ");
                    facultyNo = scan.nextInt();
                    intface.updateStudent(studId1, name, program, facultyNo);
                case 5:
                    System.out.println("Enter id to delete");
                    id = scan.nextInt();
                    intface.deleteStudent(id);
                case 6:
                    System.out.println("Thank you for using the Application!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice!");
                    break;
            }

        } while(true);

    }
}
