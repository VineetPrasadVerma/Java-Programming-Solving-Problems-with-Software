
/**
 * Write a description of BatchInversions here.
 * 
 * @author (VINEET PRASAD VERMA) 
 * @version (27-08-2017)
 */
    
    import edu.duke.*;
    import java.io.*;
    public class BatchInversions {
        public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel:outImage.pixels()){
        Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());
        int a=(255-inPixel.getRed());
        int b=(255-inPixel.getBlue());
        int c=(255-inPixel.getGreen());
        pixel.setRed(a);
        pixel.setGreen(b);
        pixel.setBlue(c);
        }
        return outImage;
        }
        
        public void selectAndConv(){
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
        ImageResource inImage=new ImageResource(f);
        ImageResource gray=makeGray(inImage);
        String fname=inImage.getFileName();
        String newName="inverted-"+fname;
        gray.setFileName(newName);
        
        gray.draw();
         gray.save();
        }
        
        
        
        }
        
    }
