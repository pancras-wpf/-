package 循环链表排序;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

class Solution {

    public Node insert(Node head, int insertVal) {
        Node pre = null;
        Node next = null;

        Node realmin = null;

        if (head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        pre = head;
        next = head.next;
        while (next.val >= pre.val){
            pre = next;
            next = next.next;
            if (next == head){
                break;
            }
        }
        realmin = next;

        while(next.val < insertVal){
            pre = next;
            next = next.next;
            //相等了，就随便插
            if(next == realmin)break;
        }
        //连接
        pre.next = new Node(insertVal);
        pre = pre.next;
        pre.next = next;

        return head;
    }
}

class Main{
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(4);
        Node node2 = new Node(1);

        head.next = head;
        node1.next = node2;
        node2.next = head;

        Solution solution = new Solution();
        solution.insert(head,0);
    }
}
