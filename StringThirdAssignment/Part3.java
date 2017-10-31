import edu.duke.*;



public class Part3 {
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
  
