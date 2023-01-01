import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtendsExceptionClass {
    //Exception 클래스를 상속받는 IOException 클래스
    public static void main(String[] args) {
        try{
            md1();
        }
        catch(IOException e){  //IOException 예외처리
            e.printStackTrace();
            System.out.println("error occur");
        }
    }
    //throws 키워드로 예외 처리를 해당 메소드를 호출한 다른 메소드로 넘길 수 있다.
    public static void md1() throws IOException{  //IOExceoption 발생시 md1()을 호출한 메소드(main)로 예외처리를 넘김
        md2(); //md2()를 호출하는 메소드
    }
    public static void md2() throws IOException{  //IOException이 발생시 md2()를 호출한 메소드(md1)로 예외처리를 넘김
        Path file = Paths.get("C:\\JavaStudy\\Simple.txt");
        BufferedWriter writer = null;
        writer = Files.newBufferedWriter(file);
        writer.write('A');
        writer.write('Z');

        if(writer != null)
            writer.close();
    }
}

//예외처리 과정

// main에서 md1()호출 -> md2()호출 -> md2()에서 IOException 발생 ->
// 예외처리를 md1()으로 넘김 -> 예외처리를 main으로 넘김 -> main에서 예외처리
