class Solution {
    public int solution(int num) {
        int count = 0;
        long target = (long)num;

        while(count<=500){
            if(target == 1){
                return count;
            }
            if(target %2 ==0){
                target/=2;
            }else{
                target = target*3 +1;
            }
            count++;

        }

        return -1;
    }
}