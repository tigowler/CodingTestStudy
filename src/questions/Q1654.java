package questions;

import java.io.*;
import java.util.StringTokenizer;

public class Q1654 {
    static FastReader in =  new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] A;

    static void input(){
        K = in.nextInt();
        N = in.nextInt();
        A = new int[K+1];
        for (int i=1; i<=K; i++){
            A[i] = in.nextInt();
        }
    }

    //길이가 X라면 N개 이상의 랜선을 만들 수 있는가
    static boolean determination(int X){
        int count = 0;
        for (int i=1; i<=K; i++){
            int target = A[i];
            while(target/X>=1){
                count++;
                target = target - X;
            }
        }

        return count>=N;
    }

    static void pro(){
        long L = 1, R = Integer.MAX_VALUE, ans = 0;
        while(L<=R){
            long mid = (L+R)/2;
            if (determination((int)mid)){
                ans = mid;
                L = mid+1;
            }
            else {
                R = mid-1;
            }
        }
        sb.append(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}

