class Solution {
    public int solution(int[] common) {
        int one = common[1] - common[0];
        int two;
        if(common[0] != 0){
            two = common[1] / common[0];    
        }else{
            two = 0;
        }
        boolean chk1 = true;
        for(int i = 0; i<common.length-1; i++){
            if(common[i] + one != common[i+1]){
                chk1 = false;
                break;
            }
        }
        if(chk1){
            return common[common.length-1] + one;
        }else{
            return common[common.length-1] * two;
        }

    }
}