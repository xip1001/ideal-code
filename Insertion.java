package com.algorithm;

import edu.princeton.cs.algs4.StdIn;

public class Insertion {

    private Insertion(){}

    //使用自然排序
    public static void sort(Comparable[] a){
        int n=a.length;
        for (int i=1;i<n;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
            assert isSorted(a,0,i);
        }
        assert isSorted(a);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i=lo+1;i<hi;i++){
            if(less(a[i],a[i-1]))
                return false;
        }
        return true;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a,0,a.length);
    }

    private static void exch(Object[] a, int j, int i) {
        Object swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }

    private static boolean less(Comparable v, Comparable m) {
        return v.compareTo(m)<0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println((a[i]));
        }
    }


    public static void main(String[] args) {
//        String[] a = {"a", "v", "r", "e"};
        String[] a = StdIn.readAllStrings();
        Selection.sort(a);
        show(a);
    }
}
