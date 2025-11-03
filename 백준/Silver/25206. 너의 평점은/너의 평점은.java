import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        double totalNum = 0;
        double totalPrice = 0;
        
        String[] bucket = {"A+","A0","B+","B0","C+","C0","D+","D0","F","P"};
        double[] priceArr = {4.5,4.0,3.5,3.0,2.5,2.0,1.5,1.0,0.0,0.0};
        Map<String,Double> map = new HashMap<>();
        
        for(int i = 0; i< 10; i++){
            map.put(bucket[i],priceArr[i]);
        }
        String line;
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            String dummy = st.nextToken();
            double num = Double.parseDouble(st.nextToken());
            String price = st.nextToken();
            
            if(price.equals("P")) continue;
            
            double c = num * map.get(price);
            totalPrice += c;
            totalNum += num;
        }
        
        
        
        double answer = totalPrice / totalNum ;
        System.out.println(answer);
        
    }
}
