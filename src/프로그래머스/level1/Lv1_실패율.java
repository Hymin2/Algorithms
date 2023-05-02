package 프로그래머스.level1;

import java.util.Arrays;

public class Lv1_실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int remain = stages.length;
        Stage[] stage_arr = new Stage[N];

        for(int i = 0; i < N; i++)
            stage_arr[i] = new Stage(i + 1);

        for(int i = 0; i < stages.length; i++){
            if(stages[i] - 1 < N)
                stage_arr[stages[i] - 1].increaseFailed();
        }

        for(int i = 0; i < N; i++){
            stage_arr[i].setTrial(remain);
            remain -= stage_arr[i].getFailed();
        }

        Arrays.sort(stage_arr);

        for(int i = 0; i < N; i++)
            answer[i] = stage_arr[i].getNum();

        return answer;
    }
}

class Stage implements Comparable<Stage>{
    int num;
    int trial;
    int failed;

    Stage(int num){
        this.num = num;
        trial = 0;
        failed = 0;
    }

    public void setTrial(int trial){
        this.trial = trial;
    }

    public void increaseFailed(){
        failed++;
    }

    public int getNum(){
        return num;
    }

    public int getFailed(){
        return failed;
    }

    public double getFailRate(){
        return trial == 0 ? 0 : (double)this.failed / this.trial;
    }

    @Override
    public int compareTo(Stage stage){
        double fail_rate = this.getFailRate() - stage.getFailRate();
        if(fail_rate > 0) return -1;
        else if(fail_rate == 0){
            return this.getNum() - stage.getNum();
        }
        else return 1;
    }
}
