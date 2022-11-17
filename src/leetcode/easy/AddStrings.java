package leetcode.easy;

public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }

    public static String addStrings(String a, String b) {
        int index_a = a.length() - 1;
        int index_b = b.length() - 1;
        int ca = 0;

        StringBuffer sb = new StringBuffer();
        while (index_a >= 0 || index_b >= 0 || ca > 0) {
            int sum = 0;
            if (index_a >= 0) {
                sum += a.charAt(index_a) - '0';
            }
            if (index_b >= 0) {
                sum += b.charAt(index_b) - '0';
            }
            sum += ca;
            sb.append(sum % 10);
            ca = sum / 10;
            index_a--;
            index_b--;
        }

        return sb.reverse().toString();
    }
}
