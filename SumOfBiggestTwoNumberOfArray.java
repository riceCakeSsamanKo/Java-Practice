import java.util.Scanner;
//n = 10^6, 초당 계산가능 10^8
// 시발 문제 잘못품. 수열의 원소중 두개 뽑아서 가장 큰 합 만드는 문제로 잘못봄 ㅅㅂ
class MaxHeap{
    /*
    * 최대 힙을 통해서 구현함
    * */
    private static final int MAX = 1000;
    private static final int MIN = -1000;
    private static final int NMAX = 100_000;

    private static int intNumbers;
    private static int heapSize;
    private static int heap[] = new int[NMAX];
    MaxHeap(int intNumbers){
        this.intNumbers = intNumbers;
        heap = new int[this.intNumbers+1];
        heapSize=0;
    }

    public static void setIntNumbers(int num){
        intNumbers = num;
    }
    public static int getIntNumbers(){
        return intNumbers;
    }

    public static void push(int input){
        int currentNode = ++heapSize;
        while(currentNode!=1 && input > heap[currentNode/2]){
            heap[currentNode] = heap[currentNode/2];
            currentNode /= 2;
        }
        heap[currentNode] = input;
    }
    public static int biggestSumOfTwoNum(){
        int sum = 0;
        sum+=getBiggestNumber();
        delete();
        sum+=getBiggestNumber();
        return sum;
    }
    private static int getBiggestNumber(){
        return heap[1];
    }
    private static int delete(){
        //최대 원소 삭제
        int root = heap[1];
        heap[1]=MIN;

        int lastElement = heap[--heapSize];
        int currentNode = 1;
        int child = 2;

        while(child<=heapSize){
            //biggest child
            if(child<heapSize && heap[child]<heap[child+1])
                child = child+1;
            //break point
            if(lastElement>heap[child])
                break;

            if(heap[child]>lastElement){
                heap[currentNode] = heap[child];
            }
            currentNode = child;
            child *= 2;
        }
        heap[currentNode] = lastElement;
        return root;
    }

    public static void showHeap(){
        int countFive=0;
        for(int i=1;i<intNumbers;i++){
            System.out.printf("[%d]: %d ",i,heap[i]);

            if((++countFive)%5 == 0)
                System.out.println();
        }
        System.out.println();
    }
}
public class SumOfBiggestTwoNumberOfArray {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        MaxHeap.setIntNumbers(in.nextInt());

        for(int i=0;i<MaxHeap.getIntNumbers();i++){
            MaxHeap.push(in.nextInt());
        }
        MaxHeap.showHeap();

        System.out.println(MaxHeap.biggestSumOfTwoNum());
    }
}
