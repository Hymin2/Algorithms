package 프로그래머스.level1;

import java.util.*;

public class Lv1_바탕화면_정리 {
    public int[] solution(String[] wallpaper){
        int[] answer = new int[4];

        Map<Integer, List<Integer>> hashMap = new LinkedHashMap<>();
        hashMap = findIndexes(wallpaper, "#");

        System.out.println(hashMap);

        answer[0] = findMinAtKey(hashMap);
        answer[1] = findMinAtValue(hashMap);
        answer[2] = findMaxAtKey(hashMap) + 1;
        answer[3] = findMaxAtValue(hashMap) + 1;

        return answer;
    }

    public int findMaxAtValue(Map<Integer, List<Integer>> hashMap){
        int max, temp;

        Integer[] arr = hashMap.keySet().toArray(new Integer[0]);

        max = Collections.max(hashMap.get(arr[0]));

        for(int i = 1; i < arr.length; i++){
            temp = Collections.max(hashMap.get(arr[i]));
            if(max < temp) max = temp;
        }
        return max;
    }

    public int findMinAtValue(Map<Integer, List<Integer>> hashMap){
        int min, temp;

        Integer[] arr = hashMap.keySet().toArray(new Integer[0]);

        min = Collections.min(hashMap.get(arr[0]));

        for(int i = 1; i < arr.length; i++){
            temp = Collections.min(hashMap.get(arr[i]));
            if(min > temp) min = temp;
        }
        return min;
    }

    public int findMaxAtKey(Map<Integer, List<Integer>> hashMap){
        Integer key_max = Collections.max(hashMap.keySet());

        return key_max;
    }

    public int findMinAtKey(Map<Integer, List<Integer>> hashMap){
        Integer key_min = Collections.min(hashMap.keySet());

        return key_min;
    }

    public Map<Integer, List<Integer>> findIndexes(String[] str, String word){
        Map<Integer, List<Integer>> hashMap = new LinkedHashMap<>();
        List<Integer> indexes = new ArrayList<>();

        for(int i = 0; i < str.length; i++) {
            if(!str[i].contains("#")) continue;

            int index = str[i].indexOf(word);

            while (index != -1) {
                indexes.add(index);
                index = str[i].indexOf(word, index + word.length());
            }
            List<Integer> temp = new ArrayList<>();
            temp.addAll(indexes);

            hashMap.put(i, temp);

            indexes.clear();
        }
        return hashMap;
    }
}
