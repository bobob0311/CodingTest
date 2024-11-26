/*
minHeap을 돈 기준으로 만든다음에 
코너는 +500
직선은 +100

최소 비용이므로 bfs

현재 좌표랑 현재 방향을 기억해야됨.
*/

import java.util.*;
class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    class Node{
        int x;
        int y;
        int money;
        int direction;
        Node(int x, int y,int money, int direction){
            this.x = x;
            this.y = y;
            this.money = money;
            this.direction = direction;
        }
    }
    public int solution(int[][] board) {
        int targetX = board.length;
        int targetY = board[0].length;
        // 들어온 방향도 저장
        boolean[][][][] chk = new boolean[targetX][targetY][2][2];
        
        PriorityQueue<Node> heap =  new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1,Node o2){
                return Integer.compare(o1.money,o2.money);
            }
        });
        // 세로 시작
        if(board[1][0] == 0){
            heap.offer(new Node(1,0,100,1));    
        }
        // 가로시작
        if(board[0][1] == 0){
            heap.offer(new Node(0,1,100,0));    
        }
        
        
                
        int answer = Integer.MAX_VALUE;
        while(!heap.isEmpty()){
            Node now = heap.poll();
            
            
            // 정지 조건
            if(now.x == targetX-1 && now.y == targetY-1){
                answer = Math.min(answer,now.money);
                continue;
            }
            for(int i = 0; i<4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                // 세로
                if(i% 2 ==0){
                    if(nextX >= 0 && nextX <targetX && chk[nextX][nextY][now.direction][1] == false && board[nextX][nextY] == 0){
                        int nextMoney = now.money;
                        if(now.direction == 1){
                            nextMoney+= 100;
                        }else{
                            nextMoney+=600;
                        }
                        chk[nextX][nextY][now.direction][1] = true;
                        heap.offer(new Node(nextX,nextY,nextMoney,1));
                    }
                }else{ // 가로
                    if(nextY >= 0 && nextY <targetY && chk[nextX][nextY][now.direction][0] == false && board[nextX][nextY] == 0){
                        int nextMoney = now.money;
                        if(now.direction == 1){
                            nextMoney+= 600;
                        }else{
                            nextMoney+=100;
                        }
                        chk[nextX][nextY][now.direction][0] = true;
                        heap.offer(new Node(nextX,nextY,nextMoney,0));
                    }
                }
                
            }
            
        }
        
        

        return answer;
    }
}