package com.generic.list;

public class MyList<Any extends Comparable<Any>> {
    private Node<Any> head;
    private Node<Any> tail;

    public final void add(Any value) {
        Node<Any> node = new Node<>(value);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        }
        else if (indexOf(value) == -1){
            this.tail.setNextNode(node);
            this.tail = this.tail.getNextNode();
        }
    }

    public final void remove(Any value) {
        if (indexOf(value) != -1)
            pop(indexOf(value));
    }

    public final boolean search(Any value) {
        return (indexOf(value) != -1);
    }

    public final boolean isEmpty() {
        return (this.head == null);
    }

    public final int size() {
        int size = 0;
        Node<Any> temp = this.head;
        while (temp != null) {
            size++;
            temp = temp.getNextNode();
        }
        return size;
    }

    public final void append(Any... values) {
        if (!isEmpty())
            for (Any value : values) {add(value);}
    }

    public final int indexOf(Any value) {
        int index = -1;
        Node<Any> temp = this.head;
        while (temp != null) {
            index++;
            if (temp.getValue().compareTo(value) == 0) {
                return index;
            }
            temp = temp.getNextNode();
        }
        return -1;
    }

    public final void insertAt(int pos, Any value) {
        if (pos > -1 && pos <= size()){
            if (pos == size())
                add(value);
            else {
                Node<Any> node = new Node<>(value);
                Node<Any> temp = this.head;
                for (int i = 1; i < pos; i++) {
                    temp = temp.getNextNode();
                }
                Node<Any> tempNextNode = temp.getNextNode();
                if (pos == 0) {
                    node.setNextNode(this.head);
                    this.head = node;
                }
                else {
                    temp.setNextNode(node);
                    node.setNextNode(tempNextNode);
                }
            }
        }
        else
            throw new ArrayIndexOutOfBoundsException("index out of bound for "+pos);
    }

    public final Any pop() {
        return pop(size()-1);
    }

    public final Any pop(int pos) {
        if (pos < 0 || pos >=size())
            throw new ArrayIndexOutOfBoundsException("index out of bound for "+pos);
        Any returnValue;
        Node<Any> temp = this.head;
        for (int i = 1; i < pos; i++) {
            temp = temp.getNextNode();
        }
        if (pos == 0)
            returnValue = removeFirstElement();
        else if (pos == size()-1)
            returnValue = removeLastElement(temp);
        else {
            Node<Any> tempNextNode = temp.getNextNode().getNextNode();
            returnValue = temp.getNextNode().getValue();
            temp.getNextNode().setNextNode(null);
            temp.setNextNode(tempNextNode);
        }
        return returnValue;
    }

    private Any removeLastElement(Node<Any> temp) {
        Any returnValue = this.tail.getValue();
        this.tail = temp;
        this.tail.setNextNode(null);
        return returnValue;
    }

    private Any removeFirstElement() {
        Node<Any> temp = this.head;
        Any returnValue = this.head.getValue();
        this.head = temp.getNextNode();
        temp.setNextNode(null);
        return returnValue;
    }

    public final String [] toStringArray() {
        String [] array = new String[size()];
        Node<Any> temp = this.head;
        int i = 0;
        while (temp != null) {
            array[i++] = (temp.getValue()).toString();
            temp = temp.getNextNode();
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder listElements = new StringBuilder();
        Node<Any> temp = this.head;
        while (temp.getNextNode() != null) {
            listElements.append(" ").append(temp.getValue()).append(",");
            temp = temp.getNextNode();
        }
        listElements.append(" ").append(tail.getValue());
        return "["+listElements+" ]";
    }
}
