import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        for(int i = 0; i< 26; i++){
            arr[i] = -1;
        }
        String str = br.readLine();
        
        for(int i = 0; i<str.length(); i++){
            int idx =((int) str.charAt(i)) - 97;
            if(arr[idx] == -1){
                arr[idx] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<26; i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
