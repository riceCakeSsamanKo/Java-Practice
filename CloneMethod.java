class SomeClass implements Cloneable{  //Cloneable은 clone 메소드를 사용하기 위한 마커 인터페이스
    private int n1;
    private int n2;

    SomeClass(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        //인스턴스 복사 메소드
        return super.clone();  //protected Object clone() throws CloneNotSupportedException의 오버라이딩
    }
    void showInfo(){
        System.out.printf("(%d, %d)",n1,n2);
        System.out.println();
    }
}

public class CloneMethod {
    public static void main(String[] args) {
        try{
            SomeClass so1 = new SomeClass(10,20);
            SomeClass so2 = (SomeClass) so1.clone();

            so1.showInfo();  //멤버만 복사함.
            so2.showInfo();

            if(so1 == so2)  //so1과 so2의 주소는 다름(== 참조값이 다름)
                System.out.println("동일값 참조");
            else
                System.out.println("참조값 다름");

        }
        catch(CloneNotSupportedException e){
            e.getStackTrace();
        }
    }
}
