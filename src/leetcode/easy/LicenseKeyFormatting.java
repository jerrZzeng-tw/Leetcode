package leetcode.easy;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (count == k) {
                sb.append('-');
                count = 0;
            }
            if ('-' != c) {
                sb.append(Character.toUpperCase(c));
                count++;
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
