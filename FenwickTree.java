public class FenwickTree{
    // BIT array - It stores the prefix
    // sum of the array. 
    private static int bit[];
    private static int n;
    // Function to build the 
    // BIT array initially.
    private static void buildBIT(int a[], int n){
        // Declaring of size n+1 becuase, 
        // It uses 1 based indexing. 
        bit=new int[n+1];
        // Calling the updateUtil Function
        // for every index of the array a.
        for(int i=0;i<n;i++)
            updateUtil(i, a[i]);
    }
    // Utility function to update the 
    // bit array.
    private static void updateUtil(int ind, int delta){
        // Increasing the index by 1 
        // to maintain 1 based indexing.
        ind++;
        // Iterating till index is 
        // in the range of the array.
        while(ind<=n){
            
            // Adding delta to bit[ind].
            bit[ind]+=delta;
            // Updating the index.
            ind+=(ind&-ind);
        }
    }
    
    // Function to Update the array.
    public static void update(int a[], int ind, int val) {
        // Calculating 'delta' that is the change
        // in value.
        int delta=val-a[ind];
        a[ind]=val;
        // Calling the updateUtil funcion 
        // to update the bit array.
        updateUtil(ind, delta);
    }
    
    // Function to find the sum of the array 
    //  elements in the range [0, ind].
    private static int findSum(int ind){
        // Initializing sum as 0.
        int sum=0;
        // Iterating while the index
        // is in the range of array.
        while(ind>0){
            // Increasing the sum.
            sum+=bit[ind];
            // Updating the index.
            ind-=(ind&(-ind));
        }
        // Returning sum.
        return sum;
    }
    
    public static int sumRange(int left, int right) {
        // Returning sum of the range 
        // [0, right] - [0, left-1].
        // Passing right+1 and left because of 
        // 1 based indexing.
        return findSum(right+1)-(findSum(left));
    }
    
    // Main Function
    public static void main(String args[]){
        
        n=10;
        int a[]=new int[]{4,2,1,5,6,3,9,7,2,3};
        buildBIT(a, n);
        System.out.println("Sum of range 2-6 is "+sumRange(2, 6));
        update(a, 5, 12);
        System.out.println("Sum of range 5-9 is "+sumRange(5, 9));
        
    }
}
