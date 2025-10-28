import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalPrice = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int calcPrice = 0;
        for(int i = 0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            
            calcPrice += price * count;
        }
        
        if(calcPrice == totalPrice) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    
}