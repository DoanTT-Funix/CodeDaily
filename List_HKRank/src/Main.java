import java.io.*;
import java.util.*;

class Node{
    int num;
    Node next;
    Node(int num){
        this.num = num;
        next=null;
    }
}
class List{
    Node head, tail;
    List(Node head,Node tail){
        head= tail=null;
    }
    public void add(int n){
        Node node = new Node(n);
        if(head==null){
            head=tail=node;
        }else{
            tail.next = node;
            tail=node;
        }
    }
    public void delete (int index){
        // index >=0;
        if(index==0){
            if(head.next==null) head =tail =null;
            else head = head.next;
        } else{
            Node temp = head;
            int i=0;
            while( temp != null && i<index-1){
                i++;
                temp=temp.next;
            }
            if(temp.next.next==null)
                temp.next = null;
            else
                temp.next=temp.next.next;
        }
    }
    public void insert (int index, int val){
        // index : 0 -> =size of List
        Node node = new Node(val);
        if(index == 0) {
            node.next = head;
            head= node;
        }
        else{
            Node temp = head;
            int i=0;
            while( temp != null && i<index-1){
                i++;
                temp=temp.next;
            }

            node.next = temp.next;
            temp.next = node;


        }
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.num+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

class Solution {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        List l = new List(null, null);
        int size = sc.nextInt();
        sc.nextLine();
        // System.out.println(size);
        // String s1= sc.nextLine();
        // System.out.println(s1);
        String[] ar= sc.nextLine().split(" ");
        //System.out.println(ar[1]);
        //System.out.println(Arrays.toString(ar));
        for(int i= 0; i<size; i++){
            //System.out.println(ar[i]);
            l.add(Integer.parseInt(ar[i]));
        }
        //l.display();
        int q = sc.nextInt();
        //System.out.println(q);
        sc.nextLine();
        for (int i = 1; i<=q; i++){
            String action = sc.nextLine();
            //System.out.println(action);
            if(action.equalsIgnoreCase("Insert")){
                //  System.out.println(i);
                String[] p = sc.nextLine().split(" ");
                l.insert(Integer.parseInt(p[0]), Integer.parseInt(p[1]));

            }
            else if(action.equalsIgnoreCase("Delete")){
                // System.out.println(i);
                l.delete(sc.nextInt());
                if(sc.hasNext()) sc.nextLine();
            }
        }
        l.display();
    }
}

//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}