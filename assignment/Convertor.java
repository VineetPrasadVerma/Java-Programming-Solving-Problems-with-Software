
/**
 * Write a description of Convertor here.
 * 
 * @author (PRATEEK SINGH KUSHWAH)
 * @version (27-08-2017)
 */


import edu.duke.*;
import java.io.*;
public class Convertor {
    public ImageResource makeGray(ImageResource inImage){
    ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());
    for(Pixel pixel:outImage.pixels()){
    Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());
    int average=(inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
    pixel.setRed(average);
    pixel.setGreen(average);
    pixel.setBlue(average);
    }
    return outImage;
    }
    
    public void selectAndConv(){
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles()){
    ImageResource inImage=new ImageResource(f);
     ImageResource gray=makeGray(inImage);
    String fname=inImage.getFileName();
    String newName="gray-"+fname;
    gray.setFileName(newName);
   
    gray.draw();
    gray.save();
    }
    
    
    
    }
    
    
    
    
}

