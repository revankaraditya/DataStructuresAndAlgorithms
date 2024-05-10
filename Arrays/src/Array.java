public class Array {
    private int[] items;
    private int capacity;
    private int current=0;

    public Array(int length) {
        capacity = length;
        this.items =new int[length];
    }

    public void insert(int item){
        if(items.length==current){
            int[] newItems = new int[current * 2];
            for(int i = 0; i< current; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        items[current++]=item;
    }
    public void print(){
        for(int i = 0; i< current; i++)
            System.out.print(items[i] + " ");
        System.out.println();
    }
    public void removeAt(int index){
        System.out.println(current);
        if(index < current && index >= 0){
            for(int i = index; i<current-1; i++){
                items[i]=items[i+1];
            }
            current--;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    public int indexOf(int item){
        for(int i = 0; i< current; i++){
            if(items[i] == item){
                return i;
            }
        }
        return -1;
    }
    public int max(){
        int m=0;
        for(int i = 0; i< current; i++){
            if(items[i]>m)
                m=items[i];
        }
        return m;
    }

    public int[] reverse(){
        int[] rev = new int[current];
        for(int i = 0, j = current -1; i< current; i++,j--)
            rev[i] = items[j];
        return rev;
    }

    public int[] intersect(int[] a){
        int[] common = new int[a.length];
        int c=0;
        for(int i = 0; i< current; i++){
            for (int k : a) {
                if (items[i] == k) {
                    common[c++] = items[i];
                }
            }
        }
        return common;
    }
    public void insertAt(int item,int index){
        if(index>=0 && index<=current)
            items[index]=item;
        else
            throw new IllegalArgumentException();
    }
}
