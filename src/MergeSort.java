public class MergeSort {
    public static void main(String[]args){
        int n = Integer.parseInt(args[0]);

        if(n < 0 || args.length !=1){


        }

        else{
            Value [] a = new Value[n];
            //Generate random values for the elements of the array.
            for (int i = 0; i < n;i++) {
                int valueParameter = (int) (1 + Math.random() * n);
                Value k = new Value(valueParameter);
                a[i] = k;
            }
            drawNPlay(a,n);
            //Sorting Program
            mergeSort(a,n,0,n);



        }


    }
    public static void drawNPlay(Value [] a,int n){
        // Find the index for the value with the smallest val variable in the array
        int smallestIndex = 0;
        for (int j = 1; j < n; j++) {
            if (a[j].getValue() < a[smallestIndex].getValue()) {
                smallestIndex = j;
            }
        }
        int min = a[smallestIndex].getValue();
        //set the hertz for the smallest value and all other values.
        //Draw each element in the array
        //Make sound for each drawing in the array
        int hz;
        for (int q = 0; q < n; q++){

            if (q == smallestIndex) {
                hz = 440;
            }
            else{
                int x = a[q].getValue();
                hz = (int)(440 * Math.pow(2, (x - min) / 12.0));
            }
            a[q].setSound(hz);
            a[q].draw(q,n);
            StdAudio.play(a[q].getSound());
        }

    }
    public static void drawNPlay2(Value [] a,int n,int s, int l){
        // Find the index for the value with the smallest val variable in the array
        int smallestIndex = 0;
        for (int j = 1; j < n; j++) {
            if (a[j].getValue() < a[smallestIndex].getValue()) {
                smallestIndex = j;
            }
        }
        int min = a[smallestIndex].getValue();
        //set the hertz for the smallest value and all other values.
        //Draw each element in the array
        //Make sound for each drawing in the array
        int hz;
        for (int q = 0; q < n; q++){

            if (q == smallestIndex) {

                hz = 440;
            }

            else{
                int x = a[q].getValue();
                hz = (int)(440 * Math.pow(2, (x - min) / 12.0));
            }
            if(q >=s&&q<=l) {
                a[q].draw2(q, n);
            }
            else {
                a[q].draw(q, n);
            }

            a[q].setSound(hz);
            StdAudio.play(a[q].getSound());




        }

    }
    public static void mergeSort(Value[] a,int n, int lo, int hi) {

        // Base case
        // (void methods can return, they just don't return anything)
        if (hi - lo <= 1) {
            StdDraw.clear();
            drawNPlay2(a,n,lo,hi);
            return;
        }
        // Prepare for the recursive calls
        // Find the midpoint to "split" the array in two "halves"
        int mid = lo + (hi - lo) / 2;
        // Recursive calls / "Divide" phase
        // Sort the two "halves" recursively
        mergeSort(a,n, lo, mid);
        mergeSort(a,n, mid, hi);
        // "Conquer" phase
        // Merge the two "halves" into c
        Value[] c = new Value[hi - lo];
        int ai = lo;
        int bi = mid;
        StdDraw.clear();
        drawNPlay2(a,n,lo,mid);
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
        StdDraw.clear();
        drawNPlay(a,a.length);
    }

}
