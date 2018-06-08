public class Solution {
    public int removeDuplicates(int[] A) {
    	//边际测试
        if(A.length == 0 || A == null)
            return 0;
        
        //设定最低长度为1，上面已经检查了长度为0的情况，所以这里从1开始
        int len = 1;

        //用index来遍历数组，从数组第二个元素开始
        for(int index = 1; index < A.length; index++){

        	//但前元素如果和前一个元素不同
            if(A[index] != A[index-1]){

            	//又，当前元素和记录元素不同
                if(A[index] != A[len])

                	//记录当前元素，用来和下一个元素做比较，目的是用来更新当前的值
                    A[len] = A[index];

                //len+1
                len++;
            }
        }
        return len;
    }
    
}