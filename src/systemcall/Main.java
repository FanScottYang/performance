package systemcall;

//系统调用的代价：上下文切换
public class Main {
	public static void main(String[] args) {
		int a = 0;
		long startTime = System.currentTimeMillis();
		// bad
		for (int i = 0; i <= 1000000; i++) {
			a = calculate(a);
			io(a);
		}

		// good
		for (int i = 0; i <= 1000000; i++) {
			a = calculate(a);
			io2(a);
		}

		long endTime = System.currentTimeMillis();
		System.out.println("total time:" + (endTime - startTime));
	}

	// User space
	private static int calculate(int a) {
		return a + 1;
	}

	// Kernal space
	private static void io(int a) {
		System.out.println(a);
	}

	// Kernal space
	private static void io2(int a) {
		Output.println(a);
	}
}
