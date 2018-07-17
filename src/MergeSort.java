import java.util.Arrays;
/**
 * Created by upupgogogo on 2018/7/16.下午12:02
 */
public class MergeSort {

    public static void mergeSort(Comparable[] nums){
        merge(nums, 0, nums.length - 1);
    }

    private static void merge(Comparable[] nums, int l, int r){
        if (l == r)
            return;
        int mid = (r + l) / 2;
        merge(nums, l, mid);
        merge(nums, mid + 1, r);
        if (nums[mid].compareTo(nums[mid + 1]) < 0)
            sort(nums, l, mid,r);
    }

    private static void sort(Comparable[] nums, int l, int mid, int r){
        if (l >= r)
            return;
        Comparable[] temp = Arrays.copyOfRange(nums, l, r+1);
        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k ++){
            if (i > mid ){
                nums[k] = temp[j - l];
                j ++;
            }
            else if (j > r){
                nums[k] = temp[i - l];
                i ++;
            }
            else if (temp[i - l].compareTo(temp[j - l]) > 0){
                nums[k] = temp[i - l];
                i ++;
            }
            else {
                nums[k] = temp[j - l];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] nums = new Integer[N];
        for (int i = 0; i < N; i ++)
            nums[i] = N - i;

        long startTime = System.currentTimeMillis();

        mergeSort(nums);

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        for (int i = 0; i < 5; i++)
            System.out.println(nums[i]);



        long startTime4 = System.currentTimeMillis();


        long endTime4 = System.currentTimeMillis();

        System.out.println(endTime4 - startTime4);


    }
}

