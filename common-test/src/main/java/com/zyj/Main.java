package com.zyj;

public class Main {
    public static void main(String[] args) {

        Node temp1 = new Node(1);

        Node temp2 = new Node(2);
        temp1.setNext(temp2);
        Node temp3 = new Node(3);
        temp2.setNext(temp3);
        Node temp4 = new Node(4);
        temp3.setNext(temp4);
        Node temp5 = new Node(5);
        temp4.setNext(temp5);
        System.out.print(getMiddle(temp1).getVal());


    }

    /**
     * 判断数字是否是二进制
     * @param val
     * @return
     */
    private static boolean isPowerOfTwo(int val) {
        return (val & -val) == val;
    }


    public static Node getMiddle(Node node){

        if(node == null){
            return null;
        }
        if(node.getNext() == null){
            return node;
        }
        Node temp = node;
        while(node.getNext()!= null){
            if(node.getNext().getNext()!= null){
                node = node.getNext().getNext();
                temp = temp.getNext();
            }else {
                break;
            }
        }
        return temp;




    }
}


class Node {

    public Node(int val) {
        this.val = val;
    }

    private int val;

    public int getVal() {
        return val;
    }

    private Node next;

    public void setNext(Node node) {
        this.next = node;
    }

    public Node getNext() {
        return next;
    }
}
