public class Student {
    private String FLP;

    public Student(String FLP) {
        this.FLP = FLP;
    }

    public String getFLP() {
        return FLP;
    }

    public void setFLP(String FLP) {
        this.FLP = FLP;
    }

    @Override
    public String toString() {
        return "Student{" +
                "FLP='" + FLP + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return FLP != null ? FLP.equals(student.FLP) : student.FLP == null;
    }

    @Override
    public int hashCode() {
        return FLP != null ? FLP.hashCode() : 0;
    }
}
