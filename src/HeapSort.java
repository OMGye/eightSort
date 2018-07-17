/**
 * Created by upupgogogo on 2018/7/14.下午2:11
 */
public class HeapSort {

    private static int tree[];

    private static int size;

    public static void heapSort(int[] nums){

        tree = new int[nums.length];
        size = tree.length;
        for (int i = 0; i < nums.length; i ++)
            tree[i] = nums[i];

        for (int i = (tree.length - 2) / 2; i >= 0 ; i-- )
            siftDown(i);
        for (int i = 0; i < nums.length; i ++){
            nums[i] = tree[0];
            int k = nums.length - i - 1;
            tree[0] = tree[k];
            size --;
            siftDown(0);
        }
    }

    private static void siftDown(int k){

        if (getLeftChild(k) >= size)
            return;
        int j = 0;
        if (getRightChild(k) < size)
            j = tree[getLeftChild(k)] > tree[getRightChild(k)] ? getLeftChild(k) : getRightChild(k);
        else
            j = getLeftChild(k);
        if (tree[k] < tree[j]){
            swap(k,j);
            k = j;
            siftDown(k);
        }

    }


    private static int getLeftChild(int index){

        if (index < 0)
            throw new IllegalArgumentException("index is illegal");
        return index * 2 + 1;
    }

    private static int getRightChild(int index){

        if (index < 0)
            throw new IllegalArgumentException("index is illegal");
        return index * 2 + 2;
    }

    private static void swap(int i, int j){
        if (i < 0 | j < 0 | i >= size | j >= size)
            throw new IllegalArgumentException("index is illegal");

        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }


    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = new int[]{4,4,5,3,5,6,2,8,9,10,14,100,23,45,67};
        heapSort.heapSort(nums);
        for (int i = 0; i < nums.length; i ++)
            System.out.println(nums[i]);
    }
}
