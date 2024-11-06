package school;

public class Student extends Person {
    private final int number;
    Group group;

    public Student(String firstName, String lastName, int number, Group group) {
        super(firstName, lastName);

        this.number = number;
        this.group = group;
    }

    public Student(String firstName, String lastName, int number) {
        this(firstName, lastName, number, null);
    }

    @Override
    protected String getJob() {
        return "Etud.";
    }

    @Override
    public String toString() {
        return String.format("%s (#%d) - %s", super.toString(), this.number, this.group.name());
    }
}
