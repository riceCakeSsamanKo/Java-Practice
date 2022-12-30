package TrashCan;

interface WHPrinter{  //흑백프린터 전용 인터페이스
    String InkType = "Black";  //상수라서 대문자 시작(public static final String InkType)

    void whPrint(String doc);  //인터페이스 메소드
}
interface CoPrinter extends WHPrinter{  //컬러 프린터 인터페이스(WHPrinter 상속)
    String TonnerType = "Laser";

    void coPrint(String doc);
}

class LGPrinter implements WHPrinter{  //WHPrinter 구현한 클래스
    @Override  //인터페이스 메소드의 오버라이딩
    public void whPrint(String doc) {
        System.out.println("<LG>");
        System.out.println("inkType: "+InkType);
        System.out.println("white&black print>>"+doc+"\n");
    }
}
class SamsungPrinter implements CoPrinter{  //CoPrinter 구현한 클래스
    @Override
    public void whPrint(String doc) {
        System.out.println("<SamSung>");
        System.out.println("inkType: "+InkType);
        System.out.println("white&black print>>"+doc+"\n");
    }

    @Override
    public void coPrint(String doc) {
        System.out.println("<SamSung>");
        System.out.println("tonnerType: "+ TonnerType);
        System.out.println("color print>>"+doc+"\n");
    }
}

public class InterfacePractice {
    public static void main(String[] args) {
        String doc = "This is document....";

        WHPrinter whPrn = new LGPrinter();
        whPrn.whPrint(doc);

        CoPrinter coPrn = new SamsungPrinter();
        coPrn.whPrint(doc);
        coPrn.coPrint(doc);
    }
}
