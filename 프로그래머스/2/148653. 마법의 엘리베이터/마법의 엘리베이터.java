/*

*/

class Solution {
    static int min = 9999999;
    public int solution(int storey) {
        int digit =0;
        int temp = storey;
        int count = 0;
        while(true){
            if(temp / 10 > 10){
                digit++;
            }else{
                digit++;
                break;
            }
            temp /=10; 
        }
        dfs(digit,0,storey);
        
        

        
        return min;
    }
    public void dfs(int digit, int count, int value){
        if(value == 0){
            min = Math.min(min,count);
            return;
        }
        int firstCount = value/ (int) Math.pow(10,digit);
        int firstValue = value% (int)Math.pow(10,digit);
        dfs(digit -1 ,count+firstCount, firstValue);
        int secondCount = 1 + ((int)Math.pow(10,digit+1) - value) / (int)Math.pow(10,digit);
        int secondValue = ((int)Math.pow(10,digit+1) - value) % (int)Math.pow(10,digit);
        dfs(digit -1, count+secondCount, secondValue);
    }
}