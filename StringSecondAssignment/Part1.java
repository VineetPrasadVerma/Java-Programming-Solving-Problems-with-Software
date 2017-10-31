
/**
 * Write a description of Part1 here.
 * 
 * @author (VINEET PRASAD VERMA) 
 * @version (a version number or a date)
 */

public class Part1 {
    public int findStopCodon(String dna,int startIndex, String stopCodon){
    int currIndex=dna.indexOf(stopCodon,startIndex);
       while(currIndex !=-1){
            if((currIndex-startIndex)%3==0){
            return currIndex;
            }
            else{
            currIndex=dna.indexOf(stopCodon,(currIndex+1));
            }
       }
    return dna.length();
    
    }
    
  /* public void testFindCodon(){
    String dna="ABCTAAATGXYZTAADEFRGT";
    int startIndex=dna.indexOf("ATG");
    int stopIndex=findStopCodon(dna,startIndex,"TAA");
    System.out.println(dna.substring(startIndex,(stopIndex+3)));
    
    
    }*/
    public String findGene(String dna,int newStartIndex){
    int startIndex =dna.indexOf("ATG",newStartIndex);
        if(startIndex==-1){
        return "";
        }
        
    int taaIndex=findStopCodon(dna,startIndex,"TAA");
    int tagIndex=findStopCodon(dna,startIndex,"TAG");
    int tgaIndex=findStopCodon(dna,startIndex,"TGA");
    int temp=Math.min(taaIndex,tagIndex);
    int minIndex=Math.min(temp,tgaIndex);
       if(minIndex==dna.length()){
        return "";
        
        }
    return(dna.substring(startIndex,minIndex+3));     
    }
    
    public void testFindGene(){
    String dna="ATGTAA";
    int count=printAllGene(dna);
    if(count==0){
    System.out.println("NO GENE FOND");
    System.out.println("NO OF GENE ="+count);
    } 
    else{
    System.out.println("NO OF GENE ="+count);
    }
     
    }

    public int printAllGene(String dna){
    int startIndex=0,c=0;
    while(true){
    String gene=findGene(dna,startIndex);
       if(gene.isEmpty()){
       break;
       }
    System.out.println("GENE = "+gene);
    startIndex=(dna.indexOf(gene,startIndex)+gene.length());
    c++;
    }
    return c;
    } 
}
   

   



