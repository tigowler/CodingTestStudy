package ParametricSearch;

import java.io.*;
import java.util.StringTokenizer;

public class Q1637 {
    static FastReader in = new FastReader();
    static int N;
    static int[][] info;

    static void input(){
        N = in.nextInt();
        info = new int[N+1][3];
        for (int i=1; i<=N; i++){
            for (int j=0; j<3; j++) info[i][j] = in.nextInt();
        }
    }

    static void pro(){
        // ans 구하기
        //mid로 반을 나눴을 때 홀수가 존재하는 쪽 개수는, 홀수일 것!
        //L~R 범위 안에 ans 존재
        long L=1, R = Integer.MAX_VALUE, ans = 0, ansCount = 0;
        while(L<=R){
            long mid = (L+R)/2;
            if (determination((int)mid)){
                ans = mid;
                R = mid-1;
            }
            else {
                L = mid+1;
            }
        }

        // ansCount 구하기

        // mid 이하의 수의 개수가 짝수라면 mid 초과 쪽의 개수는 홀수일 것이라 가정함.
        // 그런데 만일 모든 수의 개수가 양수라면 ans는 초기 값 0에서 한 번도 업데이트 되지 못했을 것!
        if (ans==0){
            System.out.println("NOTHING");
        }
        else {
            for (int i=1; i<=N; i++){
                // info[i][0]<=ans && ans<=info[i][1] => ans를 가지는 범위인지 확인
                // A, C, B안에 ans가 존재하려면 A, A+B, A+2B ... 와 같이 증가하는 수에 ans가 있어야 함
                // (ans-info[i][0])%info[i][2]==0 => 따라서 배수 관계를 고려하여 (ans-A)가 B의 배수인 경우에만 ans가 있는 것
                if (info[i][0]<=ans && ans<=info[i][1] && (ans-info[i][0])%info[i][2]==0){
                    ansCount++;
                }
            }
            System.out.println(ans+" "+ansCount);
        }

    }

    static int count(int A, int C, int B, int X){
        //A, A+B, ... , A+kB<=C 중에서 X 이하의 수가 몇 개나 있는가?
        if (X<A) return 0; // 모든 수가 X보다 크므로 0개 반환
        if (C<X) return (C-A)/B+1; // 모든 수가 X보다 작으므로 모든 개수 반환
        return (X-A)/B + 1;
    }

    static boolean determination(int cand) {
        //cand 이하의 수가 홀수 개인가? => cand 이하의 수가 홀수 개일 경우 L~mid 사이에 홀수 존재
        long sum = 0;
        for (int i=1; i<=N; i++){
            sum += count(info[i][0], info[i][1], info[i][2], cand);
        }
        return sum%2==1;
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
