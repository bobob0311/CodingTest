/*
1. n개의 포인트 
2. 운송경로는 m개의 포인트 (첫 포인트 -> 순서대로 방문)
3. x대의 로봇 0초에 출발 r좌표와 c 좌표 중 하나가 1만큼 감소하거나 증가한 좌표 => 상하좌우 이동 가능 
    r좌표가 변하는걸 먼저한다. =>  
4. 마지막 포인트에 도달하면 물류 센터를 벗어난다.


- 같은 좌표에 로봇이 2대 이상있으면 충돌할 가능성 -> 위험 상황
- 위험한 상황이 총 몇번 일어나는지 알고 싶다. 어떤 시간에 여러 좌표에서 위험 상황 발생시 그 횟수 모두 더하기


1. r좌표가 먼저 움질 일 수 있도록

*/

import java.util.*;

class Solution {
    static class Robot{
        int x;
        int y;
        int targetX;
        int targetY;
        int id;
        
        int targetNum = 1;
        int phase = 0;
        
        public Robot(int[] startPoint, int id,int[] targetPoint){
            this.x = startPoint[0];
            this.y = startPoint[1];
            this.id = id;
            this.targetX = targetPoint[0];
            this.targetY = targetPoint[1];
            map[x][y] +=1;
        }
        
        // 움직이고 개수 세주는 역할
        public boolean move(){
            map[x][y]-= 1;
            
            if(targetX < x){
                x--;
            }else if(targetX > x){
                x++;
            }else if(targetY < y){
                y--;
            }else if(targetY > y){
                y++;
            }
            map[x][y]+=1;
            
            if(x == targetX && y == targetY) return true;
            return false;
        }
    }
    
    static List<Robot> rList;
    static Queue<Robot> que = new LinkedList<>();
    static int step = 0;
    static int[][] map;
    static int answer;
    
    public int solution(int[][] points, int[][] routes) {
        rList = new ArrayList<>();
        map = new int[101][101];
        answer = 0;
        
        for(int i = 0; i< routes.length; i++){
            rList.add(new Robot(points[routes[i][0] -1] , i, points[routes[i][1] -1]));
        }
        
        for(Robot robot : rList){
            que.add(robot);
        }
        answer += chkWarn();
        
        bfs(points,routes);
        return answer;
    }
    
    static void bfs(int[][] points, int[][] routes){
        while(!que.isEmpty()){
            Robot robot = que.poll();
            int nowX = robot.x;
            int nowY = robot.y;
            int id = robot.id;
            int phase = robot.phase;
            
            if(step != phase) {
                answer += chkWarn();
                step++;
            }
            
            if(routes[robot.id].length-1 < robot.targetNum) {
                map[nowX][nowY] -=1;
                continue;
            };
            
            if(robot.move()){
                int nextTargetNum = robot.targetNum +1;
                if(routes[robot.id].length -1 < nextTargetNum){
                    robot.targetNum +=1;
                    que.add(robot);
                }else{
                    robot.targetNum +=1;
                    robot.targetX = points[routes[robot.id][nextTargetNum] -1][0];
                    robot.targetY = points[routes[robot.id][nextTargetNum] -1][1];
                    que.add(robot);    
                }
            }else{
                que.add(robot);
            }
            robot.phase+=1;
        }
    }
    
    static public int chkWarn(){
        int cnt = 0;
        
        for(int[] line: map){
            for(int dot : line){
                if(dot > 1) cnt++;
            }
        }
        
        return cnt;
    }
    
}