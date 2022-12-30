import java.util.Scanner;

class Friend{
    protected String name;
    protected String phone;

    public Friend(String na, String ph){
        name = na;
        phone = ph;
    }
    public void showInfo(){
        System.out.println("name: "+ name);
        System.out.println("phone: "+ phone);
    }
}
class UnivFriend extends Friend{
    private String major;

    UnivFriend(String na, String ph, String ma){
        super(na,ph);
        major = ma;
    }
    public void showInfo(){
        super.showInfo();
        System.out.println("major: "+major);
    }
}
class CompFriend extends Friend{
    private String company;

    CompFriend(String na, String ph, String co){
        super(na,ph);
        company = co;
    }
    public void showInfo(){
        super.showInfo();
        System.out.println("company: "+company);
    }
}

public class MyFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("친구 수 >>>");
        int fNum = sc.nextInt();  //대학 동창 + 회사원 수
        Friend friends[] = new Friend[fNum];  //대학 동창과 회사 동료를 담는 하나의 배열

        System.out.print("대학 동창수 >>>");
        int uNum = sc.nextInt();  //대학동창 수
        sc.nextLine();  //입력버퍼 비우기

        for(int i=0;i<uNum;i++){
            System.out.print("이름 >>>"); String name = sc.nextLine();
            System.out.print("전화번호 >>>"); String phone = sc.nextLine();
            System.out.print("전공 >>>"); String major = sc.nextLine();

            friends[i] = new UnivFriend(name,phone,major);  //Friend = UnivFriend 오버라이딩
        }
        for(int i=uNum;i<fNum;i++){
            System.out.print("이름 >>>"); String name = sc.nextLine();
            System.out.print("전화번호 >>>"); String phone = sc.nextLine();
            System.out.print("회사 >>>"); String comp = sc.nextLine();

            friends[i] = new CompFriend(name,phone,comp);  //Friend = CompFriend 오버라이딩
        }

        for(Friend f:friends){
            f.showInfo();
        }
    }
}