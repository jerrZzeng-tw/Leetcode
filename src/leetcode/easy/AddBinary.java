package leetcode.easy;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        int index_a = a.length() - 1;
        int index_b = b.length() - 1;
        boolean carry = false, c_a, c_b;

        StringBuffer sb = new StringBuffer();
        while (index_a >= 0 || index_b >= 0) {
            c_a = false;
            if (index_a >= 0) {
                c_a = ('1' == a.charAt(index_a));
            }
            c_b = false;
            if (index_b >= 0) {
                c_b = ('1' == b.charAt(index_b));
            }

            if (carry && c_a && c_b) {
                sb.append('1');
            } else if (carry && (c_a || c_b)) {
                sb.append('0');
            } else if (carry) {
                sb.append('1');
                carry = false;
            } else if (c_a && c_b) {
                sb.append('0');
                carry = true;
            } else if (c_a || c_b) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            index_a--;
            index_b--;
        }
        if (carry) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
