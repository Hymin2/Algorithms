package 프로그래머스.level2;

import java.util.*;

public class Lv2_타겟_넘버 {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        // answer = bfs(numbers, target);
        answer = dfs(new Node(-1, 0), numbers, target);

        return answer;
    }

    public int bfs(int[] numbers, int target){
        int answer = 0;

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, numbers[0]));
        q.add(new Node(0, numbers[0] * -1));

        while(!q.isEmpty()){
            Node n = q.peek();
            q.poll();

            if(n.getDepth() + 1 == numbers.length){
                if(n.getNum() == target) answer++;
                continue;
            }

            q.add(new Node(n.getDepth() + 1, n.getNum() + numbers[n.getDepth() + 1]));
            q.add(new Node(n.getDepth() + 1, n.getNum() - numbers[n.getDepth() + 1]));

        }

        return answer;
    }


    public int dfs(Node n, int[] numbers, int target){
        int answer = 0;

        if(n.getDepth() + 1 == numbers.length){
            if(n.getNum() == target) return 1;
            else return 0;
        }

        answer += dfs(new Node(n.getDepth() + 1, n.getNum() + numbers[n.getDepth() + 1]), numbers, target);
        answer += dfs(new Node(n.getDepth() + 1, n.getNum() - numbers[n.getDepth() + 1]), numbers, target);

        return answer;
    }
}

class Node{
    int depth;
    int num;

    Node(int depth, int num){
        this.depth = depth;
        this.num = num;
    }

    int getDepth(){
        return depth;
    }

    int getNum(){
        return num;
    }
}
