package bg.nbu.students;

/**
 * Тук дефинираме всички CRUD операции които ще имплементираме в класа
 */

public interface Students_Interface {
        //create student
        public void createStudent(Student stud);
        //show all students
        public void showAllStudents();
        //show student based on id
        public void showAllStudentsBasedOnID(int id);
        //update student
        public void updateStudent(int id, String name, String program, int facultyNo);
        //delete student
        public void deleteStudent(int id);
}
