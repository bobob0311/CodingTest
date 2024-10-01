class Solution {
    public int solution(int coin, int[] cards) {
        int startIdx = 0;
        int target = cards.length +1;
        int endIdx = cards.length / 3;
        boolean[] chk = new boolean[cards.length];
        
        int count = 0;
        for(int i =0; i<endIdx; i++){
            for(int j =i; j<endIdx; j++){
                if(cards[i] + cards[j] == target){
                    chk[i] = true;
                    chk[j] = true;
                    count++;
                }
            }
        }
        int plusStartIdx = endIdx;
        int plusEndIdx = endIdx+ (count * 2);
        int nowCoin = 0;
        
        
        // 코인을 써야만 하는데 못쓸경우 거기서 끝.
        while(nowCoin <= coin){
            count+=1;
            boolean find = false;
            plusEndIdx+=2;
            if(plusEndIdx > cards.length){
                plusEndIdx = cards.length;
                break;
            }
            for(int i =0; i<endIdx; i++){
                if(find){
                    break;
                }
                if(chk[i]){
                    continue;
                }
                for(int j = plusStartIdx; j<plusEndIdx; j++){
                   if(cards[i] + cards[j] == target){
                       chk[i] = true;
                       chk[j] = true;

                       nowCoin++;
                       find = true;
                       break;
                   } 
                }
            }
            if(find){
                continue;
            }
            
            for(int i =plusStartIdx; i<plusEndIdx; i++){
                if(find){
                    break;
                }
                if(chk[i]){
                    continue;
                }
                for(int j = i+1; j<plusEndIdx; j++){
                   if(cards[i] + cards[j] == target){
                       chk[i] = true;
                       chk[j] = true;

                       nowCoin+=2;
                       find = true;
                       break;
                   } 
                }
            }
            if(!find){
                break;
            }
        }
        if(count == 0){
            return 1;
        }
        return count;
    }
}