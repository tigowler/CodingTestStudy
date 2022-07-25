package Lecture.test2_1;

import java.io.*;
import java.util.StringTokenizer;

public class Q21925 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] arr = new int[5000];

    //left, right = 왼쪽, 오른쪽 인덱스
    static boolean isEvenPalindrome(int left, int right){
        if ((right-left) % 2 == 0) return false; //수열에 포함된 개수가 짝수가 아니면 false
        for (int i=0; i<=(right-left)/2; i++){
            if (arr[left+i] != arr[right-i]) return false;
        }
        return true;
    }

    static void input(){
        n = in.nextInt();
        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
    }

    static void pro(){
        int answer = 0;
        int j = 0;
        for (int i=0; i<n;){ //팰린드롬 시작점
            boolean found = false;
            for (j = i+1; j<n; j+=2){ //팰린드롬 끝점
                if (isEvenPalindrome(i, j)){
                    answer+=1;
                    found = true;
                    break;
                }
            }
            if (!found) {
                answer = -1;
                break;
            }
            i = j + 1;
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
