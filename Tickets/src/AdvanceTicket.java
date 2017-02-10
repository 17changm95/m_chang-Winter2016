
public class AdvanceTicket extends Ticket{
	
	private int purchaseDay; //number of days before event on day of purchase 
	
	public AdvanceTicket(int num) {
		super(num);
	}
	
	public double getPrice(int day) {
		this.purchaseDay = day;
		if (this.purchaseDay >= 10) {
			return 30.0;
		} else {
			return 40.0;
		}
	}
}
