
package projectalgorithmsortingvisualiaser;


public class HeapSort {
    pnlAnimation ani;
    
    public HeapSort(pnlAnimation ani) {
        this.ani=ani;
    }
    
    public void sort() {
        for(int i=ani.getLength()/2-1;i>=0;i--) {
            heapify(ani.getLength(),i);
        }
        System.out.println("starting sorting now");
        
        for(int i=ani.getLength()-1;i>=0;i--) {
            ani.swap(0, i);
            heapify(i, 0);
        }
    }
    
    public void heapify(int size,int max) {
        int l=max*2+1;
        int r=max*2+2;
        
        int largest=max;
        if(l<size && ani.getValue(l)>ani.getValue(max)) {
            largest=l;
        }
        if(r<size && ani.getValue(r)>ani.getValue(largest)) {
            largest=r;
        }
        
       if(largest!=max) {
            ani.swap(max, largest);
            heapify(size,largest);
       }
    }
}
