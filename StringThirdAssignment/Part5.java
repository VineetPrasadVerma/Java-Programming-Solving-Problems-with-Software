
/**
 * Write a description of Part5 here.
 * 
 * @author (Vineet Verma) 
 * @version (a version number or a date)
 */
public class Part5 {
    public int countString(String dna,String find){
        int newIndex=0;
        int c=0;
        int flength=find.length();
        
        while(true){
            int temp=dna.indexOf(find,newIndex);
            if(temp==-1){
              break;
              }
            else{
            c++;
            newIndex=temp+flength;
            }  
         }
         return c;
    
    }
    public void test(){
    String dna="ADADCTGCTGCCTGDSDS";
    String find="CTG";
    int count=countString(dna,find);
    System.out.println("NO of times is ="+count);
    
    
    
    }
    
    
    
    
}
