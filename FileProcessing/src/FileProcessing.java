import java.io.*;		// For File
import java.util.*;		// For Scanner

public class FileProcessing {

	public static void main(String[] args) 
			throws FileNotFoundException{
		// Declaring doubles num1 and num2 the difference of which is double change
		double num1;
		double num2;
		double change;
		
		Scanner input = new Scanner(new File("weather.txt"));
		double d = input.nextDouble(); // Consuming input in weather.txt
		
		// Using while loop to repeat printing out new lines of output for the difference between pairs of numbers
		while (input.hasNextLine()) {
			
		}
		
	}

}
