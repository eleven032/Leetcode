public class Solution {
    public int removeElement(int[] A, int elem) {
        //i 用来遍历
        int i;

        //j 用来记录
        int j;

        //循环遍历
        for(i=0;i<A.length;i++) {
            //如果当前元素与指定删除元素相同
            if(A[i] == elem) {
                continue；//走下一个元素
            }    

            //当当前元素不同时，记录这个值
            A[j]=A[i];
            //同时j移动一位
            j++;
        }

        return j;
    }
}