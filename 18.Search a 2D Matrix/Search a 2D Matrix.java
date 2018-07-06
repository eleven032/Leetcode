/*
Search a 2D Matrix
如果把第0行，第1行，第i行...第i+1行依次连接起来，使得2D数组被还原为1D数组，那么显然这个1D数组就被转化成为了一个排好序的数组。接下来普通的二分搜索就OK了。
*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

    	//如果这个数组为空，还玩个屁
        if (matrix.length == 0) {
            return false;
        }
        


        //先得到数组拆分成1D数组的总长度，用来做之后二分查找时的起点和终点
        int rowCount = matrix.length, colCount = matrix[0].length;

        //起点为0，尾点为总长度
        int start = 0, end = rowCount * colCount - 1, mid = 0;
        

        //进入二分法查找
        while (start  + 1 < end)  {
            mid = start + (end - start) / 2;
            int row = mid / colCount;
            int col = mid % colCount;
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        if (matrix[start / colCount][start % colCount] == target) {
            return true;
        }
        if (matrix[end / colCount][end % colCount] == target) {
            return true;
        }        
        return false;

    }
}