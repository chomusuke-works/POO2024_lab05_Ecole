package school;

import java.util.*;

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

		if (professeur != null) {
			professeur.addLesson(this);
		}
	}

	public static String schedule(Lesson ... lessons) {
		final String timeWhitespace = " ".repeat(5);
		final String rowSeparator = "-".repeat(13);
		final String[] periodTimes = {
			" 8:30",
			" 9:15",
			"10:25",
			"11:15",
			"12:00",
			"13:15",
			"14:00",
			"14:55",
			"15:45",
			"16:35",
			"17:20",
		};

		final String[] days = {
			"Lun",
			"Mar",
			"Mer",
			"Jeu",
			"Ven",
		};

		List<List<String>> scheduleColumns = new ArrayList<>(days.length);
		for (String day : days) {
			scheduleColumns.add(new LinkedList<>(List.of(
				String.format(" %-12s", day),
				rowSeparator
			)));
		}

		List<String> periodTimesColumn = new LinkedList<>(List.of(timeWhitespace, timeWhitespace));
		for (String periodTime : periodTimes) {
			periodTimesColumn.add(periodTime);
			periodTimesColumn.add(timeWhitespace);
		}

		var sortedLessons = daySort(lessons);

		int[] nextTreatedPeriod = new int[days.length];
		for (int dayIdx = 0; dayIdx < sortedLessons.size(); ++dayIdx) {
			List<Lesson> day = sortedLessons.get(dayIdx);
			List<String> dayStringColumn = scheduleColumns.get(dayIdx);

			for (Lesson lesson : day) {

				// Fill in empty periods
				while (nextTreatedPeriod[dayIdx] < lesson.startPeriod) {
					dayStringColumn.add(periodText(null));
					dayStringColumn.add(rowSeparator);

					++nextTreatedPeriod[dayIdx];
				}

				dayStringColumn.add(periodText(lesson));
				for (int i = 0; i < 2*(lesson.duration-1); ++i) {
					dayStringColumn.add(periodText(null));
					if (i % 2 == 0) {
						++nextTreatedPeriod[dayIdx];
					}
				}

				dayStringColumn.add(rowSeparator);
			}

			// Complete the day
			while (nextTreatedPeriod[dayIdx] < periodTimes.length) {
				dayStringColumn.add(periodText(null));
				dayStringColumn.add(rowSeparator);

				++nextTreatedPeriod[dayIdx];
			}
		}

		StringBuilder schedule = new StringBuilder();

		for (int i = 0; i < periodTimesColumn.size(); ++i) {
			schedule.append(periodTimesColumn.get(i)).append('|');
			for (List<String> row : scheduleColumns) {
				schedule.append(row.get(i)).append('|');
			}
			schedule.append('\n');
		}

		return schedule.toString();
	}

	private static List<List<Lesson>> daySort(Lesson... lessons) {
		final List<List<Lesson>> week = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			week.add(new ArrayList<>());
		}

		for (Lesson lesson : lessons) {
			List<Lesson> day = week.get(lesson.weekDay);
			int i = 0;
			while (i < day.size() && day.get(i).startPeriod < lesson.startPeriod) {
				++i;
			}

			if (i == day.size()) {
				day.add(lesson);
			} else {
				day.add(i, lesson);
			}
		}

		return week;
	}

	private static String periodText(Lesson lesson) {
		String subject;
		String classroom;
		String teacher;

		if (lesson == null) {
			subject = classroom = teacher = "";
		} else {
			subject = lesson.subject;
			classroom = lesson.classroom;

			if (lesson.professeur == null) {
				teacher = "";
			} else {
				teacher = lesson.professeur.getAbbreviation();
			}
		}

		return String.format("%3s   %3s %3s", subject, classroom, teacher);
	}
}
