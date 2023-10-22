public class test {
    public static void main(String[] args) {
        String s = "abb";
        long count = s.chars().filter(ch -> ch == 'a').count();
        System.out.println(count);
        System.out.println(s);
    }
}
