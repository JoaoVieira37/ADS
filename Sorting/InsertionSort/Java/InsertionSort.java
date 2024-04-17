import java.util.Random;

/*
 * 
 * Results
 * 10      ->      0.0043ms
 * 100     ->      0.1223ms
 * 1000    ->      3.5317ms
 * 10000   ->     24.9252ms
 * 100000  ->   1515.1223ms (1.5s)
 * 1000000 -> 162441.5911ms (2m42s)
 * 
 */

public class InsertionSort {

    public static void main(String args[]) {

        int[] arr = null;

        try {
            arr = new Random().ints(
                Long.parseLong(args[0]),
                0, 
                Integer.parseInt(args[0]))
            .toArray();  
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: java InsertionSort <size_of_arr_to_sort>");
            System.exit(1);
        }
        
        System.out.println("isSorted: " + isSorted(arr));

        long startTime = System.nanoTime();
        sort(arr);
        double durationInMilliseconds = (System.nanoTime() - startTime) / 1_000_000.0;
        
        System.out.println("Execution Time: " + durationInMilliseconds + "ms");
        System.out.println("isSorted: " + isSorted(arr));

    }

    public static void sort(int[] arr) {
        int i = 0, j = 0;
        while (i < arr.length) {
            j = i;
            while (j > 0 && arr[j] < arr[j-1]) {
                swap(arr, j, j-1);
                j--;
            }
            i++;
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("isSorted: " + isSorted(arr) + "\n");
    }

    private static boolean isSorted(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            if (!(arr[i] <= arr[i+1])) {
                return false;
            }
            i++;
        }
        return true;
    }

}
