public class InsertionSort2 {
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
            for (int i = 1; i < n; i++) {
                for (int j = i; j > 0; j--) {
                    if (a[j - 1].compareTo(a[j]) > 0) {
                        StdDraw.clear();
                       drawNPlay2(a,n,j-1,j);
                       StdDraw.pause(2);
                        //a[j].draw2(j,n);
                        Value tmp = a[j];
                        a[j] = a[j - 1];
                        a[j - 1] = tmp;

                        //a[j].draw(j,n);
                        // a[j-1].draw2(j-1,n);



                    } else {
                        break;
                    }

                }
            }
            StdDraw.clear();
            drawNPlay(a, n);



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

    public static void drawNPlay2(Value [] a,int n,int p, int c){
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
            if(q == c) {
                a[q].draw2(q, n);
            }
            else {
                a[q].draw(q, n);
            }

            a[q].setSound(hz);
            StdAudio.play(a[q].getSound());




        }

    }

}



