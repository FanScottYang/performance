package tuning;

public class Unrolling {
	public static void main(String[] args) {
		int i = 0;
		int count = 5;
		int[] a = new int[5];

		// before
		while (i < count) {
			a[i] = i;
			i++;
		}

		// after
		while (i < count - 1) {
			a[i] = i;
			a[i + 1] = i + 1;
			i += 2;
		}
		if (i == count - 1) {
			a[count - 1] = count - 1;
		}
		
		//语言		节省时间
		//C++		34%
		//Java		46%
		//PHP		16%
		//Python	-27%
	}
}
