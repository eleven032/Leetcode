
/*
这道题是Search in Rotated Sorted Array的扩展，思路在Find Minimum in Rotated Sorted Array中已经介绍过了，
和Find Minimum in Rotated Sorted Array唯一的区别是这道题目中元素会有重复的情况出现。
不过正是因为这个条件的出现，影响到了算法的时间复杂度。原来我们是依靠中间和边缘元素的大小关系，来判断哪一半是不受rotate影响，仍然有序的。
而现在因为重复的出现，如果我们遇到中间和边缘相等的情况，我们就无法判断哪边有序，因为哪边都有可能有序。
假设原数组是{1,2,3,3,3,3,3}，那么旋转之后有可能是{3,3,3,3,3,1,2}，或者{3,1,2,3,3,3,3}，这样的我们判断左边缘和中心的时候都是3，
我们并不知道应该截掉哪一半。解决的办法只能是对边缘移动一步，直到边缘和中间不在相等或者相遇，这就导致了会有不能切去一半的可能。
所以最坏情况就会出现每次移动一步，总共移动n此，算法的时间复杂度变成O(n)。代码如下：
*/



public int findMin(int[] num) {  


	//做边际测试
    if(num == null || num.length==0)  
        return 0;  


    //设置左右指针
    int left=0;
    int right=nums.length-1;
 
 	//进入循环，直到两边的指针相遇
    while(left<=right){

    	//动态更新中简点
        int mid = (left+right)/2;


        //当中间点与target相同时，说明找到了
        if(nums[mid]==target)
            return true;
 		


 		//当左端点<中间点，说明这一段是有序的
        if(nums[left]<nums[mid]){

        	//这是判断target是否在此区间
        	//当在此左区间时，重置左右端点，用来下一次寻找
            if(nums[left]<=target&& target<nums[mid]){
                right=mid-1;

            //当在另一边的区间里时，设置右区间为下次寻找的区间
            }else{
                left=mid+1;
            }


        //当左端点>中间点时，说明中间点以右的区间是有序的
        }else if(nums[left]>nums[mid]){

        	//判断target是否在右边区间，因为是有序的找起来方便
            if(nums[mid]<target&&target<=nums[right]){
            	//在右边找
                left=mid+1;


            //在左边
            }else{
            	//去左边区间找
                right=mid-1;
            }


        //当左端点与中间点相同，说明找到了dup
        }else{
        	//左移动一位，继续找
            left++;
        }    
    }
 	

 	//找完一遍，啥都没有，false
    return false;

}  