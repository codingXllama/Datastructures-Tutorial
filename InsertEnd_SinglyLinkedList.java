import java.util.List;

public class InsertEnd_SinglyLinkedList {

    //    Creating the linkedLIst HeadNode
    private ListNode headNode;

    //Creating the ListNode class

    public static class ListNode {

        private int dataField;
        private ListNode nextField;

        //creating class constructor

        public ListNode(int data) {
            dataField = data;
            this.nextField = null;
        }


    }


    public void DisplyList() {
        ListNode currentNode = headNode;
        while (currentNode != null) {
            System.out.print(currentNode.dataField + " -> ");
            currentNode = currentNode.nextField;
        }
        System.out.print(" null ");
    }




    public void InsertLast(int userNodeValue) {
        ListNode newNode = new ListNode(userNodeValue);
        ListNode currentNode = headNode;

        while (currentNode.nextField != null) {
            currentNode = currentNode.nextField;
        }
        currentNode.nextField = newNode;
        //System.out.print(newNode.dataField);


    }

    public void ReverseList()
    {
        ListNode currentNode=headNode;
        //the previousNode will be the new headNode when we reverse the linkedList
        ListNode previousNode=null;
        ListNode nextNode=null;

        while (currentNode!=null)
        {
            nextNode=currentNode.next;
            currentNode.next=perviousNode;
            previousNode=currentNode;
            currentNode=nextNode;
            
        }
        return previousNode;
    }


    public boolean FindElement(int searchKeyData)
    {
        ListNode currentNode= headNode;
        while(currentNode!=null)
        {
            if(currentNode.dataField==searchKeyData)
            {
                System.out.println("\nThe node: "+searchKeyData+" does Exists!");
                return  true;
            }
            currentNode=currentNode.nextField;
        }
        System.out.println("\nThe node: "+searchKeyData+" does NOT Exists!");
        return false;
    }


    public static void main(String[] args) {

//        creating a Singly linked list
        InsertEnd_SinglyLinkedList linkList_Object = new InsertEnd_SinglyLinkedList();

//        Creating the LinkedList headNode
        linkList_Object.headNode = new ListNode(89);
        ListNode secondNode = new ListNode(901);
        ListNode thirdNode = new ListNode(3);
        ListNode fourthNode = new ListNode(0);

//        Linking all the Nodes's together
        linkList_Object.headNode.nextField = secondNode;
        secondNode.nextField = thirdNode;
        thirdNode.nextField = fourthNode;

        linkList_Object.InsertLast(20);
        linkList_Object.InsertLast(390);
        linkList_Object.DisplyList();

//        Searching for a particular dataField
        linkList_Object.FindElement(3);



    }


}
