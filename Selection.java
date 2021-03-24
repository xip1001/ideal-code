package com.algorithm;

import java.util.Comparator;

class Selection {

    // 私有构造函数，不允许被实例化
    private Selection() {
    }

    /**
     * 使用自然顺序排列
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;  //将第i个元素标记为最小min
            for (int j = i + 1; j < n; j++) { //遍历数组，用第i个元素与其后面的元素进行比较
                if (less(a[j], a[min]))  //如果a[j]<a[min]，将j标记为min
                    min = j;
            }
            exch(a, i, min);  //交换两元素的位置
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * 使用比较器进行排序
     * Rearranges the array in ascending order, using a comparator.
     *
     * @param a          the array
     * @param comparator the comparator specifying the order
     */
    public static void sort_1(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(comparator, a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
            assert isSorted(a, comparator, 0, i);
        }
        assert isSorted(a, comparator);
    }


    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {

        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Comparator comparator, Object v, Object w) {

        return comparator.compare(v, w) < 0;
    }


    // 交换元素位置
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    // 判断数组是否排序
    private static boolean isSorted(Comparable[] a) {

        return isSorted(a, 0, a.length - 1);
    }

    // 判读数组是否是从[lo]到[hi]排序的
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    // 判断数组是否排序
    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // 判读数组是否是从[lo]到[hi]排序的
    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i - 1])) return false;
        return true;
    }


    // 打印数组
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println((a[i]));
        }
    }


    public static void main(String[] args) {
        String[] a = {"a", "v", "r", "e"};
        Selection.sort(a);
        show(a);
    }
}
