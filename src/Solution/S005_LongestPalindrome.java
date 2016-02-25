package Solution;

public class S005_LongestPalindrome {
	public String longestPalindrome(String s) {
		int length = s.length();
		int index = 0;
		int maxLength = 0;
		StringBuffer buffer = new StringBuffer();
		for(int i =0;i<length;i++){
			buffer.append('#');
			buffer.append(s.charAt(i));
		}
		buffer.append("#$");
		length = buffer.length();
		
		return null;
	}
}
