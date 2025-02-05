import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fac(n));
    }

    static long fac(long n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return fac(n - 1) * n;
    }

}