
/**
 * Write a description of BabyBirths here.
 * 
 * @author (VINEET VERMA) 
 * @version (a version number or a date)
 */
import org.apache.commons.csv.*;
import java.io.*;
import edu.duke.*;
public class BabyBirths {
    public void totalBirths(CSVParser parser ){
        
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int countNames = 0;       
        for(CSVRecord rec : parser){
        
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if(rec.get(1).equals("M")){
            
                totalBoys += numBorn;
                System.out.println("BOY NAME = " +rec.get(0));
            }
            else{
            
                totalGirls += numBorn;
                System.out.println("GIRL NAME = " +rec.get(0));
            }
            
            
            countNames++;
        }
        
        System.out.println("total births = "+totalBirths);
        System.out.println("total boys =" +totalBoys);
        System.out.println("total girls =" +totalGirls);
        System.out.println("total names =" +countNames);
    }
    
    public void testTotalBirths(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser(false);
    totalBirths(parser);
    }
    
    public int getRank(int year,String name,String Gender){
    
        int fRank = 0;
        int mRank = 0;
        
        String fName=getFileNameFromYear(year);
        FileResource fr = new FileResource(fName);
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec : parser){
        
            String rName = rec.get(0);
            String rGender = rec.get(1);
            if(rGender.equals("F")){
            
                fRank++;
                if(rName.equals(name)&&rGender.equals(Gender)){
                 
                    return fRank;
                   
                }
                else{
                
                    continue;
                }
            }
            else{
            
                mRank++;
                if(rName.equals(name)&&rGender.equals(Gender)){
                 
                    return mRank;
                    
                }
                else{
                
                    continue;
                }
            }
        } 
        return -1;
    }
    
    public void testGetRank(){
        
        int rank=getRank(2012,"Mason","M");
        System.out.println("RANK = "+rank);
    
    
    }
    
    public String getName(int year,int rank,String Gender){
    
        int fRank = 0;
        int mRank = 0;
        String fName=getFileNameFromYear(year);
        FileResource fr = new FileResource(fName);
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec : parser){
            String rGender = rec.get(1);
            if(rGender.equals("F")){
            
                fRank++;
                if(fRank == rank && rGender.equals(Gender)){
                 
                   String rName = rec.get(0);
                   return rName;
                   
                }
                else{
                
                    continue;
                }
            }
            else{
            
                mRank++;
                if(mRank == rank && rGender.equals(Gender)){
                 
                   String rName = rec.get(0);
                   return rName;
                   
                    
                }
                else{
                
                    continue;
                }
            }
        }
     
        return ("NO NAME");
    }
    
    
    public void testGetName(){
        
        String name=getName(2012,2,"M");
        System.out.println("NAME = "+name);
    
    
    }
    
    public void whatIsNameInYear(String name,int year,int newYear,String gender){
    
        int rank = getRank(year,name,gender);
        String newName =getName(newYear,rank,gender);
        System.out.print(name+ " born in "+year+ " would be "+newName+" if she was born in "+newYear);
        
        
    }
    
    public void testwhatIsNameInYear(){
     
        whatIsNameInYear("Isabella",2012,2014,"F");
    
    }
    
    public int yearOfHighestRank(String name,String gender){
        int maxRank=Integer.MIN_VALUE;
        int maxRankYear=-1;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            String tempFileName=f.getName();
            int year =  Integer.parseInt(tempFileName.substring(3,7));
            int rank =getRank(year,name,gender);
            if(maxRank<rank){
            
                maxRank=rank;
                maxRankYear=year;
            }
            
        
        
        }
                   
        return maxRankYear;
    }    
        
    public void testYearOfHighestRank(){
        int year = yearOfHighestRank("Mason","M");
        System.out.println("Highest rank in " +year );
    }
    
    public double getAverageRank(String name,String gender){
    
        double rank=0.0;
        int count=0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            String tempFileName=f.getName();
            int year =  Integer.parseInt(tempFileName.substring(3,7));
            double getRank =getRank(year,name,gender);
            rank +=getRank;
            count++;
        }
        double averageRank = rank/count;
        return averageRank;
    }  
    
    public void testGetAverageRank(){
    
        double averageRank = getAverageRank("Jacob","M");
        System.out.println("average rank is "+averageRank);
    
    }
    
    public int getTotalBirthsRankedHigher(String name,String gender){
        int sumNumBorn=0; 
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec : parser){
            String rName = rec.get(0);
            String rGender = rec.get(1);
            int numBorn =Integer.parseInt( rec.get(2));
            if(rGender.equals(gender)){
            
                if(!rName.equals(name)){
                 
                   sumNumBorn +=numBorn;
                   
                }
                else{
                   break;
                }
             
            }
         
        }
     
        return sumNumBorn; 
        
    
    
    }
    
    public void testGetTotalBirthsRankedHigher(){
    
        int totalBirthsRankedHigher=getTotalBirthsRankedHigher("Ethan","M");
        System.out.println("Total Births Ranked Higher is"+totalBirthsRankedHigher);
    }
    
    
    
    
    public String getFileNameFromYear(int year){
        return "yob"+year+"short.csv";
    }
    
}
