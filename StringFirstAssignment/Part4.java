
/**
 * Write a description of Part4 here.
 * 
 * @author (VINEET PRASAD VERMA) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class Part4 {
    public void link(){
        URLResource resource=new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        String a="youtube.com";
        for(String word:resource.words()){
            //System.out.println("vineet");
            int b=word.indexOf(a);
            if(b!=-1){
                int c=word.indexOf("\"",(b+a.length()));
                //System.out.println("hello");
                if(c==-1){
                    //System.out.println("abc");
                    continue;
                }
                int d=word.lastIndexOf("\"",(b-1));
                if(d!=-1){
                    //System.out.println("xyz");
                    //System.out.println(word);
                    String link=word.substring(d,c);
                    System.out.println("link is"+link);
                }
        
        }
    
        }
    
    }

}
