package leetcode.easy;

public class ReverseBits {

    public static void main(String[] args) {
        int n = -100;

        System.out.println(n + " in binary is " + toBinaryString(n));
        System.out.println("On reversing bits " + toBinaryString(reverseBits(n)));
    }

    // 反轉給定整數位的函數
    public static int reverseBits(int n) {
        int pos = Integer.SIZE - 1;     // 保持移位
        // 存儲 `n` 的反轉位。最初，所有位都設置為 0
        int reverse = 0;

        // 直到處理完所有位
        while (pos >= 0 && n != 0) {
            // 如果當前位為1，則設置結果中對應的位
            if ((n & 1) != 0) {
                reverse = reverse | (1 << pos);
            }

            n >>= 1;                    // 刪除當前位(除以 2)
            pos--;                      // 將移位減 1
        }

        return reverse;
    }

    public static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n)).replaceAll(" ", "0");
    }


}
