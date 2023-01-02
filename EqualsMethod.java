class INum{
    int num;
    INum(int num){
        this.num = num;
    }

    @Override  //Object 클래스 오버라이딩
    public boolean equals(Object obj){  //매개변수의 타입이 Object이므로 어떠한 인스턴스든 참조가 가능하다.
        //equals 메소드는 단순히 값만 같은지 비교함
        return this.num == ((INum) obj).num;
    }
    void isEquals(Object obj){
        if(this.equals(obj))
            System.out.println("두 인스턴스 내용 동일");
        else
            System.out.println("두 인스턴스 내용 다름");
    }
}

public class EqualsMethod {
    public static void main(String[] args) {
        INum inum1 = new INum(10);
        INum inum2 = new INum(15);
        INum inum3 = new INum(10);

       inum1.isEquals(inum2);  //값 비교
       inum1.isEquals(inum3);  //값 비교

       isSameInstance(inum1,inum2);  //참조 비교
       isSameInstance(inum1,inum3);  //참조 비교
    }
    public static void isSameInstance(Object obj1, Object obj2){
        if(obj1 == obj2)
            System.out.println("두 인스턴스는 동일 인스턴스");
        else
            System.out.println("두 인스턴스는 다른 인스턴스");
    }
}
