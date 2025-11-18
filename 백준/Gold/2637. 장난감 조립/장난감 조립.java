import java.io.*;
import java.util.*;

/*
기본 부품 -> 중간 부품 -> 장난감

완제품과 그에 필요한 부품들 사이의 관계가 주어져 있을 때
하나의 장난감 완제품을 조립하기 위하여 필요한 기본 부품의 종류별 개수를 계산

기본 부품의 번호가 작은거 부터 필요한 수를 카운팅

거꾸로 가야할거같은데

N 만들때 N-1 이 2개 뭐 이런식으로

*/

public class Main {
    static int N,M;
    static ArrayList<LinkedList<int[]>> graph = new ArrayList<>();
    static int[] inDegree;
    static PriorityQueue<int[]> answerArr = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
    static int[] needArr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        inDegree = new int[N+1];
        needArr = new int[N+1];
        needArr[N] = 1;
        for(int i = 0; i< N+1; i++){
            graph.add(new LinkedList<>());
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int result = Integer.parseInt(st.nextToken());
            int need = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            graph.get(result).add(new int[] {need, cnt});
            inDegree[need]++;
        }

        sort();


        StringBuilder sb= new StringBuilder();

        while(!answerArr.isEmpty()){
            int[] nowArr = answerArr.poll();
            sb.append(nowArr[0]).append(" ").append(nowArr[1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void sort(){
        Queue<Integer> que = new LinkedList<>();
        que.offer(N);

        while(!que.isEmpty()){
            int nowNode = que.poll();

            if(graph.get(nowNode).size() == 0) answerArr.add(new int[] {nowNode, needArr[nowNode]});
            for(int[] nextArr : graph.get(nowNode)){
                int nextNode = nextArr[0];
                int needCnt = nextArr[1];

                inDegree[nextNode]--;
                needArr[nextNode] += needCnt * needArr[nowNode];
                if(inDegree[nextNode] == 0) que.add(nextNode);
            }
        }

    }
}
