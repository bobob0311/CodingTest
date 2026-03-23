import java.io.*;
import java.util.*;

/*
N*N의 지도
길이란 한 행 또는 한 열 전부=> 한쪽끝에서 다른쪽 끝까지 가는 것

길을 지나가려면 길에 속한 모든 칸의 높이가 같아야한다.
- 경사로를 놓아서 지나갈 수 있는 길을 만들 수 있다.
    => 경사로는 높이가 1 길이는 L

- 경사로는 낮은 칸에 놓고 L개의 연속된 칸에 경사로의 바닥이 접하게
- 낮은 칸과 높은 칸의 높이 차이는 1
- 경사로를 놓을 낮은칸의 높이는 모두 같고 L개의 칸이 연속으로

X
- 경사로에 놓은곳에 또 경사로
- 낮은 칸과 높은 칸의 높이 차이가 1이 아닌경우
- 낮은 지점의 칸의 높이가 모두 같지 않거나 L개가 연속되지 않은 경우
- 경사로 놓다가 범위를 벗어나는 경우

- 지도가 주어졌을 때, 지나갈 수 있는 길의 개수를 구해라
*/



/*
열과 행을 기준으로 판단해야한다.
*/
public class Main {
    static boolean[][] visited;

    static StringTokenizer st;
    static StringBuilder sb;

    static int[][] map;
    static int N,L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(sol());

    }

    static int sol(){
        int cnt = 0;
        for(int i = 0; i<N; i++){
            if(columnCan(i)) cnt++;
        }
        visited = new boolean[N][N];
        for(int i = 0; i<N; i++){
            if(rowCan(i)) cnt++;
        }

        return cnt;
    }


    static boolean columnCan(int columnIdx){
        int startNum = map[0][columnIdx];
        return chkColumn(startNum,1,columnIdx);
    }

    static boolean rowCan(int rowIdx){
        int startNum = map[rowIdx][0];
        return chkRow(startNum,1,rowIdx);
    }

    static boolean chkColumn(int prevHieght, int nowIdx, int columnIdx){
        // 만약 끝까지 왔으면
        if(nowIdx ==N) {
            return true;
        };

        int nowHeight = map[nowIdx][columnIdx];

        // 다음 칸이 같은 칸이면
        if(prevHieght == nowHeight) return chkColumn(nowHeight,nowIdx+1,columnIdx);

        // 만약 한칸 올라가야하는 경우
        if(prevHieght +1 == nowHeight){
            int prevIdx = nowIdx - L;
            if(columnCanIn(nowIdx -1,prevIdx, columnIdx)){
                return chkColumn(nowHeight,nowIdx +1,columnIdx);
            }
            return false;

        // 내려가야 하는 경우
        }else if (prevHieght - 1 == nowHeight){
            int nextIdx = nowIdx + L - 1;
            if(columnCanDe(nowIdx,nextIdx, columnIdx)){
                return chkColumn(map[nextIdx][columnIdx],nextIdx+1,columnIdx);
            }
            return false;
        }
        return false;
    }

    static boolean chkRow(int prevHieght, int nowIdx, int rowIdx){
        // 만약 끝까지 왔으면
        if(nowIdx ==N) {
            return true;
        };

        int nowHeight = map[rowIdx][nowIdx];

        // 다음 칸이 같은 칸이면
        if(prevHieght == nowHeight) return chkRow(nowHeight,nowIdx+1,rowIdx);

        // 만약 한칸 올라가야하는 경우
        if(prevHieght +1 == nowHeight){
            int prevIdx = nowIdx - L;
            if(rowCanIn(nowIdx -1,prevIdx, rowIdx)){
                return chkRow(nowHeight,nowIdx +1,rowIdx);
            }
            return false;

            // 내려가야 하는 경우
        }else if (prevHieght - 1 == nowHeight){
            int nextIdx = nowIdx + L - 1;
            if(rowCanDe(nowIdx,nextIdx, rowIdx)){
                return chkRow(map[rowIdx][nextIdx],nextIdx+1,rowIdx);
            }
            return false;
        }
        return false;
    }

    static boolean columnCanDe(int start, int end, int columnIdx){
        if(end >= N) return false;

        if(visited[start][columnIdx]) return false;
        visited[start][columnIdx] = true;

        int target = map[start][columnIdx];

        for(int i = start+1; i<=end ;i++){
            if(target != map[i][columnIdx] || visited[i][columnIdx]) return false;
            visited[i][columnIdx] = true;
        }
        return true;
    }

    static boolean columnCanIn(int start, int end, int columnIdx){
        if(end < 0) return false;

        if(visited[start][columnIdx]) return false;
        visited[start][columnIdx] = true;

        int target = map[start][columnIdx];
        for(int i = start-1; i>=end ;i--){
            if(target != map[i][columnIdx] || visited[i][columnIdx]) return false;
            visited[i][columnIdx] = true;
        }
        return true;
    }

    static boolean rowCanDe(int start, int end, int rowIdx){
        if(end >= N) return false;

        if(visited[rowIdx][start]) return false;
        visited[rowIdx][start] = true;

        int target = map[rowIdx][start];
        for(int i = start+1; i<=end ;i++){
            if(target != map[rowIdx][i] || visited[rowIdx][i]) return false;
            visited[rowIdx][i] = true;
        }
        return true;
    }

    static boolean rowCanIn(int start, int end, int rowIdx){
        if(end < 0) return false;

        if(visited[rowIdx][start]) return false;
        visited[rowIdx][start] = true;

        int target = map[rowIdx][start];
        for(int i = start-1; i>=end ;i--){
            if(target != map[rowIdx][i] || visited[rowIdx][i]) return false;
            visited[rowIdx][i] = true;
        }
        return true;
    }
}