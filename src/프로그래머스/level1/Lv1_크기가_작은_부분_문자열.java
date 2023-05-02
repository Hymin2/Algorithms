package 프로그래머스.level1;

public class Lv1_크기가_작은_부분_문자열 {
    public int solution(String t, String p) {
        int answer = 0;
        int p_length = p.length();
        long p_num = Long.parseLong(p);
        long t_num;

        for(int i = 0; i < t.length() - p_length + 1; i++){
            t_num = Long.parseLong(t.substring(i, i + p_length));

            if(t_num <= p_num) answer++;
        }
        return answer;
    }
}
