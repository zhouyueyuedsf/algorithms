package niuke.string;

/**
 * @author zhouyueyue1
 *
 */
public class 第一个只出现一次的字符 {
	public int FirstNotRepeatingChar(String str) {
		int[][] hash = new int[60][2];

		int len = str.length();
		for(int i = 0; i < len; i++){
			char c = str.charAt(i);
			if(hash[c - 65][0] == 0){
				hash[c - 65][0] = c;
			} else {
				hash[c - 65][1] = c;
			}
		}
		int pos = -1;
		for (int i = 0; i < len; i++){
			char c = str.charAt(i);
			if(hash[c - 65][1] == 0){
				pos = i;
				break;
			}
		}
		return pos;
	}
	public static void main(String[] args) {
		第一个只出现一次的字符 run = new 第一个只出现一次的字符();
		String str = "aaadsEdagaaads";
		System.out.println(run.FirstNotRepeatingChar(str));
	}
}
