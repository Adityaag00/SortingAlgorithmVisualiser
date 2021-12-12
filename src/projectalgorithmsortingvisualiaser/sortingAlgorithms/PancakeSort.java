package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

import java.util.Collections;
import java.util.Vector;

public class PancakeSort implements Sort{

    private pnlAnimation ani;

    public PancakeSort(pnlAnimation ani) {
        this.ani = ani;
    }

    @Override
    public void sort() {
        pancakeSort(ani.arr,ani.arr.length);
    }

    private void flip(int arr[], int i)
    {
        int temp, start = 0;
        while (start < i) {
            ani.pancakeSwap(start,i);
            start++;
            i--;
        }
    }
    private int findMax(int arr[], int n) {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr[i] > arr[mi])
                mi = i;
        return mi;
    }

    private int pancakeSort(int arr[], int n) {
        for (int curr_size = n; curr_size > 1; --curr_size) {
            int mi = findMax(arr, curr_size);

            if (mi != curr_size-1) {
                flip(arr, mi);
                flip(arr, curr_size-1);
            }
        }
        return 0;
    }
}
