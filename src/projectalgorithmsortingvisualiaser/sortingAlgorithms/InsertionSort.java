package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

public class InsertionSort implements Sort{
   pnlAnimation ani;

   public InsertionSort(pnlAnimation ani) {
      this.ani = ani;
   }

   public void sort() {
      for (int i = 1; i < ani.getLength(); i++) {
         int key = ani.getValue(i);
         int j = i - 1;

         while (j >= 0 && ani.getValue(j) > key) {
            ani.update(j + 1, ani.getValue(j));
            j--;
         }
         ani.update(j + 1, key);
      }
   }
}
