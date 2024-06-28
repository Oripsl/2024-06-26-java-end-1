package _2806esercizipomeriggio;

import java.util.Comparator;
import java.util.List;

public class Streams {
    public static List<String> filterStrings(List<String> stringhe, Character charToFilter) {
        return stringhe.stream().filter(str -> str.startsWith(String.valueOf(charToFilter))).toList();
    }

    public static List<Integer> squareNums(List<Integer> nums) {
        return nums.stream().map(num -> num * num).toList();
    }

    public static boolean findEvenNum(List<Integer> nums) {
        return nums.stream().anyMatch(num -> (num & 2) == 0);
    }

    public static Double sumNums(List<Double> nums) {
        return nums.stream().reduce(Double::sum).orElse(null);
    }

    public static List<String> revAlphabeticalOrder(List<String> strs) {
        return strs.stream().sorted(Comparator.reverseOrder()).toList();
    }
}
