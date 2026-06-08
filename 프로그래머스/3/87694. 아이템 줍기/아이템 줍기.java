import java.util.*;

/*
rectangle => 직사각형이 담긴 2차원 배열 [좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y] (1~4)개 (1~50)사이
charater => 초기 캐릭터 위치 (1~50)
item => 아이템 위치 (1~50)

!! 캐릭터가 아이템을 줍기위해 이동해야 하는 가장 짧은 거리 산출 !!

1. 이동 가능한 4가지 경우 (아래,위,오른쪽,왼쪽)
2. 이동 가능한가?
    - 이동 가능하려면 어떤 사각형 내부에 들어가있으면 안됨
    - 어떤 사각형의 테두리에 있어야함.
*/

class Solution {
    
    static class Rectangle{
        
        int leftBottomX;
        int leftBottomY;
        int rightBottomX;
        int rightBottomY;
        int leftUpX;
        int leftUpY;
        int rightUpX;
        int rightUpY;
        
        public Rectangle(int[] rectangle){
            this.leftBottomX = rectangle[0] *2;
            this.leftBottomY = rectangle[1] *2;
            this.rightBottomX = rectangle[2] *2;
            this.rightBottomY = rectangle[1] *2;
            this.leftUpX = rectangle[0] *2;
            this.leftUpY = rectangle[3] *2;
            this.rightUpX = rectangle[2] *2;
            this.rightUpY = rectangle[3] *2;
        }
        
        public boolean chk(int x, int y){
            if(x > leftBottomX && x < rightBottomX && y > leftBottomY && y < leftUpY ) return false;
            return true;
        }
        
        public void makeMap(){
            for(int i = leftBottomX; i <= rightBottomX; i++ ){
                map[i][leftBottomY] = true;
                map[i][leftUpY] = true;
            }
            for(int i = leftBottomY; i <= leftUpY; i++){
                map[leftBottomX][i] = true;
                map[rightBottomX][i] = true;
            }
        }
    }
    
    static List<Rectangle> rList = new ArrayList<>();
    static Queue<Integer[]> que = new LinkedList<>();
    static int[] dx = new int[] {1,-1,0,0};
    static int[] dy = new int[] {0,0,1,-1};
    
    static boolean[][] chk = new boolean[102][102];
    static boolean[][] map = new boolean[102][102];
    
    static int targetX, targetY;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        targetX = itemX *2;
        targetY = itemY *2;
        
        for(int[] rect : rectangle){
            rList.add(new Rectangle(rect));
        }
        
        for(Rectangle rect : rList){
            rect.makeMap();
        }
        que.add(new Integer[]{characterX *2, characterY*2, 0});
        
        int answer = bfs();
        return answer;
    }
    
    static int bfs(){
        while(!que.isEmpty()){
            Integer[] node = que.poll();
            int nowX = node[0];
            int nowY = node[1];
            int step = node[2];
            
            if(targetX == nowX && targetY == nowY) return step;
            
            for(int i = 0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(isNotIn(nextX,nextY) && isCanGo(nextX,nextY)){
                    chk[nextX][nextY] = true;
                    que.add(new Integer[] {nextX + dx[i], nextY + dy[i], step +1});
                }
            }
        }
        return 0;
    }
    
    static boolean isCanGo(int x, int y){
        if(x<2 || x> 100 || y<2 || y > 100 || chk[x][y] || !map[x][y]) return false; 
        return true;
    }
    
    static boolean isNotIn(int x, int y){
        for(Rectangle rect : rList){
            if(!rect.chk(x,y)) return false;
        }
        return true;
    }
}