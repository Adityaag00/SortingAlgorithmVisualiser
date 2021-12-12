package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountSort implements Sort{

    private pnlAnimation ani;

    public CountSort(pnlAnimation ani) {
        this.ani=ani;
    }

    @Override
    public void sort() {
        countSort(ani.arr);
    }

    private void countSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            output[i]=arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            count[output[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            ani.updateCount(count[output[i] - min]-1,output[i]);
            count[output[i] - min]--;
        }
    }
}
