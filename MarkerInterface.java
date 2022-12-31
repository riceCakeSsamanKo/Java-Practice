//마커 인터페이스 Upper, Lower
interface Upper{}
interface Lower{}

interface Printerable{
    String getContents();
}

class Report implements Printerable, Lower{  //마커 인터페이스 Upper를 구현
    String contents;
    Report(String conts){
        contents = conts;
    }
    @Override
    public String getContents(){
        return contents;
    }
}

class Printer{
    static void print(Printerable prn){
        if(prn instanceof Upper){
            System.out.println(prn.getContents().toUpperCase());  //Upper 구현시 대문자 출력
        }
        else if(prn instanceof Lower){
            System.out.println(prn.getContents().toLowerCase());  //Lower 구현시 소문자 출력
        }
        else{
            System.out.println(prn.getContents());  //아니면 그냥 출력
        }
    }
}

public class MarkerInterface {
    public static void main(String[] args) {
        Report prn1 = new Report("This is Contents");  //Report는 Upper를 구현
        Printer.print(prn1);
    }
}
