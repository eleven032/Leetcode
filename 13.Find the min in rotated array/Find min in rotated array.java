
//O(log(n)


// num[mid]有两种可能性，
// 如果num[mid] > num[high]，证明num[mid]在rotated后的那个区间内，
// 这个区间我们刚才已知都大于pivot之前的值，所以最小值就在low=mid+1那个区间内。
// 另一种可能，num[mid] <= num[high]，那么我们刚才可以看出来这种可能性说明mid~high以及是排好序的，那么最小值在high=mid这个区间内（mid可能是最小值）。
// 依据此判断可以找到最小值。


class Solution {
    public int findMin(int[] nums) {

    	//首先定义两个pointer， 分别指向头和尾
        int low = 0, high = num.length - 1;

        //进入循环
        //当头index<尾index：意思就是数组还没走完
        //当头元素>尾元素：说明还没到达rotated点
        while (low < high && num[low] >= num[high]) {
        	//采取二分法查找

        	//更新中间值
            int mid = (low + high) / 2;

            //当最新的中间值>当前尾元素：说明还没到最小值，
            //××××××××此时最小值必然在这个mid后面的那一片区域中
            if (num[mid] > num[high])

            	//得到最新的头值，然后继续寻找
                low = mid + 1;
            else

            	//但最新值<=当前尾元素：说明我们在一片已经拍好序的区域里，说明最小值在他的左侧区域
            	//得到最新尾值，
                high = mid;
        }

        //得到最小值
        return num[low];
    }
}