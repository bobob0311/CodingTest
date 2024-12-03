/*
N(10000)개의 몇 섬 사이에는 다리가 설치되어있다.
두개의 섬에 공장을 세우고 물품을 생산
공장에서 다른 공장으로 수송
=> 다리마다 중량제한이 존재
한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값 구해라 
*/

import java.util.*;
import java.io.*;

public class Main{
    static class Node{
        List<int[]> arr;
        
        Node(){
            arr = new ArrayList<>();  
        }
        
        void link(int idx,int value){
            arr.add(new int[]{idx,value});
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 섬의 개수 
        int N = Integer.parseInt(st.nextToken());
        // 다리 정보 
        int M = Integer.parseInt(st.nextToken());
        
        List<Node> list = new ArrayList<>(N+1);
        
        for(int i = 0; i<=N; i++){
            list.add(new Node());
        }
        
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list.get(A).link(B,C);
            list.get(B).link(A,C);
        }
        
        st = new StringTokenizer(br.readLine());
        int startIdx = Integer.parseInt(st.nextToken());
        int endIdx = Integer.parseInt(st.nextToken());
        
        
        int start = 0;
        int end = 1000000001;
        int answer = 0;
        while(start <= end){
            boolean[] visited = new boolean[N+1];
            Queue<Integer> que = new LinkedList<>();
            int mid = (start+end)/2;
            
            boolean flag = false;
            que.offer(startIdx);
            
            while(!que.isEmpty()){
                
                int idx = que.poll();
                
                if(idx == endIdx){
                    flag = true;
                    break;
                }
                
                if(!visited[idx]){
                    visited[idx] = true;    
                }else{
                    continue;
                }
                
                Node nowNode = list.get(idx);
                
                for(int[] nowArr : nowNode.arr){
                    if(nowArr[1] >= mid && !visited[nowArr[0]]){
                        que.offer(nowArr[0]);
                    } else{
                        continue;
                    }
                }
            }
            // 최종까지 갈 수 있다
            if(flag){
                start = mid + 1;
                answer = mid;
            }else{
                end = mid -1;
            }
            
        }
        
        System.out.println(answer);
        
    }
}