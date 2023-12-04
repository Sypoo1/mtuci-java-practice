import java.util.*;
import java.util.stream.Stream;

public class fourthTask {
    public static void main(String[] args) {

        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println(" ");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println(" ");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println(" ");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println(" ");
        System.out.println(countSame("aaabbcdd"));
        System.out.println(countSame("vvvvaajaaaaa"));
        System.out.println(" ");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println(" ");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println(" ");
        int[][] array1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] array2 = {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        };
        System.out.println(shortestWay(array1));
        System.out.println(shortestWay(array2));
        System.out.println(" ");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println(" ");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
        System.out.println(" ");
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
    public static ArrayList<String> generateBrackets(int n){

        if (n <= 0) {
            return new ArrayList<>(List.of(""));
        }
        if (n == 1) {
            return new ArrayList<>(List.of("()"));
        }
        ArrayList<String> listOfBrackets = new ArrayList<>();
        for (String item: generateBrackets(n - 1)){

            String outerBrackets = "(" + item + ")";
            String leftBrackets = "()" + item;
            String rightBrackets = item + "()";

            if (!listOfBrackets.contains(outerBrackets)) listOfBrackets.add(outerBrackets);
            if (!listOfBrackets.contains(leftBrackets)) listOfBrackets.add(leftBrackets);
            if (!listOfBrackets.contains(rightBrackets)) listOfBrackets.add(rightBrackets);
        }
        return listOfBrackets;
    }

    public static ArrayList<String> binarySystem(int n){
        ArrayList<String> listOfBinary = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++){
            String binary = Integer.toBinaryString(i);
            binary = "0".repeat(n - binary.length()) + binary;
            if (!binary.contains("00")) {
                listOfBinary.add(binary);
            }

        }
        return listOfBinary;
    }

    public static String alphabeticRow(String string){

        int stringLength = string.length();
        if (stringLength <= 1) {
            return string;
        }
        String upperString = string.toUpperCase();
        String maxRow = "" + string.charAt(0);
        String currentRow = "" + string.charAt(0);

        for (int index = 0; index < stringLength - 1; index++){
            char currentChar = upperString.charAt(index);
            char nextChar = upperString.charAt(index + 1);
            if (currentChar >= 65 && currentChar <= 90 &&
                nextChar >= 65 && nextChar <= 90 &&
                currentChar + 1 == nextChar) {
                currentRow += string.charAt(index + 1);
                if (currentRow.length() > maxRow.length()){
                    maxRow = currentRow;
                }
            }
            else {
                currentRow = "" + string.charAt(index + 1);
            }
        }
        currentRow = "" + string.charAt(0);
        for (int index = 0; index < stringLength - 1; index++){
            char currentChar = upperString.charAt(index);
            char nextChar = upperString.charAt(index + 1);
            if (currentChar >= 65 && currentChar <= 90 &&
                    nextChar >= 65 && nextChar <= 90 &&
                    currentChar - 1 == nextChar) {
                currentRow += string.charAt(index + 1);
                if (currentRow.length() > maxRow.length()){
                    maxRow = currentRow;
                }
            }
            else {
                currentRow = "" + string.charAt(index + 1);
            }
        }

        return maxRow;
    }
    public static String countSame(String string){

        ArrayList<String> items = new ArrayList<>();
        int cnt = 1;
        char symbol = string.charAt(0);
        for (int index = 1; index < string.length(); index++){
            char currentChar = string.charAt(index);
            if (symbol == currentChar){
                cnt += 1;
            }
            else{
                String item = String.valueOf(symbol) + cnt;
                items.add(item);
                cnt = 1;
                symbol = currentChar;
            }
        }
        String item = String.valueOf(symbol) + cnt;
        items.add(item);

        Comparator<String> myCustomComparator = (s1, s2) -> {
            int num1 = Integer.parseInt(s1.substring(1));
            int num2 = Integer.parseInt(s2.substring(1));
            return Integer.compare(num1, num2);
        };
        items.sort(myCustomComparator);

        return String.join("",items);
    }

    public static int convertToNum(String string){
        if (string.equals("one thousand")) return 1000;

        int number = 0;
        ArrayList<String> words = new ArrayList<>(List.of(string.toLowerCase().split(" ")));

        while (!words.isEmpty()){

            String element = words.get(0);

            if (words.size() >= 2 && words.get(1).equals("hundred")) {
                number += 100 * stringToNum(element);
                words.remove(0);
                words.remove(0);

                continue;
            }
            if (element.contains("ty")){
                number += 10 * stringToNum(element.replace("ty", ""));
                words.remove(0);
                continue;
            }
            if (element.contains("teen")){
                number += 10 + stringToNum(element.replace("teen", ""));
                words.remove(0);
                continue;
            }
            number += stringToNum(element);
            words.remove(0);
        }
        return number;
    }
    public static int stringToNum(String string){
        switch (string) {
            case "zero" -> {
                return 0;
            }
            case "one" -> {
                return 1;
            }
            case "two", "twen" -> {
                return 2;
            }
            case "three", "thir" -> {
                return 3;
            }
            case "four", "for" -> {
                return 4;
            }
            case "five", "fif" -> {
                return 5;
            }
            case "six" -> {
                return 6;
            }
            case "seven" -> {
                return 7;
            }
            case "eight", "eigh" -> {
                return 8;
            }
            case "nine" -> {
                return 9;
            }
            case "ten" -> {
                return 10;
            }
            case "eleven" -> {
                return 11;
            }
            case "twelve" -> {
                return 12;
            }
        }
        return 0;
    }

    public static String uniqueSubstring(String string) {
        String maxSubString = "" + string.charAt(0);
        String currentSubString = "" + string.charAt(0);
        for (int i = 1; i < string.length(); i++){
            String element = String.valueOf(string.charAt(i));
            if (!currentSubString.contains(element)){
                currentSubString += element;
                if (currentSubString.length() > maxSubString.length()){
                    maxSubString = currentSubString;
                }
            }
            else {
                currentSubString = element;
            }
        }
        return maxSubString;
    }
    public static int shortestWay(int[][] matrix) {
        int n = matrix.length;

        int[][] newMatrix = new int[n][n];
        newMatrix[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++){
            newMatrix[i][0] =  newMatrix[i - 1][0] + matrix[i][0];
            newMatrix[0][i] =  newMatrix[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j < n; j++){
                newMatrix[i][j] = matrix[i][j] + Math.min(newMatrix[i - 1][j], newMatrix[i][j - 1]);
            }
        }
        return newMatrix[n - 1][n - 1];
    }
    public static String numericOrder(String string) {
        String[] words = string.split(" ");
        String[] newString = new String[(words.length)];
        for (String word: words){
            for (int i = 1; i < words.length + 1; i++){
                String num = Integer.toString(i);
                if (word.contains(num)){
                    newString[i-1] = word.replace(num, "");
                    break;
                }
            }
        }
        return String.join(" ",newString);
    }

    public static int switchNums(int num1, int num2) {
        int[] firstNum = Stream.of(Integer.toString(num1).split("")).mapToInt(Integer::parseInt).toArray();
        int[] secondNum = Stream.of(Integer.toString(num2).split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(firstNum, 0, firstNum.length);
        for (int i = firstNum.length-1; i >= 0; i--){
            for (int j = 0; j < secondNum.length; j++){
                if (firstNum[i] > secondNum[j]){
                    secondNum[j] = firstNum[i];
                    break;
                }
            }
        }
        int number = 0;
        for (int i = 0; i < secondNum.length; i++){
            number += (int) (secondNum[i] * Math.pow(10, secondNum.length - i - 1));
        }
        return number;
    }
}
