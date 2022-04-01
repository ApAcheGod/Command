import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;

    private List<Student> students = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }



    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public Student getStudentsWithName(String studentName) {
        return students.stream().filter(s -> s.getFLP().equals(studentName)).findFirst().get();
    }
}
