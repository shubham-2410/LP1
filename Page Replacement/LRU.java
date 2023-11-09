import java.util.*;

public class LRU {
    public static void lru( int fr , int pages[]){

        HashMap <Integer , Integer> hm = new HashMap<>();
        HashSet <Integer> hs = new HashSet<>();

        int miss=0;
        int hit=0;
        for(int i=0 ; i<pages.length ; i++){

            if(hs.size()<fr){
                if(!hs.contains(pages[i])){
                    hs.add(pages[i]);

                    System.out.print("Miss ");
                    miss++;
                }
                else{
                    System.out.print("Hit ");
                    hit++;
                }
                hm.put(pages[i] , i);
            }
            else{
                if(!hs.contains(pages[i])){
                    
                    int idx=Integer.MAX_VALUE;
                    int temp=0;
                    for (Integer key : hm.keySet()) {
                        if(idx>hm.get(key)){
                            idx=hm.get(key);
                            temp=key;
                        }
                    }

                    hs.remove(temp);
                    hm.remove(temp);
                    hs.add(pages[i]);
                    System.out.print("Miss ");
                    miss++;
                }
                else{
                    System.out.print("Hit ");
                    hit++;
                }
                hm.put(pages[i] , i);
            }
            
        }

        System.out.println();
        System.out.println( miss + " "+hit);

    }

    public static void main(String[] args) {
        
        int fr=4;
        int pages[]={7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        lru(fr, pages);
    }

}
