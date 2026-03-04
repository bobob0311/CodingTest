import java.io.*;
import java.util.*;

/*

*/

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] data = new String[N];

        for(int i = 0; i<N; i++){
            data[i] = st.nextToken();
        }

        Arrays.sort(data,(a,b) ->{
            return compareString(a,b);
        } );

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<data.length; i++){
            sb.append(data[i]);
        }
        if(sb.toString().charAt(0) == '0') {
            System.out.println("0");
            return;
        }
        System.out.println(sb.toString());
    }

    static int compareString(String a,String b){
        int idx = 0;
        int aLength = a.length();
        int bLength = b.length();
        while(true){
            // 만약 둘중에 하나라도 이제 못가는 상황임
            if(aLength == idx || bLength == idx){
                // a의 길이가 더 짧은 상황
                if(aLength < bLength){
                    return compareString(a,b.substring(idx));
                } else if (aLength > bLength) {
                    return compareString(a.substring(idx),b);
                }else{
                    return 0;
                }
            }


            if(a.charAt(idx) -'0' > b.charAt(idx) - '0'){
                return -1;
            }else if(a.charAt(idx) - '0' < b.charAt(idx) - '0'){
                return 1;
            }else{
                idx++;
            }
        }
    }
}