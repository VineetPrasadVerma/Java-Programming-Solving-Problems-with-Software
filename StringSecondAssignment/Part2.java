
/**
 * Write a description of Part2 here.
 * 
 * @author (VINEET PRASAD VERMA) 
 * @version (a version number or a date)
 */

public class Part2 {
    
    public int howMany(String a,String b){
    int alength=a.length();
    int c=0;
    int newIndex=0;
    while(true){
    int index=b.indexOf(a,newIndex);
    if(index==-1){
    break;
    }
    else{
    c++;
    newIndex=index+alength;
    }
    
    }
    return c;
    }

    public void testHowmany(){
    String a="AA";
    String b="ATAAAA";
    int count=howMany(a,b);
    System.out.println("no of times is = "+count);
    
    }
   


}
