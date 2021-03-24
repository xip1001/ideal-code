import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * @author xip
 *
 */
public class Test01 {
	
	 public static int[] twoSum(int[] nums, int target) {
		 Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		 for(int i=0;i<nums.length;i++){
			 int a=target-nums[i];
			 if(map.containsKey(a)){ //判断map集合中是否存在元素a
				 return new int[]{map.get(a),i};
			 }
			 map.put(nums[i], i);
		 }
		return new int[]{};
	 }

	public static void main(String[] args) {
		int [] nums=new int[]{2,7,11,15};
		int target=9;
		int[] arr=twoSum(nums,target);
		for(int i:arr){
			System.out.print(i+" ");
		}

	}

}
