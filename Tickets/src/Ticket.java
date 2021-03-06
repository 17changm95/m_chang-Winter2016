//import java.util.*;

public class Ticket {
	private int number;
	private double price;
	
	public Ticket() {
		this.number = 0;
		this.price = 30.0;
	}
	
	public Ticket(int num) {
		this.number = num;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String toString() {
		return "Number: " + this.number + ", Price: " + getPrice();
	}
}
