package 백트래킹;

public class test {
    static boolean[] arr = new boolean[5];

    public static void main(String[] args) {
        backtrack(1);
    }

    static void backtrack(int index) {
        if (index == 5) {
            // 배열의 상태 출력 (해당 부분을 원하는 작업으로 변경 가능)
            for (int i = 1; i < 5; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        arr[index] = true;
        backtrack(index + 1);
        arr[index] = false;
        backtrack(index + 1);
    }
}