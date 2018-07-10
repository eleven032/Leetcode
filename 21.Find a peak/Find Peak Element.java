/*
于题目中说明了局部峰值一定存在，那么实际上可以从第二个数字开始往后遍历，如果第二个数字比第一个数字小，说明此时第一个数字就是一个局部峰值；
否则就往后继续遍历，现在是个递增趋势，如果此时某个数字小于前面那个数字，说明前面数字就是一个局部峰值，返回位置即可。
如果循环结束了，说明原数组是个递增数组，返回最后一个位置即可，参见代码如下：

nums[-1] = nums[n] = -∞
*/



class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) 
            	return i - 1;
        }
        return nums.length - 1;
    }
}