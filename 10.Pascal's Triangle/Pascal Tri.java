/*
要得到一个帕斯卡三角， 我们只需要找到规律即可。
	第k层有k个元素
	每层第一个以及最后一个元素值为1
	对于第k（ k > 2）层第n（ n > 1 && n < k）个元素A[k][n]，A[k][n] = A[k-1][n-1]+ A[k-1][n]
*/



// f(1, n)=1，(n>0) 
// f(1, 2)=1，(n=2) 
// f(i,j) = f(i-1, j-1)+f(i, j-1)，i>2,j>2 


class Solution {
    public List<List<Integer>> generate(int numRows) {
    	//这个数据型式为【[]】list里面嵌套很多个list


    	//边际测试
        if (numRows < 0) {
            return null;
        }

        //创建一个二维数组，用来创建存储三角
        List<List<Integer>> list = new ArrayList<>();


        //第一个情况：当给定行数>=1,

        if (numRows >= 1) {//记住必须使用>=，这样才能不忽略起始的两层

        	//创建一个数组，作为三角的顶尖层使用
            List<Integer> data = new ArrayList<>();
            data.add(1);//做了一个[1]
            list.add(data);//添加到外结构中
        }

        if (numRows >= 2) {//记住必须使用>=，这样才能不忽略起始的两层
            List<Integer> data = new ArrayList<>();
            data.add(1);
            data.add(1);
            //做了一层[1,1]
            //将其添加到外结构中
            list.add(data);
        }

        //这时确定层数>=3，而上面的两个条件保证了顶部两层已被构建
        if (numRows >=3) {

        	//进入循环，从3开始，跳出条件为<=给定总层数
            for (int i = 3; i <=numRows; i++) {


            	//创建一个[]来构建本层
                List<Integer> data = new ArrayList<>();


                //提取上上层
                List<Integer> prev = list.get(i - 2);

                //首先，我们可以确定的是每层最左为1，添加1
                data.add(1);


                //进入单层构建循环，从第二个元素开始，跳出条件为外部i-1，最后一个元素也是可以确定为1，最后添加
                for (int j = 2; j <= i -1; j++) {
                	//介于最左，最右之间的元素，通过f(i,j) = f(i-1, j-1)+f(i, j-1)来确定，逐个算出并添加进此层
                    data.add(prev.get(j - 2) + prev.get(j - 1));
                }


                //添加最右元素
                data.add(1);

                //将本层添加到外结构中
                list.add(data);
            }
        }

        return list;
    }
}