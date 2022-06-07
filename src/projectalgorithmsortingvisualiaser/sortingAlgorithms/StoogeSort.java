package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

public class StoogeSort implements Sort{

    private pnlAnimation ani;

    public StoogeSort(pnlAnimation ani) {
        this.ani=ani;
    }

    @Override
    public void sort() {
        stoogesort(ani.arr,0,ani.arr.length-1);
    }

    void stoogesort(int arr[], int l, int h)
    {
        if (l >= h)
            return;

        if (arr[l] > arr[h]) {
            ani.swap(l, h);
        }

        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;

            stoogesort(arr, l, h - t);

            stoogesort(arr, l + t, h);

            stoogesort(arr, l, h - t);
        }
    }
}
