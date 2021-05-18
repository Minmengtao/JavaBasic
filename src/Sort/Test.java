package Sort;

public class Test {
    public static void main(String[] args) {
        AllSort allSort = new AllSort();
        int[] nums = new int[]{100, 2, 10, 34, 19, 29, 37, 90, 3, 9};
        //AllSort.selectionSort(nums);
        //AllSort.insertSort(nums);
        //AllSort.bubbleSort(nums);
        AllSort.quickSort(nums);
        //AllSort.mergeSort(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}

class AllSort {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //选择排序
    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = i + 1; j < n; j++) {
                if(nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    //插入排序
    public static void insertSort(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0 && nums[j] < nums[j - 1]; j--)
                swap(nums, j, j - 1);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] < nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] nums) {
        partition(nums, 0, nums.length - 1);
    }
    public static void partition(int[] nums, int left, int right) {
        if(left >= right)
            return;
        int x = nums[left], i = left, j = right;
        while(i < j) {
            while (i < j && nums[j] >= x) j--;
            if (i < j) nums[i++] = nums[j];
            while (i < j && nums[i] <= x) i++;
            if (i < j) nums[j--] = nums[i];
        }
        nums[i] = x;
        partition(nums, left, i - 1);
        partition(nums, i + 1, right);
    }

    //归并排序
    public static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        merge(nums, 0, nums.length - 1, temp);
    }
    public static void merge(int[] nums, int left, int right, int[] temp) {
        if(left >= right)
            return;
        int mid = left + (right - left) / 2;
        merge(nums, left, mid, temp);
        merge(nums, mid + 1, right, temp);
        int i = left, j = mid + 1, k = left;
        while(i <= mid && j <= right) {
            if(nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        while(i <= mid) temp[k++] = nums[i++];
        while(j <= right) temp[k++] = nums[j++];
        while(left <= right) nums[left] = temp[left++];
    }

}
