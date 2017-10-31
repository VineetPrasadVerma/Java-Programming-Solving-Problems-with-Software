
/**
 * Write a description of Part3 here.
 * 
 * @author (VINEET PRASAD VERMA) 
 * @version (a version number or a date)
 */
public class Part3 {
    public Boolean twoOccrence(String a,String b){
    int index=b.indexOf(a);
     if(index==-1){
     return false;
     }
     int currindex= b.indexOf(a,index+1); 
     if(currindex==-1){
        return false;
        }
     else{
        return true;
        }
  }
  public String lastPart(String a,String b){
    int index=b.indexOf(a);
    if(index==-1){
    return b;
    }
    else{
         return b.substring(index,b.length());
         }
    
    }
  
  
  public void testing(){
      String a="zoo";
      String b="forest";
      Boolean get=twoOccrence(a,b);
      System.out.println("the first string is" + a);
      System.out.println("the second string is" + b);
      System.out.println("ANS IS"+get);
      String lpart=lastPart(a,b);
      System.out.println("ANS IS "+lpart);
    }

}
