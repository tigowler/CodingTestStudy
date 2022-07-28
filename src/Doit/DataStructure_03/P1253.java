package Doit.DataStructure_03;

import java.util.Arrays;
import java.util.Scanner;

public class P1253 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int count = 0;
        long[] A = new long[N];
        for(int i=0; i<N; i++){
            A[i] = in.nextInt();
        }
        Arrays.sort(A);

        for (int k=0; k<N; k++){
            long find = A[k];
            int i=0, j=N-1;

            while(i<j){
                if (A[i]+A[j]==find){
                    if (i!=k && j!=k){
                        count++;
                        break;
                    }
                    else if(i==k){
                        i++;
                    }
                    else if (j==k){
                        j--;
                    }
                } else if(A[i]+A[j]<find){
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(count);
    }
}
