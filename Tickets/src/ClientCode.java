
public class ClientCode {

	public static void main(String[] args) {
		Ticket myTicket = new Ticket(1);
		System.out.println(myTicket.toString());
		WalkupTicket myWalkUp = new WalkupTicket(1);
		System.out.println(myWalkUp.getPrice());
		System.out.println(myWalkUp.toString());
	}
}
