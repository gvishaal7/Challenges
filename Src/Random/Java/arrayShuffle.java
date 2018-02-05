import java.util.Random;


public void shuffle(int[] a) {
    int aLength = a.length-1;
    Random rand = new Random();
    while(aLength > 0) {
        int swapIndex = rand.nextInt(aLength);
        int temp = a[swapIndex];
        a[swapIndex] = a[aLength];
        a[aLength] = temp;
        aLength--;
    }
}
