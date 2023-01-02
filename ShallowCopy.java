class Point implements Cloneable{
    private int xpos;
    private int ypos;
    public Point(int xpos, int ypos){
        this.xpos = xpos;
        this.ypos = ypos;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    void changePos(int xpos, int ypos){
        this.xpos = xpos;
        this.ypos = ypos;
    }
    void showInfo(){
        System.out.printf("(%d, %d)\n",xpos,ypos);
    }
}

class Rectangle implements Cloneable{
    Point upperLeft;
    private Point lowerRight;
    public Rectangle(int x1, int y1, int x2, int y2){
        upperLeft = new Point(x1,y1);
        lowerRight = new Point(x2,y2);
    }
    void changePos(int x1, int y1, int x2, int y2){
        upperLeft.changePos(x1,x2);
        lowerRight.changePos(x2,y2);
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    void showInfo(){
        System.out.print("upperLeft"); upperLeft.showInfo();
        System.out.print("lowerRight"); lowerRight.showInfo();
    }
}

public class ShallowCopy {
    public static void main(String[] args) {
        try{
            Rectangle r1 = new Rectangle(1,1,2,2);
            Rectangle r2 = (Rectangle)r1.clone();  //멤버간 얕은 복사(멤버간 참조값이 동일함)

            r1.showInfo();
            r2.showInfo();
            System.out.println();

            r1.changePos(5,5,6,6);
            r1.showInfo();
            r2.showInfo();

            if(r1.upperLeft == r2.upperLeft)  //얕은 복사 발생
                System.out.println("same");  //r1과 r2는 다르지만 멤버 변수는 동일 인스턴스를 참조함
        }
        catch(CloneNotSupportedException e){
            e.getStackTrace();
        }
    }
}


//    실행결과

//    upperLeft(1, 1)
//    lowerRight(2, 2)
//    upperLeft(1, 1)
//    lowerRight(2, 2)
//
//    upperLeft(5, 6)
//    lowerRight(6, 6)
//    upperLeft(5, 6)
//    lowerRight(6, 6)