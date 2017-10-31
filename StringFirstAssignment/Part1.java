
/**
 * Write a description of Part1 here.
 * 
 * @author (VINEET PRASAD VERMA) 
 * @version (1 SEPT 2017)
 */
public class Part1{
    public String findSimpleGene(String dna){
    int start=dna.indexOf("ATG");
    if(start==-1){
    return("NO GENE FOUND ");
    }
    int stop=dna.indexOf("TAA",start+3);
    if(stop==-1){
    return("NO GENE FOUND ");
    }
    if((stop-start)%3==0){
    String result;
    result=dna.substring(start,stop+3);
    return(result);
    }
    else{
    return(" NO GENE FOUND");
    }
    }
    public void testSimpleGene(){
    String dna="SEDTATGDEFGEFDEFRGETAAXY";
    System.out.println("The DNA is"+dna);
    String gene=findSimpleGene(dna);
    System.out.println("Gene is"+gene);
    
     dna="ATGDEFGRTGTAA";
    System.out.println("The DNA is"+dna);
    gene=findSimpleGene(dna);
    System.out.println("Gene is"+gene);
    
     dna="SEDFERRDSETAA";
    System.out.println("The DNA is"+dna);
    gene=findSimpleGene(dna);
    System.out.println("Gene is"+gene);
    
    dna="SEATGDEFTRE";
    System.out.println("The DNA is"+dna);
    gene=findSimpleGene(dna);
    System.out.println("Gene is"+gene);
    }
}
