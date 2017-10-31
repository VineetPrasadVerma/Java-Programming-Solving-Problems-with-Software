import edu.duke.*;

public class HelloWorld {
	public void runHello () {
		URLResource resource = new URLResource("https://nytimes.com");
		for (String line : resource.lines()) {
			System.out.println(line);
		}
	}
}
