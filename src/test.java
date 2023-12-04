import java.util.Arrays;
import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        String[] array = {"hi", "hi", "hello"};
        System.out.println(Arrays.toString(array));
        array = new HashSet<String>(Arrays.asList(array)).toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }
}
