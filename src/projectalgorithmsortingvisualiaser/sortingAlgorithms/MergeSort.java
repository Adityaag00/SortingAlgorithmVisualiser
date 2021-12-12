
package projectalgorithmsortingvisualiaser.sortingAlgorithms;


import projectalgorithmsortingvisualiaser.pnlAnimation;

public class MergeSort implements Sort{
    
    private pnlAnimation ani;
    
    public MergeSort(pnlAnimation ani) {
        this.ani=ani;
    }

    public void sort() {
        sort(ani.arr,0,ani.arr.length-1);
    }
    
    private void sort(int ar[],int l,int r) {
        if(l<r) {
            int mid=(l+r)/2;
            sort(ar,l,mid);
            sort(ar,mid+1,r);
            merge(ar,l,mid,r);
        }
    }
    
    public void merge(int[] ar, int l ,int mid,int r) {
        int n1=mid-l+1;
        int n2=r-mid;
        
        int a[] = new int[n1];
        int b[] = new int[n2];
        
        for(int i=0;i<n1;i++) {
            a[i]=ar[l+i];
        }
        for(int i=0;i<n2;i++) {
            b[i]=ar[mid+1+i];
        }
        
        int k=l,i=0,j=0;
        
        while(i<n1 && j<n2) {
            if(a[i]<=b[j]) {
                ani.update(k, a[i]);
                i++;
            }
            else {
                ani.update(k, b[j]);
                j++;
            }
            k++;
        }
        for(;i<n1;i++) {
            ani.update(k, a[i]);
            k++;
        }
        for(;j<n2;j++) {
            ani.update(k, b[j]);
            k++;
        }
    }
}
