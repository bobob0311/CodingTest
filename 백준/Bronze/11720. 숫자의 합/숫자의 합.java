import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String target = br.readLine();
        
        for(int i = 0; i< N; i++){
            int now = Integer.parseInt(target.substring(i,i+1));
            answer += now;
        }
        
       
        System.out.println(answer);
    }
}