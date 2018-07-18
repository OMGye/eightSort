import java.util.Arrays;

/**
 * Created by upupgogogo on 2018/7/18.下午1:27
 */
public class QuickSort {

    private QuickSort(){}

    public static void quickSort(Comparable[] nums){

        quick(nums, 0, nums.length -1);

    }


    private static void quick(Comparable[] nums, int l, int r){

        if (l >= r)
            return;

        int index = sort(nums, l, r);
        quick(nums, l, index - 1);
        quick(nums, index + 1, r);

    }

    private static int sort(Comparable[] nums, int l, int r){

        Comparable v = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i ++)
            if (nums[i].compareTo(v) < 0){
                j ++;
                swap(nums,j,i);
            }
            swap(nums,j,l);
            return j;
    }

    private static void swap(Comparable[] nums, int m, int n){

        Comparable temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{100,34,2,34,52,5,356,245,76,46,35,754,335,434,93};
        quickSort(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }
}
