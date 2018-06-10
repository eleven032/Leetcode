class Solution {
    public int removeDuplicates(int[] nums) {
    	int n = nums.length;
    	//边际测试
        if(n == 0) {
			return 0;
		} 

		//j用来随时记录去重后array长度，作为index记录
		int j = 0;

		//nums用来记录单个元素数量
		int num = 0;


		//进入循环，遍历每一个值
		for(int i = 1; i < n; i++) {

			//如果当前元素与上一个记录的元素相同，表示重复元素出现了
			if(A[j] == A[i]) {
				//无论如何，此元素数量加+1
				num++;
				//再检查数量
				//如果数量比2小，则记录J，这表示相同的元素没超过2
				if(num < 2) {
					A[++j] = A[i];
				}
				//超过2不作任何记录

			} else {

				//如果是非重复元素，J直接+1
				A[++j] = A[i];
				//该元素数量记0，因为之前的判定条件为<2，所以从0开始记
				num = 0;
			}
		} 

		//返回长度
		return j + 1;
    }
}