package com.servo.datastructures.singlylinked;


class SinglyLinkedNode   {

    private SinglyLinkedNode next;
    private int value;

    SinglyLinkedNode(int value, SinglyLinkedNode next) {
        this.value = value;
        this.next = next;
    }

    SinglyLinkedNode getNext() {
        return next;
    }

    void setNext(SinglyLinkedNode next) {
        this.next = next;
    }

    int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
