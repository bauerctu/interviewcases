/**
 * Created by chenxuehui on 2018/7/13
 */
public class ReverseLinkedList {

    /**
     * 解决思路：
     * 用pre，curr，next分别表示前一个节点，当前节点，下一个节点
     * 算法的核心思路是将当前节点curr的next指针指向自己的前驱节点pre
     * 让后将pre,curr顺次平移一个位置
     */
    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        int i = 0;
        Node next = null;
        Node pre = head;
        Node curr = head.next;

        pre.next = null;//最开始将首节点的next指针指向null
        while (curr != null && i < 100) {
            i++;
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    static class Node {
        String value;
        Node next;

        Node(String text, Node next) {
            this.value = text;
            this.next = next;
        }

        Node() {
            this.value = null;
            this.next = null;
        }
    }

    static void print(Node node) {
        if (node == null) {
            System.out.println("null");
        }
        Node p = node;
        while (p != null) {
            System.out.print(p.value + "->");
            p = p.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node head = new Node("first",null);
        Node a = new Node("a", null);
        Node b = new Node("b", null);
        Node c = new Node("c", null);
        Node d = new Node("d", null);
        Node e = new Node("e", null);
        Node f = new Node("f", null);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        print(head);

        Node s = reverse(head);

        print(s);
    }

}
