/*
将数组求和再减去现有数组


*/

class Solution {
    public int missingNumber(int[] nums) {
    	//初始值为长度，相对来说这是一个完整的有序数列，不缺任何数字
        int ret = nums.length;

        //进入循环，遍历这个相对有序函数组
        for (int i = 0; i < nums.length; i++) {

        	//对差值进行累加，最后得到缺失数字，已验证
            ret += (i - nums[i]);
        }
        return ret;

    }
}