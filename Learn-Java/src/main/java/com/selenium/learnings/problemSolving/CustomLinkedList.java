package com.selenium.learnings.problemSolving;

public class CustomLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T>{
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }

    }

    public Node<T> getNode(int size){
        Node<T> node = head;
        for(int i=0;i<size;i++){
            node = node.next;
        }

        return node;
    }
    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head=node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(T value) {
        if(tail == null){
            addFirst(value);
        }
        Node<T> node = new Node<>(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void display() {
        Node<T> temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("End");
    }

    public T deleteFirst(){
        T val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public T deleteLast(){

        if(size <= 1){
            return deleteFirst();
        }
        tail = getNode(size -1);
        tail.next = null;
        return tail.value;
    }


    public T deleteElement(int index){
        if(index==0){
            return deleteFirst();
        }

        if(index ==size-1){
            return deleteLast();
        }

        Node<T> prevNode = getNode(index-1);
        prevNode.next = prevNode.next.next;
        return prevNode.next.value;
    }


    public static void main(String[] args) {
        CustomLinkedList<String> linkedList =
                new CustomLinkedList<String>();
        linkedList.addFirst("World");
        linkedList.insertLast("Muhassan");
        linkedList.addFirst("Hello");
        System.out.println(linkedList.deleteElement(1));
        linkedList.display();

    }
}
