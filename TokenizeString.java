package TrashCan;

import java.util.StringTokenizer;
//StringTokenizer 클래스를 이용해서 문자열 받아서 덧셈 뺄셈하는 계산기 구현
public class TokenizeString {
    public static void main(String[] args) {
        String expression = "34 + 12 + 17 + 24 - 18 - 14";  //식
        StringTokenizer st = new StringTokenizer(expression, " ");

        int result = 0;
        String calOperator = null;
        while(st.hasMoreTokens()){
            String nextToken = st.nextToken();

            //연산자 들어온 부분 처리
            if(nextToken.equals("-")){
                calOperator = "-";
                continue;
            }
            else if(nextToken.equals("+")){
                calOperator = "+";
                continue;
            }
            //숫자들어온 부분 처리
            else{
                try{
                    if(calOperator == "-"){
                        result -= Integer.valueOf(nextToken);  //정수로 변환
                    }
                    else{
                        result += Integer.valueOf(nextToken);
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("result = "+ result);
    }
}
