import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];
        int INF = Integer.MAX_VALUE;
        int startPoint = s;
        int endPointA = a;
        int endPointB = b;
        for(int i = 0; i<map.length; i++){
            Arrays.fill(map[i],INF);    
        }
        for(int i =0; i<map.length; i++){
            map[i][i] = 0;
        }
        
        
        for(int i = 0; i<fares.length; i++){
            int[] fare = fares[i];
            int point1 = fare[0];
            int point2 = fare[1];
            int money = fare[2];
            
            map[point1][point2] = money;
            map[point2][point1] = money;
        }
        
        for(int k = 1 ;k<n+1;k++){
            for(int j =1; j<n+1; j++){
                for(int i =1; i<n+1; i++){
                    if (map[i][k] != INF && map[k][j] != INF) { 
                        int temp = Math.min(map[i][j] , map[i][k] + map[k][j]);
                        map[i][j] = temp;
                        map[j][i] = temp;
                        
                    }
                }
            }
        }
        
        int ab = map[startPoint][endPointA] + map[startPoint][endPointB];
        
        for(int i =1; i<n+1; i++){
            int temp = map[startPoint][i] + map[i][endPointA] + map[i][endPointB];
            if(temp < ab){
                ab = temp;
            }
        }
        
        return ab;
    }
}