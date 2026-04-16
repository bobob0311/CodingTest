// 19 57시 시작 
import java.util.*;

class Solution {
    static int[][] map;
    static int[][] dp;
    static int M,N;
    static TreeSet<Integer> set = new TreeSet<>((a,b)->Integer.compare(a,b));
    static int maxVal = 0;
    static int[] answerArr = new int[2];
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        M = m;
        N = n;
        
        map = new int[m][n];
        dp = new int[m][n];
        
        for(int i = 0; i< drops.length;i++){
            int[] drop = drops[i];
            map[drop[0]][drop[1]] = i+1;
        }
        
       
        calcColumnByH(h);
        calcRowByW(w,h);
        
        return answerArr;
    }
    
    static void calcRowByW(int w,int h){
        for(int i = 0; i< M-h+1; i++){
            set.clear();
            initSetByRow(i,w);
            moveW(i,w);
        }
    }
    
    static void initSetByRow(int rowIdx,int w){
        for(int i = 0; i<w; i++){
            int nowDropNum = dp[rowIdx][i];
            if(nowDropNum != 0) set.add(nowDropNum);
        }
        
        if(set.size() != 0){
            if(maxVal < set.first()){
                maxVal = set.first();
                answerArr[0] = rowIdx;
                answerArr[1] = 0;
            }            
        }else{
            if(maxVal != Integer.MAX_VALUE){
                maxVal = Integer.MAX_VALUE;
                answerArr[0] = rowIdx;
                answerArr[1] = 0;    
            }
            
        }
    }
    
    static void moveW(int rowIdx,int w){
        for(int i = w; i<N;i++){
            int start = i-w;
            int end = i;
            set.remove(dp[rowIdx][start]);
            if(dp[rowIdx][end] != 0){
                set.add(dp[rowIdx][end]);                
            }
            
            if(set.size() != 0){
                if(maxVal < set.first()){
                    maxVal = set.first();
                    answerArr[0] = rowIdx;
                    answerArr[1] = start+1;
                }            
            }else{
                if(maxVal != Integer.MAX_VALUE){
                    maxVal = Integer.MAX_VALUE;
                    answerArr[0] = rowIdx;
                    answerArr[1] = start+1;    
                }
                
            }
        }
    }
    
    static void calcColumnByH(int h){
        for(int i = 0; i<N; i++){
            set.clear();
            initSetByColumn(i,h);
            moveH(i,h);
        }
    }
    
    static void initSetByColumn(int columnIdx,int h){
        for(int i = 0; i<h; i++){
            int nowDropNum = map[i][columnIdx];
            if(nowDropNum != 0) set.add(nowDropNum);
        }
        
        if(set.size() != 0){
            dp[0][columnIdx] = set.first();                
        }
    }
    
    static void moveH(int columnIdx,int h){
        for(int i = h; i<M;i++){
            int start = i-h;
            int end = i;
            set.remove(map[start][columnIdx]);
            if(map[end][columnIdx] != 0){
                set.add(map[end][columnIdx]);                
            }
            if(set.size() != 0){
                dp[start+1][columnIdx] = set.first();                
            }
        }
    }
    
    
}