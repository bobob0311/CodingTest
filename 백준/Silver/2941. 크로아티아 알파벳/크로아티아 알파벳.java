import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String c : croatia) {
            str = str.replace(c, "a");
        }

        System.out.println(str.length());
    }
}