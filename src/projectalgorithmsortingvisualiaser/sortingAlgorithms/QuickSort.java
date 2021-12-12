package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

public class QuickSort implements Sort{
    private pnlAnimation ani;

    public QuickSort(pnlAnimation ani){
        this.ani=ani;
    }

    @Override
    public void sort() {
        quickSort(ani.arr,0,ani.arr.length-1);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = (low - 1);
        for(int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                ani.swap(i, j);
            }
        }
        ani.swap(i + 1, high);
        return (i + 1);
    }
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
