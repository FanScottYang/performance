package tuning;

//惰性求值
public class LazyEvaluation {
	public static void main(String[] args) {
		int[] data = new int[5000];

		// before
		for (int i = 0; i < 5000; i++) {
			data[i] = calculate(i);
		}
		System.out.println(data[1001]);

		// after
		data[1001] = calculate(1001);
		System.out.println(data[1001]);
	}
	
	private static int calculate(int i) {
		return i*(i+1);
	}
}
