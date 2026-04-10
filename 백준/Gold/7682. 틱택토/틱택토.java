import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.*;

/*
틱택토 게임에서 발생할 수 있는 최종 상태인지를 반별해라.

1. X가 O보다 많거나 같아야한다.
2. O가 이겼을때 X와 같은 갯수여야한다.
3. O와 X가 동시에 이길 수 없다.
4. X가 이겼다면 O보다 한개 많아야한다.

*/



public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String nowString = br.readLine();
            if(nowString.equals("end")) break;

            if(isValid(nowString)) {
                sb.append("valid").append("\n");
            }else{
                sb.append("invalid").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static boolean isValid(String nowString){
        boolean oWin = isOWin(nowString);
        boolean xWin = isXWin(nowString);
        int Ocount = OCnt(nowString);
        int Xcount = XCnt(nowString);

        if(!oWin && !xWin && Ocount + Xcount != 9) return false;
        if(Ocount > Xcount) return false;
        if(oWin && xWin) return false;

        if(xWin){
            if(Xcount - 1 != Ocount) return false;
        }else if(oWin){
            if(Ocount != Xcount) return false;
        }
        return true;

    }

    static int OCnt(String nowString){
        int cnt = 0;
        int targetChar = 'O';
        for(int i = 0; i < 9; i++){
            if(targetChar == nowString.charAt(i)) cnt++;
        }
        return cnt;
    }

    static int XCnt(String nowString){
        int cnt = 0;
        int targetChar = 'X';
        for(int i = 0; i < 9; i++){
            if(targetChar == nowString.charAt(i)) cnt++;
        }
        return cnt;
    }

    static boolean isOWin(String nowString){
        if(chkRow('O',nowString) ||
                chkcolumn('O',nowString) ||
                chkCross('O',nowString))return true;
        return  false;
    }

    static boolean isXWin(String nowString){
        if(chkRow('X',nowString) ||
                chkcolumn('X',nowString) ||
                chkCross('X',nowString))return true;
        return  false;
    }

    static boolean chkCross(char targetChar, String nowString){
        if(nowString.charAt(0) == targetChar &&
                nowString.charAt(4) == targetChar &&
                nowString.charAt(8) == targetChar) return true;
        if(nowString.charAt(2) == targetChar &&
                nowString.charAt(4) == targetChar &&
                nowString.charAt(6) == targetChar) return true;
        return false;
    }

    static boolean chkRow(char targetChar, String nowString){
        boolean chk;
        for(int i = 0; i<3; i++){
            chk = true;
            for(int j = 0; j<3; j++){
                if(targetChar != nowString.charAt(i*3 +j)) chk = false;
            }
            if(chk) return true;
        }
        return false;
    }

    static boolean chkcolumn(char targetChar, String nowString){
        boolean chk;
        for(int i = 0; i<3; i++){
            chk = true;
            for(int j = 0; j<3; j++){
                if(targetChar != nowString.charAt(i +j*3)) chk = false;
            }
            if(chk) return true;
        }
        return false;
    }
}