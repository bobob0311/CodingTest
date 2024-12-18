import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		int want = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		int M = Integer.parseInt(split[0]);
		int N = Integer.parseInt(split[1]);
		int[] pizzaA = new int[M];
		int[] pizzaB = new int[N];
		int sumA = 0;
		for(int i=0;i<M;i++) {
			pizzaA[i] = Integer.parseInt(br.readLine());
			sumA += pizzaA[i];
		}
		int sumB = 0;
		for(int i=0;i<N;i++) {
			pizzaB[i] = Integer.parseInt(br.readLine());
			sumB += pizzaB[i];
		}
		int[] dpA = new int[want+1];
		int[] dpB = new int[want+1];
		dpA[0] = 1;
		dpB[0] = 1;
		int temp = 0;
		for(int i=0;i<M;i++) {
			temp = 0;
			for(int j=0;j<M-1;j++) {
				if(pizzaA[(i+j)%M]+temp > want) {
					break;
				}
				temp += pizzaA[(i+j)%M];
				dpA[temp]++;
			}
		}
		for(int i=0;i<N;i++) {
			temp = 0;
			for(int j=0;j<N-1;j++) {
				if(pizzaB[(i+j)%N]+temp > want) {
					break;
				}
				temp += pizzaB[(i+j)%N];
				dpB[temp]++;
			}
		}
		if(sumA>want) dpA[0] = 1; 
		else dpA[sumA] = 1;
		if(sumB>want) dpB[0] = 1; 
		else dpB[sumB] = 1;
		for(int i=0;i<=want;i++) {
			result+=dpA[i] *dpB[want-i];
		}
		System.out.println(result);
	}
}