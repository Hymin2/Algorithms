package 프로그래머스.level2;

public class Lv2_올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;

        int sp = 0;

        char[] stack = new char[s.length()];
        char[] brackets = s.toCharArray();

        for(char c : brackets){
            if(c == '('){
                stack[sp++] = '(';
            } else{
                sp--;

                if(sp == -1) return false;
            }
        }

        if(sp > 0 ) return false;

        return true;
    }
}
