package Doit.DataStructure_03;

import java.util.Arrays;
import java.util.Scanner;

public class P1940 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] A = new int[N];
        for (int i=0; i<N; i++){
            A[i] = in.nextInt();
        }

        Arrays.sort(A);
        int i=0, j=N-1;
        int count=0;
        while(i<j){
            int sum = A[i]+A[j];
            if (sum<M) i++;
            else if(sum>M) j--;
            else{
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
    }
}
