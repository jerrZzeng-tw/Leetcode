package leetcode.easy;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            sum *= 26;
            sum += columnTitle.charAt(i) - 64;
        }
        return sum;
    }

}
