import java.util.*;

/*
세로 n 50
가로 m 50
 2500

requests 100

=> 250000



접근 가능한 해당 종류의 컨테이너를 모두 꺼낸다.

1. 하나인 경우 접근 가능한 컨테이너만 꺼낸다
2. 같은 알파벳이 두번인 경우 요청된 종류의 모든 컨테이너를 꺼낸다. 

*/

class Solution {
    static char[][] map;
    static int cnt = 0;
    static boolean[][] chk;
    static Queue<int[]> que = new LinkedList<>();
    static Queue<int[]> can = new LinkedList<>();
    static int[] dx = new int[] {0, 0, 1, -1};
    static int[] dy = new int[] {1, -1, 0, 0};
    
    public int solution(String[] storage, String[] requests) {
        map = new char[storage.length][storage[0].length()];
        
        for(int i = 0; i<storage.length; i++){
            for(int j = 0; j< storage[0].length(); j++){
                map[i][j] = storage[i].charAt(j);
            }
        }
        
        for(int i = 0; i< requests.length; i++){
            String nowString = requests[i];
            char nowChar = nowString.charAt(0);
            
            if(nowString.length() == 1){
                deleteCanContainer(nowChar);
            }else{
                deleteAllContainer(nowChar);
            }
        }
        
        int answer = map.length * map[0].length - cnt;
        return answer;
    }
    
    // 해당되는 알파벳을 모두 지움
    static void deleteAllContainer(char targetChar){
        for(int i = 0; i< map.length; i++){
            for(int j = 0; j< map[0].length; j++){
                if(map[i][j] == targetChar){
                    map[i][j] = '-';
                    cnt++;
                }
            }
        }
    }
    
    // 해당되는 알파벳중 접근 가능한 알파벳만 지움
    static void deleteCanContainer(char targetChar){
        chk = new boolean[map.length][map[0].length];
        
        // 겉에 좌표 모두 집어넣기
        for(int i = 0; i<map.length; i++){
            if(i == 0 || i == map.length -1){
                for(int j = 0; j< map[0].length; j++){
                    que.add(new int[] {i,j});
                    chk[i][j] = true;
                }
            }else{
                que.add(new int[] {i,0});
                chk[i][0] = true;
                que.add(new int[] {i,map[0].length-1});
                chk[i][map[0].length-1] = true;
            }
        }
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            
            if(map[x][y] == '-'){
                for(int i = 0; i<4; i++){
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];
                    
                    if(nextX >=0 && nextY >=0 && nextX <map.length && nextY < map[0].length && !chk[nextX][nextY]){
                        que.add(new int[] {nextX, nextY});
                        chk[nextX][nextY] = true;
                    }
                }
            }else{
                can.add(new int[] {x,y});
            }
        }
        
        while(!can.isEmpty()){
            int[] now = can.poll();
            int x = now[0];
            int y = now[1];
            
            if(map[x][y] == targetChar){
                map[x][y] = '-';
                cnt++;
            }
            
        }
        
        
    }
}