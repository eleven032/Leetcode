public class Solution {
    public int[] plusOne(int[] digits) {
		
		//得到array的长度
        int n = digits.length;
		
		//进入循环，从array尾端进入，逐个递减遍历
        for (int i = digits.length - 1; i >= 0; --i) {
			
			//既然是做加法，都是从最尾端开始，判断是不是9,只有9才需要进位
			//最尾端不断在变化，因为会有进位行为，所以最准确的说法是当前元素是进位的index元素
			
			//当最尾端<9
            if (digits[i] < 9) {
				
				//最尾端+1即可
                ++digits[i];
                return digits;
            }
			
			//如果最尾端是9，则将其设为0
			//这时循环会继续走向当前index的前一个index，也就是进位过程
            digits[i] = 0;
        }
		//这里代表循环结束，到达这里表示循环内的条件一直没达成
		//相当于这个array为[9,9,9,9,9....]
		//此时需要为array添加一位
		//创建一个新的array，长度比原来长1位
        int[] res = new int[n + 1];
		
		//将起始设为1，其余默认为0
        res[0] = 1;
		
		//返回一个相当于[1,0,0,0,0,0,0,0,0.....]的数
        return res;
    }
}