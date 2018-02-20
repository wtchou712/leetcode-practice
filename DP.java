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

/* Pascal's Triangle II

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

https://leetcode.com/problems/pascals-triangle-ii/description/

*/
public List<Integer> getRow(int rowIndex) {
    //1
    //11
    //121
    //1331
    //14641
    //dynamic programming, builds array from end
    //solution works by adding current number above and above left.
    ArrayList<Integer> pascal = new ArrayList<Integer>();
    pascal.add(1);//initialize first row
    for(int row=1; row<rowIndex+1; row++){
        pascal.add(0);//add 0 to increase size of array
        for(int i=row; i>=1; i--)
            pascal.set(i, pascal.get(i-1)+pascal.get(i));
    }
    return pascal;
}