package Lecture.SortApplication;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1183 {

    static FastReader in  = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;

    static void input(){
        N = in.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            arr[i] = a-b;
        }
    }

    static void pro(){
        Arrays.sort(arr);
        if (N%2==0){
            int mid = N/2;
            int left = arr[mid-1], right = arr[mid];
            sb.append(right-left+1);
        }
        else {
            sb.append(1);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
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
