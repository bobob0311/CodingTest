class Solution {
    public int[] solution(int[] arr) {
        for(int i = 0; i<arr.length; i++){
            int target = arr[i];
            if(target>= 50 && target % 2 == 0 ){
                arr[i] = target/2;
            }else if(target<50 && target % 2 == 1){
                arr[i] = target * 2;
            }
        }
        
        return arr;
    }
}