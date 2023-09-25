package inheritanceLearning;

public class InheritanceChild extends InheritanceParent{
	
	public void B() {
		int x=10;
		int y = 15;
		System.out.println(x*y);
	}
	
	public void C() {
		System.out.println("I am from Child class");
	}
	
	public static void main(String[]args) {
		InheritanceChild ic = new InheritanceChild();
		ic.A();
		ic.B();
		ic.C();
		
		
	}
	
	
	
	
	
	
	

}
