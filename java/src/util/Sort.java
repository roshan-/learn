package util;

public class QuickSort {

    public static <T extends Comparable<T>> void swap(T[] a, int i, int j) {
        T temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static <T extends Comparable<T>> void sort(T[] a, int begin, int end) {
        if (begin >= end) return;
        T pivot = a[(begin + end)/2];

        int i= begin, j=end;
        while (i < j) {
            while (a[i].compareTo(pivot) < 0 && i<j) i++;
            while (a[j].compareTo(pivot) > 0 && i<j) j--;
            if (i < j) {
                swap(a, i++, j--);
            }
        }
        if (i > begin) sort(a, begin, i);
        if (j < end)   sort(a, j+1, end);
    }
    public static <T extends Comparable<T>> void print(T[] a) {
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i].toString() + " ");
        }
        System.out.println("\n");
    }

