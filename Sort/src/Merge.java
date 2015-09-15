import edu.princeton.cs.algs4.StdOut;

/**
 * Created by tage on 15-9-12.
 */
public class Merge {
    public static Comparable[] aux = null;//辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];//一次性分配空间
        sort(a, 0, a.length - 1); //调用private sort()
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);//将左半边排序,递归调用
        sort(a, mid + 1, hi);//将右半边排序,递归调用
        merge(a, lo, mid, hi);//归并结果
    }


    public static void merge(Comparable[] a, int lo, int mid, int hi) { //归并已经有序的两个子数组
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];//左边数组取尽,取右边的数组
            else if (j > hi) a[k] = aux[i++];//右边数组取尽,取左边的数组
            else if (less(aux[j], aux[i])) a[k] = aux[j++];//选较小的元素添加
            else a[k] = aux[i++];
        }
    }

    public static void fasterMerge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= mid; i++) {
            aux[i] = a[i];
        }

        for (int j = mid + 1; j <= hi; j++) {
            aux[j] = a[hi - j + mid + 1];
        }

        int i = lo;
        int j = hi;
        for (int k = lo; k <= hi; k++) {
            if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j--]
        }

    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Comparable<String>[] a = args;
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
