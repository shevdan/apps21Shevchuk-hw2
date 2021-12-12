package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.Objects;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("hi");
        Object[] arr1 = {1, 2, 3};

//        Queue q = new Queue();
//        System.out.println(q.peek());

//        ImmutableLinkedList arr = new ImmutableLinkedList(arr1);
//
//
//
//        ImmutableLinkedList res = new ImmutableLinkedList(arr1);
//        System.out.println(Objects.equals(res.toString(), arr.toString()));

        Stack stack = new Stack();
        for (int i : new int[]{1, 2, 3, 4, 5}) {
            stack.push(i);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.pop());

        System.out.println(stack.pop());

        System.out.println(stack.pop());



//        System.out.println(arr.getHead());
//        System.out.println(res);

//        ImmutableArrayList arr = new ImmutableArrayList(arr1);
//
//        ImmutableArrayList res = (ImmutableArrayList) arr.set(  1, "Hello");
//        System.out.println(res);
//        System.out.println(arr);
//        System.out.println(arr.indexOf(100));
//
//        Object[] arr2 = arr.toArray();
//        for (Object elm : arr2){
//            System.out.println(elm);
//        }
    }
}
