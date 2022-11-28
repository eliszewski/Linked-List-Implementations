package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable> {
    private Node head;
    private Node tail;
    private int size;


    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public class Node<T>{
        T value;
        Node<T> nextNode;

        public Node(T value, Node<T> nextValue) {
            this.value = value;
            this.nextNode = null; //set default to null
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }
    public void add(Node<T> node){
        if(getHead() == null) setHead(node);
        else {
            this.tail.setNextNode(node);
            this.setTail(node);
            this.setSize(size++);
        }
    }
    public T get(int index) {
        int counter = 0;
        Node<T> currentNode = head;
        while (counter != index) {
            currentNode = currentNode.getNextNode();
            counter++;
        }
        return currentNode.getValue();
    }
    public boolean contains(T value){
        Node<T> currentNode = getHead();
        while(currentNode != null){
            if(currentNode.getValue() == value) return true;
            currentNode = currentNode.getNextNode();
        }
        return false;
    }
    public int find(T valueToFind){
        Node<T> currentNode = head;
        int index = 0;
        while(currentNode != null){
            if(currentNode.equals(valueToFind)) return index;
            else{
                index++;
                currentNode = currentNode.getNextNode();
            }
        }
        return -1;
    }

}
