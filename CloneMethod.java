package TrashCan;

class SomeClass implements Cloneable{  //Cloneable은 clone 메소드를 사용하기 위한 마커 인터페이스
    private int n1;
    private double n2;
    String str;
    StringBuilder sb;


    public void setSomeClass(int n1, double n2, String str, StringBuilder sb) {
        this.n1 = n1;
        this.n2 = n2;
        this.str = str;
        this.sb = sb;
    }

    SomeClass(int n1, double n2,String str, StringBuilder sb){
        this.n1 = n1;
        this.n2 = n2;
        this.str = str;
        this.sb = sb;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        //인스턴스 복사 메소드
        return super.clone();  //protected Object clone() throws CloneNotSupportedException의 오버라이딩
    }
    void showInfo(){
        System.out.printf("(%d, %g, %s, %s)",n1, n2, str, sb);
        System.out.println();
    }
}

public class CloneMethod {
    public static void main(String[] args) {
        try{
            StringBuilder sb = new StringBuilder("StringBuilderCanChange");

            SomeClass so1 = new SomeClass(10,20.2,"StringCannotChange",sb);
            SomeClass so2 = (SomeClass) so1.clone();  //clone의 리턴값이 Object형이라서 형변환 필수
            //멤버만 얕은복사.(여기서는 StringBuilder sb만 얕은 복사되고 나머진 안됨.)
            //int, double은 기본자료형이라서 인스턴스가 아님(맞나?). String은 인스턴스긴 한데 문자열 변경이 불가한 특성이 있음.

            System.out.print("so1"); so1.showInfo();
            System.out.print("so2"); so2.showInfo();  //so2의 int, double, String은 변경X.
            System.out.println();  //줄바꿈

            sb.replace(0,sb.length(),"new StringBuilder");
            so1.setSomeClass(123,456.4,"new String",sb);  //String은 문자열 수정이 불가능해 변경 불가. StringBuilder는 얕은 복사 대상.

            //System.out.print("so1"); so1.showInfo();
            System.out.print("so2"); so2.showInfo();  //so2의 int, double, String은 변경X.


            if(so1 == so2)  //so1과 so2는 서로다른 인스턴스(== 참조값이 다름)
                System.out.println("동일값 참조");
            else
                System.out.println("참조값 다름");
        }
        catch(CloneNotSupportedException e){
            e.getStackTrace();
        }


    }
}
