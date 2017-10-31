
/**
 * Write a description of Part2 here.
 * 
 * @author (VINEET VERMA) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Part2 {
    public CSVRecord coldestHourInFile(CSVParser parser){
        
        CSVRecord lowestSoFar= null;
        for(CSVRecord currentRow : parser){
            lowestSoFar= getLowestOfTwo(currentRow,lowestSoFar);
        }      
        
        return lowestSoFar;
    }
    
    public void testColdHourInFile(){
        
        FileResource fr= new FileResource();
        CSVParser parser= fr.getCSVParser();
        CSVRecord lowest= coldestHourInFile(parser);
        System.out.println("LOWEST TEPERATURE WAS " +lowest.get("TemperatureF")+ " at " +lowest.get("DateUTC"));
    
    
    }
    
    public  String fileWithColdestTemperature()throws IOException {
        
        CSVRecord lowestSoFar= null;
        DirectoryResource dr= new DirectoryResource();
        String lowestTempFileName= null;
        double minTemp=Double.MAX_VALUE;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow= coldestHourInFile(fr.getCSVParser());
            double currentTemp= Double.parseDouble(currentRow.get("TemperatureF"));
            if(currentTemp<minTemp){
                    minTemp= currentTemp;
                    lowestTempFileName= f.getCanonicalPath();
            }     
        }
        return lowestTempFileName;
    }
    
    public CSVRecord getLowestOfTwo(CSVRecord currentRow, CSVRecord lowestSoFar){
        
        if(lowestSoFar== null){
                lowestSoFar= currentRow;
            }
        else{
                double currentTemp= Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp= Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if(currentTemp!=-9999 && lowestTemp!=-9999 && currentTemp<lowestTemp ){
                    lowestSoFar= currentRow;
                }
        }
        return lowestSoFar; 
    }
    
    public void  testFileWithColdestTemperature ()throws IOException{
        
        String fName= fileWithColdestTemperature();    
        FileResource fr= new FileResource(fName);
        CSVParser parser= fr.getCSVParser();
        CSVRecord lowest= coldestHourInFile(parser);
        System.out.println("LOWEST TEMPERATURE WAS " +lowest.get("TemperatureF")+ " at " +lowest.get("TimeEST"));
        System.out.println("COLDEST TEMPERATURE WAS IN FILE" +fName);
        parser= fr.getCSVParser();
        for(CSVRecord record: parser){
            
            System.out.println(record.get("TemperatureF")+ " " +record.get("DateUTC"));
        }
        
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
       
        CSVRecord lowestSoFar= null;
        for(CSVRecord currentRow : parser){
           if(lowestSoFar== null){
                lowestSoFar= currentRow;
            }
           else{
                String tempCurrentHumidity= currentRow.get("Humidity");
                if(tempCurrentHumidity.contains("N/A")){
                   continue;
                }
                double currentHumidity= Double.parseDouble(tempCurrentHumidity);
                double lowestHumidity= Double.parseDouble(lowestSoFar.get("Humidity"));
                if(currentHumidity < lowestHumidity ){
                    lowestSoFar= currentRow;
                }
           }
     
        }      
        
        return lowestSoFar;
    }
    
    public CSVRecord lowestHumidityInManyFile(){
        
        CSVRecord lowestSoFar= null; 
        DirectoryResource dr= new DirectoryResource();
        for(File f : dr.selectedFiles()){
            
            FileResource fr= new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            
            for(CSVRecord currentRow : parser){
               if(lowestSoFar== null){
                    lowestSoFar= currentRow;
               }
               else{
                    String tempCurrentHumidity= currentRow.get("Humidity");
                    if(tempCurrentHumidity.contains("N/A")){
                        continue;
                    }
                    double currentHumidity= Double.parseDouble(currentRow.get("Humidity"));
                    double lowestHumidity= Double.parseDouble(lowestSoFar.get("Humidity"));
                    if(currentHumidity < lowestHumidity ){
                        lowestSoFar= currentRow;
                    }
               }
         
            }
        }
        
        return lowestSoFar;
    }
    
    public void testLowestHumidityInFile(){
       
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord record = lowestHumidityInFile(parser);
        System.out.println("LOWEST HUMIDITY WAS "+record.get("Humidity")+ "AT " +record.get("DateUTC"));
    }
    
      
    public void testLowestHumidityInManyFile(){
        CSVRecord record = lowestHumidityInManyFile();
        System.out.println("LOWEST HUMIDITY WAS "+record.get("Humidity")+ "AT " +record.get("DateUTC"));
    }
    
    public double averageTemperatureInFile(CSVParser parser){
        double averageTemperature=0;
        int c=0;
        for(CSVRecord currentRow: parser){
           
            double currentTemp= Double.parseDouble(currentRow.get("TemperatureF"));
            averageTemperature=averageTemperature+currentTemp;
            c++;
        }
        averageTemperature= (averageTemperature/c);
        
        return averageTemperature;   
    }
  
    public void testAverageTemperatureInFile(){
    
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemperature= averageTemperatureInFile(parser);
        System.out.println("AVERAGE TEMPERATURE IN FILE IS"+averageTemperature);
    
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){
    
        double averageTemperature=0.0;
        int c=0;
        for(CSVRecord currentRow: parser){
           
            double currentTemp= Double.parseDouble(currentRow.get("TemperatureF"));
            double currentHumidity= Double.parseDouble(currentRow.get("Humidity"));
            if(currentHumidity >= value){
                averageTemperature=averageTemperature+currentTemp;
                c++;
            }
            
        }
        if(averageTemperature==0.0){
           return 0;
        }
        else{
           averageTemperature= (averageTemperature/c);
        }
        return averageTemperature;
         
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
    
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int value=80;
        double averageTemperature= averageTemperatureWithHighHumidityInFile(parser,value);
        if(averageTemperature==0.0){
            System.out.println("NO TEMPERATURE WITH THAT HUMIDITY");
        }
        else{
            System.out.println("AVERAGE TEMPERATURE WHEN HIGH HUMIDITY IS"+averageTemperature);
        }
    }
    
}
