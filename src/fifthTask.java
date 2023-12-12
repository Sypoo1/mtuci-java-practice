import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
public class fifthTask {
    public static void main(String[] args) {
        System.out.println("1) sameLetterPattern");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println("2) spiderVsFly");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println(spiderVsFly("A4" ,"H2"));
        System.out.println(spiderVsFly("A2", "H4"));
        System.out.println(spiderVsFly("G2", "A2"));
        System.out.println("3) digitsCount");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println("4) totalPoints");
        System.out.println(totalPoints(new String[] { "cat", "create", "sat" }, "caster"));
        System.out.println(totalPoints(new String[] { "trance", "recant" }, "recant"));
        System.out
                .println(totalPoints(new String[] { "dote", "dotes", "toes", "set", "dot", "dots", "sted" }, "tossed"));

        System.out.println("5) sumsUp");
        System.out.println((Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 4, 5}))));
        System.out.println((Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 7, 9}))));
        System.out.println((Arrays.deepToString(sumsUp(new int[]{10, 9, 7, 2, 8}))));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7})));
        System.out.println("6) takeDownAverage");
        System.out.println(takeDownAverage(new String[] { "95%", "83%", "90%", "87%", "88%", "93%" }));
        System.out.println(takeDownAverage(new String[] { "10%" }));
        System.out.println(takeDownAverage(new String[] { "53%", "79%" }));
        System.out.println("7) caesarCipher");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("encode", "almost last task!", 4));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));
        System.out.println(caesarCipher("decode", "ABQSWX PEWX XEWO!", 4));
        System.out.println("8) setSetup(сочетания)");
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println("9) timeDifference");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println("10) isNew");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(130));
    }

    public static boolean sameLetterPattern(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int diff = s1.charAt(0) - s2.charAt(0);
        for (int i = 1; i < s1.length(); i++) {
            if ((s1.charAt(i) - s2.charAt(i)) != diff) {
                return false;
            }
        }
        return true;
    }


    public static String spiderVsFly(String spiderPosition, String flyPosition) {
        System.out.println("From "+ spiderPosition + " to " + flyPosition + ":");

        int spiderSymbol = spiderPosition.charAt(0) - 65;
        int spiderNumber = Integer.parseInt(spiderPosition.substring(1, 2));
        int flySymbol = flyPosition.charAt(0) - 65;
        int flyNumber = Integer.parseInt(flyPosition.substring(1, 2));
        if (flyNumber == 0) flySymbol = 0;


        double straightWay = 1;
        double[] ways = new double[5];
        for (int i = 0; i < 5; i++) ways[i] = i * Math.sqrt(2 - Math.sqrt(2));

        StringBuilder strWay1 = new StringBuilder(spiderPosition);
        double intWay1 = 0;
        int nowSpiderSymbol1 = spiderSymbol;
        int nowSpiderNumber1 = spiderNumber;
        while (nowSpiderSymbol1 != flySymbol || nowSpiderNumber1 != flyNumber) {
            if (nowSpiderNumber1 == 0) {
                nowSpiderSymbol1 = flySymbol;
                nowSpiderNumber1 = 1;
            } else if (nowSpiderSymbol1 == spiderSymbol) {
                nowSpiderNumber1 -= 1;
                if (nowSpiderNumber1 == 0) nowSpiderSymbol1 = 0;
            } else {
                nowSpiderNumber1 += 1;
            }
            strWay1.append("-").append((char) (nowSpiderSymbol1 + 65)).append(nowSpiderNumber1);
            intWay1 += straightWay;
        }

        StringBuilder strWay2 = new StringBuilder(spiderPosition);
        double intWay2 = 0;
        int nowSpiderSymbol2 = spiderSymbol;
        int nowSpiderNumber2 = spiderNumber;
        if (nowSpiderNumber2 > flyNumber) {
            while (nowSpiderNumber2 != flyNumber) {
                nowSpiderNumber2 -= 1;
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += straightWay;
            }
            while (nowSpiderSymbol2 != flySymbol) {
                int clock = flySymbol - nowSpiderSymbol2;
                if (clock < 0) clock += 8;
                if (clock <= 4) {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 1) % 8;

                }
                else {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 7) % 8;
                }
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += ways[nowSpiderNumber2];
            }
        }
        else {
            while (nowSpiderSymbol2 != flySymbol) {
                int clock = flySymbol - nowSpiderSymbol2;
                if (clock < 0) clock += 8;
                if (clock <= 4) {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 1) % 8;

                }
                else {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 7) % 8;
                }
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += ways[nowSpiderNumber2];
            }
            while (nowSpiderNumber2 != flyNumber) {
                nowSpiderNumber2 += 1;
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += straightWay;
            }
        }
        if (intWay1 <= intWay2) {
            return strWay1.toString();
        }
        return strWay2.toString();
    }


    // 3
    public static int digitsCount(long number) {
        if (number < 10)
            return 1;
        return 1 + digitsCount(number / 10);
    }

    // 4
    public static int totalPoints(String[] words, String originalWord) {
        int points = 0;
        HashMap<Character, Integer> letters = new HashMap<>();
        for (char letter: originalWord.toCharArray()){
            letters.put(letter, letters.getOrDefault(letter,0) + 1);
        }
        words = new HashSet<String>(Arrays.asList(words)).toArray(new String[0]); // delete duplicates from words

        wordsLoop:
        for (String word : words){
            HashMap<Character, Integer> tempLetters = new HashMap<>();
            for (char letter : word.toCharArray()){
                tempLetters.put(letter, tempLetters.getOrDefault(letter,0) + 1);
            }
            for (char key : tempLetters.keySet()){
                if (!letters.containsKey(key) || letters.get(key) < tempLetters.get(key)){
                    continue wordsLoop;
                }
            }

            if (word.length() == 3) points += 1;
            else if (word.length() == 4) points += 2;
            else if (word.length() == 5) points += 3;
            else if (word.length() == 6) points += 54;
        }
        return points;
    }

    // 5
    public static int[][] sumsUp(int[] a) {
        ArrayList<int[]> ans = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == 8) {
                    ans.add(new int[] { Math.min(a[i], a[j]), Math.max(a[i], a[j]), j - i });
                }
            }
        }
        ans.sort(Comparator.comparing((int[] x) -> x[2]));
        return ans.stream().map(arr -> Arrays.copyOf(arr, 2)).toArray(int[][]::new);
    }

    // 6
    public static String takeDownAverage(String[] results) {
        int summa = 0;
        int students = results.length;
        for (String result : results) {
            summa += Integer.parseInt(result.replaceFirst("%", ""));
        }
        int answer = Math.round((float) summa / (float) students) - 5 * (students + 1);
        return "" + answer + "%";
    }

    // 7
    public static String caesarCipher(String mode, String input, int shift) {
        if (Objects.equals(mode, "encode")) {
            shift = shift * 1;
        } else if (Objects.equals(mode, "decode")) {
            shift = shift * -1;
        } else {
            return "error";
        }
        StringBuilder ans = new StringBuilder();
        for (char i : input.toUpperCase().toCharArray()) {
            if (i >= 'A' && i <= 'Z') {
                ans.append((char) ('A' + (i - 'A' + shift + 26) % 26));
            } else
                ans.append(i);
        }
        return ans.toString();
    }

    // 8
    public static int setSetup(int n, int k) {
        if (k == 0)
            return 1;
        return n * setSetup(n - 1, k - 1);
    }

    // 9
    public static String timeDifference(String cityA, String timeA, String cityB) {
        Map<String, Float> timeOffsets = new HashMap<>() {
            {
                put("Los Angeles", -8f);
                put("New York", -5f);
                put("Caracas", -4.5f);
                put("Buenos Aires", -3f);
                put("London", 0f);
                put("Rome", 1f);
                put("Moscow", 3f);
                put("Tehran", 3.5f);
                put("New Delhi", 5.5f);
                put("Beijing", 8f);
                put("Canberra", 10f);
            }
        };

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("LLLL d, yyyy HH:mm").withLocale(Locale.ENGLISH);
        LocalDateTime origT = null;
        try {
            origT = LocalDateTime.parse(timeA, formatter1);
        } catch (DateTimeParseException e) {
            return "error while parsing";
        }

        float difA = (timeOffsets.get(cityB) - timeOffsets.get(cityA));
        if ((int) difA != difA) {
            origT = origT.plusMinutes(30);
        }
        origT = origT.plusHours((int) difA);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return origT.format(formatter2);
    }

    // 10
    public static boolean isNew(int n) {
        int[] digits = new int[10];
        for (char c : Integer.toString(n).toCharArray()) {
            digits[c - '0']++;
        }

        StringBuilder build = new StringBuilder();
        if (digits[0] > 0) {
            for (int i = 1; i < 10; i++) { // одна цифра перед нулями
                if (digits[i] > 0) {
                    build.append(i);
                    digits[i]--;
                    break;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            while (digits[i] > 0) {
                build.append(i);
                digits[i]--;
            }
        }
        // System.out.println(build);
        return build.toString().equals(Integer.toString(n));
    }
}