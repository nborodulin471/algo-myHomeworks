package binary_search;

class Main {
    public static void main(String[] args) {
        int arrBooks[] = new int[]{14, 16, 19, 32, 32, 32, 56, 69, 72};
        int newBook = 32;
        int largeBooks = numberLargeBooks(arrBooks, newBook);
        System.out.println(largeBooks);
    }

    private static int numberLargeBooks(int[] arrBooks, int newBook) {

        int length = arrBooks.length;
        int right = length;
        int left = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid + 1 > length - 1) {
                if (arrBooks[mid] > newBook){
                    return 1;
                }else break;
            }else if (arrBooks[0] > newBook) {
                return length;
            }else if (arrBooks[mid] <= newBook && arrBooks[mid + 1] > newBook) {
                return length - (mid + 1);
            } else if (arrBooks[mid] <= newBook) {
                left = mid + 1;
            } else if (arrBooks[mid] > newBook) {
                right = mid - 1;
            }
        }
        return 0;
    }
}