/*
n개의 주사위를 가지고 승부
각 면이 나올 확률은 동일

A가 승리할 확률이 가장 높아지기 위해서 어떤 주사위를 가져가야하나?
n=> 10개 이하
1~100;

모든 경우의 수를 센다?
*/

// 선택부터?
// 계산부터?

import java.util.*;
class Solution {
    static int max = 0;
    static int[] firstArr;
    static int[] secondArr;
    static int stIdx = 0;
    static int[] maxArr;
    public int[] solution(int[][] dice) {
        boolean[] chk = new boolean[dice.length];
        maxArr = new int[dice.length/2];
        firstArr = new int[dice.length/2];
        secondArr = new int[dice.length/2];
        
        findArr(dice.length/2, 0,dice,chk,0);
        
        Arrays.sort(maxArr);
        return maxArr;
    }
    
    
    void findArr(int limit, int now,int[][] dice,boolean[] chk,int idx){
        if(now == limit){
            findCount(dice,chk);
            return;
        }
        for(int i =idx; i<dice.length; i++){
            if(!chk[i]){
                firstArr[now] = i;
                chk[i] = true;
                findArr(limit,now+1,dice,chk,i+1);
                chk[i] = false;
            }
            
        }
    }
    void findCount(int[][] dice,boolean[]chk){
        int idx = 0;
        for(int i =0; i<dice.length; i++){
            if(chk[i] == false){
                secondArr[idx++] = i;
            }
        }

        int[] valueArr1 = new int[(int)Math.pow(6,firstArr.length)];
        int[] valueArr2 = new int[(int)Math.pow(6,firstArr.length)];
        idx =0;
        stIdx=0;
        calc(dice, valueArr1,0,0,firstArr);
        stIdx=0;
        calc(dice, valueArr2,0,0,secondArr);
        
        Arrays.sort(valueArr1);
        Arrays.sort(valueArr2);
        
        int count =0;
        
        for(int i =0; i<valueArr2.length; i++){
            int nowValue = valueArr1[i];
            
            int startIdx = 0;
            int endIdx = valueArr2.length-1;
            while(startIdx<endIdx){
                int mid = (startIdx + endIdx) /2;
                if(nowValue > valueArr2[mid]){
                    startIdx = mid+1;
                }else {
                    endIdx = mid -1;
                }
            }
            if(valueArr2[startIdx] >= nowValue){
                count += startIdx-1;
            }else{
                count += startIdx;
            }
        }
        
        int temp = max;
        max = Math.max(max,count);
        if(temp!=max){
            for(int i=0; i<maxArr.length; i++){
                maxArr[i] = firstArr[i]+1;
            }
        }
    }
    
    void calc(int[][] dice, int[] valueArr,int nowIdx,int nowSum, int[]arr){
        if (nowIdx == firstArr.length){
            valueArr[stIdx++] = nowSum;
            return;
        }
        for(int i =0; i<6;i++){
            calc(dice, valueArr,nowIdx+1, nowSum + dice[arr[nowIdx]][i], arr);
        }
    }
}