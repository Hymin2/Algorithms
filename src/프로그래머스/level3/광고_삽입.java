package 프로그래머스.level3;

public class 광고_삽입 {
    public static void main(String[] args) {
        String result = solution("25:00:00", "00:01:00", new String[]{"24:00:01-25:00:00"});

        System.out.println(result);
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int n = logs.length;;
        int playTimeInt = timeToInt(play_time);
        int advTimeInt = timeToInt(adv_time);

        int[] time = new int[playTimeInt + 1];
        int[] sumTime = new int[playTimeInt + 1];

        for(int i = 0; i < n; i++){
            String[] startEndTime = logs[i].split("-");
            time[timeToInt(startEndTime[0])]++;
            time[timeToInt(startEndTime[1])]--;
        }

        for(int i = 1; i < playTimeInt + 1; i++){
            time[i] += time[i - 1];
            sumTime[i] = sumTime[i - 1] + time[i];
        }

        int max = 0;
        int maxIndex = 0;

        for(int i = 1; i < playTimeInt - advTimeInt; i++){
            int viewer = sumTime[advTimeInt + i] - sumTime[i - 1];
            if(viewer > max){
                max = viewer;
                maxIndex = i;
            }
        }

        return timeToString(maxIndex);
    }

    public static int toInt(String str){
        return Integer.parseInt(str);
    }
    public static int timeToInt(String time){
        String[] hhmmss = time.split(":");

        return toInt(hhmmss[0]) * 3600 + toInt(hhmmss[1]) * 60 + toInt(hhmmss[2]);
    }

    public static String timeToString(int time){
        int hour = time / 3600;
        time = time % 3600;
        int minute = time / 60;
        int seconds = time % 60;

        return String.format("%02d:%02d:%02d",hour, minute, seconds);
    }
}
