class BinarySearch {
    public static int searchNormal(int[] array, int item) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (array[midIndex] == item)
                return midIndex;
            else if (item < array[midIndex])
                rightIndex = midIndex - 1;
            else if (item > array[midIndex])
                leftIndex = midIndex + 1;
        }
        return -1;
    }

    public static int searchRecursive(int[] array, int item) {
        return searchRecursive(array, item, 0, array.length - 1);
    }

    private static int searchRecursive(int[] array, int item, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex)
            return -1;
        int midIndex = (leftIndex + rightIndex) / 2;
        if (array[midIndex] == item)
            return midIndex;
        else if (item < array[midIndex])
            return searchRecursive(array, item, leftIndex, midIndex - 1);
        return searchRecursive(array, item, midIndex + 1, rightIndex);
    }
}
