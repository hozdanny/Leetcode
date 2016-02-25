package Solution;

import java.util.Arrays;

public class S005_LongestPalindrome {
    public String longestPalindrome(String s) {
        int length = s.length();
        int index = 0;
        int maxLength = 0;
        StringBuffer buffer = new StringBuffer();
        buffer.append('^');
        for (int i = 0; i < length; i++) {
            buffer.append('#');
            buffer.append(s.charAt(i));
        }
        buffer.append("#$");
        length = buffer.length();
        System.out.println("the original string: " + s);
        System.out.println("the modified string:" + buffer.toString());
        //maxBoundary:最大回文字的边界 即系 center+P[center]
        //center:最大回文字子串的中心位置
        int maxBoundary = 0;
        int center = 0;
        int[] p = new int[length];
        Arrays.fill(p, 0);
        System.out.println(Arrays.toString(p));
        for (int i = 1; i < length - 1; i++) {
            //如果边界小于当前位置,说明此位置还在最长回文字串中, 则此位置的最长字符串中心对称位置 与 最大回文字中的堆成位置 取最小值.
            //如果边界大于当前位置,则赋值0,在下一步中比较对称位计算p值.
            p[i] = (maxBoundary > i) ? Math.min(p[2 * center - i], maxBoundary - i) : 0;
            System.out.print("mx: " + maxBoundary + "|  " + "i: " + i + "|  " + "center: " + center + "|  ");
            while (buffer.charAt(i + 1 + p[i]) == buffer.charAt(i - 1 - p[i])) {
                //当两边对称位置的符号相等,p++
                p[i]++;
            }
            //如果中心位置索引+最长回文长度大于mx,则这是到此为止发现的最长回文,更新mx和中心id索引
            if (i + p[i] > maxBoundary) {
                center = i;
                maxBoundary = i + p[i];
            }
            //更新最长长度记录
            if (p[i] > maxLength) {
                index = i;
                maxLength = p[i];
            }
            System.out.println(i + ": " + Arrays.toString(p));
        }
        index = (index - maxLength - 1) / 2;
        return s.substring(index, index + maxLength);
    }

    public static void main(String[] args) {
        S005_LongestPalindrome lp = new S005_LongestPalindrome();
        String testString = "dfsdsfe";
        String s = lp.longestPalindrome(testString);
        System.out.print(s);
    }
}
