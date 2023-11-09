public class FCFS {
    
    public static void util (int wt[] , int bt[] , int tt[] ){

        wt[0] = 0;

        for(int i=1 ; i<bt.length ; i++){
            wt[i] = wt[i-1]+bt[i-1];
        }

        for(int i=0 ; i<bt.length ; i++){
            tt[i]=wt[i]+bt[i];
        }
    }

    public static void fcfs (int bt[] , int at[]){

        int wt[] = new int[bt.length];
        int tt[] = new int[bt.length];

        util(wt, bt , tt);

        int avgWt =0;
        int avgTT =0;
        System.out.println("AT  BT  WT  TT");
        for(int i=0 ; i<bt.length ; i++){
            System.out.println(at[i] +"   "+bt[i]+"  "+wt[i]+"  "+tt[i]);
            avgTT+=tt[i];
            avgWt+=wt[i];
        }

        System.out.println();
        System.out.println("Avg Waiting time : " + (double)avgWt/bt.length);
        System.out.println("Avg Total time : " + (double)avgTT/bt.length);
    }
    public static void main(String[] args) {
        int bt[] ={10, 5, 8};
        int at[] ={0, 2, 3};

        fcfs(bt, at);

    }
}
