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
    //Time Complexity: O(n)
    public void DisplayList(ListNode headNode) {
        ListNode currentNode = headNode;
        while (currentNode != null) {
            System.out.print(currentNode.dataField + " -> ");
            currentNode = currentNode.nextField;
        }
        System.out.print("null\n");
    }

    //creating the method to reverse the linkedList
    //Time Complexity: O(n)
    public ListNode ReverseList(ListNode headNode) {
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
    //Time Complexity: O(1), because we are inserting at the head(first node) of the singly linked list
    public void InsertFront(int userData) {
        //creating the newNode to be inserted
        ListNode newNode = new ListNode(userData);
        // ListNode currentNode= headNode;
        newNode.nextField = headNode;
        headNode = newNode;
    }

    //This method is for inserting an element at the end of the singly linked list
    //Time Complexity: O(n), where n is the size of elements  we must traverse through in order to reach and insert an element in the singly linked list
    public void InsertEnd(int userData) {
        ListNode newNode = new ListNode(userData);
        ListNode currentNode = headNode;

        //checking each Nodes reference field
        while (currentNode.nextField != null) {
            currentNode = currentNode.nextField;
        }
        currentNode.nextField = newNode;
    }

    //This method is responsible for finding the size of the Singly Linked List
    //Time Complexity: O(n)
    public int ListLength(ListNode userHeadNode) {
        int count = 0;
        ListNode currentNode = userHeadNode;
        while (currentNode != null) {
            count += 1;
            currentNode = currentNode.nextField;
        }
        return count;

    }

    //This method is responsible for finding the maximum value of a node inside a linked list
    //Time Complexity: O(n)
    public int MaxValue(int listSize) {
        ListNode currentNode = headNode;
        int maxValue = headNode.dataField;
        int counter;
        for (counter = 0; counter < listSize; counter++) {
            if (currentNode.dataField > maxValue) {
                maxValue = currentNode.dataField;
            }
            currentNode = currentNode.nextField;
        }
        return maxValue;

    }

    //This Method is responsible for finding the lowest value in the singly linked list
    //Time Complexity: O(n), where n is the size of the singly linked list
    public int MinValue(int listSize) {
        ListNode currentNode = headNode;
        int minValue = currentNode.dataField;
        int counter;
        for (counter = 0; counter < listSize; counter++) {
            if (currentNode.dataField < minValue) {
                minValue = currentNode.dataField;
            }
            currentNode = currentNode.nextField;

        }
        return minValue;
    }


    //This method is responsible for finding the middle value of a singly linked list regardless of it's size is even or odd
    //Time complexity: O(n), where n is the number of nodes in the given singly linked list
    public ListNode GetMiddleElement(ListNode userHeadNode) {
        ListNode fastPointer = userHeadNode;
        ListNode slowPointer = userHeadNode;
        //first we must always check if the head is pointing to null
        if (headNode == null) {
            return null;
        }

        //moving both pointers as long as the fastPointer does not equal to null and it does not reference to null
        while (fastPointer != null && fastPointer.nextField != null) {
            //moving up the slowPointer which is used for 
            slowPointer = slowPointer.nextField;
            fastPointer = fastPointer.nextField.nextField;
        }
        return slowPointer;
    }

    //This is the second way of trying to read nth data from the end of list
    //Time complexity is O(n), where n is the number of elements in the list.
   public ListNode NthElementFromEnd(int listSize, int userNumber) {
       if (this.headNode == null) {
           return null;
       }
       //this.headNode=headNode;
       ListNode mainPointer = headNode;
       int numberOfMoves = listSize - userNumber;
       while (numberOfMoves > 0) {
           mainPointer = mainPointer.nextField;
           numberOfMoves--;
       }

       return mainPointer;
   }

    public ListNode NthElementFromEndNew(int userNumber)
    {
        ListNode mainPtr= headNode;
        ListNode refPtr= headNode;
        int counter=0;

        while(counter<userNumber)
        {
            refPtr= refPtr.nextField;
            counter+=1;
        }

        while (refPtr!=null && refPtr.nextField!=null)
        {
            refPtr=refPtr.nextField;
            mainPtr=mainPtr.nextField;
        }
        return mainPtr;
    }

//    public ListNode NthElementFromBackNew2(int userValue, int listSize)
//    {
//        int maxSize= listSize-1;
//        int indexOfN=maxSize-userValue;
//        ListNode mainPtr= headNode;
//        while (indexOfN>0)
//        {
//            mainPtr=mainPtr.nextField;
//        }
//    }



    //Main method is where we create and provoke functions on our SinglyLinkedList object
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
        myLinkedList.InsertEnd(89);

        //Inserting a key at the end of a linked list
        myLinkedList.InsertEnd(690);

        //getting the length of the list
        int listLength = myLinkedList.ListLength(myLinkedList.headNode);
        System.out.println("The list Length is: " + listLength);

        //Finding the maximum value in the linked list
        System.out.println("The Max value in the linked list is: " + myLinkedList.MaxValue(listLength));

        //Finding the minimum value in the linked List
        System.out.println("The min value in the linked list is: " + myLinkedList.MinValue(listLength));

        //Displaying the linked list before it has been reversed
        System.out.print("\nBefore Reversing the list: ");
        myLinkedList.DisplayList(myLinkedList.headNode);

        //Finding the nth element from the back
        ListNode nthLastElement = myLinkedList.NthElementFromEndNew(2);
        System.out.println("The value for nth term is: " + nthLastElement.dataField);

        System.out.println("New way- The value of the nth terms is: "+myLinkedList.NthElementFromEndNew(2).dataField);

        //Finding the middle element of the Original(Not reversed) singly linked list
        System.out.println("The middle element is: " + myLinkedList.GetMiddleElement(myLinkedList.headNode).dataField + "\n");

        //Reversing the linked list, we do this by creating an a listNode that stores the reversed headNode
        System.out.print("After Reversing the list: ");
        ListNode reversedHeadNode = myLinkedList.ReverseList(myLinkedList.headNode);

        //Displaying the reversed LinkedList
        myLinkedList.DisplayList(reversedHeadNode);

        //Finding the middle element of the Reversed singly linked list
        ListNode ReversedMiddleNode = myLinkedList.GetMiddleElement(reversedHeadNode);
        System.out.println("The middle element is: " + ReversedMiddleNode.dataField);

        //ListNode nthReversedValue = myLinkedList.NthElementFromEnd(listLength, 2, reversedHeadNode);
        //Finding the nth Number from the end of the Reversed linkedList
        //System.out.println("The value for nth term is: " + nthReversedValue.dataField);


    }
}

