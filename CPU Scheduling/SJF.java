
// SJF Preemptive

public class SJF {
    public static class process {
        int at;
        int bt;
        int id;

        public process(int i, int a, int b) {
            id = i;
            at = a;
            bt = b;
        }
    }

    public static void waiting(process p[], int wt[]) {

        int rt[] = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            rt[i] = p[i].bt;
        }

        int complete = 0;
        int tt = 0;
        int minn = Integer.MAX_VALUE;
        int s = 0;
        Boolean check = false;

        while (complete != p.length) {
            for (int i = 0; i < p.length; i++) {
                if (p[i].at <= tt && (rt[i] > 0) && rt[i] < minn) {
                    s = i;
                    check = true;
                    minn = rt[i];
                }
            }
            
            if (!check) {
                tt++;
                continue;
            }

            rt[s] -= 1;
            if (rt[s] == 0) {
                check=false;
                minn = Integer.MAX_VALUE;
                complete++;
                wt[s] = tt - p[s].bt-p[s].at+1;
            }
            tt++;
        }
    }

    public static void sjf(process p[]) {

        int wt[] = new int[p.length];
        int tt[] = new int[p.length];

        waiting(p, wt);

        for (int i = 0; i < p.length; i++) {
            tt[i] = wt[i] + p[i].bt;
        }
        int avgWT = 0;
        int avgTT = 0;
        System.out.println("id  at  bt  wt  tt");
        for (int i = 0; i < wt.length; i++) {
            System.out.println(p[i].id + "   " + p[i].at + "   " + p[i].bt + "   " + wt[i] + "  " + tt[i]);
            avgTT += tt[i];
            avgWT += wt[i];
        }
        System.out.println("Avg waiting time : " + (double) avgWT / p.length);
        System.out.println("Avg turn around time : " + (double) avgTT / p.length);
    }

    public static void main(String[] args) {
        process proc[] = { new process(1, 1, 6),
                new process(2, 1, 8),
                new process(3, 2, 7),
                new process(4, 3, 3) };

        sjf(proc);
    }
}
