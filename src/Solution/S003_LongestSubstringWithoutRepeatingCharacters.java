package Solution;

import java.util.Arrays;

public class S003_LongestSubstringWithoutRepeatingCharacters {
	/*
	 * 假设子串里含有重复字符，则父串一定含有重复字符。
	 */
	public int lengthOfLongestSubstring(String s) {
		// 一共有256个ASCII code
		boolean[] hash = new boolean[256];
		//对所有元素赋值false
		Arrays.fill(hash, false);
		int n = s.length();
		if (n <= 1) {
			return n;
		}
		
		int start = 0, end = 0, result = 0;
		while (end <= n && start + result < n) {
			if (hash[s.charAt(end)] == false) {
				//如果此字符之前没出现过，就把它数组里面的值改成ture，即遇见过
				//先赋值，end再自增
				hash[s.charAt(end++)] = true;
			} else {
				//如果此字符之前出现过，就改回来
				//先赋值，start再自增
				hash[s.charAt(start++)] = false;
			}
			result = Math.max(end - start, result);
		}
		return result;
	}

	// test
	public static void main(String[] args) {
		S003_LongestSubstringWithoutRepeatingCharacters ls = new S003_LongestSubstringWithoutRepeatingCharacters();
		System.out.println(ls.lengthOfLongestSubstring("abcabaderf"));
	}
}
