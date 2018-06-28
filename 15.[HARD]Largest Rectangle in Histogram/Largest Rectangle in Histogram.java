/*目前第一道hard题，有点小兴奋
要求找到最大方块面积


根据stack的解决方案

中心思想：
数组给出的高度是无序的，
所以，当我们线性遍历时会遇到不同的高度
当遇到比上次高度大的高度时，把index push进stack，同时在此if条件下推进index
当遇到比上次高度小的高度时，a.pop出peek值，计算出当前height*(当前i-之前相关联的stack peek)，并判断是否是最大面积
						 b. 此时i在此if条件下并不会推进，而是继续和当前peek值做比较（a步骤已经pop出前一个值），只要h【peek】比当前h[i]大，就会计算最新的(长×宽)记得此时的宽会变化，下有链接查看
						 c. .....
						 d......
						不断计算递减height的面积（宽度不断增大），直到遇到比当前高度要小的高度
						另外每一次pop都会永久pop掉，所以stack中index对应的高度永远是递增的不会出现【1，5，6，2，3】
						只会出现【1，2，3】，其中5和6已在上次计算中被pop出去，与链接结合理解


详解：
https://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html 

*/

class Solution {
    public int largestRectangleArea(int[] height) {
    	//创建一个stack数据结构，后进先出
        Stack<Integer> stack = new Stack<Integer>();


        int i = 0;

        //初始化最大面积值为0
        int maxArea = 0;


        //创建一个用来存放所有高度的数列
        int[] h = new int[height.length + 1];


        //将原数组赋值到新数组
        h = Arrays.copyOf(height, height.length + 1);




        //进入循环，当i<新数组长度，不断更新
        while(i < h.length){


        	//********stack.peek查找的是当前stack顶部值，也即是上一个循环push进去的值×××××××××
        	//1.当stack是空的时候，第一个放进去的i
        	//2.当上一个height<=当前height
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){

            	//先把当前index push入stack，然后index前进一位
                stack.push(i++);


            //当上一个height>前height时
            }else {

            	//创建t用来临时保存stack中顶部的index，
            	//同时将这个index 从stack中移出，此时stack顶部是上上次push进去的值
                int t = stack.pop();


                //更新最大面积
                //详细思路见顶部
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}