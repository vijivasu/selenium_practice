package interfaceLearning;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class InterfaceImplementation1 implements InterfaceAbstractDeclaration {

	public void Do() {
		// TODO Auto-generated method stub
		System.out.println("Addition");
		
	}

	public void Get() {
		// TODO Auto-generated method stub
		int x=10;
		int y= 15;
		System.out.println(x +" and "+ y);
		
	}

	public void Set() {
		// TODO Auto-generated method stub
		System.out.println("Values are set");
		
	}
public static void main(String[] args) {
	
	InterfaceImplementation1 II = new InterfaceImplementation1();
	II.Do();
	II.Get();
	II.Set();
}
	}
