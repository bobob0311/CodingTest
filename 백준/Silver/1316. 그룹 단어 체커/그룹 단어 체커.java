import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for(int i = 0; i< cnt; i++){
            String nowStr = br.readLine();
            Map<Character,Integer> map = new HashMap<>();
            char prevChar = nowStr.charAt(0);
            boolean flag = true;
            for(int j = 1; j<nowStr.length(); j++){
                // 만약 전이랑 다를경우
                if(prevChar != nowStr.charAt(j)){
                    // 전에 이게 안나온 경우 나왔다고 표시
                    if(map.get(prevChar) == null){
                        map.put(prevChar,1);
                        prevChar = nowStr.charAt(j);
                    // 나왔는데 또 나온 경우
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(map.get(prevChar) != null) flag = false;
            if(flag) answer++;
            
        }
        System.out.println(answer);
    }
}
