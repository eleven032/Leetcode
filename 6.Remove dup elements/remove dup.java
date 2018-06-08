public class Solution {
    public int removeDuplicates(int[] A) {

        //边际测试
        if (A.length < 2) {
            return A.length;
        }
        
        
        //设定两个指针，一前一后
        int j = 0;
        int i = 1;
     

        //后指针只要小于总长，不断循环
        while (i < A.length) {


            //如果出现相邻重复元素
            if (A[i] == A[j]) {
                //后指针后移一位，继续走循环
                i++;

            //不相等
            } else {

                //前指针后移一位
                j++;

                //将j所在位置覆盖为新元素
                A[j] = A[i];

                //后指针后移一位
                i++;
            }
        }
     
        //返回值
        return j + 1;
    }
}