import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int now = 1;
        int cnt = 1;
        
        while (N > now) {
            now += 6 * cnt;
            cnt++;
        }
        
        System.out.println(cnt);
    }
}
