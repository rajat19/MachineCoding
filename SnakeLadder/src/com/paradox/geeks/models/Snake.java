package com.paradox.geeks.models;

public class Snake {
    private Cell head;
    private Cell tail;

    public Snake(Cell head, Cell tail) {
        this.head = head;
        this.tail = tail;
    }

    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }

    public Cell getTail() {
        return tail;
    }

    public void setTail(Cell tail) {
        this.tail = tail;
    }
}
