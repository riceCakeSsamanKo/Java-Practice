package TrashCan;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_pracitice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (String i : list) {
            System.out.println(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
