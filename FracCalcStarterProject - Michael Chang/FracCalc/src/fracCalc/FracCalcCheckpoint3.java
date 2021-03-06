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
        Scanner console = new Scanner(System.in); //New instance of Scanner object named console
        String answer; //answer will be variable of Scanner object console. Scope of answer to be within main.

        do { //do-while loop is used. I intend console to allow a first input to be entered without the while loop condition being applied.
        	System.out.print("Type in your input: ");
	        answer = console.nextLine();
	        System.out.println(produceAnswer(answer));
        } while (answer.equals("quit") == false); //User must enter "quit" in order to exit out of program. Might modify to make input case insensitive.
    }
    
    public static String[] parseOperand(String input) {
    	//This method splits the expression by the spaces.
        String[] fracExpr; //String array fracExpr has scope within produceAnswer. Holds operands and operators of input.
    	
    	if (input.contains(" ")) { //Detects if spaces are inside expression.
        	fracExpr = input.split(" "); //Splits expression by space.
        	return fracExpr;
    	} else {
        	throw new IllegalArgumentException("Please enter spaces between operands and operators.");
        	//Throws error if no spaces are included between operand and operators.
        }
    }
    
	public static int[] toImproperFrac(String input){
		//converting mixed numbers to improper fractions and also converting whole numbers into fractions with 1 as denominator.
		int whole;
		int numer1;
		int denom;
		
		if (input.contains("_") && input.contains("/")) { //Condition of mixed number with whole number
    		whole = Integer.parseInt(input.substring(0, input.indexOf("_")));
    		numer1 = Integer.parseInt(input.substring(input.indexOf("_") + 1, input.indexOf("/")));
    		denom = Integer.parseInt(input.substring(input.indexOf("/") + 1));
		} else if (input.contains("_") == false && input.contains("/") == false) { //Condition of integer
			whole = 0;
			numer1 = Integer.parseInt(input);
			denom = 1;
		} else { //Condition for fractions without whole numbers
			whole = 0;
			numer1 = Integer.parseInt(input.substring(0, input.indexOf("/")));
    		denom = Integer.parseInt(input.substring(input.indexOf("/") + 1));
		}
		
		int numer2;
		
		if (whole < 0 || numer1 < 0) { //Condition is for fractions that have negative values. Numerator must be calculated for correctly with absolute values followed by multiplication of -1 to make number negative.
			numer2 = -1 * (Math.abs(denom) * Math.abs(whole) + Math.abs(numer1));
		} else { //Condition is for fractions that have positive value.
			numer2 = denom * whole + numer1;
		}
		int[] answer = {numer2, denom};
		return answer;
	}
    
    public static int[] addition(int[] input1, int[] input2) { //This condition finds the sum between two operands.
        int[] answer = new int[2];
        
    	if (input2[1] == input1[1]) { //Condition is if denominators of two operands are equal.
        	answer[0] = input1[0] + input2[0]; //Adding two numerators together here.
        	answer[1] = input1[1]; //Denominator is the same.
        	return answer;
        } else if (input2 != input1) { //Condition is denominators of two operands are not equal.
        	int numer1 = input1[0] * input2[1]; //Multiply denominator of second operand with numerator of first operand.
        	int denom = input1[1] * input2[1]; //Multiply denominators of both operands together for a common denominator.
        	int numer2 = input1[1] * input2[0]; //Multiply denominator of first operand with numerator of second operand.
        	answer[0] = numer1 + numer2; //Add numerators together
        	answer[1] = denom; //Denominator is common denominator found earlier.
        	return answer;
        } else if (input1[1] == 0 || input2[1] == 0) {
        	throw new IllegalArgumentException("Undefined."); //Error shown if denominator for either operand is equal to 0.
        } else {
        	throw new IllegalArgumentException("Error in spacing or values. Please try again.");
        	//Error shown if there are errors in spacing, values, or operand placement.
        }
    }
    
    public static int[] subtraction(int[] input1, int[] input2) { //Finds the difference between two operands.
        int[] answer = new int[2];
        
    	if (input2[1] == input1[1]) { //Condition is if denominators of two operands are equal.
        	answer[0] = input1[0] - input2[0]; //Subtracting two numerators together here.
        	answer[1] = input1[1]; //Denominator is the same.
        	return answer;
        } else if (input2 != input1) { //See comments for this operation above in sum.
        	int numer1 = input1[0] * input2[1];
        	int denom = input1[1] * input2[1];
        	int numer2 = input1[1] * input2[0];
        	answer[0] = numer1 - numer2;
        	answer[1] = denom;
        	return answer;
        } else if (input1[1] == 0 || input2[1] == 0) {
        	throw new IllegalArgumentException("Undefined.");
        } else {
        	throw new IllegalArgumentException("Error in spacing or values. Please try again.");
        }
    }
    
    public static int[] multiplication(int[] input1, int[] input2) {
        int[] answer = new int[2];
        
        if (input1[1] != 0 && input2[1] != 0) { //Condition to check if either denominators of both operands are equal to 0.
        	answer[0] = input1[0] * input2[0]; //Multiplies numerators together
        	answer[1] = input1[1] * input2[1]; //Multiplies denominators together
        	return answer;
        } else if (input1[1] == 0 || input2[1] == 0) {
        	throw new IllegalArgumentException("Undefined.");
        	//Error thrown if either denominators of either operands contain 0.
        } else {
        	throw new IllegalArgumentException("Error in spacing or values. Please try again.");
        	//Error shown if there are errors in spacing, values, or operand placement.
        }
    }
    
    public static int[] division(int[] input1, int[] input2) { //Finds quotient between two operands.
    	int[] answer = new int[2]; //String array answer is initialized.
    	int numer2 = input2[0]; //Second operand's numerator assigned to variable numer2
    	int denom2 = input2[1]; //Second operand's denominator assigned to variable denom2
    	input2[0] = denom2; //Following two operations simulate reciprocation of second operand
    	input2[1] = numer2;
    	
    	if (input1[1] != 0 && input2[1] != 0) { //Condition for if denominators of both operands do not contain 0.
    		int i1i2Product = input1[1] * input2[1]; //Product of denominators of both operands
    		
    		if (i1i2Product < 0) { //If denominators of both operands are negative, then signs for numerator and denominator must be reversed in order to return a valid value and prevent denominator from having negative value.
    			answer[0] = -1 * input1[0] * input2[0];
    			answer[1] = -1 * input1[1] * input2[1];
    		} else {
    			answer[0] = input1[0] * input2[0];
            	answer[1] = input1[1] * input2[1];
    		}
        	return answer;
        } else if (input1[1] == 0 || input2[1] == 0) {
        	throw new IllegalArgumentException("Undefined.");
        } else {
        	throw new IllegalArgumentException("Error in spacing or values. Please try again.");
        	//Error shown if there are errors in spacing, values, or operand placement.
        }
    }
    
    public static String intArrayConvert(int[] input) { //Converts int arrays after operation methods into mixed number or whole number strings.
    	String answer;
    	int whole = 0;
    	int numer = input[0];
    	int denom = input[1];
    	
    	if (numer > denom) {
    		whole = numer / denom; //Whole number is divided by ints and number found sans remainder left.
    		numer = numer % denom; //New numerator is remainder from numerator divided by denominator.
    		
    		if (numer == 0) {
    			return answer = whole + ""; //Returns only a whole number without / or anything else
    		} else {
    			return answer = whole + "_" + numer + "/" + denom; //Returns whole number and numerator and denominator.
    		}
    	} else if (numer == denom) { //Yielding 1 when numerator is equal to denominator
    		return answer = "1";
    	} else if (numer == 0) { //Yielding 0 when numerator is equal to 0.
    		return answer = "0";
    	} else if (denom == 0) {
    		throw new IllegalArgumentException("Undefined");
    	} else {
    		return answer = numer + "/" + denom;
    		//Returning regular fraction that has no whole number.
    	}
    }
    
    public static String produceAnswer(String input) {
    	String[] parsedInput = parseOperand(input); //parsedInput stores value for result of parseOperand(input)
    	int[] num1 = toImproperFrac(parsedInput[0]); //num1 is converted form of first operand of parsedInput
    	int[] num2 = toImproperFrac(parsedInput[2]); //num2 is converted form of second operand of parsedInput
    	int[] sum = new int[2]; //The sum. Rest of variable names below are self explanatory
    	int[] difference = new int[2];
    	int[] quotient = new int[2];
    	int[] product = new int[2];
    	
    	if (parsedInput[1].equals("+")) { //Condition that + operator is contained in expression
	    	sum = addition(num1, num2);
	    	return intArrayConvert(sum); //Returns String
	    } else if (parsedInput[1].equals("-")) { //Condition that - operator is contained in expression
	    	difference = subtraction(num1, num2);
	    	return intArrayConvert(difference);
	    } else if ((parsedInput[1].equals("*"))) { //Condition that * operator is contained in expression
	    	product = multiplication(num1, num2);
	    	return intArrayConvert(product);
	    } else if (parsedInput[1].equals("/")) { //Condition that / operator is contained in expression
	    	quotient = division(num1, num2);
	    	return intArrayConvert(quotient);
	    } else if (input.contains("quit")) { //When quit is entered returns nothing
    		return "";
    	} else {
    		throw new IllegalArgumentException("Please enter proper values. Either that or you have entered quit into the console.");
    		//Must have catch-all for either improper values or "quit" entered into console
    	}
    }
}