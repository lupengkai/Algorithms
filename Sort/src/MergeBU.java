import edu.princeton.cs.algs4.StdOut;

/**
 * Created by tage on 15-9-14.
 */
public class MergeBU { //自顶向下的归并排序
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {// sz 子数组大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) { //lo:子数组索引
                merge(a, lo, lo + sz - 1, Math.min((lo + sz + sz - 1), N - 1));
            }
        }
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
        String[] a = args;
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
