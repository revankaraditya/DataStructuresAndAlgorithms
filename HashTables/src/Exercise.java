import java.util.*;

public class Exercise {
    public int mostFrequent(int[] array){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int item: array){
            var count = map.getOrDefault(item,0);
            map.put(item,count+1);
        }
        int max=-1;
        int result=array[0];
        for(var item:map.entrySet()){
           if(item.getValue()>max) {
               max = item.getValue();
               result = item.getKey();
           }
        }
        return result;
    }
    public int countPairsWithDiff(int[] items,int diff){
        Set<Integer> set = new HashSet<>();
        int count=0;
        for(int item: items)
            set.add(item);
        for(int item:items) {
            if (set.contains(item - diff))
                count++;
            if(set.contains(item+diff))
                count++;
            set.remove(item);
        }
        return count;
    }
    public int[] twoSum(int[] items,int sum){
        HashMap<Integer,Integer> mapIndex = new HashMap<>();
        for(int i=0;i<items.length;i++){
            int toFind = sum-items[i];
            if(mapIndex.containsKey(toFind)){
                return new int[] {mapIndex.get(toFind),i};
            }
            mapIndex.put(items[i],i);
        }
        return null;
    }
}
