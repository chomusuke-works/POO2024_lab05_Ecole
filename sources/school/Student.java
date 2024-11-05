package school;

public class Student extends Person {
    private int number;
    private Group group;

    Student(String firstName, String lastName, int number, Group group) {
        super(firstName, lastName);

        this.number = number;
        this.group = group;
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
