package 프로그래머스.level3;

public class 광고_삽입 {
    public static void main(String[] args) {
        String result = solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});

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

        for(int i = 0; i < playTimeInt - advTimeInt; i++){
            if(sumTime[advTimeInt + i] - sumTime[i] > max){
                max = sumTime[advTimeInt + i] - sumTime[i];
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
        StringBuilder hour = new StringBuilder(String.valueOf(time / 3600));
        time = time / 3600;
        StringBuilder minute = new StringBuilder(String.valueOf(time / 60));
        StringBuilder seconds = new StringBuilder(String.valueOf(time % 60));

        if(hour.length() == 1) hour.insert(0, 0);
        if(minute.length() == 1) minute.insert(0, 0);
        if(seconds.length() == 1) seconds.insert(0, 0);

        return hour + ":" + minute + ":" + seconds;
    }
}
