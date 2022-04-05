package BruteForce.problems;

import java.util.Scanner;

public class Q14888 {
    static int N, max, min;
    static int[] nums, operators, order;
    public static StringBuilder sb = new StringBuilder();

    static void input(){
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); //입력받을 숫자의 개수
        nums = new int[N+1]; //숫자 저장 배열
        operators = new int[5]; //연산자 저장 배열
        order = new int[N+1]; //연산자를 순서대로 저장할 배열
        for (int i=1; i<=N; i++) nums[i] = in.nextInt();
        for (int i=1; i<=4; i++) operators[i] = in.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    //연산자에 따라 입력받은 숫자를 순서대로 계산하여 반환
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
            //연산자를 선택-비선택해가며 rec_func 진행
            for (int cand = 1; cand <=4; cand++){
                if (operators[cand]>=1){ //연산자가 없을 경우 실행 x
                    operators[cand]--; //연산자 한 개 사용
                    order[k]=cand; //선택한 연산자 저장
                    rec_func(k+1, calculator(value, cand, nums[k+1]));
                    //연산자를 사용하지 않은 상태로 되돌리기
                    operators[cand]++; //연산자 개수 다시 증가
                    order[k]=0;  //order에서도 연산자 삭제
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
