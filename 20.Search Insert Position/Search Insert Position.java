/*
O(logn)
排序数组

一切都在提示你使用二分法查找


本题是基本考察二分查找的题目，与基本二分查找方法不同的地方是，二分查找法当查找的target不在list中存在时返回-1，而本题则需要返回该target应在此list中插入的位置。 

当循环结束时，如果没有找到target，那么low一定停target应该插入的位置上，high一定停在恰好比target小的index上。 

[1,3,5,6], 7

low = 0, high = 3

step1: mid = 1

          A[mid] = 3, 3<7

          low = mid + 1 = 2

 

low = 2, high = 3

step2: mid = 2

          A[mid] = 5, 5<7

         low = mid + 1 = 3

 

low = 3, high = 3

step3: mid = 3

          A[mid] = 6, 6<7

          low = mid + 1 = 4 



low = 4, high = 3

return low = 4; 

 

 [1,3,5,6], 0

low = 0, high = 3

step1: mid = 1

          A[mid] = 3, 3>0

          high = mid - 1 = 0

 

low = 0, high = 0

step2: mid = 0

          A[mid] = 1, 1>0

          high = mid - 1 = -1

 

low = 0, high = -1

return 0 
*/





class Solution {
    public int searchInsert(int[] nums, int target) {

    	//边际测试
        if(A == null||A.length == 0)
            return 0;


        //二分法查找
        int low = 0, high = A.length-1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            

            //当中间值>target
            if(A[mid] > target)
            	//说明插入点在左半边，继续查找
                high = mid - 1;

            //<
            else if(A[mid] < target)
            	//右半边，继续查找
                low = mid + 1;
            else
            	//==时，找到了这个值，那就返回其位置
                return mid;
        }
        
        //当循环结束时，如果没有找到target，那么low一定停target应该插入的位置上，high一定停在恰好比target小的index上
        //看上面的范例
        return low;
    }
}