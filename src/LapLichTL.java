import java.util.*;
import java.util.Random;

class Activity {
    int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class Compare {
    static void compare(Activity arr[]) {
        Arrays.sort(arr, new Comparator<Activity>() {
            @Override
            public int compare(Activity s1, Activity s2) {
                return s1.finish - s2.finish;
            }// Sap xep tang dan (Hoat dong xong truoc xep truoc)
        });
    }
}

class LaplichTL {
    static void InLich(Activity arr[], int n) {
        Compare obj = new Compare();
        obj.compare(arr);
        System.out.println("Lich duoc chon :");
        int i = 0;
        System.out.print("(" + arr[i].start + ", " + arr[i].finish + ") ");
        for (int j = 1; j < n; j++) {
            if (arr[j].start >= arr[i].finish) {
                System.out.print("(" + arr[j].start + ", " + arr[j].finish + ") ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
//        Random rd = new Random();
        int n = 9;
        Activity arr[] = new Activity[n];
//        int start = 0;
//        int finish = 0;
//        arr[0] = new Activity(0, 0);
//        for(int i=1; i<n; i++){
//            start = rd.nextInt(100);
//            do{
//                finish = rd.nextInt(100);
//            } while(finish <= start );
//
//            arr[i] = new Activity(start, finish);;
//        }
        arr[0] = new Activity(1, 3);
        arr[1] = new Activity(2, 5);
        arr[2] = new Activity(4, 7);
        arr[3] = new Activity(3, 8);
        arr[4] = new Activity(5, 9);
        arr[5] = new Activity(8, 10);
        arr[6] = new Activity(9, 11);
        arr[7] = new Activity(11, 14);
        arr[8] = new Activity(13, 16);
        long startTime = System.currentTimeMillis();
        InLich(arr, n);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime));
    }
}