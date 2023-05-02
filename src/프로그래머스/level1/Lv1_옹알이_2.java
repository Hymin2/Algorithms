package 프로그래머스.level1;

public class Lv1_옹알이_2 {
    public int solution(String[] babbling) {
        int answer = 0;
        int index = 0;
        int i, k;

        String[] word = {"aya", "ye", "woo", "ma"};

        for(i = 0; i < babbling.length; i++){
            for(k = 0; k < word.length; k++){
                if((index = babbling[i].indexOf(word[k].repeat(2))) != -1){
                    break;
                }
            }

            if(index != -1) continue;

            babbling[i] = babbling[i].replace(word[0], " ").replace(word[1], " ").replace(word[2], " ").replace(word[3], " ");


            if(!babbling[i].matches("(.*)[a-z](.*)")) answer++;
        }
        return answer;
    }
}
