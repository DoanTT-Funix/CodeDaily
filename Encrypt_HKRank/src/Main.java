import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        List<Character> cS = new ArrayList<>();
        for(int i= 0; i< s.length(); i++){
            char c= s.charAt(i);
            if(c>='a' && c<='z') cS.add(c);
        }
        int length = cS.size();
        int col = (int)Math.ceil(Math.sqrt(length));
        int row = (int)Math.ceil((double)length/ col);
        // int row = (int)Math.floor(Math.sqrt(length));
        //System.out.println("row: col = "+row+" :"+ col);
        char[][] enS = new char[row][col];
        for(int i=0; i< row; i++)
            for(int j=0; j<col; j++){
                int pos = i* col + j;
                if(pos<length) enS[i][j] = cS.get(pos);
                else enS[i][j] = '!';
                // System.out.println(enS[i][j]);
            }
        String rs ="";
        for(int i = 0; i<col; i++){
            String temp = "";
            for(int j= 0; j<row; j++){
                if(enS[j][i] != '!')
                    temp+= String.valueOf(enS[j][i]);
            }
            rs+=temp+" ";
        }
        return rs;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}