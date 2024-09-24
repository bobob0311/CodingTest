import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new LinkedList<>();
        int idx = findIdx(ext);
        for(int[] nowData : data){
            if(nowData[idx] < val_ext){
                list.add(nowData);
            }
        }
        
        int[][] arr = new int[list.size()][4];
        for(int i = 0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        idx = findIdx(sort_by);
        int sort = idx;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[sort], b[sort]));

        return arr;
    }
    public int findIdx(String str){
        if(str.equals("code")){
            return 0;
        }else if(str.equals("date")){
            return 1;
        }else if(str.equals("maximum")){
            return 2;
        }else{
            return 3;
        }
    }
}