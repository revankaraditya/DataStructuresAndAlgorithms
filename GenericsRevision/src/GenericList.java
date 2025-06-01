public class GenericList<T> {
    private T[] t;
    GenericList(int n){
        this.t = (T[])new Object[n];
    }
//    public T getValue(){
//        return t;
//    }
//    public void setValue(T t){
//        this.t=t;
//    }
}
