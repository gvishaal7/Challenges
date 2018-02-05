import java.util.Random;


public void shuffle(Object[] a) {
    int aLength = a.length-1;
    Random rand = new Random();
    while(aLength > 0) {
        int swapIndex = rand.nextInt(aLength);
        Object temp = a[swapIndex];
        a[swapIndex] = a[aLength];
        a[aLength] = temp;
        aLength--;
    }
}
