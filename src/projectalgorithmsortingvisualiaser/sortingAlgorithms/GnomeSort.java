package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

public class GnomeSort implements Sort{

    private pnlAnimation ani;

    public GnomeSort(pnlAnimation ani) {
        this.ani=ani;
    }

    @Override
    public void sort() {
        gnomeSort(ani.arr, ani.getLength());
    }

    void gnomeSort(int arr[], int n)
    {
        int index = 0;

        while (index < n) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                ani.swap(index, index - 1);
                index--;
            }
        }
        return;
    }
}
