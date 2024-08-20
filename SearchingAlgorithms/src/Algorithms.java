public class Algorithms {
    public int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == target) {
                return i;
            }
        return -1;
    }

    public int binarySearchRecursive(int[] array, int target) {
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    private int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right)
            return -1;
        var middle = (left + right) / 2;
        if (target == array[middle])
            return middle;
        else if (target < array[middle])
            return binarySearchRecursive(array, target, left, middle - 1);
        else
            return binarySearchRecursive(array, target, middle + 1, right);
    }

    public int binarySearchIterative(int[] array, int target) {
        var left = 0;
        var right = array.length - 1;
        while (left <= right) {
            var middle = (left + right) / 2;
            if (target == array[middle])
                return middle;
            else if (target < array[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }

    public int ternarySearch(int[] array, int target) {
        return ternarySearch(array, target, 0, array.length);
    }

    private int ternarySearch(int[] array, int target, int left, int right) {
        if (left > right)
            return -1;
        var partitionSize = (right - left) / 3;
        var mid1 = left + partitionSize;
        var mid2 = right - partitionSize;
        if (array[mid1] == target)
            return mid1;
        else if (array[mid2] == target)
            return mid2;
        else if (target < array[mid1])
            return ternarySearch(array, target, left, mid1 - 1);
        else if (target > array[mid1] && target < array[mid2])
            return ternarySearch(array, target, mid1 + 1, mid2 - 1);
        else
            return ternarySearch(array, target, mid2 + 1, right);
    }

    public int jumpSearch(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0, next = blockSize;
        while(start<array.length && array[next-1]< target){
            start=next;
            next+=blockSize;
            if(next>array.length)
                next=array.length;
        }
        return linearSearch(array,target,start,next);
    }
    public int linearSearch(int[] array,int target,int start,int end){
        for(int i=start;i<end;i++)
            if(array[i]==target) {
                return i;
            }
        return -1;
    }
    public int exponentialSearch(int[] array,int target){
        int bound=1;
        while(bound<array.length && array[bound] < target)
            bound*=2;
        var left = bound/2;
        var right = Math.min(bound,array.length-1);
        return binarySearchRecursive(array,target,left,right);


//        int bound = 1;
//        while(target<=array[array.length-1]){
//            if(target<=array[bound])
//                return binarySearchRecursive(array,target,bound/2,bound+1);
//            bound=Math.min(bound*2,array.length-1);
//        }
//        return -1;
    }
}
