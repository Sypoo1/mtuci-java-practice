import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class thirdTask {
    public static void main(String[] args) {
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println(" ");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println(" ");
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println(" ");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println(" ");
        int[] firstArray = new int[]{1, -3, 2};
        int[] secondArray = new int[]{2, 5, 2};
        int[] thirdArray = new int[]{1, -6, 9};
        System.out.println(countRoots(firstArray));
        System.out.println(countRoots(secondArray));
        System.out.println(countRoots(thirdArray));
        System.out.println(" ");
        String[][] firstData = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        };
        String[][] secondData = {
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        };
        System.out.println(Arrays.toString(salesData(firstData)));
        System.out.println(Arrays.toString(salesData(secondData)));
        System.out.println(" ");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println(" ");
        firstArray = new int[]{3, 1, 4, 2, 7, 5};
        secondArray = new int[]{1, 2, 3, 4, 5};
        thirdArray = new int[]{1, 2, -6, 10, 3};
        System.out.println(waveForm(firstArray));
        System.out.println(waveForm(secondArray));
        System.out.println(waveForm(thirdArray));
        System.out.println(" ");
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println(" ");
        int[][] firstMatrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 29, 10},
                {5, 5, 5, 5, 35},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };
        int[][] secondMatrix = {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };
        System.out.println((Arrays.deepToString(dataScience(firstMatrix))));
        System.out.println(Arrays.deepToString(dataScience(secondMatrix)));

    }

    public static String replaceVovels(String string) {
        char[] vowels = new char[]{'a', 'o', 'e', 'u', 'i', 'y'};
        for (char vowel : vowels) {
            string = string.replace(vowel, '*');
            string = string.replace(Character.toUpperCase(vowel), '*');
        }
        return string;
    }

    public static String stringTransform(String string) {

        for (char letter = 65; letter <= 90; letter++) {
            char[] double_letter = new char[]{letter, letter};
            string = string.replace(String.valueOf(double_letter), "*" + letter);
            char[] double_lower_letter = new char[]{Character.toLowerCase(letter), Character.toLowerCase(letter)};
            string = string.replace(String.valueOf(double_lower_letter), "*" + letter);
        }
        string = string.replace("*", "Double");
        return string;
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        return Math.min(a * b, Math.min(a * c, b * c)) <= w * h;
    }

    public static boolean numCheck(int number) {
        int startNumber = number;
        int powSum = 0;
        while (number > 0) {
            powSum += (number % 10) * (number % 10);
            number /= 10;
        }
        return powSum % 2 == startNumber % 2;
    }

    public static int countRoots(int[] array) {
        int a = array[0];
        int b = array[1];
        int c = array[2];
        int D = b * b - 4 * a * c;
        if (D < 0) {
            return 0;
        } else if (D == 0) {
            double x = (double) -b / (2 * a);
            if (x == (int) x) return 1;
            else return 0;
        } else {
            int result = 0;
            double x1 = (-b - Math.sqrt(D)) / (2 * a);
            double x2 = (-b + Math.sqrt(D)) / (2 * a);
            if (x1 == (int) x1) result += 1;
            if (x2 == (int) x2) result += 1;
            return result;
        }
    }

    public static String[] salesData(String[][] data) {
        String[] bestItems = {};
        int longestLength = 0;
        for (String[] item : data) {
            longestLength = Math.max(longestLength, item.length);
        }
        for (String[] item : data) {
            if (item.length == longestLength) {
                bestItems = Arrays.copyOf(bestItems, bestItems.length + 1);
                bestItems[bestItems.length - 1] = item[0];
            }
        }
        return bestItems;
    }

    public static boolean validSplit(String string) {
        String[] words = string.split(" ");
        for (int index = 0; index < words.length - 1; index++) {
            char[] current_word = words[index].toCharArray();
            char[] next_word = words[index + 1].toCharArray();
            if (current_word[current_word.length - 1] != next_word[0]) return false;
        }
        return true;
    }

    public static boolean waveForm(int[] array) {
        boolean increasing;
        if (array[1] < array[0]) increasing = false;
        else if (array[1] > array[0]) increasing = true;
        else return false;
        for (int index = 1; index < array.length; index++) {
            if (increasing) {
                if ((index % 2 != 0) && (!((array[index] > array[index - 1])))) return false;
                if ((index % 2 == 0) && (!((array[index] < array[index - 1])))) return false;
            }
            if (!increasing) {
                if ((index % 2 != 0) && (!((array[index] < array[index - 1])))) return false;
                if ((index % 2 == 0) && (!((array[index] > array[index - 1])))) return false;
            }
        }
        return true;
    }

    public static String commonVovel(String string) {
        string = string.toLowerCase();
        char[] charArray = string.toCharArray();
        Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
        char[] vowels = {'a', 'o', 'e', 'u', 'i', 'y'};
        for (char vowel : vowels) dictionary.put(vowel, 0);
        for (char item : charArray) if (dictionary.containsKey(item)) dictionary.put(item, dictionary.get(item) + 1);
        int maxCount = 0;
        for (int value : dictionary.values()) maxCount = Math.max(maxCount, value);
        for (char key : dictionary.keySet()) if (dictionary.get(key) == maxCount) return String.valueOf(key);
        return string;
    }

    public static int[][] dataScience(int[][] matrix){
        int n = matrix[0].length;
        for (int mainRow = 0; mainRow < n; mainRow++){
            int newElement = 0;
            for (int sideRow = 0; sideRow < n; sideRow++) if (sideRow != mainRow) newElement += matrix[sideRow][mainRow];
            matrix[mainRow][mainRow] = (int) Math.round((double) newElement / (n - 1));
        }
        return matrix;
    }
}