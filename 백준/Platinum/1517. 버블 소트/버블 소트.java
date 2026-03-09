import java.io.*;
import java.util.*;

/*
- 구간의 곱을 구하려는 문제
*/

public class Main {
    static int N;
    static int[] list;
    static int[] tree;
    static long answer =0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }



        sort(list,1,N);

        System.out.println(answer);
    }



    static void sort(int[] arr, int left, int right){
        if(left == right) return;

        int mid = (left + right) /2;

        sort(arr, left, mid);
        sort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid,int right){
        int leftSize = mid - left +1;
        int rightSize = right - mid;

        int[] leftTemp = new int[leftSize];
        int[] rightTemp = new int[rightSize];

        for(int i = 0; i<leftSize; i++){
            leftTemp[i] = arr[left +i];
        }

        for(int i = 0; i<rightSize; i++){
            rightTemp[i] = arr[mid +1 +i];
        }

        int leftIdx = 0;
        int rightIdx = 0;

        int realIdx = left;

        while(leftIdx < leftSize && rightIdx <rightSize){
            if(leftTemp[leftIdx] <= rightTemp[rightIdx]){
                answer += (realIdx-left)-leftIdx;
                arr[realIdx++] = leftTemp[leftIdx++];
            }else{
                arr[realIdx++] = rightTemp[rightIdx++];
            }
        }

        while(leftIdx < leftSize){
            answer += (realIdx-left)-leftIdx;
            arr[realIdx++] = leftTemp[leftIdx++];
        }

        while(rightIdx < rightSize){
            arr[realIdx++] = rightTemp[rightIdx++];
        }
    }

}