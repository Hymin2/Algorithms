package 프로그래머스.level2;

import java.util.*;

public class Lv2_3차_방금_그곡 {
    Set<String> hashSet = new HashSet<>();
    String[] noteArr = {"C", "c", "D", "d", "E", "F", "f", "G", "g", "A", "a", "B"};

    public static void main(String[] args) {
        Lv2_3차_방금_그곡 sol = new Lv2_3차_방금_그곡();

        String[] str = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        sol.solution("ABCDEFG", str);
    }

    public String solution(String m, String[] musicinfos) {
        StringBuilder answer = new StringBuilder("(None)");

        for(int i = 0; i < noteArr.length; i++)
            hashSet.add(noteArr[i]);

        List<String> mList = toStringList(m, m.length());
        int maxMusicLen = 0;

        for(String str : musicinfos){
            String[] splitStr = str.split(",");
            int diff = diffTime(splitStr[0], splitStr[1]);

            List<String> musicList = toStringList(splitStr[3], diff);

            if(isSameMusic(mList, musicList) && diff > maxMusicLen){
                maxMusicLen = diff;
                answer.setLength(0);
                answer.append(splitStr[2]);
            }
        }

        return answer.toString();
    }

    public boolean isSameMusic(List<String> mList, List<String> musicList){
        int index = 0;
        for(int i = 0; i < musicList.size(); i++){
            if(mList.get(index).equals(musicList.get(i))){
                index++;
                if(index == mList.size()) return true;
            } else index = 0;
        }

        return false;
    }

    public int diffTime(String start, String end){
        String[] splitStart = start.split(":");
        String[] splitEnd = end.split(":");

        int diff = (toInt(splitEnd[0]) * 60 + toInt(splitEnd[1])) - (toInt(splitStart[0]) * 60 + toInt(splitStart[1]));

        return diff;
    }

    public int toInt(String str){
        return Integer.parseInt(str);
    }

    public List<String> toStringList(String m, int len){
        List<String> notes = new ArrayList<>();
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
        int index = 0;

        while(len != notes.size()){
            String str = m.substring(index, index + 1);
            if(hashSet.contains(str)) {
                notes.add(str);
            }
            index = (index + 1) % m.length();
        }

        return notes;
    }

}
