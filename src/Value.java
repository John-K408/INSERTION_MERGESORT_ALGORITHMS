public class Value {
    private int val;
    private static double[] sound = new double[4410];

    public Value(int val){
        this.val = val;
    }

    public  int getValue(){//why does it say cannot reference this in a static statement

        return this.val;
    }

    public  double[] getSound(){

        return this.sound;
    }

    public int compareTo (Value other){
        if(this.val < other.val){
            return -1;
        }
        else if(this.val == other.val){
            return 0;
        }
        else {
            return 1;
        }
    }

    public void setSound(int hz){
        int SAMPLING_RATE = 44100;
        double n = sound.length;
        for (int i = 0; i < n; i++) {
            sound[i] = Math.sin((2 * Math.PI * i * hz) / SAMPLING_RATE);
        }
    }

    public void draw( int index, double n){
        // n is the user argument which shows the number of elements in the array.
        double height = this.val * 0.05;
        double length = 0.99/n;
        double xCoordinate = 0.01+length/2 + length*index;
        double yCoordinate = 0.01+height/2;
        StdDraw.rectangle(xCoordinate,yCoordinate,length/2,height/2);
    }

    public void draw2( int index, double n){
        // n is the user argument which shows the number of elements in the array.
        double height = this.val * 0.05;
        double length = 0.99/n;
        double xCoordinate = 0.01+length/2 + length*index;
        double yCoordinate = 0.01+height/2;
        StdDraw.setPenColor(4,4,50);
        StdDraw.filledRectangle(xCoordinate,yCoordinate,length/2,height/2);
    }



}
