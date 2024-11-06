class Solution {
    int max = -1;
    
    public int[] solution(int[] array) {
        int index = -1;
        for(int i =0; i<array.length; i++){
            if(max < array[i]){
                max = array[i];
                index = i;
            }
        }
        
        int[] answer = new int[] {max, index};
        return answer;
    }
}