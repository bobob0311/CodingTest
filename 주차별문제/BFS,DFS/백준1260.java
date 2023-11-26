// DFS와 BFS로 탐색한 결과를 출력한느 프로그램을 작성

// 정점의 개수 (1<=N<=1,000) 
// 간선의 개수 (1<=M<=10,000)
// 탐색을 시작할 정점의 번호 V

// N,M,V
// M개의 줄에는 간선이 연결하는 두정점의 번호, 두정점 사이에 여러개의 간선이 있을 수 있다. 주어지는 간선은 양방향
import java.util.Scanner;

public class 백준1260 {

    static int N, M, V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        System.out.println(N);
        System.out.println(M);
        System.out.println(V);
    }

}
