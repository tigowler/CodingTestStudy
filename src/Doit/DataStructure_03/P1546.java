package Doit.DataStructure_03;

import java.util.Scanner;

public class P1546 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A[] = new int[N];
        for (int i=0; i<N; i++){
            A[i] = in.nextInt();
        }
        long sum=0;
        long max=0;
        for (int i=0; i<N; i++){
            if (A[i]>max) max = A[i];
            sum = sum+A[i];
        }
        System.out.println(sum*100.0/max/N);
    }
}
