package trees;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52};
        build(arr);
    }

    public static void mark(int arr[], int left, int right, int level, int[] levels){
        if (left == right){
            levels[left] = level;
            return;
        }
        int middle = (left + right) / 2;
        levels[middle] = level;
        mark(arr, left, middle - 1, level + 1, levels);
        mark(arr, middle + 1, right, level + 1, levels);
    }

    public static void build(int[] arr){
        int[] levels = new int[arr.length];
        mark(arr, 0, arr.length - 1, 0, levels);

        for (int level = 0; level < levels.length; level++){
            for (int i = 0; i < arr.length; i++) {
                if (levels[i] == level) {
                    System.out.print(arr[i]);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
    }


}
