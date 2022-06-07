package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

public class CombSort implements Sort{

    private pnlAnimation ani;

    public CombSort(pnlAnimation ani) {
        this.ani=ani;
    }

    @Override
    public void sort() {
        sort(ani.arr);
    }

    int getNextGap(int gap)
    {
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }

    void sort(int arr[])
    {
        int n = arr.length;

        int gap = n;

        boolean swapped = true;

        while (gap != 1 || swapped == true)
        {
            gap = getNextGap(gap);
            swapped = false;

            for (int i=0; i<n-gap; i++)
            {
                if (arr[i] > arr[i+gap])
                {
                    ani.swap(i, i+gap);
                    swapped = true;
                }
            }
        }
    }
}
