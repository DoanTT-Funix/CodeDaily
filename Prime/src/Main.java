import java.io.*;
import java.util.*;

class Solution {

    public static boolean checkPrime(int n) {
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0 || n == 1) return false;
        // for n>=25
        for (int i = 5; i * i <= n; ) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
            i += 6;
        }
        return true;
    }

    public static String outputString(int[] arr) {
        String[] kq = new String[4];

        for (int i = 0; i <= 3; i++) {
            if (checkPrime(arr[i]))
                kq[i] = String.valueOf(arr[i]);
            else
                kq[i] = "";
        }
        for (int i = 1; i <= 3; i++) {
            if (kq[i].equals(""))
                kq[i] = kq[i - 1];
            else {
                if (!kq[i - 1].equals(""))
                    kq[i] = kq[i - 1] + " " + kq[i];
            }
        }
        if (checkPrime(arr[4])) {
            if (kq[3].equals(""))
                kq[3] = String.valueOf(arr[4]);
            else
                kq[3] += " " + String.valueOf(arr[4]);
        }

        return kq[0] + "\n" + kq[1] + "\n" + kq[2] + "\n" + kq[3];
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[] input = new int[5];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            for (int i = 0; i < 5; i++) {
                input[i] = Integer.parseInt(br.readLine());
                //if (input[i]> max) max=input[i];
            }

        } catch (IOException e) {
            return;
        }
        System.out.println(outputString(input));
    }
}

//class Main {
//    public static void main(String[] args) {
//
//    }
//}