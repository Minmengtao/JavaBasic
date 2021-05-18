package Sort;

import java.util.Arrays;

public class SelfSort {
    public static void main(String[] args) {
        Integer[] res = new Integer[]{1, 10, 2, 9, 11, 8, 0, 6, 4, 5};
        Arrays.sort(res, (o1, o2) -> {
            return o1 - o2;
        });
        for(int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }
}
