// 원이라는 점에서 처리를 잘해야될거같다.

class Solution {
    public int solution(int[] money) {
        // 마지막집을 비울경우
        int[] arr1 = new int[money.length];
        arr1[0] = money[0];
        arr1[1] = money[1];
        arr1[2] = money[2] + arr1[0];
        
        for(int i =3; i<money.length; i++){
            arr1[i] = Math.max(arr1[i-2],arr1[i-3]) + money[i];
        }
        // 마지막집을 비우지 않을 경우
        int[] arr2 = new int[money.length];
        arr2[0] = 0;
        arr2[1] = money[1];
        arr2[2] = money[2];
        for(int i =3; i<money.length; i++){
            arr2[i] = Math.max(arr2[i-2],arr2[i-3]) + money[i];
        }
        
        int max = 0;
        for(int i =0; i<money.length-1; i++){
            if(max<arr1[i]){
                max = arr1[i];
            }
        }
        
        for(int i =0; i<money.length; i++){
            if(max<arr2[i]){
                max = arr2[i];
            }
        }
        
        return max;
    }
}