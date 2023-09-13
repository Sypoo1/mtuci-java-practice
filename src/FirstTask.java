
public class FirstTask {
    public static void main(String[] args) {

        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println(" ");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println(" ");
        System.out.println(containers(3,4,2));
        System.out.println(containers(5,0,2));
        System.out.println(containers(4,1,4));
        System.out.println(" ");
        System.out.println(triangleType(5,5,5));
        System.out.println(triangleType(5,4,5));
        System.out.println(triangleType(3,4,5));
        System.out.println(triangleType(5,1,1));
        System.out.println(" ");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println(" ");
        System.out.println(howManyItems(22,1.4,2));
        System.out.println(howManyItems(45,1.8,1.9));
        System.out.println(howManyItems(100,2,2));
        System.out.println(" ");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println(" ");
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52,8));
        System.out.println(gcd(259, 28));
        System.out.println(" ");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24,950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println(" ");
        System.out.println(tables(5, 2));
        System.out.println(tables(31,20));
        System.out.println(tables(123,58));
    }

    public static double convert(int gallons){
        return gallons * 3.785d;
    }

    public static int fitCalc(int minutes, int intensity){
        return minutes * intensity;
    }

    public static int containers(int boxes, int bags, int barrels){
        return 20 * boxes + bags * 50 + barrels * 100;
    }

    // ошибка в переводе, isosceles и equilateral нужно поменять местами
    public static String triangleType(int x, int y, int z){
        if ((x == y) && (y == z)){
            return "isosceles";
        } else if (((x+y) <= z) || ((y+z) <= x) || ((x + z) <= y)) {
            return "not a triangle";
        } else if ((x==y) || (x==z) || (y == z)) {
            return "equilateral";
        } else return "different-sided";

    }
    public static int ternaryEvaluation(int a, int b){
        return a > b ? a : b;
    }
    // непонятное условие
    public static int howManyItems(int n, double w, double h){
        return (int) (n/(2*w*h));
    }
    public static int factorial(int n){
        int result = 1;
        for (int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }
    // ошибка в методичке в третьем примере
    public static int gcd(int a, double b){
        int result = 1;
        for (int i = 1; i <= a; i++){
            if ((a % i == 0) && (b % i == 0)) {
                result = i;
            }
        }
        return result;
    }
    public static int ticketSaler(int cnt, int price){
       return cnt * price * 72 / 100;
    }
    public static int tables(int cntStudents, int cntTables){
        int difference = cntStudents - cntTables * 2;
        if (difference <= 0){
            return 0;
        } else if ((difference) % 2 == 0)  {
            return difference / 2;
        } else return difference / 2 + 1;
    }

}