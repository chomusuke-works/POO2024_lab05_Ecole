package school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {
	private final int number;
	private final String orientation;
	private final int quarter;
	private final List<Student> students = new ArrayList<>();
	private Lesson[] lessons;

	public Group(int number, String orientation, int quarter, Student... students) {
		if (students.length < 1) {
			throw new IllegalArgumentException("A group must have at least one student");
		}

		this.number = number;
		this.orientation = orientation;
		this.quarter = quarter;

		for (Student student : students) {
			if (student.group != null) {
				throw new RuntimeException("The student " + student + " already has a group.");
			}

			this.students.add(student);
			student.group = this;
		}

		this.students.addAll(Arrays.asList(students));
	}

	public String schedule() {
		return Lesson.schedule(lessons);
	}

	public String name() {
		return String.format("%s%d-%d", orientation, quarter, number);
	}

	public int studentCount() {
		return students.size();
	}

	public void defineLessons(Lesson ... args) {
		lessons = Arrays.copyOf(args, args.length);
	}
}
