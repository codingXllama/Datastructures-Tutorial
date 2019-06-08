package JavaTuts;

import java.util.List;


//creating the SinglyLinkedList class
public class SinglyLinkedList0 {
    private ListNode headNode;

    //creating the inner class for each of the Nodes in the linked List
    public static class ListNode {
        private int dataField;
        private ListNode nextField;

        //class constructor
        public ListNode(int userData) {
            dataField = userData;
            this.nextField = null;
        }

    }

    //creating the display method
    private void DisplayList(ListNode headNode) {
        ListNode currentNode = headNode;
        while (currentNode != null) {
            System.out.print(currentNode.dataField + " -> ");
            currentNode = currentNode.nextField;
        }
        System.out.print("null\n");
    }

    //creating the method to reverse the linkedList
    private ListNode ReverseList(ListNode headNode) {
        if (headNode == null) {
            return headNode;
        }
        ListNode currentNode = headNode;
        ListNode prevNode = null;
        ListNode nextNode;

        while (currentNode != null) {
            nextNode = currentNode.nextField;
            currentNode.nextField = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;

    }

    //creating the method for inserting a node at the front of the linked List
    private void InsertFront(int userData) {
        //creating the newNode to be inserted
        ListNode newNode = new ListNode(userData);
        // ListNode currentNode= headNode;
        newNode.nextField = headNode;
        headNode = newNode;
    }

    private void InsertEnd(int userData) {
        ListNode newNode = new ListNode(userData);
        ListNode currentNode = headNode;

        //checking each Nodes reference field
        while (currentNode.nextField != null) {
            currentNode = currentNode.nextField;
        }
        currentNode.nextField = newNode;
    }

    public  int ListLength(ListNode userHeadNode)
    {
        int count=0;
        ListNode currentNode= userHeadNode;
        while (currentNode!=null)
        {
            count+=1;
            currentNode=currentNode.nextField;
        }
        return count;

    }

    public int MaxValue(int listSize)
    {
        ListNode currentNode= headNode;
        int maxValue=headNode.dataField;
        int counter;
        for(counter=0;counter<listSize;counter++)
        {
            if (currentNode.dataField>maxValue)
            {
                maxValue=currentNode.dataField;
            }
            currentNode=currentNode.nextField;
        }
        return maxValue;

    }


    public static void main(String[] args) {

        //creating the nodes for the linked List
        ListNode headNode = new ListNode(100);
        ListNode firstNode = new ListNode(20);
        ListNode secondNode = new ListNode(90);
        ListNode thirdNode = new ListNode(10);

        //attaching all the listNodes together
        headNode.nextField = firstNode;
        firstNode.nextField = secondNode;
        secondNode.nextField = thirdNode;

        //creating a linkedList object to invoke different methods on it
        SinglyLinkedList0 myLinkedList = new SinglyLinkedList0();
        //assigning the local headNode variable to the SinglyLinkedList0 object's instance variable
        myLinkedList.headNode = headNode;


        //Inserting a key at the front of a linked list
        myLinkedList.InsertFront(21);

        //Inserting a key at the end of a linked list
        myLinkedList.InsertEnd(690);

        //getting the length of the list
        int listLength=myLinkedList.ListLength(myLinkedList.headNode);
        System.out.println("The list Length is: "+listLength);

        //Finding the maximum value in the linked list
        System.out.println("The Max value in the linked list is: "+myLinkedList.MaxValue(listLength));


        System.out.print("\nBefore Reversing the list: ");
        myLinkedList.DisplayList(myLinkedList.headNode);

        //Reversing the headNode
        System.out.print("After Reversing the list: ");
        ListNode reversedHeadNode = myLinkedList.ReverseList(myLinkedList.headNode);
        //Displaying the reversed LinkedList
        myLinkedList.DisplayList(reversedHeadNode);





    }
}

