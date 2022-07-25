package Lecture.test2_1;

import java.io.*;
import java.util.StringTokenizer;

public class Q21923 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] arr = new int[1000][1000];
    static long[][] dp_first = new long[1000][1000];
    static long[][] dp_second = new long[1000][1000];

    static void input(){
        n = in.nextInt();
        m = in.nextInt();
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = in.nextInt();
            }
        }
    }

    static void pro(){
        //상승 비행 테이블 초기화
        dp_first[n-1][0] = arr[n-1][0];
        for (int i=n-2; i>=0; i--){
            dp_first[i][0] = arr[i][0] + dp_first[i+1][0];
        }
        for (int j=1; j<m; j++){
            dp_first[n-1][j] = arr[n-1][j] + dp_first[n-1][j-1];
        }

        //상승 비행 DP
        for (int i = n-2; i>=0; i--){
            for (int j=1; j<m; j++){
                dp_first[i][j] = arr[i][j];
                dp_first[i][j] += Math.max(dp_first[i][j-1], dp_first[i+1][j]);
            }
        }

        //하강 비행 테이블 초기화
        dp_second[n-1][m-1] = arr[n-1][m-1];
        for (int i=n-2; i>=0; i--){
            dp_second[i][m-1] = arr[i][m-1] + dp_second[i+1][m-1];
        }
        for (int j=m-2; j>=0; j--){
            dp_second[n-1][j] = arr[n-1][j] + dp_second[n-1][j+1];
        }

        //하강 비행 DP
        for (int i=n-2; i>=0; i--){
            for (int j=m-2; j>=0; j--){
                dp_second[i][j] = arr[i][j];
                dp_second[i][j] += Math.max(dp_second[i][j+1], dp_second[i+1][j]);
            }
        }

        //특정 위치 (i, j) 전까지 상승 비행 - (i, j)이후 하강 비행 했을 때의 점수 구하기
        long answer = dp_first[0][0] + dp_second[0][0];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                answer = Math.max(answer, dp_first[i][j] + dp_second[i][j]);
            }
        }
        System.out.println(answer);
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
