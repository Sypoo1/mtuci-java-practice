import java.util.Objects;

public class SecondTask {
    public static void main(String[] args){

        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
//        System.out.println(differenceEvenOdd(int[] a = {44, 32, 86, 19}));

    }

    public static boolean duplicateChars(String s){
        s = s.toLowerCase();
        String[] a = s.split("");
        boolean result = false;
        int len = a.length;
        for (int i = 0; i < len; i++){
            if (result){
                break;
            }
            for (int j = i+1; j < len; j++) {
                if (Objects.equals(a[j], a[i])){
                    result = true;
                    break;
                }
            }

        }
        return result;
    }

    public static String getInitials(String s){
        return s.split(" ")[0].split("")[0] + s.split(" ")[1].split("")[0];
    }

    public static int differenceEvenOdd(int[] a){
        int odd = 0;
        int even = 0;
        for (int i = 0; i < a.length; i++){
            if (i % 2 == 0){
                even += a[i];
            } else odd += a[i];
        }
        return even > odd ? (even-odd) : (odd-even);
    }
}
