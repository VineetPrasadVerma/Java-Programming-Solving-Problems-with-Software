
/**
 * Write a description of Part4 here.
 * 
 * @author (VINEET VERMA) 
 * @version (a version number or a date)
 */
    public class Part4 {
        public float cgRatio(String dna){
             float dnaLength=dna.length();
             int c=0;
             int newIndex=0;
             int newIndex1=0;
            while(true){
             int temp=dna.indexOf("C",newIndex1);
             if(temp==-1){
              int temp1=dna.indexOf("G",newIndex);
              if(temp1==-1){
                   break;
              } 
              else{
                  c++;
                  newIndex=temp1+1;
              }
             
            }
            else{
                 
                 c++;
                 newIndex1=temp+1;
                 
            }
            }
            float ratio=c/dnaLength;
            return ratio;
            }
        
            public void test(){
            String dna="ATGCCATAG";
            float ratio=cgRatio(dna);
            System.out.print(ratio);
        
            }   
        }