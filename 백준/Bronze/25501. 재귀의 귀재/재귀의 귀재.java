import java.util.*;
import java.io.*;

public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String nowStr = br.readLine();
            cnt = 1;
            sb.append(re(nowStr, 0, nowStr.length() - 1) + " " + cnt + "\n");
        }
        System.out.println(sb.toString());

    }

    static int re(String now, int start, int end) {
        if (start >= end) {
            return 1;
        } else if (now.charAt(start) != now.charAt(end)) {
            return 0;
        } else {
            cnt++;
            return re(now, start + 1, end - 1);
        }
    }
}