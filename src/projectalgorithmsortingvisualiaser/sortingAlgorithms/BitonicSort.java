package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

import java.util.Arrays;

public class BitonicSort implements Sort{

    pnlAnimation ani;

    public BitonicSort(pnlAnimation ani) {
        this.ani = ani;
    }

    @Override
    public void sort() {
        bitonicSort(ani.arr, 0, ani.arr.length, 1);
        Arrays.stream(ani.arr).forEach(a-> System.out.print(a+" "));
    }

    void compAndSwap(int a[], int i, int j, int dir)
    {
        if(i>=a.length || j>=a.length) {
            return;
        }
        if ( (a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)) {
            ani.swap(i,j);
        }
    }
    void bitonicMerge(int a[], int low, int cnt, int dir) {
        if (cnt>1) {
            int k = cnt/2;
            for (int i=low; i<=low+k; i++)
                compAndSwap(a,i, i+k, dir);
            bitonicMerge(a,low, k, dir);
            bitonicMerge(a,low+k, k, dir);
        }
    }

    void bitonicSort(int a[], int low, int cnt, int dir) {
        if (cnt>1) {
            int k = cnt/2;
            bitonicSort(a, low, k, 1);
            bitonicSort(a,low+k, k, 0);
            bitonicMerge(a, low, cnt, dir);
        }
    }
}
