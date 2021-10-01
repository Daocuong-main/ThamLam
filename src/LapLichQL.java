import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LapLichQL {
    private static List<Activity> activity = new ArrayList<>();
    private static int[] actResult;
    private static boolean[] Daxet;
    private static int[] array;
    private static int max;

    static class Activity {
        int start, finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        public int getStart() {
            return start;
        }

        public int getFinish() {
            return finish;
        }

        @Override
        public String toString() {
            return "{" + start + ", " + finish + "}";
        }
    }

    public static void main(String[] args) {

        activity.add(new Activity(0, 0));
        activity.add(new Activity(1, 3));
        activity.add(new Activity(2, 5));
        activity.add(new Activity(4, 7));
        activity.add(new Activity(3, 8));
        activity.add(new Activity(5, 9));
        activity.add(new Activity(8, 10));
        activity.add(new Activity(9, 11));
        activity.add(new Activity(11, 14));
        activity.add(new Activity(13, 16));

        Daxet = new boolean[activity.size()];
        actResult = new int[activity.size()];
        array = new int[activity.size()];

        Arrays.fill(Daxet, false);
        max = 0;
        lapLich(0);
        Inlich();
    }

    public static void lapLich(int i) {
        for (int j = 1; j < activity.size(); j++) {
            if (i == 0) {
                Daxet[j] = true;
                array[i] = j;
                lapLich(i + 1);
                Daxet[j] = false;
            } else {
                if (activity.get(j).getStart() >= activity.get(array[i - 1]).getFinish() && !Daxet[j]) {
                    array[i] = j;
                    if (i > max) {
                        max = i;
                        System.arraycopy(array, 0, actResult, 0, i + 1);
                    }
                    Daxet[i] = true;
                    lapLich(i + 1);
                    Daxet[i] = false;
                }
            }
        }
    }

    public static void Inlich() {
        for (int i = 0; i <= max; i++) {
            System.out.println(activity.get(actResult[i]).getStart() + " " + activity.get(actResult[i]).getFinish());
        }
        System.out.println("So hoat dong toi da: " + (max + 1));
    }
}