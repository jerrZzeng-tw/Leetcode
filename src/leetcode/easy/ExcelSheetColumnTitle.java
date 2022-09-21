package leetcode.easy;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle_best(701));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int col = (columnNumber % 26);
            columnNumber = columnNumber / 26;
            if (col == 0) {
                col = 26;
                columnNumber--;
            }
            sb.append((char) (col + 64));

        }
        return sb.reverse().toString();
    }

    public static String convertToTitle_best(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            --n;
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }

        return sb.reverse().toString();
    }
}
