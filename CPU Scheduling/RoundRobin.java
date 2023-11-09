public class RoundRobin {

    public static void waiting(int bt[], int wt[], int q) {

        int rem_bt[] = new int[bt.length];

        for (int i = 0; i < bt.length; i++) {
            rem_bt[i] = bt[i];
        }

        Boolean flag = true;
        int tt = 0;
        while (true) {
            flag = true;

            for (int i = 0; i < bt.length; i++) {

                if (rem_bt[i] != 0) {
                    if (rem_bt[i] > q) {
                        flag = false;
                        rem_bt[i] = rem_bt[i] - q;
                        tt += q;
                    } else {
                        tt += rem_bt[i];
                        rem_bt[i] = 0;
                        wt[i] = tt - bt[i];
                    }
                }
            }

            if(flag){
                break;
            }
        }

    }

    public static void rr(int at[], int bt[], int q) {

        int wt[] = new int[bt.length];
        int tt[] = new int[bt.length];

        waiting(bt, wt, q);

        for(int i=0 ; i<bt.length ; i++){
            tt[i] = wt[i] + bt[i];
        }

        System.out.println("AT  BT  WT  TT");

        int avgTT =0;
        int avgWT =0;
        for(int i=0 ; i<bt.length ; i++){
            System.out.println(at[i] +"   "+bt[i]+" "+wt[i]+"  "+tt[i]);
            avgTT+=tt[i];
            avgWT+=wt[i];
        }

        System.out.println("Avg Waiting Time : " + (double)avgWT/bt.length);
        System.out.println("Avg Total Time : " + (double)avgTT/bt.length);

    }

    public static void main(String[] args) {

        int at[] = {1, 2, 3};
        int bt[] = {10, 5, 8};
        int quantum = 2;
        rr(at, bt, quantum);
    }
}
