/**
 * @author Michael Chang
 * @version 1.0
 * @since 11/4/16
 * @period 1°
 */

package fracCalc;
import java.util.*;

public class FracCalcCheckpoint2 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in); //New instance of Scanner object named console
        String answer; //answer will be variable of Scanner object console. Scope of answer to be within main.
        
        do { //do-while loop is used. I intend console to allow a first input to be entered without the while loop condition being applied.
	        System.out.print("Type in your input: ");
	        answer = console.nextLine();
	        System.out.println(produceAnswer(answer));
        } while (answer.equals("quit") == false); //User must enter "quit" in order to exit out of program. Might modify to make input case insensitive.
    }

    public static String produceAnswer(String input) {
    	//Purpose of this method is to parse second operand down into whole number, numerator, and denominator.
        String[] fracExpr; //String array fracExpr has scope within produceAnswer. Holds operands and operators of input.
        String whole; //String whole will display whole number.
        String numer; //String numer will display numerator.
        String denom; //String denom will display denominator.
        
        if (input.contains(" ")) {
        	fracExpr = input.split(" "); //Splits expression by space.
        	
        	if (fracExpr[2].contains("_")) { //This condition will be satisfied when second operand is a mixed number.
        		whole = "whole:" + fracExpr[2].substring(0, fracExpr[2].indexOf("_")) + " ";
        		numer = "numerator:" + fracExpr[2].substring(fracExpr[2].indexOf("_") + 1, fracExpr[2].indexOf("/")) + " ";
        		denom = "denominator:" + fracExpr[2].substring(fracExpr[2].indexOf("/") + 1);
        		
        		return whole + numer + denom;
        	} else if (fracExpr[2].contains("/") == false) { //This condition will be satisfied when second operand is not a fraction.
        		whole = "whole:" + fracExpr[2] + " ";
        		numer = "numerator:" + 0 + " ";
        		denom = "denominator:" + 1;
        		
        		return whole + numer + denom;
        	} else if (fracExpr[2].contains("_") == false && fracExpr[2].contains("/")) { //This condition will be satisfied when second operand is a fraction that is not in mixed form.
        		whole = "whole:" + 0 + " ";
        		numer = "numerator:" + fracExpr[2].substring(0, fracExpr[2].indexOf("/")) + " ";
        		denom = "denominator:" + fracExpr[2].substring(fracExpr[2].indexOf("/") + 1);
        		
        		return whole + numer + denom;
        	} else {
        		throw new IllegalArgumentException("Please enter proper values."); //Error that is thrown if proper values aren't used in expression or there are missing values in numerator or denominator.
        	}
        } else if (input.contains("quit")) { //Terminates program.
        	return "";
        } else {
        	throw new IllegalArgumentException("Please enter spaces between first operand and operator and/or second operand and operator.");
        	//This throws an error if no spaces are put in between operand and operator.
        }
    }
}