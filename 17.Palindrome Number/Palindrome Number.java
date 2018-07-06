/*
回文特点：所有%10的余数和是其本身

*/


class Solution {
    public boolean isPalindrome(int x) {

      //边际测试，<0就自己滚出
        if (x < 0)
          return false;

        //0是回文
        else if (x == 0)
          return true;


        //其他数字让我们好好玩一玩
        else {

          //建立临时值,值相同与原数值
          int tmp = x;
          //创建y
          int y = 0;


          //当X！=0时，不断循环
          while (x != 0) {

          	//关键点：不断取余数并将这些余数相加
          	//回文的一个关键点便是所有余数相加是其原值

          	//这个循环就是让其所有余数相加，直到没有余数
            y = y * 10 + x % 10;
            x = x / 10;
          } 





          //判断是否和原值相同
          if (y == tmp)
            return true;
          else
            return false;
        }
    }
}