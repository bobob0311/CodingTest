class Solution {
    public int solution(int[] num_list) {
        int a = 0;
        int b = 1;
        
        for(int i = 0; i<num_list.length; i++){
            int value = num_list[i];
            
            a+=value;
            b*=value;
        }
        if(a*a> b){
            return 1;
        }else{
            return 0;
        }
    }
}