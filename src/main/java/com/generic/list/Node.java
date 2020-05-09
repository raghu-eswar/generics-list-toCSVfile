package com.generic.list;

public class Node <Any extends Comparable<Any>> {
    private Any value;
    private Node<Any> NextNode;

    public Node(Any value) {
        this(value,null);
    }

    public Node(Any value, Node<Any> nextNode) {
        this.value = value;
        this.NextNode = nextNode;
    }

    public Any getValue() {
        return value;
    }

    public void setValue(Any value) {
        this.value = value;
    }

    public Node<Any> getNextNode() {
        return NextNode;
    }

    public void setNextNode(Node<Any> nextNode) {
        this.NextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", NextNode=" + NextNode +
                '}';
    }
}
