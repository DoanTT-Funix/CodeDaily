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
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String insert(char c, String s){
        // Chèn 1 ký tự vào 1 chuỗi đã có thứ tự thành 1 chuỗi đã có thứ tự
        int posInsert;
        String rs;
        //System.out.println("Dau vao char=  "+c+" ; va chuoi s = "+s);
        //System.out.println(s.charAt(0));
        if(s.charAt(0)>c){
            //rs= String.valueOf(s.charAt(0))+ c;
            // rs= s.charAt(0)+c+""; chet choc vi cong char la phep cong 2 so nguyen,
            // gap "" ket qua moi chuyen ve chuoi
            rs=""+s.charAt(0)+c+s.substring(1);
            // System.out.println("insert: "+rs);

        }
        else{
            for(posInsert = 1; posInsert< s.length(); posInsert++){
                if(s.charAt(posInsert) > c)
                    break;
            }
            rs= s.charAt(posInsert) + s.substring(0, posInsert)+ c+ s.substring(posInsert +1);
        }
        // System.out.println("insert: "+rs);
        return rs;
    }
    public static String biggerIsGreater(String w) {
        // Write your code here
        int length = w.length();
        // duyỵet từ cuối chuỗi đi lên, cho đến khi gặp kí tự nhỏ hơn kí tự liền trước thì dừng
        // Để dễ hình dung thì cứ nối các ký tự từ cuối về.
        // đường nối này sẽ đi ngang, hoặc lên, cho đến khi gặp breakPos, tại đây đường nối "đỗ dốc"
        int breakPos = -1;
        for(int i = length -1; i>0; i--){
            if(w.charAt(i)>w.charAt(i-1)){
                breakPos = i-1;
                break;
            }
        }
        //System.out.println("brkP= "+breakPos);
        if(breakPos==-1) return "no answer";
        else{
            String subRevert =new StringBuffer(w.substring(breakPos+1)).reverse().toString();
            //System.out.println("chuoi dau vao de Revert: "+subRevert);
            //System.out.println("Ky tu tham gia  Revert: "+w.charAt(breakPos));
            String rsAfInsert = insert(w.charAt(breakPos), subRevert);
            // System.out.println("ket qua SAU insert: "+rsAfInsert);
            return w.substring(0, breakPos) + rsAfInsert;
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}