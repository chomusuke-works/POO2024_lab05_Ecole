package school;

public class Lesson {
	private final String subject;
	private final int weekDay;
	private final int startPeriod;
	private final int duration;
	private final String classroom;

	private final Teacher professeur;

	public Lesson(String subject, int weekDay, int startPeriod, int duration, String classroom, Teacher professeur) {
		this.subject = subject;
		this.weekDay = weekDay;
		this.startPeriod = startPeriod;
		this.duration = duration;
		this.classroom = classroom;

		this.professeur = professeur;
	}

	public static String schedule(Lesson ... lessons) {
		return "";
	}
}
