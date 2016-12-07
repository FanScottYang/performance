package recursion;

import java.util.Stack;

/**
 * Created by fyang on 12/6/16.
 */
public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(calculate1(35));
        long endTime = System.currentTimeMillis();
        System.out.println("Total time usage: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        System.out.println(calculate2(35));
        endTime = System.currentTimeMillis();
        System.out.println("Total time usage: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        System.out.println(calculate3(35));
        endTime = System.currentTimeMillis();
        System.out.println("Total time usage: " + (endTime - startTime));
    }

    private static int calculate1(int a) {
        if (a == 1 || a == 2) {
            return 1;
        } else {
            return calculate1(a - 1) + calculate1(a - 2);
        }
    }

    //用栈消除递归
    private static int calculate2(int a) {
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        int[] f = {a, -2, 0};
        stack.add(f);
        while (!stack.isEmpty()) {
            int[] t = stack.peek();
            if (t[0] == 1 || t[0] == 2) {
                result = 1;
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek()[1]++;
                    stack.peek()[2]++;
                }
            } else if (t[1] == -2) {
                int[] tmp = {t[0] - 1, -2, 0};
                stack.add(tmp);
            } else if (t[1] == -1) {
                int[] tmp = {t[0] - 2, -2, 0};
                stack.add(tmp);
            } else if (t[1] == 0) {
                int tmp = stack.pop()[2];
                result = tmp;
                if (!stack.isEmpty()) {
                    stack.peek()[1]++;
                    stack.peek()[2] += tmp;
                }
            }
        }
        return result;
    }

    //用循环消除尾递归和单向递归
    private static int calculate3(int a) {
        int f1, f2, f3 = 0;
        if (a == 1 || a == 2) {
            return 1;
        }
        f1 = 1;
        f2 = 1;
        for (int i = 3; i <= a; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    //大问题由相同的小问题组成(数学归纳法), open -> closed
    private static int calculate4(int a) {
        return 0;
    }
}
