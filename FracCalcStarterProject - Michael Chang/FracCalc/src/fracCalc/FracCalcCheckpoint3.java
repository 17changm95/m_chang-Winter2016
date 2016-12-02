/**
 * @author Michael Chang
 * @version 1.0
 * @since 11/4/16
 * @period 1�
 */

package fracCalc;
import java.util.*;

public class FracCalcCheckpoint3 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer;
        
        do {
	        System.out.print("Type in your input: ");
	        answer = console.nextLine();
	        System.out.println(produceAnswer(answer));
        } while (answer.equals("quit") == false);
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    public static String[] parseOperand(String input) {
        String[] fracExpr;
    	
    	if (input.contains(" ")) {
        	fracExpr = input.split(" ");
    	} else {
        	throw new IllegalArgumentException("Please enter spaces between operands and operators.");
        }
    }
    
	public static String toImproperFrac(String input){
		//converting mixed numbers to improper fractions
		int whole;
		int numer1;
		int denom;
		
		if (input.contains("_") && input.contains("/")) {
    		whole = Integer.parseInt(input.substring(0, input.indexOf("_")));
    		numer1 = Integer.parseInt(input.substring(input.indexOf("_") + 1, input.indexOf("/")));
    		denom = Integer.parseInt(input.substring(input.indexOf("/") + 1));
		} else {
			//add something here later
		}
		
		int numer2 = denom * whole + numer1;
		String answer = numer2 + "/" + denom;
		return answer;
	}
    
    public static String addition(String[] input) {
        for (int i = 0; i < input.length; i++) {
        	if (input[i].contains("/") && input[i].contains("_")) {
        		input[i] = toImproperFrac(input[i]);
        	} else {
        	}
        }
        
    }
    
    public static String produceAnswer(String input) { 
        
        if (input.contains(" ")) {
        	fracExpr = input.split(" ");
        	
        	if (fracExpr[2].contains("_")) {
        		whole = "whole:" + fracExpr[2].substring(0, fracExpr[2].indexOf("_")) + " ";
        		numer = "numerator:" + fracExpr[2].substring(fracExpr[2].indexOf("_") + 1, fracExpr[2].indexOf("/")) + " ";
        		denom = "denominator:" + fracExpr[2].substring(fracExpr[2].indexOf("/") + 1);
        		
        		return whole + numer + denom;
        	} else if (fracExpr[2].contains("/") == false) {
        		whole = "whole:" + fracExpr[2] + " ";
        		numer = "numerator:" + 0 + " ";
        		denom = "denominator:" + 1;
        		
        		return whole + numer + denom;
        	} else if (fracExpr[2].contains("_") == false && fracExpr[2].contains("/")) {
        		whole = "whole:" + 0 + " ";
        		numer = "numerator:" + fracExpr[2].substring(0, fracExpr[2].indexOf("/")) + " ";
        		denom = "denominator:" + fracExpr[2].substring(fracExpr[2].indexOf("/") + 1);
        		
        		return whole + numer + denom;
        	} else {
        		throw new IllegalArgumentException("Please enter proper values.");
        	}
        } else (input.contains("quit")) {
        	return "";
    }
}
