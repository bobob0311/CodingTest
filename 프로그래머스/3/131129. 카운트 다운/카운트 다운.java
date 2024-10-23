// 최선의 경우와 싱글 또는 불을 맞춘 횟수를 적어야된다. 

class Solution {
    public int[] solution(int target) {
        int v = Math.max(61,target+1);
        
        int[][] arr = new int[v][2];
        for(int i =1; i<=20; i++){
            arr[i][0] = 1;
            arr[i][1] = 1;
            
            arr[i*2][0] = 1;
            arr[i*2][1] = 0;
            
            arr[i*3][0] = 1;
            arr[i*3][1] = 0;
        }
        arr[50][0] = 1;
        arr[50][1] = 1;
        
        for(int i =1; i<=target; i++){
            int end = i-1;
            int start = 1;
            int value = arr[i][0];
        
            while(start<=end){
                if(arr[start][0] == 0 || arr[end][0] ==0){
                    start++;
                    end--;
                    continue;
                }
                
                int nowValue = arr[start][0] + arr[end][0];
                int nowC = arr[start][1] + arr[end][1];
                
                if(value == 0){
                    arr[i][0] = nowValue;
                    arr[i][1] = nowC;
                    value = nowValue;
                    
                }else if(value > nowValue){
                    arr[i][0] = nowValue;
                    arr[i][1] = nowC;
                    value = nowValue;
                }else if(value == nowValue){
                    if(arr[i][1] < nowC){
                        arr[i][1] = nowC;
                    }
                }
                start++;
                end--;
            }
        }
        
        int[] answer = {arr[target][0],arr[target][1]};
        return answer;
    }
}