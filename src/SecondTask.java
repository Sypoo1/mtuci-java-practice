import java.util.Arrays;

public class SecondTask {
    public static void main(String[] args){

        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println(" ");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println(" ");
        int[] firstArray = {44, 32, 86, 19};
        int[] secondArray = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(firstArray));
        System.out.println(differenceEvenOdd(secondArray));
        System.out.println(" ");
        firstArray = new int[] {1, 2, 3, 4, 5};
        secondArray = new int[] {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(firstArray));
        System.out.println(equalToAvg(secondArray));
        System.out.println(" ");
        firstArray = new int[] {1, 2, 3};
        secondArray = new int[] {3, 3, -2, 408, 3, 31};
        System.out.println(Arrays.toString(indexMult(firstArray)));
        System.out.println(Arrays.toString(indexMult(secondArray)));
        System.out.println(" ");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println(" ");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println(" ");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println(" ");
        System.out.println(botHelper("help"));
        System.out.println(botHelper("I am helper"));
        System.out.println(" ");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

    public static boolean duplicateChars(String word){
        word = word.toLowerCase();
        String[] arrayOfLetters = word.split("");
        boolean result = false;
        int lengthOfWord = arrayOfLetters.length;
        for (int i = 0; i < lengthOfWord; i++){
            if (result)
                break;

            for (int j = i+1; j < lengthOfWord; j++) {
                if (arrayOfLetters[j].equals(arrayOfLetters[i])){
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

    public static int differenceEvenOdd(int[] array){
        int odd = 0;
        int even = 0;
        for (int element : array) {
            if (element % 2 == 0)
                even += element;
            else
                odd += element;
        }
        return even > odd ? (even-odd) : (odd-even);
    }

    public static boolean equalToAvg(int[] array){
        int summa = 0;
        for (int element : array){
            summa += element;
        }
        double avg = (double) summa / (double) array.length;
        boolean result = false;
        for (int element : array){
            if (element == avg) {
                result = true;
                break;
            }
        }
        return result;
    }
    public static int[] indexMult(int[] array){
        int lengthOfArray = array.length;
        int[] newArray = new int[lengthOfArray];
        for (int index = 0; index < lengthOfArray; index++){
            newArray[index] = array[index] * index;
        }
        return newArray;
    }
    public static String reverse(String string){
        int lengthOfString = string.length();
        char[] arrayOfChars = new char[lengthOfString];
        string.getChars(0, lengthOfString, arrayOfChars, 0);
        String result = "";
        for (int index = lengthOfString - 1; index >= 0; index--){
            result = result + arrayOfChars[index];
        }
        return result;
    }
    public static int Tribonacci(int number){
        if (number == 1 || number == 2)
            return 0;
        else if (number == 3)
            return 1;
        int firstNumber = 0;
        int secondNumber = 0;
        int thirdNumber = 1;
        int buffer;
        for (int index = 4; index <= number; index++){
            buffer = firstNumber + secondNumber + thirdNumber;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
            thirdNumber = buffer;
        }
        return  thirdNumber;
    }

    public static String pseudoHash(int length){
        String alphabet = "abcdef0123456789";

        String result = "";
        for (int index = 0; index < length; index++){
            result = result + alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return result;
    }
    public static String botHelper(String string) {
        string = string.toLowerCase();

        int index = string.indexOf("help");
        if (index == -1) {
            return "Keep waiting";
        }

        for (char firstLetter = 65; firstLetter <= 90; firstLetter++) {
            String newString = (firstLetter + "help").toLowerCase();
            if (string.contains(newString)) {
                return "Keep waiting";
            }
        }
        for (char secondLetter = 65; secondLetter <= 90; secondLetter++) {
            String newString = ("help" + secondLetter).toLowerCase();
            if (string.contains(newString)) {
                return "Keep waiting";
            }
        }
        return "Calling for a staff member";
    }

    public static boolean isAnagram(String firstString, String secondString){

        int firstLengthOfString = firstString.length();
        int secondLengthOfString = secondString.length();

        if (firstLengthOfString != secondLengthOfString)
            return false;

        char[] firstArrayOfChars = new char[firstLengthOfString];
        firstString.getChars(0, firstLengthOfString, firstArrayOfChars, 0);
        Arrays.sort(firstArrayOfChars);


        char[] secondArrayOfChars = new char[secondLengthOfString];
        secondString.getChars(0, secondLengthOfString, secondArrayOfChars, 0);
        Arrays.sort(secondArrayOfChars);

        boolean result = true;
        for (int index = 0; index < firstLengthOfString; index++){
            if (firstArrayOfChars[index] != secondArrayOfChars[index]) {
                result = false;
                break;
            }

        }
        return result;

    }
}
