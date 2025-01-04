import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;
        String[] arr = str.split("-");
        for (int i = 0; i < arr.length; i++) {
            String nowStr = arr[i];
            String[] now = nowStr.split("\\+");
            int temp = 0;
            for (int j = 0; j < now.length; j++) {
                temp += Integer.parseInt(now[j]);
            }
            if (i == 0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }

        System.out.println(answer);

    }
}