package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

import java.util.Arrays;

public class RadixSort implements Sort{

    pnlAnimation ani;

    public RadixSort(pnlAnimation ani) {
        this.ani=ani;
    }

    @Override
    public void sort() {
        radixsort(ani.arr,ani.arr.length);
    }

    private void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            output[i]=arr[i];
        }

        for (int i = 0; i < n; i++) {
            count[(output[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int i1 = count[(output[i] / exp) % 10];
            ani.update(i1 - 1,output[i]);
            count[(output[i] / exp) % 10]--;
        }
    }

    private void radixsort(int arr[], int n) {
        int m = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
