package school;

import school.people.Professeur;

import java.util.List;

public class Lesson {
	private final String subject;
	private final int weekDay;
	private final int startPeriod;
	private final int duration;
	private final String classroom;

	private final Professeur professeur;

	public Lesson(String subject, int weekDay, int startPeriod, int duration, String classroom, Professeur professeur) {
		this.subject = subject;
		this.weekDay = weekDay;
		this.startPeriod = startPeriod;
		this.duration = duration;
		this.classroom = classroom;

		this.professeur = professeur;
	}

	public String schedule() {
		return "";
	}

	public static Lesson getLessonAt(List<Lesson> lessons, int weekDay, int period) {
		for (Lesson lesson : lessons) {
			if (lesson.weekDay == weekDay && lesson.startPeriod <= period && lesson.startPeriod + lesson.duration - 1 >= period) {
				return lesson;
			}
		}

		return null;
	}
}
