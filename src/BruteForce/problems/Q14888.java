package BruteForce.problems;

import java.util.Scanner;

public class Q14888 {
    static int N, max, min;
    static int[] nums, operators, order;
    public static StringBuilder sb = new StringBuilder();

    static void input(){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        nums = new int[N+1];
        operators = new int[5];
        order = new int[N+1];
        for (int i=1; i<=N; i++) nums[i] = in.nextInt();
        for (int i=1; i<=4; i++) operators[i] = in.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int calculator(int operand1, int operator, int operand2){
        if (operator==1) return operand1 + operand2;
        else if (operator==2) return operand1 - operand2;
        else if (operator==3) return operand1 * operand2;
        else return operand1 / operand2;
    }

    static void rec_func(int k, int value){
        if (k==N){
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        else {
            for (int cand = 1; cand <=4; cand++){
                if (operators[cand]>=1){
                    operators[cand]--;
                    order[k]=cand;
                    rec_func(k+1, calculator(value, cand, nums[k+1]));
                    operators[cand]++;
                    order[k]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }
}
