import java.io.*;
import java.util.*;

/*
S -> T로 바꾸는 게임

- 문자열의 뒤에 A를 추가 한다.
- 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.

A를 0으로 보고
B를 1로 본다면?

*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String S,T;

    static Queue<String> que = new LinkedList<>();
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        int SLength = S.length();
        que.offer(T);
        while(!que.isEmpty()){
            String nowString = que.poll();
            int nowStringLength = nowString.length();
            if(nowStringLength < SLength ) continue;
            if(nowStringLength == SLength && S.equals(nowString)){
                System.out.println(1);
                return;
            }
            if(nowString.charAt(nowStringLength-1) == 'A'){
                que.offer(nowString.substring(0,nowStringLength -1));
            }
            if(nowString.charAt(0) == 'B'){
                que.offer(reverseString(nowString.substring(1)));
            }


        }
        System.out.println(0);


    }

    static String reverseString(String nowStr){
        sb.setLength(0);
        sb.append(nowStr);
        sb.reverse();
        return sb.toString();
    }

}