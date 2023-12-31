package 구현;
public class 백준4673 {
    static boolean[] ck = new boolean[10001];

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            int res = i;
            int num = res;
            while (res > 0) {
                num += res % 10;
                res /= 10;
            }
            if (num <= 10000) {
                if (ck[num] == false) {
                    ck[num] = true;
                }
            }

        }
        for (int i = 1; i <= 100; i++) {
            if (ck[i] == false)
                System.out.println(i);
        }

    }
}
