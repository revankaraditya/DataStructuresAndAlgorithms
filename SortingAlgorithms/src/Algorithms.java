import java.util.*;

public class Algorithms {
    public void bubbleSort(int[] array){
        //Optimised Solution

        //Consider that the array is sorted in the beginning
        boolean isSorted;    //for best case scenario
        for(int i=0;i<array.length;i++){
            //In every pass we assume that the array is sorted
            isSorted = true;
            for(int j=1;j<array.length-i;j++){
                if(array[j]<array[j-1]) {   //If true then the assumption that the array is sorted becomes false
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }
            if(isSorted)    //This validates our assumption and we break
                return;
        }

        /*  My implementation
        //k represents no of passes
        //i and j are two pointer for sorting
        for(int k=0;k<(array.length-1);k++)
            for(int i=0,j=1;j<array.length-k;i++,j++){
                if(array[i]>array[j])
                    swap(array,i,j);
        }
        */
    }
    public void selectionSort(int[] array){
        for(int i=0;i<array.length;i++){
            var minIndex = i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]< array[i])
                    minIndex=j;
            }
            swap(array,i,minIndex);
        }
    }

    public void insertionSort(int[] array){
        for(int i=1;i<array.length;i++){    //iterate over all the items in the array
            var current = array[i]; //consider the current item is in the right place
            var j= i-1;         //previous index of current

            //shift the element until right place is found
            //previous item > current item
            while(j >= 0 && array[j] > current){
                array[j+1] = array[j];  //shift the item one place forward
                j--;  //decrement the index by one place
            }
            array[j+1]  = current;  //as the j is decremented in the previous step we increment and insert the value
        }


//      My implementation
//        for(int currentIndex=1;currentIndex<array.length;currentIndex++){
//            int currentItem = array[currentIndex];
//            int previousItem = array[currentIndex - 1];
//
//            if(currentItem < previousItem){
//                shiftToCorrectPosition(array,currentItem,currentIndex);
//            }
//
//        }
    }

//    private void shiftToCorrectPosition(int[] array, int currentItem, int currentIndex) {
//        var insertPosition = -1;
//        for(int i=currentIndex;i>0;i--){
//            int previousItem = array[i - 1];
//            if(currentItem < previousItem){
//                array[i] = previousItem;
//                insertPosition = i-1;
//            }
//        }
//        array[insertPosition] = currentItem;
//    }

    public void mergeSort(int array[]){
        //divide the array into half
        //sort each half
        //merge all the arrays
        if(array.length<2)
            return;

        var middle = array.length/2;
        int[] left = new int[middle];
        for(int i=0;i<middle;i++){
            left[i] = array[i];
        }
        int[] right = new int[array.length-middle];
        for(int i=middle;i<array.length;i++){
            right[i-middle] = array[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(array,left,right);
    }
    private void merge(int[] array, int[] left,int[] right){
        int i=0, j=0, k=0;
        while(j<left.length && k<right.length){
            if(left[j]<=right[k])
                array[i++] = left[j++];
            else
                array[i++] = right[k++];
        }
        while(j<left.length)
            array[i++] = left[j++];
        while(k<left.length)
            array[i++] = left[k++];
    }
    public void quickSort(int[] array){
        quickSort(array,0,array.length-1);
    }

    private void quickSort(int[] array,int start,int end){
        //Partition
        //recurse the left and right partition

        if(start>=end)  //Base condition
            return;

        var boundary = partition(array,start,end);

        quickSort(array,start,boundary-1);
        quickSort(array,boundary+1,end);

    }

    private int partition(int[] array,int start,int end) {
        //initially we consider the left partition is empty and add item to it
        //simultaneously we move the greater elements to the right
        var pivot = array[end];  // consider the pivot as the end item of the array
        var boundary = start-1; //consider a boundary pointer that points to the end of the left partition
        for(int i=start;i<=end;i++){    //iterate over all the items in the array
            if(array[i] <= pivot)       //if the element is less than or equal to pivot
                swap(array,i,++boundary);   //increment the left boundary and swap the items
        }
        return boundary;    //after the positioning the boundary represents the pivot index


// my Implementation
//        var pivot = array[pivotPosition];
//        int i=0;
//        while(i<pivotPosition){
//            if(array[i] >= pivot){
//                var item = array[i];
//                var k=i;
//                while(k<array.length-1){
//                    array[k] = array[k+1];
//                    k++;
//                }
//                array[array.length-1] = item;
//                pivotPosition--;
//            }
//            else
//                i++;
//        }
//        return pivotPosition;
    }

    public void countingSort(int[] array, int max){
        //populate the counts array
        int[] counts = new int[max+1];
        for(int item:array)
            counts[item]++;

        //sort the array using counts array
        for(int i=0,j=0;i<counts.length;i++)
            while(counts[i]>0) {
                array[j++] = i;
                counts[i]--;
            }
    }

    public void bucketSort(int[] array, int numberOfBuckets) {
        var i = 0;
        for (var bucket : createBuckets(array, numberOfBuckets)) {
            Collections.sort(bucket);
            for (var item : bucket)
                array[i++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (var i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (var item : array)
            buckets.get(item / numberOfBuckets).add(item);

        return buckets;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
