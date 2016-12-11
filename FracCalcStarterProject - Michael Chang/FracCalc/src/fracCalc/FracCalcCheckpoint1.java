/**
 * @author Michael Chang
 * @version 1.0
 * @since 11/4/16
 * @period 1�
 */

package fracCalc;
import java.util.*;

public class FracCalcCheckpoint1 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in); //New instance of Scanner object named console
        String answer = console.nextLine(); //answer will be variable of Scanner object console
        
        System.out.println(produceAnswer(answer)); //Outputs second operand in expression, which is input.
    }

    public static String produceAnswer(String input) { 
        String[] fracExpr;
        
        if (input.contains(" ")) {
        	fracExpr = input.split(" "); //Detects for spaces ' ' and creates String array spaces divided by spaces
        	return fracExpr[2]; //Return last element in String array. Last element is second operand in expression.
        } else {
        	throw new IllegalArgumentException("Please enter spaces between first operand and operator and/or second operand and operator.");
        	//This throws an error if no spaces are put in between operand and operator.
        }
    }
}
