import java.util.*;

public class Priority {

    public static class Process implements Comparable<Process> {
        int at;
        int bt;
        int pr;
        int id;

        public Process(int a, int b, int p, int i) {
            at = a;
            bt = b;
            pr = p;
            id = i;
        }

        @Override
        public int compareTo(Process p) {
            if (this.pr - p.pr == 0) {
                return this.at - p.at;
            }

            return this.pr - p.pr;
        }
    }

    public static void waiting(int wt[], int tat[], Process p[]) {

        PriorityQueue<Process> pq = new PriorityQueue<>();
        for (int i = 0; i < p.length; i++) {
            pq.add(p[i]);
        }

        int tt = 0;
        int complete = 0;

        HashSet<Process> hs = new HashSet<>();
        while (complete != p.length) {

            while (!pq.isEmpty() && pq.peek().at > tt) {
                hs.add(pq.poll());
            }

            if (pq.isEmpty()) {
                for (Process a : hs) {
                    pq.add(a);
                }
                hs.clear();
                tt++;
                continue;
            }

            Process a = pq.poll();
            wt[a.id] = tt - a.at;
            System.out.println("Completed " +  a.id);
            tat[a.id] = wt[a.id] + a.bt;
            tt += a.bt;
            complete++;

            for (Process n : hs) {
                pq.add(n);
            }
            hs.clear();
        }

    }

    public static void priority(Process p[]) {
        int wt[] = new int[p.length];
        int tt[] = new int[p.length];

        waiting(wt, tt, p);

        System.out.println("AT  BT  PR  WT  TT");

        int avgTT = 0;
        int avgWT = 0;
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].at + "   " + p[i].bt + "   " + p[i].pr + "   " + wt[i] + "   " + tt[i]);
            avgTT += tt[i];
            avgWT += wt[i];
        }

        System.out.println("Avg Waiting Time : " + (double) avgWT / p.length);
        System.out.println("Avg Total Time : " + (double) avgTT / p.length);
    }

    public static void main(String args[]) {

        Process proc[] = {
                new Process(0, 3, 3, 0),
                new Process(1, 6, 4, 1),
                new Process(3, 1, 9, 2),
                new Process(2, 2, 7, 3),
                new Process(5, 4, 8, 4),
                new Process(4, 4, 8, 5),
        };
        priority(proc);
    }
}
