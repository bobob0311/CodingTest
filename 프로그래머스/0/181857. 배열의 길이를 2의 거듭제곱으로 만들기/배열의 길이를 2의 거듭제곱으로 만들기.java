class Solution {
    public int[] solution(int[] arr) {
        int num = 0;
        while(true){
            if(arr.length<=(int)Math.pow(2,num)){
                break;
            }
            num++;
        }
        
        
        int[] answer = new int[(int)Math.pow(2,num)];
        for(int i = 0; i<arr.length; i++){
            answer[i] = arr[i];
        }
        for(int i = arr.length; i<Math.pow(2,num);i++){
            answer[i] = 0;
        }
        
        return answer;
    }
}