package polymorphism;

public class Main {
	public static void main(String[] args) {
		//overwrite method
		Leave1 leave1 = new Leave1();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			leave1.doSomething();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("total time for overwrite method:" + (endTime - startTime));
		
		//override method
		Leave2 leave2 = new Leave2();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			leave2.doSomething("2");
		}
		endTime = System.currentTimeMillis();
		System.out.println("total time for override method:" + (endTime - startTime));
		
		//normal method
		Normal normalClass = new Normal();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			normalClass.doSomething();
		}
		endTime = System.currentTimeMillis();
		System.out.println("total time for normal method:" + (endTime - startTime));
	}
}
