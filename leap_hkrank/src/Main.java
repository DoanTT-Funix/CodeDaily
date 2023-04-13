import java.util.*;

class Solution {

    public static void canWin(int leap, int[] g, boolean[] kq, int size, int i) {
        // Return true if you can win the game; otherwise, return false.
        // canLengthGame: gia tri cell 0 gan game[n-1] nhat
        // khoi tao canLengthGame = game.length - 1
        // Su dung de quy de giai
        // tra loi cau hoi thang hay ko? mo rong ra: chi cu the cach di
        // boolean kq=true;

        if(i+leap>=size || i+1 >=size){
            kq[0]=true;
            //System.out.println("WIN");
            return;
        }

        for(int dem=1; dem<=3; dem++){
            int j=0;// try(j) tiep sau i
            switch (dem){
                case 1: j=i+leap;break;
                case 2: j=i+1;break;
                case 3: j=i-1; break;
                default:break;
            }
            if((j>0 && j<size) && g[j]==0){
                g[j]=1;
                canWin(leap,g,kq,size,j);
            }

        }

//        for (int j = i - 1; j <= i + leap; j++) {
//            if((j==i-1 || j==i+1||j==i+leap)&& (j<size && j>0) && gtt[j]){
//                gtt[j]=false;
//                canWin(leap,g,gtt,kq,size,j);
//            }
//        }

//        if(i==0 && !kq){
//            kq=false;
//            System.out.println("LOSE");
//            return;
//        }


    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         boolean[] kq={false};
         int leap=1;
         int[]g={0,1,0};
        //int leap = 4;
        //int[] g ={0,1,1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,0,1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1};
       // int[] g={0,1,1,1,0,1,1,0,1};
        //boolean[] gtt={false,false,false,true,true,false,false,true,false};
       // int leap=4;

       // int q = scan.nextInt();
//        while (q-- > 0) {
//            int n = scan.nextInt();
//            int leap = scan.nextInt();
//
//            int[] game = new int[n];
//            for (int i = 0; i < n; i++) {
//                game[i] = scan.nextInt();
//            }
//
//            System.out.println( (canWin(leap, game, n-1)) ? "YES" : "NO" );
//        }

        //System.out.println( (canWin(leap, game, game.length-1)) ? "YES" : "NO" );
        canWin(leap,g,kq,g.length,0);
        System.out.println(kq[0] ? "YES" : "NO");
    }
}
//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}