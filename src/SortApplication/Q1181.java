package SortApplication;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1181 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Elem[] arr;

    static class Elem implements Comparable<Elem>{
        public String string;

        @Override
        public int compareTo(Elem other){
            if(this.string.length()==other.string.length()) return this.string.compareTo(other.string);
            else return this.string.length()-other.string.length();
        }
    }

    static void input(){
        N = in.nextInt();
        arr = new Elem[N];
        for(int i=0; i<N; i++){
            arr[i] = new Elem();
            arr[i].string = in.next();
        }
    }

    static void pro(){
        Arrays.sort(arr);
        for (int i=0; i<arr.length; i++){
            if(i==0||arr[i].compareTo(arr[i-1])!=0) sb.append(arr[i].string).append('\n');
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
