import edu.princeton.cs.algs4.StdOut;

/**
 * Created by tage on 15-9-5.
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;//数组长度

        for (int i = 0; i < N; i++) {
            int min = i;//从已经排好的元素开始
            for (int j = i+1; j < N; j++) {//找到从已经排好顺序的部分开始剩下最小的元素
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);//将最小的元素和最前面开始的元素交换
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
            if (less(a[i], a[i-1])) {
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
