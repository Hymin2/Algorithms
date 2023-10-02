package 역량SW테스트.day1;

public class Valid_parentheses {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int sp = -1;

        for(char c : s.toCharArray()){
            switch (c){
                case '(':
                    stack[++sp] = ')';
                    break;
                case '[':
                    stack[++sp] = ']';
                    break;
                case '{':
                    stack[++sp] = '}';
                    break;
                default:
                    if(sp == -1 || stack[sp--] != c) return false;
            }
        }

        return sp == -1;
    }
}
