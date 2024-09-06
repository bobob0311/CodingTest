/*
모든 풍선에는 서로 다른 숫자

1. 인접한 두풍선을 고른 후 하나 펑
2. 터진 풍선ㅇ로 인해 풍선들 사이에 빈공간이 생기면 빈공간이 없도록 풍선 중앙 밀착

인접한 두 풍선 중에 번호가 더 작은 풍선을 터트리는 건 딱 한번만 가능

1. 작은걸 한번 터트린경우 => 마지막에 양 옆에 자기보다 큰수가 있어야 된다.
2. 작은걸 안터트린경우 => 마지막에 옆에 자기보다 큰수가 하나 있어야 한다. 

*/

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] arr = new int[a.length];
        int min = 1000000001;
        for(int i = 0; i<a.length; i++){
            if(a[i] < min){
                min = Math.min(min,a[i]);
            }else{
                arr[i]++;
            }
        }
        min = 1000000001;  
        for(int i=a.length-1; i>=0; i--){
            if(a[i] < min){
                min = Math.min(min,a[i]);
            }else{
                arr[i]++;
            }
        }
        
        for(int v : arr){
            if(v != 2){
                answer++;
            }
        }
        

        return answer;
    }
}
