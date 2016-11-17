package tuning;

public class SentinelValues {
	public static void main(String[] args) {
		boolean found = false;
		int i = 0;
		int count = 5;
		int[] item = { 1, 2, 3, 4, 5 };
		int testValue = 4;

		// before
		while ((!found) && (i < count)) {
			if (item[i] == testValue) {
				found = true;
			} else {
				i++;
			}
		}

		// after
		int[] item2 = { 1, 2, 3, 4, 5, testValue };
		while (item2[i] != testValue) {
			i++;
		}

		// check if value was found
		if (i < count) {

		}
		
		
		//当item是一个整数数组的时候
		//语言			节省时间
		//C#			23%
		//Java			44%
		//Visual Basic	65%
	}
}
