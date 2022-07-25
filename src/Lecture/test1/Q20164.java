package Lecture.test1;

import java.io.*;
import java.util.StringTokenizer;

public class Q20164 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, ans_min = Integer.MAX_VALUE, ans_max = Integer.MIN_VALUE;

    static void input(){
        N = in.nextInt();
    }

    static int get_odd_cnt(int x){
        int res = 0;
        while(x>0){
            int digit = x%10;
            if (digit%2==1) res++;
            x /= 10;
        }
        return res;
    }

    //x라는 수에 도달했으며, 이 때까지 등장한 홀 수 자릿수가 total_odd_cnt만큼 있을 때, 남은 경우를 모두 잘라보는 함수
    static void dfs(int x, int total_odd_cnt){
        //1. 만약 한 자리 수이면 더 이상 작업할 수 없으므로 정답 갱신 후 종료
        if (x<=9){
            ans_min = Math.min(ans_min, total_odd_cnt);
            ans_max = Math.max(ans_max, total_odd_cnt);
            return;
        }
        //2. 두 자리 수면 2개로 나눠서 재귀 호출
        if (x<=99){
            int next_x = (x/10)+(x%10);
            dfs(next_x, total_odd_cnt+get_odd_cnt(next_x));
            return;
        }

        //3. 세 자리 수면 가능한 3가지 자르는 방법을 모두 진행행
        String s = Integer.toString(x);
        for (int i=0; i<=s.length()-3; i++){
            for (int j=i+1; j<=s.length()-2; j++){
                String x1 = s.substring(0, i+1); //s[0...i]
                String x2 = s.substring(i+1, j+1); //s[i+1...j]
                String x3 = s.substring(j+1, s.length()); //s[j+1...end]

                int next_x = Integer.parseInt(x1)+Integer.parseInt(x2)+Integer.parseInt(x3);
                dfs(next_x, total_odd_cnt + get_odd_cnt(next_x));
            }
        }
    }

    static void pro(){
        dfs(N, get_odd_cnt(N));
        sb.append(ans_min).append(" ").append(ans_max);
        System.out.println(sb);
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
