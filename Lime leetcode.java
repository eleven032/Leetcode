// 1. sort colors---done
// 2. largest rectangle in histogram---done
// 3. maximal rectangle---done
// 4. construct binary tree from preorder and inorder traversal
// 5. construct binary tree from inorder and postorder traversal
// 6. max points on a line
// 7. three points on a line
// 8. number if islands
// 9. next greater element I
// 10. longest continuous increasing subsequence---doing
// 11. my calendar I---done
// 12. my calendar II---done
// 13. backspace string compare---done
// 14. longest mountain in array---done






//color sort
class Solution {
    public void sortColors(int[] nums) {


        //first let's check the edge case
        //if length smaller than 2 we just return
        if(nums.length<2){
            return;
        }
        

        //create an color database, with three color
        int color [] = new int [3];

        //we first loop the given array, and add each color's count into the color database array 
        for(int i=0;i<nums.length;i++){
            color[nums[i]]++;
        }
        //now we get an array with each color's count number
        

        //next step is going through the color database array and sort the all color

        //first we need two pointer
        //j represent color
        int j = 0;
        //k is for array length count
        int k = 0;


        //as loong as we did not go through whole the color database array 
        
        while(j<=2){
            //if color database still has one color
            if(color[j]!=0){

                //put into the given array
                nums[k]=j;
                //length ++
                k++;

                //this color in database - 1
                color[j]--;
            
            //else mean if the database do not have this color anymore then move to the next color
            } else {
                j++;
            }
        }
    }
}




//color sort 2
class Solution {
    public void sortColors(int[] nums) {
        //edge case detect
        if(nums.length<2){
            return;
        }


        //we set two pointer one for red, one for blue
        int red = 0; int blue = nums.length-1;
        //one pointer to go through
        int curr = 0;

        //do not need go over whole array
        while(curr<=blue){
            //when curr point to the color is red
            if(nums[curr]==0){

                //swap with the red
                swap(nums, red, curr);
                curr++;
                red++;


                //when the curr point to the color is blue
            } else if(nums[curr]==2){
                //swap with blue
                swap(nums, blue, curr);
                //only right is 100%sure sorted, but left might be 1 or 0 not100% sure it is sorted
                //we only decrease blue
                blue--;
                
                //if is 1 then just leave it here
            } else {
                curr++;
            }
        }
    }
    public static void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}



//最大矩阵面积【2，4，6，8，2，6】
public int largestRectangleArea2(int[] height) {
    //create a stack use to store all the index
    Stack<Integer> stack = new Stack<Integer>();

    //pointer
    int i = 0;

    //use to store current maximum area
    int maxArea = 0;

    //create a new array with height with one more element to know if the loop is end or not
    int[] h = new int[height.length + 1];


    h = Arrays.copyOf(height, height.length + 1);

    //go through the new height array
    while(i < h.length){


        //if it's the first column or this column is bigger than previous one
        //we push this column in
        if(stack.isEmpty() || h[stack.peek()] <= h[i]){
            stack.push(i);
            i++;
        }else {
            //if it is not, we need calculate the area of this one and compare with previous


            //let t = the last highest column index
            int t = stack.pop();

            //maxArea is previous max area
            //h[t] is the current height, we check which index we could use
            maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }
    }
    return maxArea;
}



//最大矩形面积 矩阵
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0){
             return 0;
        }
        
        int maxarea = 0;
        
        //use to record and create historgam
        int[] dp = new int[matrix[0].length];


        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {

                // update the state of this row's histogram using the last row's histogram
                // by keeping track of the number of consecutive ones
                
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            // update maxarea with the maximum area from this row's histogram
            maxarea = Math.max(maxarea, largestRectangleArea(dp));
        } 
        return maxarea;
    }
    
    //上面
    public int largestRectangleArea(int[] heights) {
            if(heights.length==0){
                return 0;
            }
            int i = 0;
            int max = 0;
            int h [] = Arrays.copyOf(heights, heights.length+1);

            Stack<Integer> position = new Stack<>();
            while(i<h.length){
                if(position.isEmpty()||h[i]>=h[position.peek()]){
                    position.push(i);
                    i++;
                } else {
                    int t = position.pop();
                    max=Math.max(max, h[t]*(position.isEmpty()?i:i-position.peek()-1));
                }
            }
            return max;

        }
    
    
    
    
}



//my calendar 1
class MyCalendar {
    //create a treemap since we need check the intersection of time interval
    TreeMap<Integer, Integer> event;
    

    //constructor
    public MyCalendar() {
        event = new TreeMap<Integer, Integer>();
    }
    


    
    public boolean book(int start, int end) {


        //we get one event which start date is the most left close to this input start
        Integer prev = event.floorKey(start);

        //we get one event which start date is most right close to this input start
        Integer next = event.ceilingKey(start);


        //if prev is not null and start time is smaller than last event's end time
        //they have intersection
        if(prev!=null&&start<event.get(prev)){
            return false;
        } 
        

        //if next not equal to null and end time is bigger than next event's start date
        //they have intersection
        if(next!=null&&end>next){
            return false;
        }
        

        //otherwise, put it into the map
        event.put(start,end);
        return true;
    }
}


//calendar 2
class MyCalendarTwo {
    //booked is use to store the validate event
    List<int[]> booked;
    //overlaps use to record the date of overlaping part
    List<int[]>overlaps;

    //constructor
    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    

    
    public boolean book(int start, int end) {
        //first we go over the overlaps array to check if the new start and end is validate or invalidate 
        for(int []a:overlaps){

            //when start < new end end > than new start
            //return false;
            if(a[0]<end&&start<a[1]){
                return false;
            }
        }


        //now go through the booked array, use to add new event
        
        for(int []a:booked){
            //when we find the overlap, calculate the overlap and add into overlaps array
            if(a[0]<end&&start<a[1]){
                overlaps.add(new int[]{Math.max(start, a[0]), Math.min(end,a[1])});
            }
        }

        //add new event into it
        booked.add(new int[]{start,end});
        return true;
    }
}

//longest mountain 
class Solution {
    public int longestMountain(int[] A) {
        //use to record the max length
        int maxlen = 0;

        //use to record the index of mountain start
        int upstart = -1;

        //check the first index that montain up or not
        boolean firstup = true;

        //check the curent and last one 
        for(int i = 1; i < A.length; ++i) {

            //if i bigger than i-1
            if(A[i] > A[i-1]) {
                //in the same time if firstup is true
                //which means this is the start of the mountain
                if(firstup) {
                    
                    //record new start index
                    upstart = i-1;
                    //set the firstup to false
                    firstup = false;
                }
            }

            //if it's equal 
            else if(A[i] == A[i-1]) {

                //reset the upstart
                upstart = -1;
                //set first up equal to true
                firstup = true;
            }

            //if smaller
            else { // A[i-1] > A[i] 
                //if upstart bigger than 0 which mean not in the begining of the array
                //and now is time to pick the longer one of the mountain 
                if(upstart >= 0) {
                    //pick the  longer one and record it
                    maxlen = Math.max(maxlen, i-upstart+1);
                }

                firstup = true;
            }
        }
        return maxlen;
    }
}


//string back space
class Solution {

    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }
    
    
    public static String helper(String a){
        Stack<Character> tmp = new Stack<>();
        for(char i: a.toCharArray()){
            if(i!='#'){
                tmp.push(i);
            } else if(!tmp.empty()){
                tmp.pop();
            }
        }
        return String.valueOf(tmp);
    }
}


//string back space better way O(1) space
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}

