package com.servo.datastructures.singlylinked;

public class SinglyLinkedList {

    private int count;
    private SinglyLinkedNode head;

    public SinglyLinkedList() {
        count = 0;
    }

    public void addFirst(int value) {
        //case: list is empty
        if (head == null) {
            head = new SinglyLinkedNode(value, null);
        }
        //case: one value
        else {
            SinglyLinkedNode previousHead = head;
            head = new SinglyLinkedNode(value, previousHead);
        }
        count += 1;
    }

    public int getFirst() {
        if (head != null) {
            return head.getValue();
        }
        throw new RuntimeException("something bad");
    }

    public int getLast() {
        if (head == null) {
            throw new RuntimeException("something bad");
        }
        SinglyLinkedNode currentNode = this.head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    public boolean remove(int value) {
        SinglyLinkedNode previousNode = null;
        for (SinglyLinkedNode currentNode = this.head; currentNode != null; previousNode = currentNode, currentNode = currentNode.getNext()) {
            if (currentNode.getValue() == value) {
                if (previousNode == null) {
                    head = currentNode.getNext();
                } else {
                    previousNode.setNext(currentNode.getNext());
                }
                count -= 1;
                return true;
            }
        }
        return false;
    }

    public boolean recursiveRemove(int value) {
        if (head == null) {
            return false;
        }
        this.recursiveRm(head, value);
        return true;
    }

    public int getCount() {
        return count;
    }

    //Helper method
    public void printValues() {
        if (head == null) {
            throw new RuntimeException("something bad");
        }
        for (SinglyLinkedNode currentNode = this.head; currentNode != null; currentNode = currentNode.getNext()) {
            System.out.println(currentNode.getValue());
        }
    }

    private SinglyLinkedNode recursiveRm(SinglyLinkedNode currentNode, int value) {
        //you've passed a
        if (currentNode == null) {
            return null ;
        }
        //We found our guy, we need to return the next link.
        if (currentNode.getValue() == value) {
            count -= 1;
            return currentNode.getNext();
        }
        currentNode.setNext(recursiveRm(currentNode.getNext(), value));
        return currentNode;
    }
}


