package Programmers.고득점kit.DP;

/*
대각선 방향ㅇ로 한칸 오른쪽 또는 왼쪼그로만 이동 가능
=> 이전 idx 에서 +1 또는 +0 만 가능하다 
높이가 500
숫자는 0~9999


*/

class Solution {
    static int[][] St;

    public int solution(int[][] triangle) {
        St = new int[500][500];
        St[0][0] = triangle[0][0];
        // 위의 층의 인덱스를 i
        // 현재 층의 인덱스를 j
        // k는 현재 층의 인덱스 +0 +1
        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                for (int k = j; k <= j + 1; k++) {
                    int value = triangle[i + 1][k] + St[i][j];
                    if (St[i + 1][k] < value) {
                        St[i + 1][k] = value;
                    }
                }
            }
        }

        // for(int i=0; i<4; i++){
        // for(int j=0; j<triangle[i].length; j++){
        // System.out.print(St[i][j]+" ");
        // }
        // System.out.println("");
        // }
        int answer = 0;
        for (int value : St[triangle.length - 1]) {
            answer = Math.max(answer, value);
        }

        return answer;
    }
}