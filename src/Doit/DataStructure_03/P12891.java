package Doit.DataStructure_03;

import java.util.Scanner;

public class P12891 {
    static Scanner in = new Scanner(System.in);

    static int S = in.nextInt(); // 전체 문자열 크기
    static int P = in.nextInt(); // 부분 문자열 크기
    static int check = 0; // 4개 중 몇 개를 충족시켰는지 확인하는 변수
    static String DNA = in.next();
    static int[] restrict = new int[4]; // A, C, G, T
    static int[] state = new int[4];
    static int res = 0;

    public static void main(String[] args) {
        for (int i=0; i<4; i++){
            restrict[i] = in.nextInt();
            if (restrict[i]==0) check++;
        }

        for (int i=0; i<P; i++){ // 첫 P 문자열(윈도우) 처리
            Add(DNA.charAt(i));
        }

        if (check==4) res++;

        // 슬라이딩 윈도우
        for(int i=P; i<S; i++){
            int j = i-P;
            Add(DNA.charAt(i));
            Remove(DNA.charAt(j));
            if (check==4) res++;
        }

        System.out.println(res);

    }

    private static void Remove(char c){
        switch (c){
            case 'A':
                if (state[0]==restrict[0]) check--;
                state[0]--;
                break;
            case 'C':
                if (state[1]==restrict[1]) check--;
                state[1]--;
                break;
            case 'G':
                if (state[2]==restrict[2]) check--;
                state[2]--;
                break;
            case 'T':
                if (state[3]==restrict[3]) check--;
                state[3]--;
                break;
        }
    }

    private static void Add(char c){
        switch (c){
            case 'A':
                state[0]++;
                if (state[0]==restrict[0]) check++;
                break;
            case 'C':
                state[1]++;
                if (state[1]==restrict[1]) check++;
                break;
            case 'G':
                state[2]++;
                if (state[2]==restrict[2]) check++;
                break;
            case 'T':
                state[3]++;
                if (state[3]==restrict[3]) check++;
                break;
        }
    }

}
