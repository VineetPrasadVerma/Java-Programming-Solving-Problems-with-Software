
/**
 * Write a description of Part1 here.
 * 
 * @author (VINEET PRASAD VERMA) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class Part1 {
    public String countryInfo(CSVParser parser, String fCountry){
       
            for(CSVRecord record:parser){
                String country=record.get("Country");
                if(country.contains(fCountry)){
                   String export=record.get("Exports");
                   String values=record.get("Value (dollars)");
                   String info=(country+" : "+export+" : "+values);
                   return info;
                   
                } 
            }
            String info1="NOTFOND"; 
            return info1;
                
    }
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
        for(CSVRecord record:parser){
            String export=record.get("Exports");
            if(export.contains(exportItem1)&&export.contains(exportItem2)){
                String country=record.get("Country");
                System.out.println(country);
                
            
            
            }
    
    
    
        }
    
    
    }
     public int numberOfExporters(CSVParser parser,String exportItem){
         int c=0;
         for(CSVRecord record:parser){
            String export=record.get("Exports");
            if(export.contains(exportItem)){
                String country=record.get("Country");
                c++;
                
            
            
            }
    
    
    
        }
    
        return c;
    }
    public void bigExporters(CSVParser parser,String amount){
        int length=amount.length();
        for(CSVRecord record:parser){
            String values=record.get("Value (dollars)");
            int length1=values.length();
            if(length1>length){
                String country=record.get("Country");
                System.out.println(country+": "+values);
            
            
            }
        
        
        
        }
    
    
    
    
    
    
    }
    
    public void tester(){
        FileResource fr=new FileResource( );
        CSVParser parser=fr.getCSVParser();
        String info = countryInfo(parser,"Nauru");
        System.out.println(info);
        parser=fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","diamonds");
        parser=fr.getCSVParser();
        int howMany=numberOfExporters(parser,"sugar");
        System.out.println(howMany);
        parser=fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }
    
    
    

}