package com.zipcodewilmington.singlylinkedlist;

import java.util.Objects;

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

        public Node(T value) {
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
    public void add(T valueToAdd){
        Node<T> node = new Node<T>(valueToAdd);
        if(getHead() == null) setHead(node);
        else {
            this.tail.setNextNode(node);
        }
        this.setTail(node);
        size++;
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
            if(currentNode.getValue().equals(value)) return true;
            currentNode = currentNode.getNextNode();
        }
        return false;
    }
    public int find(T valueToFind){
        Node<T> currentNode = head;
        int index = 0;
        while(currentNode != null){
            if(currentNode.getValue().equals(valueToFind)) return index;
            else{
                index++;
                currentNode = currentNode.getNextNode();
            }
        }
        return -1;
    }
    public int size(){return getSize();}

    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> theCopy = new SinglyLinkedList<T>();
        Node<T> currentNode = this.head;
        while(currentNode !=  null ){
            theCopy.add(currentNode.getValue());
            currentNode =  currentNode.getNextNode();
        }
        return theCopy;
    }
    public void remove(int index){
        int counter = 0;
        if(index == 0) this.setHead(head.nextNode); // 0 index case
        else {
            Node<T> currentNode = this.head;
            //iterate to the one before index
            while (counter != index - 1) {
                currentNode = currentNode.getNextNode();
                counter++;
            }
            //last index case
            if(currentNode.getNextNode().getNextNode() == null){
                currentNode.setNextNode(null);
                setTail(currentNode);
            }
            //change node before to point to the next one after the next
            else {
                currentNode.setNextNode(currentNode.getNextNode().getNextNode());
            }
        }
        size--;
    }
    //need an equals method

    public boolean equals(SinglyLinkedList<T> sllToCompare){
        Node<T> currentNode1 = this.head;
        Node<T> currentNode2 = sllToCompare.getHead();
        if(this.size()!= sllToCompare.size()) return false;
        else {
            while(currentNode1 != null){
                if(!currentNode1.getValue().equals(currentNode2.getValue())) return false;
                currentNode1 = currentNode1.getNextNode();
                currentNode2 = currentNode2.getNextNode();
            }
            return true;
        }
    }
    public void sort(){
        boolean changed = false;
        Node<T> current = this.head;
        Node<T> next = current.getNextNode();
        int n = this.size;
        for(int i = 0; i < n ; i++){
            while(next != null){ //till end of list
                if(current.getValue().compareTo(next.getValue() ) > 0){
                    //swap the values
                     T temp = current.getValue();
                    current.setValue(next.getValue());
                    next.setValue(temp);
                    changed = true;
                }
                //move to the next
                current = next;
                next = current.getNextNode();
            }
            // reset and iterate swap again
            if(!changed) break; //if nothing was changed: array is sorted break
            current = head;
            next = current.getNextNode();
        }
    }
    public void reverse(){
        Node<T> current = this.head;
        Node<T> prev = null;
        Node<T> next;
        tail = head;
        while(current != null){
            next = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = next;
        }
        this.head = prev;
    }
    public SinglyLinkedList<T> slice(int start, int end) {
        SinglyLinkedList<T> sliced = new SinglyLinkedList<>();
        Node<T> current = this.head;
        for(int i = 0 ;i < end; i++){
            if(i >= start){
                sliced.add(current.getValue());
            }
            current = current.getNextNode();
        }
        return sliced;
    }
}
