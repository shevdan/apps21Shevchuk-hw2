package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] arr;
    private int arrLength = 0;

    public ImmutableArrayList(Object[] elements) {
        arr = new Object[elements.length];
        this.arrLength = elements.length;
        for (int i = 0; i < elements.length; i++){
            arr[i] = elements[i];
        }

    }

    public ImmutableArrayList() {
    }

    @Override
    public String toString(){
        String res = "";
        for (int i = 0; i < arrLength; i++){
            res += arr[i];
            res += " ";
        }
        return res;
    }



    private Object[] createCopy(int len) {
        Object[] arrCopy;
        if (Objects.equals(len, arr.length) || len > arr.length) {
            arrCopy = new Object[2*(len + 1)];
        }
        else {
            arrCopy = new Object[len];
        }
        return arrCopy;
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] arrCopy = createCopy(arrLength);
        for (int i = 0; i < arrLength; i++){
            arrCopy[i] = arr[i];
        }
        arrCopy[arrLength] = e;

        ImmutableArrayList res = new ImmutableArrayList(arrCopy);
        res.arrLength = arrLength + 1;
        return  res;
    }

    @Override
    public ImmutableList add(int index, Object e) throws IndexOutOfBoundsException {

        if (index > arrLength  + 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] arrCopy = createCopy(arrLength);
        for (int i = 0; i < index; i++){
            arrCopy[i] = arr[i];
        }

        arrCopy[index] = e;
        for (int i = index + 1; i <= arrLength; i++){
            arrCopy[i] = arr[i - 1];
        }
        ImmutableArrayList res = new ImmutableArrayList(arrCopy);
        res.arrLength = arrLength + 1;
        return  res;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] arrCopy = createCopy(arrLength + c.length);
        for (int i = 0; i < arrLength; i++){
            arrCopy[i] = arr[i];
        }
        for (int i = arrLength; i < arrLength + c.length; i++){
            arrCopy[i] = c[i - arrLength];
        }
        ImmutableArrayList res = new ImmutableArrayList(arrCopy);
        res.arrLength = arrLength + c.length;
        return  res;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) throws IndexOutOfBoundsException {
        if (index > arrLength + 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] arrCopy = createCopy(arrLength + c.length);
        for (int i = 0; i < index; i++) {
            arrCopy[i] = arr[i];
        }

        for (int i = index; i < index + c.length; i++){
            arrCopy[i] = c[i - index];
        }

        for (int i = index + c.length; i < arrLength + c.length; i++){
            arrCopy[i] = arr[i - c.length];
        }

        ImmutableArrayList res = new ImmutableArrayList(arrCopy);
        res.arrLength = arrLength + c.length;
        return  res;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index > arrLength || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public ImmutableList remove(int index) throws IndexOutOfBoundsException {
        if (index > arrLength || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] arrCopy = createCopy(arrLength);
        for (int i = 0; i < index; i++){
            arrCopy[i] = arr[i];
        }

        for (int i = index + 1; i < arrLength; i++) {
            arrCopy[i - 1] = arr[i];
        }
        ImmutableArrayList res = new ImmutableArrayList(arrCopy);
        res.arrLength = arrLength - 1;
        return  res;
    }

    @Override
    public ImmutableList set(int index, Object e) throws IndexOutOfBoundsException {

        if (index > arrLength || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] arrCopy = createCopy(arrLength);
        for (int i = 0; i < arrLength; i++){
            arrCopy[i] = arr[i];
        }
        arrCopy[index] = e;
        ImmutableArrayList res = new ImmutableArrayList(arrCopy);
        res.arrLength = arrLength;
        return  res;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < arrLength; i++){
            if (Objects.equals(arr[i], e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return arrLength;
    }

    @Override
    public ImmutableList clear() {
        Object[] arrCopy = new Object[0];

        return new ImmutableArrayList(arrCopy);
    }

    @Override
    public boolean isEmpty() {
        return arrLength == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arrCopy = new Object[arrLength];
        for (int i = 0; i < arrLength; i++){
            arrCopy[i] = arr[i];
        }
        return arrCopy;
    }
}
