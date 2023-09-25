package inheritanceLearning;

 class A1 {
	 public void Do() {
	System.out.println("I am doing A1");
}
}
 class B1 extends A1{
	 public void get() {
		 System.out.println("I am getting B1");
}
}
 
 class C1 extends B1{
	 public void set() {
		 System.out.println("I am setting C1");
	 }
 }
	 
 

public class MultipleLevelINheritance extends C1  {
	
	public static void main(String[] args) {
		MultipleLevelINheritance MI = new MultipleLevelINheritance();
		MI.Do();
		MI.get();
		MI.set();
		
	}
	
	
	
	
	
}