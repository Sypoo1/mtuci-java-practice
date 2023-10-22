import java.util.Arrays;

public class fourthTask {
    public static void main(String[] args) {

        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        String[] bracketsArray = generateBrackets(3);
        System.out.println(Arrays.toString(bracketsArray));
    }
    public static String nonRepeatable(String s) {
        if ( s.length() <= 1 ) return s;
        char firstChar = s.charAt(0);
        long count = s.chars().filter(ch -> ch == firstChar).count();
        if (count > 1){
            return firstChar + nonRepeatable(s.replaceAll(String.valueOf(firstChar), ""));
        }
        else return firstChar + nonRepeatable(s.substring(1));
    }
    public static String[] generateBrackets(int n){

        String[] a = new String[] {inner(n), pairs(n)};
        return a;
    }
    public static String pairs(int number){
        String s = "";
        for (int i = 0; i < number; i++){
            s += "()";
        }
        return s;
    };
    public static String inner(int number){
        String s = "";
        for (int i = 0; i < number; i++){
            s += "(";
        }
        for (int i = 0; i < number; i++){
            s += ")";
        }
        return s;
    };
}
