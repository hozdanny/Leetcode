package Solution;
import java.util.HashMap;

public class S001_TwoSum {
	public int[] twoSum(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i<nums.length; i++){
			int defference = target - nums[i];
			if(map.get(defference)!=null){
				return new int[]{map.get(defference),i};
			}else{
				map.put(nums[i], i);
			}
		}
		return null;
	}
	
	//test
	public static void main(String[] args){
		S001_TwoSum twoSum = new S001_TwoSum();
		int[] i = twoSum.twoSum(new int[]{2,7,11,15}, 26);
		for(int num:i){
			System.out.print(num);
		}
	}
}
