class Solution {
	public boolean hasDuplicate(int[] nums) {
		ArrayList<Integer> tmp = new ArrayList<>();

		for (int num : nums) {
			if (tmp.contains(num))	
				return true;
			tmp.add(num);
		}
		return false;
	}
}