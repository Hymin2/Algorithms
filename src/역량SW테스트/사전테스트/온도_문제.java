package 역량SW테스트.사전테스트;

import java.util.HashMap;
import java.util.Stack;

public class 온도_문제 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int[] stack = new int[temperatures.length];

        int sp = -1;

        for(int i = 0; i < temperatures.length; i++) {
            while (sp != -1 && temperatures[i] > temperatures[stack[sp]]) {
                result[stack[sp]] = i - stack[sp];
                sp--;
            }

            stack[++sp] = i;
        }

        return result;
    }
}
