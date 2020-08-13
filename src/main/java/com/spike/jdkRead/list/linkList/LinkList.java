package com.spike.jdkRead.list.linkList;

/**
 * @description: 链表相关
 * @author: Spike
 * @date: 2020-04-13 14:24
 *
 * 判断给定的链表是以NULL结尾，还是形成了一个环？如果链表中存在环，则找到环的起始节点
 *
 *蛮力法：从表头开始遍历，针对每个节点均检查是否存在它之后的某个节点的后继指针指向该节点，如果存在则说明该链表存在环。
 *       如果一直遍历到表尾节点都未发现这种节点，则说明该链表不存在环。很显然这种算法是一种效率很差的算法，因此不考虑使用
 *
 * 使用散列表（哈希表）：从表头开始逐个遍历链表中的每个节点，并检查其是否已经存在散列表中。
 *                    如果存在则说明已经访问过该节点了，也就是存在环；如果一直到表尾都没有出现已经访问过的节点，则说明该链表不存在环。时间复杂度：O(n)
 *
 * Floyd环判定算法：使用两个在链表中具有不同移动速度的指针（如：fastNode每次移动两个节点，slowNode每次移动一个节点），
 *                两个指针同时从表头开始移动，如果在某一时刻它们相遇了，则表明该链表存在环。
 *                原因很简单：快速移动指针和慢速移动指针将会指向同一位置的唯一可能情况就是整个或者部分链表是一个环
 **/

public class LinkList {


    static class SinglyNode {
        private int data; // 数据
        private SinglyNode next; // 该节点的下个节点

        SinglyNode(int data) {
            this.data = data;
        }

        public SinglyNode(int data, SinglyNode next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public SinglyNode getNext() {
            return next;
        }

        public void setNext(SinglyNode next) {
            this.next = next;
        }

        @Override
        public String toString() {

            return "SinglyNode [data=" + data + "]";
        }



    }

    /**
     * 在找到环之后，将slowNode重新设置为表头节点，接下来slowNode和fastNode每次分别移动一个节点，
     * 当它们再次相遇时即为环的起始节点
     *
     * @时间复杂度 O(n)
     * @param headNode
     * @return
     */
     static SinglyNode findLoopStartNode(SinglyNode headNode){
        SinglyNode fastNode=headNode,slowNode=headNode;
        //是否存在环的标识
        boolean loopExists = false;

        while(slowNode.getNext() != null && fastNode.getNext() != null && fastNode.getNext().getNext() != null){
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();

            if(slowNode == fastNode){
                loopExists = true;
                break;
            }
        }
        //如果存在环，则slowNode回到表头
        if(loopExists){
            slowNode = headNode;
            while(slowNode != fastNode){
                slowNode = slowNode.getNext();
                fastNode = fastNode.getNext();
            }
            return fastNode;

        }
        return null;
    }

    public static void main(String[] args) {
        SinglyNode headNode1 = new SinglyNode(11);

        SinglyNode currentNode = headNode1;
        for(int i=2;i<=5;i++){
            SinglyNode tmpNode = new SinglyNode(11 * i);
            currentNode.setNext(tmpNode);
            currentNode = tmpNode;
            System.out.println(tmpNode.hashCode());
        }

        //链表headNode2，人为构造了一个环
        SinglyNode headNode2 = new SinglyNode(11);
        SinglyNode ringStartNode = null;
        currentNode = headNode2;
        for(int i=2;i<=8;i++){
            SinglyNode tmpNode = new SinglyNode(11 * i);
            currentNode.setNext(tmpNode);
            currentNode = tmpNode;
            if(i == 3){
                ringStartNode = tmpNode;
            }else if(i == 8){
                tmpNode.setNext(ringStartNode);
            }
        }
//        System.out.println("链表headNode1的环的起始节点：" + findLoopStartNode(headNode1)
//                + "；链表headNode2的环的起始节点：" + findLoopStartNode(headNode2));


//        reverseList(headNode1);
    }


    static SinglyNode reverseList(SinglyNode head) {
        SinglyNode temp = null;
        SinglyNode nextNode ;
        while (head != null) {

            nextNode = head.getNext();
            head.setNext(temp);
            temp = head;
            head = nextNode;

        }
        return temp;
    }
}
