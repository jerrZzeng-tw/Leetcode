package leetcode.easy;

public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
    }

    public static int hammingWeight(int n) {
        int pos = Integer.SIZE - 1;     // 保持移位
        // 存儲 `n` 的反轉位。最初，所有位都設置為 0
        int count = 0;

        // 直到處理完所有位
        while (pos >= 0 && n != 0) {
            // 如果當前位為1，則+1
            if ((n & 1) != 0) {
                count++;
            }

            n >>= 1;                    // 刪除當前位(除以 2)
            pos--;                      // 將移位減 1
        }

        return count;
    }

}
