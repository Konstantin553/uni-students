package bg.nbu.students;

/**
 * Тук дефинираме нашият конструктор
 */

public class Student {
    private int id;
    private String name;
    private String program;
    private int facultyNo;

    public Student(){

    }

    public Student(int id, String name, int facultyNo, String program) {
        this.id = id;
        this.name = name;
        this.facultyNo = facultyNo;
        this.program = program;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public int getFacultyNo() {
        return facultyNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setFacultyNo(int facultyNo) {
        this.facultyNo = facultyNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", programme='" + program + '\'' +
                ", facultyNo=" + facultyNo +
                '}';
    }
}
