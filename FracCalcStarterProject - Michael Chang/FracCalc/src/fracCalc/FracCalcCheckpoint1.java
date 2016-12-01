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
        Scanner console = new Scanner(System.in);
        String answer = console.nextLine();
        
        System.out.println(produceAnswer(answer));
    }

    public static String produceAnswer(String input) { 
        String[] fracExpr;
        
        if (input.contains(" ")) {
        	fracExpr = input.split(" ");
        	return fracExpr[2];
        } else {
        	throw new IllegalArgumentException("Please enter spaces between first operand and operator and/or second operand and operator.");
        }
    }
}
