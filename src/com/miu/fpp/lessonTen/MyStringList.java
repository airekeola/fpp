package com.miu.fpp.lessonTen;

import java.util.Arrays;

public class MyStringList {

    private final int INITIAL_LENGTH = 4;
    private String[] strArray;
    private int size;


    public MyStringList() {
        strArray = new String[INITIAL_LENGTH];
        size = 0;
    }

    //Sort Array
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                if (strArray[i].compareTo(strArray[j]) > 0) {
                    String temp = strArray[i];
                    strArray[i] = strArray[j];
                    strArray[j] = temp;
                }
            }
        }
    }

    // Add element in last
    public void add(String s) {

        if (s == null) return;
        if (size == strArray.length) resize();
        strArray[size++] = s;
    }

    public String get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        return strArray[i];
    }

    public boolean find(String s) {
        if (s == null) return false;
        for (String test : strArray) {
            if (test.equals(s)) return true;
        }
        return false; // The element is not in the list
    }

    public void insert(String s, int pos) {
        if (pos > size || pos < 0) return;
        if (pos == strArray.length || size + 1 > strArray.length) {
            resize();
        }
        String[] temp = new String[strArray.length + 1];
        System.arraycopy(strArray, 0, temp, 0, pos); // src, spos,des,dspos,number of elements
        temp[pos] = s;

        System.arraycopy(strArray, pos, temp, pos + 1, strArray.length - pos);
        strArray = temp;
        ++size;
    }

/*	 public void insert(String s, int pos) {
	 if(pos<0 || pos > size) return;
		if(pos == strArray.length||size+1 > strArray.length) {
			resize ();
		}
		String[] temp = new String[strArray.length+1];
       for(int i = 0; i < pos; i++)
        temp[i] = strArray[i];
    temp[pos] = s;
    for(int i = pos + 1; i < strArray.length; i++)
        temp[i] =strArray[i - 1];
    strArray = temp;
		++size;
}*/

    public boolean remove(String s) {
        if (size == 0) return false; // list is empty
        if (s == null) return false;
        int index = -1;
        for (int i = 0; i < size; ++i) {
            if (strArray[i].equals(s)) {
                index = i;
                break;
            }
        }
        if (index == -1) return false; // s is not found in the list
        String[] temp = new String[strArray.length];
        System.arraycopy(strArray, 0, temp, 0, index);
        System.arraycopy(strArray, index + 1, temp, index, strArray.length - (index + 1));
        strArray = temp;
        --size;
        return true;
    }

    private void resize() {
        System.out.println("resizing");
        int len = strArray.length;
        int newlen = 2 * len;
        String[] temp = new String[newlen];
        System.arraycopy(strArray, 0, temp, 0, len);
        // strArray = Arrays.copyOf(strArray, newlen);
        strArray = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; ++i) {
            sb.append(strArray[i] + ", ");
        }
        sb.append(strArray[size - 1] + "]");
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Object clone() {
        String[] temp = Arrays.copyOf(strArray, size);
        return temp;

    }

    public static void main(String[] args) {
        MyStringList list = new MyStringList();
//        System.out.println("Is Empty : " + list.isEmpty());
//        list.add("Java");
//        list.add("C#");
//        list.insert("Android", 0);
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.get(0));
//        System.out.println(list.find("Java"));
//        System.out.println(list.remove("Java"));


        System.out.println(list.size());
        list.add("b");
        System.out.println(list);

        list.add("y");
        list.add("x");
        list.add("w");
        list.add("v");
        list.add("u");
        list.add("a");

        list.add("b");
        list.add("y");
        list.add("a");
        list.add("f");
        list.add("q");
        list.add("z");
        list.add("j");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);
        list.sort();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("Is Empty : " + list.isEmpty());

    }

}

