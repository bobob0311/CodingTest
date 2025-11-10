import java.io.*;
import java.util.*;

/*
특정 문자열 S
특정 알파벳과 구간이 주어지면
구간 사이에 특정 알파벳이 몇번 나타나는지 구해라
*/

public class Main {
    static char targetChar;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] prefix = new int[26][str.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                prefix[j][i + 1] = prefix[j][i];
            }
            prefix[c][i + 1]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int idx = ch - 'a';
            sb.append(prefix[idx][end + 1] - prefix[idx][start]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
