
package projectalgorithmsortingvisualiaser.sortingAlgorithms;

import projectalgorithmsortingvisualiaser.pnlAnimation;

/**
 *
 * @author Aditya
 */
public class SelectionSort implements Sort{
    
    pnlAnimation ani;
    
    public SelectionSort(pnlAnimation ani) {
      this.ani = ani;
    }
    
    public void sort() {
        int min=0;
        for(int i=0;i<ani.getLength()-1;i++){
            min=i;
            for(int j=i+1;j<ani.getLength();j++) {
                if(ani.getValue(j)<ani.getValue(min))
                    min=j;
                
            }
            ani.swap(min, i);
        }
    }
}
