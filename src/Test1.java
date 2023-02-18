import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("888"));
        System.out.println(Integer.parseInt("888") + 100);

        System.out.println(String.valueOf("19203") + 100);
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(9);

        list.sort((a, b) -> a - b);
        Integer[] integers = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(integers));

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        for (Entry entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey());
            System.out.println("value: " + entry.getValue());
        }

        Collections.swap(list, 0, 1);
        Integer[] integers2 = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(integers2));

        System.out.println('A' - 0);
        String str = "";
        System.out.println(str == null);
        System.out.println(str.length());


        System.out.println("abc".substring(1, 1) + "1");

        System.out.println("abc".compareTo("b"));
        System.out.println("bc".compareTo("ba"));
        System.out.println("bc".compareTo("bc"));

        new String('a' + "");
        Stack<String> stack = new Stack<>();
        stack.push("abc");
        System.out.println(stack.empty());
        System.out.println(stack.isEmpty());

    }
}
