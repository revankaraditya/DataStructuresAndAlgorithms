import java.util.*;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        private Entry(int key, String value) {
            this.key = key;
            this.value=value;
        }
    }
    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key,String value){
        //Get index
//        var index = hash(key);
//        if(isBucketEmpty(index))  //check if entry does not exist
//            entries[index] = new LinkedList<>();
//
//        //check if key already exist
//        var bucket = entries[index];
//        for(var entry : bucket){
//            if(entry.key==key) {
//                entry.value = value;
//                return;
//            }
//        }
//        bucket.addLast(new Entry(key,value));


        var entry = getEntry(key);
        if(entry!=null){
            entry.value = value;
            return;
        }
        var bucket = getOrCreateBucket(key);
        bucket.add(new Entry(key,value));
    }

//    private boolean isBucketEmpty(int index) {
//        return entries[index] == null;
//    }

    public String get(int key){
//        int index = hash(key);
//        if(!isBucketEmpty(index)) {
//            var bucket = entries[index];
//            for (var entry : bucket) {
//                if (entry.key == key)
//                    return entry.value;
//            }
//        }
//        return null;
        var entry = getEntry(key);
//        if(entry==null)
//            return null;
//        return entry.value;
        return (entry==null)?null:entry.value;
    }

    public void remove(int key){
//        int index = hash(key);
//        if(isBucketEmpty(index))
//            throw new IllegalStateException("Bucket Empty, key not found");
//        var bucket = entries[index];
//        for(var entry : bucket){
//            if(entry.key==key){
//                bucket.remove(entry);
//                return;
//            }
//        }
//        throw new IllegalStateException("Bucket empty");
        var entry = getEntry(key);
        if(entry==null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private Entry getEntry(int key){
        LinkedList<Entry> bucket = getBucket(key);
        if(bucket!=null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        int index = hash(key);
        var bucket = entries[index];
        return bucket;
    }

    private int hash(int key) {
        return key%entries.length;
    }

    private LinkedList<Entry> getOrCreateBucket(int key){
        var index = hash(key);
        var bucket = entries[index];
        if(bucket==null)
            entries[index] = new LinkedList<>();
        return bucket;
    }

}
