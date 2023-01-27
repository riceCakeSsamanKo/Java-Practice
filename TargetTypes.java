class Box<T>{
    T ob;

    public T get() {
        return ob;
    }

    public void set(T ob) {
        this.ob = ob;
    }
}
class BoxFactory{
    public static <T> Box<T> makeBox(){
        return new Box<T>();
    }
}

public class TargetTypes {
    public static void main(String[] args) {
        Box<Integer> iBox = BoxFactory.makeBox();  // 1
        iBox.set(1);

        Box<String> sBox = BoxFactory.<String>makeBox();  // 2
        sBox.set("String");

        Box<Double> dBox = new Box<>();  // 3
        dBox.set(1.1);

        Box<Long> lBox = new Box<Long>();  // 4
        lBox.set(12345678901234L);
    }
}
