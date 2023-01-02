class Point implements Cloneable{
    private int xpos;
    private int ypos;
    public Point(int xpos, int ypos){
        this.xpos = xpos;
        this.ypos = ypos;
    }

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
    public Object clone() throws CloneNotSupportedException{ //깊은 복사가 발생하도록 오버라이딩
        Rectangle copy = (Rectangle)super.clone();
        //깊은 복사
        copy.upperLeft = (Point)upperLeft.clone();
        copy.lowerRight = (Point)lowerRight.clone();

        return copy;  //깊은 복사된 Rectangle copy가 Object 형으로 반환
    }
    void showInfo(){
        System.out.print("upperLeft"); upperLeft.showInfo();
        System.out.print("lowerRight"); lowerRight.showInfo();
    }
}

public class DeepCopy {
    public static void main(String[] args) {
        try{
            Rectangle r1 = new Rectangle(1,1,2,2);
            Rectangle r2 = (Rectangle)r1.clone();

            r1.showInfo();
            r2.showInfo();
            System.out.println();

            r1.changePos(5,5,6,6);
            r1.showInfo();
            r2.showInfo();

            if(r1.upperLeft == r2.upperLeft)
                System.out.println("same");
            else
                System.out.println("different");
        }
        catch(CloneNotSupportedException e){
            e.getStackTrace();
        }
    }
}
