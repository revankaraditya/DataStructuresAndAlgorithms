import java.util.Arrays;

public class HashTableLinearProbing {
    private class Entry{
        private int key;
        private String value;

        private Entry(int key,String value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "["+key+","+value+"]";
        }
    }
    private Entry[] hashTable;
    private int capacity;
    private int count;
    public HashTableLinearProbing(int capacity){
        this.capacity =capacity;
        hashTable = new Entry[this.capacity];
    }

    public void put(int key,String value){
        var entry = getEntry(key);
        if(entry!=null){
            entry.value = value;
            return;
        }
        if(isFull())
            throw new IllegalStateException("Hashtable Full");
        hashTable[getIndex(key)] = new Entry(key,value);
        count++;
    }
    public String get(int key){
        var entry = getEntry(key);
        return entry!=null ? entry.value : null;
    }

    public void remove(int key){
        int index = getIndex(key);
        if(index==-1||hashTable[index]==null)
            return;
        hashTable[index] = null;
        count--;
    }
    public int size(){
        return count;
    }

    private boolean isFull(){
        return capacity==count;
    }
    private Entry getEntry(int key){
        int index = getIndex(key);
        return index>=0?hashTable[index]:null;
    }

    private int getIndex(int key) {
        int steps=0;
        while(steps<capacity){
            int index = index(key,steps++);
            var entry = hashTable[index];
            if(entry==null || entry.key==key)
                return index;
        }
        return -1;
    }
    private int hash(int key){
        return key% capacity;
    }
    private  int index(int key,int i){
        return hash(key+i)%capacity;
    }
    @Override
    public String toString(){
        return Arrays.toString(hashTable);
    }
}
