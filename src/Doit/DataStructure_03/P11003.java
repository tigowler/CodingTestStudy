package Doit.DataStructure_03;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

// 정렬할 시 시간 복잡도 문제 발생. Deque 이용하여 시간 복잡도 줄이기!
public class P11003 {
    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        StringBuilder sb = new StringBuilder();
        int N = in.nextInt();
        int L = in.nextInt();
        int[] A = new int[N];
        for (int i=0; i<N; i++){
            A[i] = in.nextInt();
        }
        Deque<Node> d = new LinkedList<>();

        for (int i=0; i<N; i++){
            int now = A[i];

            // 1) 새로운 값이 들어오면 현재 수보다 큰 값을 제거함
            while(!d.isEmpty() && d.getLast().value>now){
                d.removeLast();
            }
            // 2) 새로운 값 추가
            d.addLast(new Node(now, i));
            // 3) 윈도우 크기에서 벗어난 값은 덱에서 제거
            if (d.getFirst().index<=i-L){
                d.removeFirst();
            }
            sb.append(d.getFirst().value).append(" ");
        }

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

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}

