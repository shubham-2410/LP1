import java.util.Arrays;

public class Optimal {

    public static Boolean isPresent(int frame[], int n) {

        for (int i = 0; i < frame.length; i++) {
            if (frame[i] == n) {
                return true;
            }
        }
        return false;
    }

    public static int distance(int pages[], int frame[], int n) {

        int dist = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < frame.length; i++) {
            Boolean flag = false;
            for (int k = n; k < pages.length; k++) {

                if (pages[k] == frame[i]) {
                    flag = true;
                    if (dist < (k - n)) {
                        dist = k - n;
                        idx = i;
                    }
                    break;
                }

            }
            if (!flag) {
                return i;
            }
        }

        return idx;
    }

    public static void optimal(int fr, int pages[]) {

        int frame[] = new int[fr];
        int hit = 0;
        int miss = 0;
        int idx = 0;
        for (int i = 0; i < pages.length; i++) {

            if (isPresent(frame, pages[i])) {
                System.out.print("Hit ");
                hit++;
                continue;
            }

            if (idx < fr) {
                frame[idx] = pages[i];
                idx++;
                miss++;
                System.out.print("Miss ");
            } else {
                if (!isPresent(frame, pages[i])) {
                    int k = distance(pages, frame, i);
                    System.out.println(Arrays.toString(frame) + "  " + frame[k] + "  " + pages[i]);
                    frame[k] = pages[i];
                    miss++;
                    System.out.print("Miss ");
                }
            }
        }

        System.out.println();
        System.out.println(miss + " " + hit);
    }

    public static void main(String[] args) {

        int fr = 4;
        int pages[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };

        optimal(fr, pages);
    }
}