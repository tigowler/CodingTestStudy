package Lecture.test2_1;

import java.io.*;
import java.util.StringTokenizer;

public class Q21918 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, a, b, c;
    static int[] bulbs;

    static void input(){
        N = in.nextInt();
        M = in.nextInt();
        bulbs = new int[N+1];
        for (int i=1; i<=N; i++){
            bulbs[i] = in.nextInt();
        }
    }

    static void changeBulbState(){
        switch (a){
            case 1:
                //i번째 전구의 상태를 x로 변경
                bulbs[b] = c;
                break;
            case 2:
                //l번째부터 r번째까지의 전구 상태 변경
                for (int i=b; i<=c; i++){
                    if (bulbs[i]==0) bulbs[i]=1;
                    else bulbs[i]=0;
                }
                break;
            case 3:
                //l번째부터 r번째까지의 전구 끄기
                for (int i=b; i<=c; i++){
                    bulbs[i] = 0;
                }
                break;
            case 4:
                //l번째부터 r번째까지의 전구를 켜기
                for (int i=b; i<=c; i++){
                    bulbs[i] = 1;
                }
                break;
            default:
                break;
        }
    }

    static void pro(){
        changeBulbState();
    }

    public static void main(String[] args) {
        input();
        for (int i=1; i<=M; i++) {
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            pro();
        }
        //출력
        for (int i=1; i<=N; i++){
            sb.append(bulbs[i]).append(' ');
        }
        System.out.println(sb);
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
