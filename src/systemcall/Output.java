package systemcall;

public class Output {
	private static int BUFFER_SIZE = 1000;
	private static StringBuffer buffer = new StringBuffer(BUFFER_SIZE);
	private static int current_position = 0;

	public static void println(int a) {
		buffer.append(a).append("\n");
		current_position = current_position + 2;
		if (current_position == BUFFER_SIZE) {
			System.out.print(buffer.toString());
			buffer = new StringBuffer(BUFFER_SIZE);
			current_position = 0;
		}
	}
}
