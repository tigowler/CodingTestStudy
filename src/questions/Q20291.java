package questions;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Q20291 {
    static int N;
    static String[] files;
    static StringBuilder sb = new StringBuilder();

    static void input(){
        Scanner in = new Scanner(System.in);
        N = Integer.parseInt(in.next());
        files = new String[N];
        for (int i=0; i<N; i++){
            String filename = in.next();
            String ex = filename.substring(filename.indexOf('.')+1);
            files[i] = ex;
        }
    }

    static void pro(){
        Arrays.sort(files);
        String ex = files[0];
        int curCount = 1;

        for (int i=1; i<N; i++){
            if (Objects.equals(files[i - 1], files[i])){
                curCount++;
            }
            else {
                sb.append(ex).append('\n');
                sb.append(curCount).append('\n');
                curCount=1;
                ex = files[i];
            }
        }
        sb.append(ex).append('\n');
        sb.append(curCount).append('\n');
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
}
