package school;

import java.util.List;

public class Horaire {
    private final static char verticalSeparator = '|';
    private final static char horizontalSeparator = '-';
    private final static String[] periodTimes = {
        "8:30",
        "9:15",
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
    private final static String[] days = {
        "Lun",
        "Mar",
        "Mer",
        "Jeu",
        "Ven",
    };

    public static String get(List<Lesson> lessons) {
        StringBuilder sb = new StringBuilder();

        // Day header
        sb.append(String.format("%5s%c", "", verticalSeparator));
        for (String day : days) {
            sb.append(String.format(" %-12s%c", day, verticalSeparator));
        }
        sb.append("\n");

        // Header separator
        sb.append(String.format("%5s%c", "", verticalSeparator));
        for (String day : days) {
            sb.append(String.format("%13s%c", String.valueOf(horizontalSeparator).repeat(13), verticalSeparator));
        }
        sb.append("\n");

        for (int i = 0; i < periodTimes.length; i++) {
            // Lessons
            sb.append(String.format("%5s%c", periodTimes[i], verticalSeparator));
            for (int j = 0; j < days.length; j++) {
                Lesson lesson = Lesson.getLessonAt(lessons, j + 1, i + 1);
                sb.append(String.format("%13s%c", lesson == null ? "" : lesson, verticalSeparator));
            }
            sb.append("\n");

            // Lessons separator
            sb.append(String.format("%5s%c", "", verticalSeparator));
            for (int j = 0; j < days.length; j++) {
                Lesson lesson = Lesson.getLessonAt(lessons, j + 1, i + 1);
                Lesson nextLesson = Lesson.getLessonAt(lessons, j + 1, i + 2);
                sb.append(String.format("%13s%c", lesson != null && lesson == nextLesson ? "" : String.valueOf(horizontalSeparator).repeat(13), verticalSeparator));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
