/*
구멍을 막을 두 레고조각
구멍 너비 => x
두 조각의 길이의 합은 구멍의 너비와 정확하게 일치해야한다. 
무조건 두조각으로

구멍의 너비 
레고의 조각 수 
100000000 이하

1000000 1000000
a + b = target
*/
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input = br.readLine())!=null && !input.isEmpty()){
        int target = Integer.parseInt(input) * 10000000;
        int N = Integer.parseInt(br.readLine());
        /*
        if (N < 2) {
            System.out.println("danger");
            return;
        }
        */
        
        int[] arr = new int[N];
        
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        boolean flag = false;
        int start = 0;
        int end = arr.length-1;
        
        while(start < end){
            int sum = arr[start] + arr[end];
            
            if(sum < target){
                start++;
            }else if(sum > target){
                end--;
            }else{
                System.out.printf("yes %d %d\n", arr[start], arr[end]);
                flag = true;
			    break;
            }
        }
        if(!flag){
            System.out.println("danger");    
        }
        
        }
        
        
        
        
        
        
    }
}