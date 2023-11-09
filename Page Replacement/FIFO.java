
import java.util.*;

public class FIFO {

    public static void fifo(int fr, int pages[]) {

        HashSet<Integer> hs = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();

        int hit = 0;
        int miss = 0;

        for (int i = 0; i < pages.length; i++) {

            if (hs.size() < fr) {
                if (!hs.contains(pages[i])) {
                    hs.add(pages[i]);
                    System.out.print("Miss ");
                    miss++;
                    q.add(pages[i]);
                }
                else{
                    System.out.print("Hit ");
                    hit++;
                }
            }
            else{
                if(!hs.contains(pages[i])){
                    miss++;
                    System.out.print("Miss ");

                    int k =q.poll();
                    hs.remove(k);
                    
                    hs.add(pages[i]);
                    q.add(pages[i]);
                }
                else{
                    System.out.print("Hit ");
                    hit++;
                }
            }

        }
        System.out.println();
        System.out.println( miss + " "+hit);

    }

    public static void main(String[] args) {

        int fr = 4;
        int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};

        fifo(fr, pages);
    }
}
