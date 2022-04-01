import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Receiver {

    private List<Group> groups = Arrays.asList(new Group("ЭМА-18-1"), new Group("ЭМА-18-2"));

    public List<Group> getGroups() {
        return groups;
    }

    public void create(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Доступные группы: ");
            groups.forEach(g -> System.out.print(g.getName() + " "));
            System.out.println();
            System.out.println("Введите данные студента: ");
            Student student = new Student(br.readLine());
            System.out.println("В какую группу отнести студента: ");
            String groupTarget = br.readLine();
            groups
                    .stream()
                    .filter(g -> g.getName().toLowerCase(Locale.ROOT).equals(groupTarget.toLowerCase(Locale.ROOT)))
                    .findFirst()
                    .get()
                    .addStudent(student);
            System.out.println("Студент " + student.getFLP() + " добавлен");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copy(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Доступные группы: ");
            groups.forEach(g -> System.out.print(g.getName() + " "));
            System.out.println();
            System.out.println("Группа студента: ");
            String groupSource = br.readLine();
            System.out.println("Введите данные студента: ");
            String student = br.readLine();
            System.out.println("В какую группу скопировать данные студента: ");
            String groupTarget = br.readLine();

            groups
                    .stream()
                    .filter(g -> g.getName().toLowerCase(Locale.ROOT).equals(groupTarget.toLowerCase(Locale.ROOT)))
                    .findFirst()
                    .get()
                    .addStudent(
                            groups.stream()
                            .filter(g -> g.getName().toLowerCase(Locale.ROOT).equals(groupSource.toLowerCase(Locale.ROOT)))
                            .findFirst()
                            .get()
                            .getStudents()
                            .stream()
                            .filter(s -> s.getFLP().equals(student))
                            .findFirst()
                            .get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rebase(){

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Доступные группы: ");
            groups.forEach(g -> System.out.print(g.getName() + " "));
            System.out.println();
            System.out.println("Группа студента: ");
            String groupSource = br.readLine();
            System.out.println("Введите данные студента: ");
            String student = br.readLine();
            System.out.println("В какую группу скопировать данные студента: ");
            String groupTarget = br.readLine();

            Group group = groups.stream()
                            .filter(g -> g.getName().toLowerCase(Locale.ROOT).equals(groupSource.toLowerCase(Locale.ROOT)))
                                    .findFirst().get();

            Student rebasedStudent = group
                    .getStudents()
                    .stream()
                    .filter(s -> s.getFLP().equals(student)).findFirst()
                    .get();

            group.deleteStudent(rebasedStudent);

            groups
                    .stream()
                    .filter(g -> g.getName().toLowerCase(Locale.ROOT).equals(groupTarget.toLowerCase(Locale.ROOT)))
                    .findFirst()
                    .get()
                    .addStudent(rebasedStudent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Доступные группы: ");
            groups.forEach(g -> System.out.print(g.getName() + " "));
            System.out.println();
            System.out.println("Введите данные студента: ");
            Student student = new Student(br.readLine());
            System.out.println("Из какой группы удалить студента: ");
            String groupName = br.readLine();
            Group group = groups
                    .stream()
                    .filter(g -> g.getName().toLowerCase(Locale.ROOT).equals(groupName.toLowerCase(Locale.ROOT)))
                    .findFirst()
                    .get();

            group.deleteStudent(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
