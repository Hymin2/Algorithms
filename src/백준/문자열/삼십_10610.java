package 백준.문자열;

import java.util.*;
import java.io.*;

public class 삼십_10610 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).sorted().toArray();

        if(Arrays.stream(nums).sum() % 3 != 0 || nums[0] != 0)
            System.out.println("-1");
        else {
            for(int i = nums.length - 1; i >= 0; i--)
                System.out.print(nums[i]);
        };


    }
}
