public class Solution {
    public int removeDuplicates(int[] A) {

        //边际测试，传进来个null，或者没元素玩个屁啊
        if (A == null || A.length == 0) {
            return 0;
        }
        

        //声明起始的返回值
        int size = 0;

        //用单指针循环遍历
        for (int i = 0; i < A.length; i++) {

            //当前array元素与A[size]不同时，进入如下循环
            if (A[i] != A[size]) {


                //
                A[++size] = A[i];
            }
        }
        return size + 1;
    }
}