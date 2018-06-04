class Solution {
    //数组是一条乱序的数值数组，装水是指任意数组的2个元素拉一条到X轴的垂线，得到两条边，与X轴组成一个容器
    public int maxArea(int[] height) {

        //设置两个pointer，分别从数组两端起始
        int left = 0;
        int right = height.length-1;

        //设定max初始值
        int max = 0;

        //做一个循环，不断尝试不同的最短边得到的面积，
        //循环跳出条件为，但如果两个pointer相遇时
        while (left < right) {

            //每次计算新的边组合成的面积
            //出现更大值时不断更新
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            //当左边为较小边时，移动左边，反之亦然
            if (height[left] < height[right]) {                
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}