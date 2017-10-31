
/**
 * Write a description of TwoOcc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwoOcc {
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1) {
            break;
        }
        String found = input.substring(index+1, index+4);
        //System.out.print(index+1);
        //System.out.print(index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+4);
    }
}
   public void test() {
     //findAbc("abcd");
     findAbc("eusabce");
     //findAbc("abcbbbabcdddabc");
}

}
