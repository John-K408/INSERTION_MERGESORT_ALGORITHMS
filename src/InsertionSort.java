public class InsertionSort {
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
            // Find the index for the value with the smallest val variable in the array
            int smallestIndex = 0;
            for (int j = 1; j < n; j++) {
                if (a[j].getValue() < a[smallestIndex].getValue()) {
                    smallestIndex = j;
                }
            }
            int min = a[smallestIndex].getValue();
            for (int q = 0; q< n; q++){
                if (q == smallestIndex) {
                    int hz = 440;
                    a[q].setSound(hz);
                }
                else{
                    int x = a[q].getValue();
                    int hz = (int)(440 * Math.pow(2, (x - min) / 12.0));
                    a[q].setSound(hz);
                }

            }








            drawNPlay(a,n);
           //Sorting Program
            for (int i = 1; i < n; i++) {
                for (int j = i; j > 0; j--) {
                    if (a[j - 1].compareTo(a[j]) > 0) {
                        StdDraw.clear();
                        //a[j].draw2(j,n);
                        Value tmp = a[j];
                        a[j] = a[j - 1];
                        a[j - 1] = tmp;
                        //StdDraw.clear();
                        //a[j].draw(j,n);
                        // a[j-1].draw2(j-1,n);
                        drawNPlay(a, n);


                    } else {
                        break;
                    }

                }
            }


        }


    }
    public static void drawNPlay(Value [] a,int n){

        for (int q = 0; q < n; q++){

                a[q].draw(q,n);
                StdAudio.play(a[q].getSound());
            }

        }



}
