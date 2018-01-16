/* Length of Last Word
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 
Example:
Input: "Hello World"
Output: 5

https://leetcode.com/problems/length-of-last-word/description/
*/

public int lengthOfLastWord(String s) {
    //start at tail and decrement until you hit a char
    //then start head at 0 and increment until you hit tail
    //count chars until tail, reset to 0 when hit space
    int tail=s.length()-1; 
    int len =0; 
    while(tail>=0 && s.charAt(tail)==' ') tail--;
    for(int head=0; head<=tail; head++){
        if(s.charAt(head)==' ') len=0; 
        else len++;
    }
    return len; 
}

/* Implement strStr()
Return the index of the first occurence of needle in haystack or -1 if needle is not part of haystack

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

https://leetcode.com/problems/implement-strstr/description/
*/

public int strStr(String haystack, String needle) {     
    for(int i=0; ; i++){//searches each char
        for(int j=0; ; j++){
        //search from i until end of needle, found haystack, or haystack not matching
            if(j==needle.length()) return i; //if reach end of needle
            if(i+j>=haystack.length()) return -1; //if searched all of haystack
            if(haystack.charAt(i+j)!=needle.charAt(j)) break; //haystack and needle dont match
        }
    }
}

/* Count and Say
The count-and-say sequence is the sequence of integers with the first five terms as following: 
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

https://leetcode.com/problems/count-and-say/description/
*/

public String countAndSay(int n) {
    //count until the number changes then say that number
    String ans = "1"; 
    
    for(int i=2; i<=n; i++){
        ans = countAndSayHelper(ans);
    }
    return ans;
}

//helper is the one doing the actual counting and saying
public String countAndSayHelper(String str){
    String ans = "";
    int count=1;
    char previous=str.charAt(0);
    for(int i=1; i<str.length(); i++){
        if(str.charAt(i)!=previous){
            //if number is different, add count then number
            ans+= Integer.toString(count) + previous; 
            count=0;
            previous = str.charAt(i);
        }
        count++;
    }
    ans+= Integer.toString(count) + previous;
    return ans; 
}