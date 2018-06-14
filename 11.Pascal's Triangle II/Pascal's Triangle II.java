// 这一题的要求就是只用一行的空间来存储结果而不需要额外的来存储上一行！！！
// use only O(k) extra space

/*
首先了解一下，只用一行得到下一行的结果是如何实现的

现在，我们需要计算下一行，而我们拥有当前行
[a,b,c,d......]

我们知道除了第一和最后一位与之前相同，剩下的元素为：
i从1 to（length-2)
当前行[i] = 前一行[i]+前一行[i+1]

***************************************
当得到新的行的元素时，我们要写入此行的对应位置，这时会发生一个问题
上一行的元素会被覆盖掉，而这个覆盖掉的元素还要用来做下一个元素的计算，不行

所以，我们从右往左计算，反向计算
这样就变成了   前一行[i] + 前一行[i-1]


*/






class Solution {
    public List<Integer> getRow(int rowIndex) {

    	//首先，创建一个初始list
       	ArrayList<Integer> res = new ArrayList<Integer>();  
	   	
       	//玩蛋去吧，没空陪你玩
	   	if(rowIndex<0)   
	     	return res;  


	    //通过边际测试，直接先确定第一个元素1
	   	res.add(1);  


	   	//进入循环，在没到K行之前一直移动
	   	for(int i=1;i<=rowIndex;i++){  

	   		//里循环用来遍历之前一行的list，做新一行的元素计算
	       	for(int j=res.size()-2;j>=0;j--){

	       		//设置新行的元素  
	           	res.set(j+1,res.get(j)+res.get(j+1));  
	       	}  

	       	//添加尾元素
	       	res.add(1);  
	   	}  
	   	return res;   
    }
}