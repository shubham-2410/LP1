public class FirstFit {
    
    public static void ff(int process[] , int memory[]){

        int idx[] = new int[process.length];
        for(int i=0 ; i<process.length ; i++){
            idx[i]=-1;
        }

        for(int i=0 ; i<process.length ; i++){

            for(int j=0; j<memory.length ; j++){
                
                if(memory[j] >=process[i]){
                    idx[i]=j+1;
                    memory[j]-=process[i];
                    break;
                }
            }

        }

        System.out.println("ID Process Block");
        for(int i=0 ; i<process.length ; i++){
            System.out.print( i + "  "+process[i]+"     ");
            if(idx[i]!=-1){
                System.out.println(idx[i]);
            }
            else{
                System.out.println("NO");
            }
        }

    }


    public static void main(String[] args) {
        
        int memory[] = {100, 500, 200, 300, 600}; 
        int process[] =  {212, 417, 112, 426}; 

        ff(process, memory);
    }
}
