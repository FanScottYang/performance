package pagefault;

//分页中断
public class Main {
	final static int MAX_ROWS = 1000;
	final static int MAX_COLUMNS = 10000;
	final static Element BLANK_VALUE = new Element();
	public static void main(String[] args) {
		Element[][] table = new Element[MAX_ROWS][MAX_COLUMNS];
		
		long startTime = System.currentTimeMillis();
		//bad
		for (int i = 0; i < MAX_COLUMNS; i++) {
			for (int j = 0; j < MAX_ROWS; j++) {
				table[j][i] = BLANK_VALUE;
			}
		}
		//good
		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS; j++) {
				table[i][j] = BLANK_VALUE;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
