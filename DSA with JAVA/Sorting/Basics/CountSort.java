import java.util.Arrays;

public class CountSort {
    static void sortIt(int[] arr,int n)
    {
        int max = arr[0];
        for(int i=1;i<n;i++)
        {
            if(max<arr[i])
            {
                max=arr[i];
            }
        }

        int[] crr = new int[max+1];
        Arrays.fill(crr,0);

        for(int i=0;i<n;i++)
        {
            crr[arr[i]]=crr[arr[i]]+1;
        }

        int j=0;
        for( int i=0;i<=max;i++)
        {
            if(crr[i]!=0 && crr[i]>1)
            {
                while(crr[i]>0) {
                    crr[i]= (crr[i] - 1);
                    arr[j]=i;
                    j=j+1;
                }
            }
            if(crr[i]!=0 && crr[i]==1)
            {
                arr[j]=i;
                j=j+1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr ={7,1,4,1,4,3,2,6,3773,7,22,22};
        System.out.println("Before sorting, the array is: ");
        for(int x: arr)
        {
            System.out.print( x + " " );
        }

        System.out.println();

        int n= arr.length;
        sortIt(arr,n);

        System.out.println("After sorting, the array is: ");
        for(int x: arr)
        {
            System.out.print( x +" ");
        }
    }
}