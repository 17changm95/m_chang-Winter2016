/**
 * @author Mike
 * @since 12/15/2016 2:50 AM
 * @version 1.0
 */
public class Giraffe {
	
	//encapsulated fields
	private int age;
	private int neckLength;
	private String name;
	private double weight;
	private String favColor;
	
	public Giraffe() {
		this.age = 0;
		this.neckLength = 5;
		this.name = "Girambe";
		this.weight = 5;
		this.favColor = "Silverback Gray";
	}
	
	public Giraffe(int age, int neckLength, String name, double weight, String favColor) {
		this.age = age;
		this.neckLength = neckLength;
		this.name = name;
		this.weight = weight;
		this.favColor = favColor;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setNeckLength(int neckLength) {
		this.neckLength = neckLength;
	}
	
	public String setName(String name) {
		return "You heartless human being. You already hold this animal hostage in its cage.\nLet this poor animal have its name.";
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String setFavColor(String favColor) {
		return "This animal has a personality. This animal has feelings. Don't take that right away from them you cruel human.";
	}
	
	public int getAge() {
		return age;
	}
	
	public int getNeckLength() {
		return neckLength;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String getFavColor() {
		return favColor;
	}
	
	public String toString() {
		return "Giraffe name: " + name + "\nGiraffe age: " + age + "\nGiraffe weight: " + weight + "\nGiraffe neck length: " + neckLength + "\nGiraffe favorite color: " + favColor;
	}
}