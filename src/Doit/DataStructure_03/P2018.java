package Doit.DataStructure_03;

import java.util.Scanner;

public class P2018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int count = 1; // N 미리 카운트
        int sum = 1;
        int start=1, end=1;

        while(end!=N){
            if (sum==N){
                count++;
                end++;
                sum += end;
            }
            else if(sum>N){
                sum -= start;
                start++;
            }
            else {
                end++;
                sum+=end;
            }
        }

        System.out.println(count);
    }
}
