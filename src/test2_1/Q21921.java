package test2_1;

import java.io.*;
import java.util.StringTokenizer;

public class Q21921 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, X;
    static int[] A;
    static int sum=0;

    static void input(){
        N = in.nextInt();
        X = in.nextInt();
        A = new int[N+1];
        for (int i=1; i<=N; i++){
            A[i] = in.nextInt();
            if (i<=X) sum+=A[i];
        }
    }

    static void pro(){
        int max_sum = sum;
        int count=1;

        int left = 1;
        int right = X;
        while(true){
            left++;
            right++;
            if (right>N) break;
            sum = sum + A[right] -A[left-1];
            if (max_sum == sum) count++;
            else if(max_sum < sum){
                max_sum = sum;
                count = 1;
            }
        }

        if (max_sum==0){
            System.out.println("SAD");
        }
        else{
            System.out.println(max_sum);
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
