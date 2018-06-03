public int[] twoSum(int[] numbers, int target) {
		  //res 用来返回两个index
          int [] res = new int[2];

          //边际测试
          if(numbers==null||numbers.length<2)
              return res;

          ///////////////////////////////////////////////////////////////////////////////////

          //创建map
          HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
          


          //循环遍历每个list里的元素
          for(int i = 0; i < numbers.length; i++){

          	  //先检测map里存不存在和当前元素相加为target的(key,value)
              if(!map.containsKey(target-numbers[i])){
              	  //不存在的话，添加当前元素进去
                  map.put(numbers[i],i);
              }else{
              	//存在的话，放入结果中，返回
                 res[0]= map.get(target-numbers[i])+1;
                 res[1]= i+1;
                 break;
             }
         }
         return res;
     }