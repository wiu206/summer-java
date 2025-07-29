import java.util.*;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int bitmask = checkPalindromeBits(line.toLowerCase(), 0);

        if (bitmask == 0 || (bitmask & (bitmask - 1)) == 0) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }

    static int checkPalindromeBits(String s, int mask) {
        if (s.isEmpty()) return mask;
        char c = s.charAt(0);
        if (Character.isLetter(c)) {
            int pos = c - 'a';
            mask ^= (1 << pos); // flip bit
        }
        return checkPalindromeBits(s.substring(1), mask);
    }
}
