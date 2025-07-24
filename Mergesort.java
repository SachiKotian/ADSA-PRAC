import java.util.*;
public class Mergesort {
    public static void merge(int arr[],int lb,int mid,int ub)
    {
        int merger[]=new int[ub-lb+1];

        int i=lb;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ub)
        {
            if(arr[i]<=arr[j])
            {
                merger[k]=arr[i];
                i++;
                k++;
            }
            else{
                merger[k]=arr[j];
                j++;
                k++;
            }
        }
            while(i<=mid)
            {
                merger[k]=arr[i];
                i++;
                k++;
            }
        
            while(j<=ub)
            {
                merger[k]=arr[j];
                j++;
                k++;
            }
            for(i=0,j=lb;i<merger.length;i++,j++)
            {
                arr[j]=merger[i];
            }
        
    }

    public static void mergesort(int arr[],int lb,int ub)
    {
        int  mid;
        if(lb<ub)
        {
            mid=(lb+ub)/2;
            mergesort(arr,lb,mid);
            mergesort(arr,mid+1,ub);
            merge(arr,lb,mid,ub);

        }
    }
    public static void main(String args[])
    {
      
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of array elements");
        n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array elements");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        mergesort(arr,0,n-1);

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }


    }
    
}
