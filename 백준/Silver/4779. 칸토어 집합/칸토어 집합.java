import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input);
            sb.setLength(0);
            recure(1, (int) Math.pow(3, n));
            System.out.println(sb.toString());
        }

    }

    static void recure(int start, int end) {
        if (start == end) {
            sb.append("-");
            return;
        }
        int size = (end - start + 1) / 3;

        recure(start, start + size - 1);
        nothing(start + size, end - size);
        recure(end - size + 1, end);
    }

    static void nothing(int start, int end) {
        for (int i = 0; i < end - start + 1; i++) {
            sb.append(" ");
        }
        return;
    }

}