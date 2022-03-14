package acom.stack.linkedList;

public class Test {
	
	public static void main(String[] args) {
		try {
			sum();
		} catch (NullPointerException e) {
			System.out.println("Cough in main");
		}
		//System.out.println(1.0 / 0.0);
		//System.out.println(System.getProperty("sun.arch.data.model"));
	}
	
	public static void sum() {
		try {
			throw new NullPointerException("Demo");
		} catch (NullPointerException e) {
			System.out.println("Cought in Sum");
			throw e;
		}
	}
}
