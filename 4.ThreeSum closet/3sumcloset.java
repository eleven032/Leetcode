class Solution {
    public int threeSumClosest(int[] nums, int target) {

    	//设定初始最小值，其实就是一个大的数
        int closest = INT_MAX;  

        //返回值
        int res = 0;  

        //排序，还是那句话，可以递减的寻找
        sort(num.begin(), num.end());  
  
  		//外循环，从第一个数开始
        for (int i = 0; i < num.size(); i++)  
        {  
        	//内循环，从i的下一个数开始，另一个pointer从最尾端开始，向中间靠拢
            for (int j = i+1, k = num.size()-1; j < k; )  
            {  
            	//算出当前的和
                int sum = num[i]+num[j]+num[k];  

                //有种情况是直接得到target值，直接结束，都相同了还找个屁
                if (sum == target) return sum;  


                //算出当前差值
                int t = abs(sum-target);  
  				
  				//如果当前差值小于前一个差值，则此为当前最小
                if (t<closest)  
                {  
                	//分别记录两个值
                    res = sum;  
                    closest = t;  
                }  

                //如果比前一个差值大，有两种情况

                //a.和小于目标值，左边指针前进
                if (sum < target) j++;  

                //b.和大于目标值，右边指针后退
                else if (sum > target) k--;  
            }  

            //避免重复，跳过相同的值
            while (i < num.size() && num[i] == num[i+1]) i++;  
        }  
        return res;  
    }
}