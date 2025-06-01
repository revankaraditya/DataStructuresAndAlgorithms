public class SortingAlgo {
    public static void bubbleSort(int[] array){
        boolean isSorted;
        for(int i=0;i<array.length;i++) {
            isSorted = true;
            for (int j = 1; j < array.length-i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }
            if(isSorted)
                return;
        }
    }
    public static void selectionSort(int[] array){
        for(int i=0;i<array.length;i++){
            int minIndex = i;
            for(int j=i;j<array.length;j++)
                if(array[j]<array[minIndex])
                    minIndex = j;
            swap(array,i,minIndex);
        }
    }
    public static void insertionSort(int[] array){
        for(int i=1;i<array.length;i++){
            int current = array[i];
            int previousIndex = i-1;
            while( previousIndex>=0 && array[previousIndex]>current){
                array[previousIndex+1] = array[previousIndex];
                previousIndex--;
            }
            array[previousIndex+1] = current;
        }
    }
    public static void mergeSort(int[] array){
        if(array.length<2)
            return;
        int mid = array.length/2;
        int[] left = new int[mid];
        for(int i=0;i<left.length;i++){
            left[i] = array[i];
        }
        int[] right = new int[array.length-mid];
        for(int i=0,j=mid;i<right.length;i++,j++){
            right[i] = array[j];
        }
        mergeSort(left);
        mergeSort(right);
        mergeArrays(array,left,right);
    }

    private static void mergeArrays(int[] array, int[] left, int[] right) {
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j])
                array[k++] = left[i++];
            else
                array[k++] = right[j++];
        }
        while(i<left.length)
            array[k++] = left[i++];
        while(j<right.length)
            array[k++] = right[j++];
    }

    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
