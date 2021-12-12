package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

public class BubbleSort implements Sort{

   pnlAnimation ani;

   public BubbleSort(pnlAnimation ani) {
      this.ani = ani;
   }

   public void sort() {
      for (int i = 0; i < ani.getLength()-1; i++) {
         for (int j = 0; j < ani.getLength()-1; j++) {
            if (ani.getValue(j) > ani.getValue(j + 1))
               ani.swap(j, j + 1);
         }
      }
   }
}
