
public class TextProcessing {
	
	public static void main(String[] args) {
		//some variables
		char ch1 = 'b';
		char ch2 = 'b';
		char ch3 = 'c';
		Character ch4 = 4;
		int x = 456;
		int y = 12932;
		int z = 1234132424;
		int v = 230492134;
		
		//formatting int x, y, z, and v in a nice little row
		System.out.printf("4DLocation: (%-6d, %-6d, %-6d, %-6d)\n", x, y, z, v);
		
		//checking if ch1 and ch2 are equal
		if (ch1 == ch2) {
			System.out.println("ch1 and ch2 are the same character");
		} else {
			System.out.println("ch1 and ch2 are not the same character");
		}
		
		//checking if ch2 and ch3 are equal
		if (ch2 == ch3) {
			System.out.println("stupid");
		} else {
			System.out.println("alternative facts");
		}
		
		int int1 = Character.getNumericValue('6');
		
		System.out.println(69 + int1);
	}
}
