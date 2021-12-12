package ua.edu.ucu.collections.immutable;

import java.util.ArrayList;
import java.util.Objects;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head, tail;


    public ImmutableLinkedList(Object[] elements) {
        if (elements.length != 0) {

            Node elm = new Node(elements[0]);
            head = elm;
            tail = elm;

            for (int i = 1; i < elements.length; i++) {
                elm = new Node(elements[i]);
                tail.setNext(elm);
                elm.setPrevious(tail);
                tail = elm;
                tail.setNext(null);
            }
        }



    }

    public ImmutableLinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            res.append(curr.getValue());
            res.append(" ");
            curr = curr.getNext();
        }
        return res.toString();
    }

    private ImmutableList copy() {
        ImmutableLinkedList res = new ImmutableLinkedList();


        if (head == null) {
            return res;
        }
        Node curr = head;
        Node newElm = new Node(curr.getValue());

        res.head = newElm;
        res.tail = newElm;
        curr = curr.getNext();
        while (curr != null) {

            newElm = new Node(curr.getValue());
            res.tail.setNext(newElm);
            newElm.setPrevious(res.tail);
            res.tail = newElm;
            res.tail.setNext(null);
            curr = curr.getNext();
        }

        return res;
    }


    @Override
    public ImmutableList add(Object e) {
        ImmutableLinkedList res = (ImmutableLinkedList) copy();


        Node newElm;
        if (res.tail != null) {

            newElm = new Node(e);
            res.tail.setNext(newElm);
            newElm.setPrevious(res.tail);
            res.tail = newElm;
            res.tail.setNext(null);
        }
        else {
            newElm = new Node(e);
            res.tail = newElm;
            res.head = newElm;
        }



        return res;
    }

    @Override
    public ImmutableList add(int index, Object e)
            throws IndexOutOfBoundsException {
        ImmutableLinkedList res = (ImmutableLinkedList) copy();


        int idx = 0;
        Node newElm = new Node(e);

        if (index == 0) {
            newElm.setNext(res.head);
            res.head.setPrevious(newElm);
            res.head = newElm;
            return res;
        }
        idx++;
        Node curr = res.head;
        while (curr != null) {

            if (Objects.equals(index, idx)) {
                newElm.setPrevious(curr);
                newElm.setNext(curr.getNext());
                curr.setNext(newElm);
                return res;
            }
            idx++;
            curr = curr.getNext();
        }

        throw new IndexOutOfBoundsException();

    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableLinkedList toAdd = new ImmutableLinkedList(c);
        if (head == null) {
            return toAdd;
        }

        ImmutableLinkedList res = (ImmutableLinkedList) copy();

        res.tail.setNext(toAdd.head);
        toAdd.head.setPrevious(res.tail);
        res.tail = toAdd.tail;

        return res;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c)
            throws IndexOutOfBoundsException {
        ImmutableLinkedList res = (ImmutableLinkedList) copy();
        ImmutableLinkedList toAdd = new ImmutableLinkedList(c);
        if (toAdd.isEmpty()) {
            return res;
        }

        if (res.isEmpty() && index == 0) {
            return toAdd;
        }

        int idx = 0;
        if (index == 0) {
            toAdd.tail.setNext(res.head);
            res.head.setPrevious(toAdd.tail);
            res.head = toAdd.head;
            return res;
        }
        idx++;
        Node curr = res.head;
        while (curr != null) {
            if (Objects.equals(index, idx)) {
                toAdd.head.setPrevious(curr);
                toAdd.tail.setNext(curr.getNext());
                if (curr.getNext() != null) {
                    curr.getNext().setPrevious(toAdd.tail);
                }
                curr.setNext(toAdd.head);
                return res;
            }
            idx++;
            curr = curr.getNext();
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public Object get(int index) {
        int idx = 0;


        Node curr = head;
        while (curr != null) {
            if (Objects.equals(index, idx)) {
                return curr.getValue();
            }
            idx++;
            curr = curr.getNext();
        }



        throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableList remove(int index) throws IndexOutOfBoundsException {
        ImmutableLinkedList res = (ImmutableLinkedList) copy();

        int idx = 0;



        if (index == 0) {
            if (res.head.getNext() != null) {
                res.head.getNext().setPrevious(null);
                res.head = res.head.getNext();
            }
            else {
                res.head = null;
                res.tail = null;
            }
            return res;
        }


        Node curr = res.head.getNext();
        idx++;


        while (curr != null) {
            if (Objects.equals(index, idx)) {
                if (!Objects.equals(curr, res.tail)) {

                    curr.getNext().setPrevious(curr.getPrevious());
                    curr.getPrevious().setNext(curr.getNext());
                }
                else {
                    curr.getPrevious().setNext(null);
                    res.tail = curr.getPrevious();
                }
                return res;
            }
            idx++;
            curr = curr.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableList set(int index, Object e)
            throws IndexOutOfBoundsException {
        ImmutableLinkedList res = (ImmutableLinkedList) copy();

        int idx = 0;
        Node curr = res.head;
        while (curr != null) {
            if (Objects.equals(index, idx)) {
                curr.setValue(e);
                return res;
            }
            idx++;
            curr = curr.getNext();
        }

        throw new IndexOutOfBoundsException();

    }


    @Override
    public int indexOf(Object e) {
        int idx = 0;


        Node curr = head;
        while (curr != null) {
            if (Objects.equals(e, curr.getValue())) {
                return idx;
            }
            idx++;
            curr = curr.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        int idx = 0;


        Node curr = head;
        while (curr != null) {

            idx++;
            curr = curr.getNext();
        }
        return idx;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Object[] toArray() {
        if (head == null) {
            return new Object[0];
        }
        ArrayList<Object> arrCopy = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            arrCopy.add(curr.getValue());
            curr = curr.getNext();
        }

        return arrCopy.toArray();
    }

    public ImmutableLinkedList addFirst(Object e) {
        ImmutableLinkedList res = (ImmutableLinkedList) copy();



        Node newHead = new Node(e);

        if (res.head == null) {
            res.head = newHead;
            res.tail = newHead;
            return res;
        }

        res.head.setPrevious(newHead);
        newHead.setNext(res.head);
        res.head = newHead;

        return res;
    }

    public ImmutableLinkedList addLast(Object e) {
        ImmutableLinkedList res = (ImmutableLinkedList) copy();


        Node newHead = new Node(e);
        if (res.head == null) {
            res.head = newHead;
            res.tail = newHead;
            return res;
        }

        res.tail.setNext(newHead);
        newHead.setPrevious(res.tail);
        res.tail = newHead;

        return res;
    }

    public Node getHead() {
        if (tail == null) {
            return null;
        }
        return new Node(head.getValue());
    }

    public Node getTail() {
        if (tail == null) {
            return null;
        }
        return new Node(tail.getValue());
    }

    public Object getFirst() {
        if (head == null) {
            return null;
        }
        return head.getValue();
    }

    public Object getLast() {
        if (tail == null) {
            return null;
        }
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        ImmutableLinkedList res = (ImmutableLinkedList) copy();
        if (res.head == null) {
            return null;
        }

        if (Objects.equals(res.head, res.tail)) {
            res.tail = null;
            res.head = null;
            return res;
        }

        res.head.getNext().setPrevious(null);
        res.head = res.head.getNext();
        return res;
    }

    public ImmutableLinkedList removeLast() {
        ImmutableLinkedList res = (ImmutableLinkedList) copy();

        if (Objects.equals(res.head, res.tail)) {
            res.tail = null;
            res.head = null;
            return res;
        }

        res.tail.getPrevious().setNext(null);
        res.tail = res.tail.getPrevious();

        return res;
    }
}
