
/**
 * Write a description of Part6 here.
 * 
 * @author (VINEET VERMA) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part6 {
    public void processGenes(StorageResource sr){
        int c=0,flag=0,tempLength=0;
        for(String g:sr.data()){
            
            if(g.length()>60){
                
                System.out.println(g);
                c++;
            }
            float tempRatio = cgRatio(g);
            if(tempRatio > 0.35){
                
                System.out.println(g);
                flag++;
            }
            int temp1Length=g.length();
            if(temp1Length>tempLength){
                tempLength=temp1Length;
            }
            
        }
    
        System.out.println("NO OF STRINGS WHOSE LENGTH IS HIGHER THAN 60 IS " +c);
        System.out.println("NO OF STRINGS WHOSE RAtIO IS HIGHER THAN 0.35 IS " +flag);
        System.out.println(" STRINGS WHOSE LENGTH IS MAXIUMUM " +tempLength);
    
    
    }
    
    
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
    
    public void testProcessGene(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
       
         StorageResource geneList=getAllGene(dna);
         
         
       
       /*dna="CCCCGGG";
       geneList.add(dna);
       
       dna="ASDCCCCGGG";
       geneList.add(dna);
      
       dna="CGG";
       geneList.add(dna);
     
       dna="CGGFJHKDHOHFDOHFO";
       geneList.add(dna);
    */   processGenes(geneList);

       
    }
    

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
    StorageResource gene=getAllGene(dna);
    for(String g: gene.data()){
    System.out.println(g);
    
    }
    
   String dna1="ATGDFERLDTAA";
   gene=getAllGene(dna1);
    for(String g: gene.data()){
    System.out.println(g);
    
    }
   
   
    String dna2="ATGSDFTAASDFEATGGSDFETGA";
    gene=getAllGene(dna2);
    for(String g: gene.data()){
    System.out.println(g);
    
    }
   
    String dna3="ATGSDTGADFGDFGTAGTAA";
     gene=getAllGene(dna3);
    for(String g: gene.data()){
    System.out.println(g);
    
    }
    
    String dna4="ATGDFCDCFVFD";
    gene=getAllGene(dna4);
    for(String g: gene.data()){
    System.out.println(g);
    
    }
     
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
              //System.out.println("GENE = "+gene);
              startIndex=(dna.indexOf(gene,startIndex)+gene.length());
             }
    }
    if(geneFound==false){
    System.out.println("No gene found");
    }
}
    public StorageResource getAllGene(String dna){
        StorageResource geneList=new StorageResource();
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
                      geneList.add(gene); 
                      geneFound=true;
                     // System.out.println("GENE = "+gene);
                      startIndex=(dna.indexOf(gene,startIndex)+gene.length());
                   }
        }
        if(geneFound==false){
        System.out.println("No gene found");
        }
        return geneList;

    } 
}