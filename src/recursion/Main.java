package recursion;

import java.util.Stack;

/**
 * Created by fyang on 12/6/16.
 */
public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        System.out.println(calculate1(40));
        System.out.println(calculate2(10));
        long endTime = System.currentTimeMillis();
        System.out.println("Total time usage: " + (endTime - startTime));
    }

    private static int calculate1(int a) {
        if (a == 1) {
            return 1;
        } else if (a == 2) {
            return 2;
        } else {
            return calculate1(a - 1) + calculate1(a - 2);
        }
    }

    private static int calculate2(int a) {
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        int[] f = {a, -2, 0};
        stack.add(f);
        while (!stack.isEmpty()) {
            int[] t = stack.peek();
            if (t[0] == 1) {
                stack.pop();
                stack.peek()[1] ++;
                stack.peek()[2] += 1;
            } else if (t[0] == 2) {
                stack.pop();
                stack.peek()[1] ++;
                stack.peek()[2] += 2;
            } else if (t[1] == -2) {
                int[] tmp = {a-1, -2, 0};
                stack.add(tmp);
            } else if (t[1] == -1) {
                int[] tmp = {a-2, -2, 0};
                stack.add(tmp);
            } else if (t[1] == 0) {
                int tmp = stack.pop()[2];
                stack.peek()[2] += tmp;
            }
        }
        return 0;
    }
}
