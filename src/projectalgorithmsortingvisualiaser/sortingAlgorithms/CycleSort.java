package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

public class CycleSort implements Sort{

    private pnlAnimation pnlAnimation;

    public CycleSort(pnlAnimation pnlAnimation) {
        this.pnlAnimation=pnlAnimation;
    }

    @Override
    public void sort() {
        cycleSort(pnlAnimation.arr,pnlAnimation.arr.length);
    }

    private void cycleSort(int arr[], int n) {
        int writes = 0;

        for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
            int item = arr[cycle_start];

            int pos = cycle_start;
            for (int i = cycle_start + 1; i < n; i++)
                if (arr[i] < item)
                    pos++;

            if (pos == cycle_start)
                continue;
            while (item == arr[pos])
                pos += 1;
            if (pos != cycle_start) {
                int temp = item;
                item = arr[pos];
                pnlAnimation.update(pos,temp);
                writes++;
            }
            while (pos != cycle_start) {
                pos = cycle_start;
                for (int i = cycle_start + 1; i < n; i++)
                    if (arr[i] < item)
                        pos += 1;
                while (item == arr[pos])
                    pos += 1;
                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    pnlAnimation.update(pos,temp);
                    writes++;
                }
            }
        }
    }
}
