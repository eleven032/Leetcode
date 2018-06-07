// 根据之前的各类sum问题，其实有策略：
// 先排序，这个算法可以考虑最简单的case, 2sum，这是个经典问题，方法就是先排序，然后利用头尾指针找到两个数使得他们的和等于target。
// ThreeSum就是 sum =a+b+c 同理FourSum就是 sum = a+b+c+d 然后sum和target比较



public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();

        //先排序
        Arrays.sort(nums);

        //i,j作为基值，a,b作为头尾pointer， reverse用来记录2sum和
        int i,j,a,b,reserve;


        //双外层循环，决定了两个基值
        for( i=0;i<nums.length-3;i++){
            for( j=i+1;j<nums.length-2;j++){
                 a=j+1;
                 b=nums.length-1;
                 reserve=target-nums[i]-nums[j];


                //循环递减搜寻符合条件的值
                while(a<b){


                	//>记录值，尾部移动
                    if(nums[a]+nums[b]>reserve){
                        b--;
                        continue;
                    }

                    //找到了
                    if(reserve==nums[a]+nums[b]){
                        ArrayList<Integer> item=new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[a]);
                        item.add(nums[b]);
                        result.add(item);

                    }


                    //<记录值，头部移动
                    a++;
                    while(nums[a]==nums[a-1] && a<b ){
                        a++;
                    }


                }

                //避免走重复值,对应j循环的基值
                while(nums[j]==nums[j+1] && j<nums.length-2){
                        j++;
                }
            }

            //避免走重复值，对应i循环的基值
            while(nums[i]==nums[i+1] && i<nums.length-3 ){
                        i++;
            }
        }
        return result;
    }



// 对于K sum
// 第一，注意比如3sum的时候，先整体排一次序，然后枚举第三个数字的时候不需要重复， 比如排好序以后的数字是 a b c d e f, 那么第一次枚举a, 在剩下的b c d e f中进行2 sum, 完了以后第二次枚举b, 只需要在 c d e f中进行2sum好了，而不是在a c d e f中进行2sum
// 第二，K sum的复杂度是O(n^(K-1))。 这个界好像是最好的界了，也就是K-sum问题最好也就能做到O(n^(K-1))复杂度