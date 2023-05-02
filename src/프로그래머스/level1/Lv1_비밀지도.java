package 프로그래머스.level1;

public class Lv1_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            String str1 = toBinary(arr1[i], n);
            String str2 = toBinary(arr2[i], n);

            answer[i] = decodeMap(str1, str2);
        }

        return answer;
    }

    public String decodeMap(String map1, String map2){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < map1.length(); i++){
            if(map1.charAt(i) == '#' || map2.charAt(i) == '#')
                sb.append('#');
            else
                sb.append(' ');
        }

        return sb.toString();
    }

    public String toBinary(int num, int len){
        StringBuilder sb = new StringBuilder();

        while(num != 0){
            if(num % 2 == 0) sb.insert(0, ' ');
            else if (num % 2 == 1) sb.insert(0, "#");

            num /= 2;
        }

        sb.insert(0, " ".repeat(len - sb.length()));

        return sb.toString();
    }
}
