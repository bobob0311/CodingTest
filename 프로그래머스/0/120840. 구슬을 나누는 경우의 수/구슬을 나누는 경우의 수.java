class Solution {
    public int solution(int balls, int share) {
        if(balls == share){
            return 1;
        }
        double up = 1;
        for(int i =balls ; i>share; i--){
            up *=i;
        }
        for(int i = balls-share ; i>0 ; i--){
            up /= i;
        }
        return (int) up;
    }
}