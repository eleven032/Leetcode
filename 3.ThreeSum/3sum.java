
public List<List<Integer>> threeSum(int[] nums) {  

    //先定义返回值
    List<List<Integer>> ret = new ArrayList<>();  
    

    //边际测试，啥都没有还来骗我，滚蛋
    if (nums == null || nums.length < 3)  
        return ret;  


    int len = nums.length;  

    //排序对我们很重要，排好序我们可以以递减的方式不断缩小下次要查找的数量
    Arrays.sort(nums);  




    // 注意，对于 num[i]，寻找另外两个数时，只要从 i+1 开始找就可以了。  
    // 这种写法，可以避免结果集中有重复，因为数组时排好序的，  
    //所以当一个数被放到结果集中的时候，其后面和它相等的直接被跳过。  
    for (int i = 0; i < len; i++) {  
        // 可省，目的减少无意义的循环，因为必须是负数开始
        if (nums[i] > 0)  
            break;


        // 避免重复！！！！  可以避免【-2，-2，-2，0......】-2被读取3次，而是直接跳过第2，3 个-2，到0那里
        if (i > 0 && nums[i] == nums[i - 1])  
            continue;  //continue用法，符合条件则不执行当次循环的剩下循环内语句，而是回到最初的起点，进入第（i+1）次循环

        // 找寻算法的起始点永远是当前数的后一个开始
        //这里定义左右两个起始点，向中间推进
        int begin = i + 1;  
        int end = len - 1;  


        //内循环，用来查找符合的（a+b）
        while (begin < end) {  

            int sum = nums[i] + nums[begin] + nums[end];  
            
            //找到了，加入数组，然后滚去找下一个
            if (sum == 0) {  
                List<Integer> list = new ArrayList<>();  
                list.add(nums[i]);  
                list.add(nums[begin]);  
                list.add(nums[end]);  
                ret.add(list);  

                //begin没什么好说的，继续找下一个可能的数
                begin++;  
                //因为begin变大了，相应的end往小的找
                end--;  

                // 避免重复！！！！ 
                while (begin < end && nums[begin] == nums[begin - 1])  
                    begin++;  
                while (begin < end && nums[end] == nums[end + 1])  
                    end--;  

            } else if (sum > 0)  //>0代表右边的过大
                end--;  
            else  //<0代表左边过小
                begin++;  
        }  //循环下去
    }  
    return ret;  
}  
