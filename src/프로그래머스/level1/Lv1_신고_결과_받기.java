package 프로그래머스.level1;

import java.util.*;

public class Lv1_신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, User> user_map = new HashMap<>();
        List<String> list;
        int[] answer = new int[id_list.length];

        for(int i = 0; i < id_list.length; i++){
            user_map.put(id_list[i], new User(id_list[i], i));
        }

        for(int i = 0; i < report.length; i++){
            String[] str = report[i].split(" ");
            user_map.get(str[0]).reportOtherPerson(str[1]);
            user_map.get(str[1]).reportedByOtherPerson(str[0]);
        }

        for(int i = 0; i < id_list.length; i++){
            if(user_map.get(id_list[i]).getReportedCount() >= k){
                list = user_map.get(id_list[i]).getReported();

                for(int j = 0; j < list.size(); j++){
                    answer[user_map.get(list.get(j)).index]++;
                }
            }
        }
        return answer;
    }

    public class User{
        private String name;
        private Set<String> report;
        private Set<String> reported;
        private int reported_cnt;
        private int index;

        User(String name, int index){
            this.name = name;
            report = new HashSet<>();
            reported = new HashSet<>();
            reported_cnt = 0;
            this.index = index;
        }

        public void reportOtherPerson(String name){
            report.add(name);
        }

        public String getName(){
            return name;
        }

        public int getIndex(){
            return index;
        }

        public void reportedByOtherPerson(String name){
            if(!reported.contains(name)) {
                reported_cnt++;
                reported.add(name);
            }
        }

        public List<String> getReported(){
            List<String> list = new ArrayList<>(reported);
            return list;
        }

        public int getReportedCount(){
            return reported_cnt;
        }
    }
}
