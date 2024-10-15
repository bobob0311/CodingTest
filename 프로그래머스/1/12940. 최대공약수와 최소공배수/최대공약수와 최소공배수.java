class Solution {
    public int[] solution(int n, int m) {
        int min =1;
        int max =Math.max(n,m);
        
        /*
        while(true){
            if(min % n == 0 && min % m ==0){
                break;
            }
            min++;
        }
        */
        
        
        while(true){
            if(n % max ==0 && m%max == 0){
                break;
            }
            max--;
        }


        while(n>1 || m >1){
            for(int i =2; i<=Math.max(n,m); i++){
                if(n%i == 0 && m%i ==0){
                    min*=i;
                    n/=i;
                    m/=i;
                    break;
                }else if(n % i == 0){
                    min*=i;
                    n/=i;
                    break;
                }else if(m % i == 0){
                    min*=i;
                    m/=i;
                    break;
                }
            }
        }
        
        
        
        int[] answer = {max,min};
        return answer;
    }
}