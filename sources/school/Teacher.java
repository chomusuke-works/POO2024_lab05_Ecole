package school;

import java.util.Arrays;

public class Teacher extends Person {
    private final String abbreviation;
    private Lesson[] lessons;
    private int lessonCount;

    public Teacher(String firstName, String lastName, String abbreviation) {
        super(firstName, lastName);
        lessonCount = 0;
        lessons = new Lesson[2];

        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", super.toString(), this.abbreviation);
    }

    public String schedule() {
        return Lesson.schedule(lessons);
    }

    void addLesson(Lesson lesson) {
        if (lessonCount == lessons.length) {
            lessons = Arrays.copyOf(lessons, lessons.length * 2);
        }

        lessons[lessonCount] = lesson;
        ++lessonCount;
    }

    @Override
    protected String getJob() {
        return "Prof.";
    }
}
