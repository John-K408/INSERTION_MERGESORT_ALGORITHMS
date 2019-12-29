
    public class MergeSortWithComments {
        public static void mergesort(Value[] a) {
            mergesort(a, 0, a.length);
        }

        public static void mergesort(Value[] a, int lo, int hi) {
            // Base case
            // (void methods can return, they just don't return anything)
            if (hi - lo <= 1) return;
            // Prepare for the recursive calls
            // Find the midpoint to "split" the array in two "halves"
            int mid = lo + (hi - lo) / 2;
            // Recursive calls / "Divide" phase
            // Sort the two "halves" recursively
            mergesort(a, lo, mid);
            mergesort(a, mid, hi);
            // "Conquer" phase
            // Merge the two "halves" into c
            Value[] c = new Value[hi - lo];
            int ai = lo;
            int bi = mid;
            for (int ci = 0; ci < c.length; ci++) {
                if (ai == mid) {
                    c[ci] = a[bi];
                    bi++;
                } else if (bi == hi) {
                    c[ci] = a[ai];
                    ai++;
                } else if (a[ai].compareTo(a[bi]) < 0) {
                    c[ci] = a[ai];
                    ai++;
                } else {
                    c[ci] = a[bi];
                    bi++;
                }
            }
            // Copy the elements c back into arr in the right place.
            for (int ci = 0; ci < c.length; ci++) {
                a[lo + ci] = c[ci];
            }
        }
}

