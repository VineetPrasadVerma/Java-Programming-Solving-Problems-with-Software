
/**
 * Write a description of Part2 here.
 * 
 * @author (VINEET PRASAD VERMA) 
 * @version (1 SEPT 2017)
 */
public class Part2{
    public String findSimpleGene(String dna,int startcod,int stopcod){
    
    if(startcod==-1){
    return("NO GENE FOUND ");
    }
    if(stopcod==-1){
    return("NO GENE FOUND ");
    }
    if((stopcod-startcod)%3==0){
    String result;
    int d=dna.length();
    System.out.println("Length is"+d);
    result=dna.substring(startcod,stopcod+3);
    return(result);
    }
    else{
    return(" NO GENE FOUND");
    }
    }
    public void testSimpleGene(){
    String dna="FGTSEDATGDEFGERTAAFERTS";
    System.out.println("The DNA is"+dna);
    int startcod=dna.indexOf("ATG");
    int stopcod=dna.indexOf("TAA",startcod+3);
    String gene=findSimpleGene(dna,startcod,stopcod);
    System.out.println("Gene is"+gene);
    
    
    dna="ATGDETFERDET";
    System.out.println("The DNA is"+dna);
    startcod=dna.indexOf("ATG");
    stopcod=dna.indexOf("TAA",startcod+3);
    gene=findSimpleGene(dna,startcod,stopcod);
    System.out.println("Gene is"+gene);
    
    dna="ATGSIJHJHDHSDTAA";
    System.out.println("The DNA is"+dna);
    startcod=dna.indexOf("ATG");
    stopcod=dna.indexOf("TAA",startcod+3);
    gene=findSimpleGene(dna,startcod,stopcod);
    System.out.println("Gene is"+gene);
    
    dna="ATGHIHAIDHIA";
    System.out.println("The DNA is"+dna);
    startcod=dna.indexOf("ATG");
    stopcod=dna.indexOf("TAA",startcod+3);
    gene=findSimpleGene(dna,startcod,stopcod);
    System.out.println("Gene is"+gene);
  
    }
}
