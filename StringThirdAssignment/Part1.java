
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
    String dna="ATGSKDTAAFGATGARYVWSDFJTAA";
    printAllGene(dna);
    
    String dna1="ATGDFERLDTAA";
   printAllGene(dna1);
   
    String dna2="ATGSDFTAASDFEATGGSDFETGA";
    printAllGene(dna2);
   
    String dna3="ATGSDTGADFGDFGTAGTAA";
    printAllGene(dna3);
    
    String dna4="ATGDFCDCFVFD";
    printAllGene(dna4);
   
     
    }

    public void printAllGene(String dna){
    int startIndex=0;
    boolean geneFound=false;  
    int dnalength=dna.length();
    while(true){
        if(startIndex==dnalength){
        break;
        }
    String gene=findGene(dna,startIndex);
       if(gene.isEmpty()){
           //System.out.println("NO GENE FOUND");
           startIndex=startIndex+1;
           }
           else{
               geneFound=true;
              System.out.println("GENE = "+gene);
              startIndex=(dna.indexOf(gene,startIndex)+gene.length());
             }
    }
    if(geneFound==false){
    System.out.println("No gene found");
    
    }
    
    } 
}
   

  