import java.util.Arrays;

class Person implements Comparable {  //Comparable 인터페이스 구현
    private String name;
    private int age;
    private int height;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String toString(){
        return "-"+name+": "+age+"세, "+height+"cm";
    }

    @Override
    public int compareTo(Object o) {  // 구현부 (sorting 시 크고 작음의 기준)
        // o의 나이가 크면 리턴값 음수
        // o의 나이가 작으면 리턴값 양수
        // 서로의 나이가 같으면 리턴값 0

        int ageComp = this.age - ((Person)o).age;  //나이 비교 값
        return ageComp;
    }
}
public class ArrayObjSort {
    public static void main(String[] args) {
        Person p[] = new Person[4];

        p[0] = new Person("kim",21,171);
        p[1] = new Person("Lee",45,180);
        p[2] = new Person("Park",16,160);
        p[3] = new Person("Choi",21,154);

        Arrays.sort(p);

        for(Person person : p){
            System.out.println(person);
        }
    }
}
