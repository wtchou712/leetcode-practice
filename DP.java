/* Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

https://leetcode.com/problems/pascals-triangle/description/

*/

public List<List<Integer>> generate(int numRows) {
    //dynamic programming type solution
    ArrayList<List<Integer>> pascal = new ArrayList<List<Integer>>();
    for (int row=0; row<numRows; row++){//build each row
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<row+1; i++){
            //add one if at either end of array
            if(i==0 || i==row) arr.add(1);
            else{//add the two elements from previous row
                arr.add(pascal.get(row-1).get(i-1) + pascal.get(row-1).get(i));
            }
        }
        pascal.add(arr);
    }
    return pascal;
}