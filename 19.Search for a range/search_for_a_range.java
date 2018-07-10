/*
从题目中获取到关键字：sorted array ，find...position, a given target value, O(logn). 

这些关键字都在提醒我们这道题的思路应该是二分查找法。 

第一步，在给定数组中找到该target，记录该位置。
这时我们并不关心这个target是边界还是中间值，我们只需确定，在数组中是能够找到这样一个target值。如果找不到返回{-1，-1}。
为了保证时间复杂度是O(logn), 这里自然而然使用传统二分查找法实现。

第二步，确定该target的右边界。
此时我们将对数组从刚才确定的那个target的pos作为起始点，到数组结束，来确定右边界。
同样是使用二分查找法，当新的mid值仍然等于target值时，我们能确定该mid左半边（到pos）都是等于target，继续在右半边查找。如果新的mid值不等于target值，我们就知道右边界一定在新mid值的左半边，继续查找。
最后新的high指针指向的就是右边界的位置。

第三步，确定该target的左边界。这一步与第二步对称操作，最后新的low指针指向的就是左边界的位置。


*/



public int[] searchRange(int[] A, int target) {

		//先确定默认值
        int [] res = {-1,-1};

        //初步边际测试
        if(A == null || A.length == 0)
            return res;
        
        //先用二分法查找到一个target值，得到其位置
        int low = 0;
        int high = A.length-1;
        int pos = 0;
        while(low <= high){
            int mid = (low + high)/2;
            pos = mid;
            if(A[mid] > target)
                high = mid - 1;
            else if(A[mid] < target)
                low = mid + 1;
            else{
                res[0] = pos;
                res[1] = pos;
                break;
            }
        }
        


        //如果找不到，自然就返回默认值
        if(A[pos] != target)
            return res;
        
        //第二次二分法查找，确定右边界

        //从之前找到的位置开始，只对右边的target进行二分法查找

        //新的起始点为当时的pos
        int newlow = pos;

        //终点为数组尾端
        int newhigh = A.length-1;

        //二分法查找循环，当两个pointer相遇，表示当前high指针指向了range最尾端

        //low指针一直是指着target的，所以当右端点与low相遇，自然就是range右端点
        while(newlow <= newhigh){
            int newmid = (newlow+newhigh)/2;

            //找到了的话继续向右查找
            if(A[newmid] == target)
            	//不断更新起始点
                newlow = newmid + 1;
            else
            	//找不到，这表明range的右端点在这一段数组的左边，所以更新最尾端
                newhigh = newmid - 1;
        }
        res[1] = newhigh;
        
        //再一次二分法查找左端点，与上面相反即可
        newlow = 0;
        newhigh = pos;
        while(newlow <= newhigh){
            int newmid = (newlow+newhigh)/2;
            if(A[newmid] == target)
                newhigh = newmid - 1;
            else
                newlow = newmid + 1;
        }
        res[0] = newlow;
        
        return res;
    }