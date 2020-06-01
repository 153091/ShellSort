/** %java ShellSort.java input.txt
 Note: ShellSort.java uses unchecked or unsafe operations.
 Note: Recompile with -Xlint:unchecked for details.
 A E E L M O P R S T X
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ShellSort {

    public static void sort(Comparable[] a) {
        int n = a.length;

        //naidem nuzhniy h
        int h =1;
        while (h < n/3) h = 3*h +1 ; //increment 1, , 13, 40, 121, 364

        while (h>=1)
        {//h-sort array
            for (int i = h; i<n ; i++) {

                for (int j = i; j>=h && less(a[j], a[j-h]); j -=h)  exch(a, j, j-h);
            }
            h=h/3; //move to next increment
        }
        assert isSorted(a);
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)<0;
    }
    private static boolean isSorted(Comparable[] a) {
        for (int i=1; i< a.length; i++ )
            if(less(a[i], a[i-1])) return false;
            return true;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        sort(a);
        for (String s: a)
            StdOut.print(" " +s);

    }
}
