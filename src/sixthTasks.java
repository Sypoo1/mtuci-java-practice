
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class sixthTasks {
    public static void main(String[] args) {
        System.out.println("1) hiddenAnagram");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("2) collect");
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));
        System.out.println("3) nicoCipher");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println("4) twoProduct");
        System.out.println(Arrays.toString(twoProduct(new int[] { 1, 2, 3, 9, 4, 5, 15 }, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[] { 1, 2, 3, 9, 4, 15, 3, 5 }, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[] { 1, 2, -1, 4, 5, 6, 10, 7 }, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[] { 100, 12, 4, 1, 2 }, 15)));
        System.out.println("5) isExact");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println("6) fractions");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println("7) pilishString");
        System.out.println(pilishString("33314444"));
        System.out.println(pilishString("TOP"));
        System.out.println(pilishString("X"));
        System.out.println(pilishString(""));
        System.out.println(pilishString(
                "HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println(pilishString("FORALOOP"));
        System.out.println(pilishString("CANIMAKEAGUESSNOW"));
        System.out.println("8) calculate expression");
        System.out.println("10 - (1 - 5) = " + generateNonconsecutive("10 - (1 - 5)"));
        System.out.println("3 + 5 * (2 - 6) = " + generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println("3 + (2 - 6) * 5 = " + generateNonconsecutive("3 + (2 - 6) * 5"));
        System.out.println("3 + 5 * (-6 + 2) = " + generateNonconsecutive("3 + 5 * (-6 + 2)"));
        System.out.println("3 + (-6 + 2) * 5 = " + generateNonconsecutive("3 + (-6 + 2) * 5"));
        System.out.println("5 * (2 - 6) + 3 = " + generateNonconsecutive("5 * (2 - 6) + 3"));
        System.out.println("6 - 18 / (-1 + 4) = " + generateNonconsecutive("6 - 18 / (-1 + 4)"));
        System.out.println("6 - 18 / (4 - 1) = " + generateNonconsecutive("6 - 18 / (4 - 1)"));
        System.out.println("10 / 0 = " + generateNonconsecutive("10 / 0"));
        System.out.println("9) isValid");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println(isValid("abcdefghhgfedcbaa"));
        System.out.println("10) findLCS");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
        System.out.println(findLCS("ABCDGH", "AEDFHR"));
    }

    // 1
    public static String hiddenAnagram(String s1, String s2) {
        // s1 = s1.toLowerCase();
        StringBuilder s1t = new StringBuilder(); // оставляем только буквы
        for (char i : s1.toCharArray()) {
            if (i >= 'A' && i <= 'z')
                s1t.append(Character.toLowerCase(i));
        }
        s1 = s1t.toString();
        s2 = s2.toLowerCase();
        // System.out.println(s1);
        // System.out.println(s2);
        int[] a = new int[26]; // счётчик букв во второй строке
        for (char i : s2.toCharArray()) {
            if (i >= 'a' && i <= 'z')
                a[i - 'a']++;
        }
        int[] b = new int[26]; // счётчик букв в подстроке первой строки
        int l = 0; // начало подстроки
        for (int r = 0; r < s1.length(); r++) {
            if (a[s1.charAt(r) - 'a'] == 0) {
                Arrays.fill(b, 0);
                l = r + 1;
                continue;
            } else if (a[s1.charAt(r) - 'a'] == b[s1.charAt(r) - 'a']) { // доходим до лишней буквы
                char t = s1.charAt(r);
                for (int j = l; j < r; j++) {
                    if (s1.charAt(j) == t) {
                        l = j + 1;
                        break;
                    } else {
                        b[s1.charAt(j) - 'a']--;
                    }
                }
            } else {
                b[s1.charAt(r) - 'a']++;
            }
            if (Arrays.equals(a, b))
                return s1.substring(l, r + 1);
        }
        return "notfound";
    }

    // 2
    // public static String[] collect(S    tring s, int n) {
    //     if (s.length() <= n)
    //         return new String[] { s };
    //     String[] a = collect(s.substring(n - 1, s.length()), n);
    //     return new String[(s.length() + n - 1) / n];
    // }
    public static String[] collect(String s, int n) {
        if (s.length() <= n) {
            return new String[0];
        }

        List<String> slices = new ArrayList<>();
        for (int i = 0; i <= s.length() - n; i += n) {
            slices.add(s.substring(i, i + n));
        }
        slices.sort(String::compareTo);
        return slices.toArray(new String[s.length() / n]);
    }

    // 3
    public static String nicoCipher(String s1, String s2) {
        int n = s2.length(), m = (s1.length() + n - 1) / n + 1;
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) { // заполнение нулевого столбца
            arr[i][0] = s2.charAt(i);
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (i * n + j < s1.length())
                    arr[j][i + 1] = s1.charAt(i * n + j);
                else
                    arr[j][i + 1] = ' ';
            }
        }
        // System.out.println(Arrays.deepToString(arr));
        Arrays.sort(arr, Comparator.comparing((char[] x) -> x[0]));
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                ans.append(arr[j][i + 1]);
            }
        }
        return ans.toString();
    }

    // 4
    public static int[] twoProduct(int[] arr, int n) {
        for (int d = 0; d < arr.length; d++) {
            for (int r = 0; r + d < arr.length; r++) {
                if (arr[r] * arr[r + d] == n) {
                    return new int[] { arr[r], arr[r + d] };
                }
            }
        }
        return new int[0];
    }

    // 5
    public static int[] isExact(int n) {
        return isExactRecurs(n, 1);
    }

    public static int[] isExactRecurs(int n, int i) {
        if (n == 1) {
            return new int[] { 1, 0 };
        }
        if (n % i == 0) {
            int[] t = isExactRecurs(n / i, i + 1);
            if (t.length == 0) {
                return new int[0];
            }
            return new int[] { n, t[1] + 1 };
        } else {
            return new int[0];
        }
    }

    // public static int[] isExact(int n) {
    // int ans = 1, nc = n;
    // for (; n != 1; ans++) {
    // if (n % ans == 0) {
    // n /= ans;
    // } else {
    // return new int[0];
    // }
    // }
    // return new int[] { nc, ans - 1 };
    // }

    // 6
    public static String fractions(String s) {
        int n = 1, m = 1;
        String t1 = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
        StringBuilder sb = new StringBuilder(s.substring(0, s.indexOf("(")));
        int len = sb.length();
        while (sb.length() - len <= 15) {
            sb.append(t1);
        }
        s = sb.substring(0, 16 + len);
        double k = Double.parseDouble(s);
        while ((double) n / (double) m != k) {
            // System.out.println((double) n / (double) m);
            // System.out.println(k);
            if ((double) n / (double) m > k)
                m++;
            else
                n++;
        }
        // System.out.println(sb.toString());
        // System.out.println(sb.length());
        return n + "/" + m;
    }

    public static int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }

    // 7
    public static String pilishString(String s) {
        String pi = new StringBuilder("" + Math.PI).replace(1, 2, "").toString();
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < 15; i++) {
            int t = pi.charAt(i) - '0';
            if (j + t <= s.length()) {
                ans.append(s.substring(j, j + t));
                ans.append(" ");
                j += pi.charAt(i) - '0';
            } else if (j < s.length()) { // вывод последнего слова
                // System.out.println("enter");
                while (j < s.length()) {
                    ans.append(s.charAt(j));
                    j++;
                    t--;
                }
                j--;
                while (t != 0) {
                    ans.append(s.charAt(j));
                    t--;
                }
                break;
            } else {
                break;
            }
        }
        return ans.toString();
    }

    // 8
    public static double generateNonconsecutive(String s) {
        try {
            s = s.replaceAll("\\s+", ""); // Удаляем пробелы из выражения
            Stack<Double> numStack = new Stack<>();
            Stack<Character> exprStack = new Stack<>();
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == '(') {
                    exprStack.push(c);
                    i++;
                } else if (c == ')') {
                    while (!exprStack.isEmpty() && exprStack.peek() != '(') {
                        applyOperator(numStack, exprStack);
                    }
                    exprStack.pop();
                    i++;
                } else if (isOperator(c) && (i == 0 || s.charAt(i - 1) != '(')) {
                    while (!exprStack.isEmpty() && priority(exprStack.peek(), c)) {
                        applyOperator(numStack, exprStack);
                    }
                    exprStack.push(c);
                    i++;
                } else {
                    int k = 1; // inversion
                    if (isOperator(c)) {
                        k *= -1;
                        i++;
                    }
                    StringBuilder numBuilder = new StringBuilder();
                    while (i < s.length()
                            && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
                        numBuilder.append(s.charAt(i));
                        i++;
                    }
                    double num = Double.parseDouble(numBuilder.toString());
                    numStack.push(num * k);
                }
            }
            while (!exprStack.isEmpty()) {
                applyOperator(numStack, exprStack);
            }
            if (numStack.size() == 1 && exprStack.isEmpty()) {
                return numStack.pop();
            } else {
                throw new ArithmeticException("Неверное выражение");
            }
        } catch (Exception e) {
            System.out.println(e);
            return Double.NaN; // Обработка ошибок, например, деление на ноль или неправильное выражение
        }
    }

    private static void applyOperator(Stack<Double> numStack, Stack<Character> exprStack) {
        char expr = exprStack.pop();
        double b = numStack.pop();
        double a = numStack.pop();
        // System.out.println("" + a + " " + expr + " " + b);
        double ans = 0.0;
        switch (expr) {
            case '+':
                ans = a + b;
                break;
            case '-':
                ans = a - b;
                break;
            case '*':
                ans = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                ans = a / b;
                break;
        }
        numStack.push(ans);
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static boolean priority(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return true;
        }
        return false;
    }

    // 9
    public static String isValid(String s) {
        if (s.length() < 2) {
            return "YES";
        }
        int[] a = new int[26];
        for (char i : s.toCharArray()) {
            a[i - 'a']++;
        }
        // System.out.println(Arrays.toString(a));
        int x = -1, n = 0;
        boolean flag = true;
        for (int i : a) {
            if (i == 0)
                continue;
            else if (x == i)
                n++;
            else if (x == -1) {
                x = i;
                n = 1;
            } else if (i - 1 == x && flag)
                flag = false;
            else if (i + 1 == x && flag && n == 1) {
                flag = false;
                x--;
                n++;
            } else
                return "NO";
        }
        return "YES";
    }

    // 10
    public static String findLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    a[i][j] = a[i - 1][j - 1] + 1;
                } else {
                    a[i][j] = Math.max(a[i - 1][j], a[i][j - 1]);
                }
            }
        }

        // pathRecovery
        StringBuilder path = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                path.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (a[i - 1][j] > a[i][j - 1])
                i--;
            else
                j--;
        }

        path.reverse();
        return path.toString();
    }
}