import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String input = "";
 
        while((input = br.readLine())!=null && !input.isEmpty()){
            //cm를 nm로 변경
            long x = Integer.parseInt(input) * 1_000_000_000L / 100;
            int n = Integer.parseInt(br.readLine());
 
            long[] lego = new long[n];
 
            for(int i=0;i<lego.length;i++){
                lego[i] = Long.parseLong(br.readLine());
            }
 
            Arrays.sort(lego);
 
            int[] answer = new int[]{0,0};
            boolean valid = false;
            int l = 0;
            int r = n-1;
 
            //투포인터를 이용해 두수의 합이 x인 것을 탐색
            while(l<r){
                long sum = lego[l]+lego[r];
 
                //두 수의 합이 x인 경우
                if(sum == x){
                    valid = true;
 
                    //두 수의 절대값이 더 크거나 같은것을 찾은 경우 해당 경우의 수를 대입
                    //원래는 큰 것만해도 가능하나 초기값을 0,0으로 고정하여 차이가 0이 나온다.
                    //이 때 lego[l]과 lego[r]이 모두 값이 같아 차이가 0인 경우 부등호가 <이면 업데이트되지 않기 때문에 <=로 설정한다.
                    if(lego[answer[1]] - lego[answer[0]]  <= lego[r] - lego[l]){
                        answer[0] = l;
                        answer[1] = r;
                    }
                }
 
                if(sum > x){
                    r--;
                }else{
                    l++;
                }
            }
 
            if(!valid){
                System.out.println("danger");
            }else{
                System.out.println(String.format("yes %d %d",lego[answer[0]],lego[answer[1]]));
            }
        }
    }
}