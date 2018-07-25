/**
 * Created by upupgogogo on 2018/7/25.下午2:58
 */
public class ThreeWaysQuickSort {

    private ThreeWaysQuickSort(){}

    public static void quickSort(Comparable[] nums){

        quick(nums, 0, nums.length -1);

    }


    private static void quick(Comparable[] nums, int l, int r){

        if (l >= r)
            return;
        Comparable v = nums[l];
        int lt = l;
        int gt = r;
        // [lt,gt]代表v == e
        int i = l + 1;
        while(i <= gt){
            if (v.compareTo(nums[i]) > 0){
                lt ++;
                swap(nums, i, lt);
                i ++;
            }
            else if (v.compareTo(nums[i]) < 0){
                swap(nums, i, gt);
                gt --;
            }
            else {
                i ++;
            }
        }
        swap(nums, l, lt);

        quick(nums, l, lt - 1);
        quick(nums, gt + 1, r);

    }



    private static void swap(Comparable[] nums, int m, int n){

        Comparable temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,23,43,5,34,2,34,422,442,211,4,32};
        quick(nums,0,nums.length -1);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
