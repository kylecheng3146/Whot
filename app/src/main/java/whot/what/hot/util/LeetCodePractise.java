package whot.what.hot.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** LeetCode practise
 * Created by Kevin on 27/10/2017.
 */

public class LeetCodePractise {
    private static final String TAG = "LeetCodePractise";

    private LeetCodePractise() {
        // This utility class is not publicly instantiable
    }

    /**
     * LeetCode 461 漢明距離
     * */
    public static int hammingDistance(int x, int y) {
        /*
        先把x y 互斥或取值
        ex: 1 = 00000001 ,4 = 00000100
        算法：
          00000001
        = 00000100
        ------------
          00000101 = 5
        */
        int res = 0, exc = x ^ y;
        while (exc != 0) {
            ++res;
            /*再將值做位元且的運算取漢明距離直到值為0
            * 位元且規則是 都是1回1 ， 都是0回0
            * 下列參數為 5 &= 4
            * 5 = 00000101
            * 4 = 00000100
            *----------------
            * =   00000100  == 4
            * 迴圈
            * */
            exc &= (exc - 1);
        }
        return res;
    }

    /**
     * 561. Array Partition I
     * */
    public static int arrayPairSum(int[] nums) {
        /*2
          n個數字分成Ñ組，每組2個數字，取每組中較小的數字，求和。要求是得到的和最大，方法返回值即為這個最大和。
          設的2n個數字升序排序後為：A0，A1，A2，A3，...，A（2n-1個）。
          猜想一下容易發現，最大和即為（a0 + a2 + a4 + ...。+ a（2n-2））

          for example： [1,4,3,2,5,8]
          先排序陣列後為 [1,2,3,4,5,8]*
          迴圈去值為 1 3 5
          result = 0 + 1 + 3 + 5 = 9
        */
        Arrays.sort(nums);
        int result = 0;

        //i 以 0 2 4 6 8 為基準跳數
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }

    /**
     * 476. Number Complement
     * 題目要求為：給定一個非負整數，
     * 求出其complement number。所謂complement number，
     * 指對整數二進制最高位為1的位之後的所有位置取反，如5的二進制表示為00……00101，
     * 起最高位為1的位置是3，因此只對3之後的所有位置取反，得到00*00010，最後得出complement number為2。

     * 解法：先求出最高位為1的位數，然後計算出掩碼，再將原數據取反後和掩碼求與，即得出最後結果。
     ```
     * */
    public static int findComplement(int num) {
        int valid = 0, tmp = num;
        /*舉11為例，先將暫存數除盡，
         * 跳脫迴圈取得valid為4*/
        while(tmp > 0) {
            tmp /= 2;
            valid++;
        }
        /*~11， 補數11二進制為00001011 反轉 11110100
        * 1<<4 = 00000001 向左位移4格 ， 為00010000 = 16
        * 16-1 = 15 , 15 二進制為00001101
        *  做位元且的運算得到
        *   11110100
        * & 00001101
        * = 00000100 == 4
        * */
        return ~num & ((1 << valid) - 1);
    }

    /**
     * 575. Distribute Candies
     * 給一個長度為偶數的整數數組，數組中不同數字都代表不同糖果，
     * 將糖果平均分給弟弟和妹妹，妹妹最多能得到幾種糖果。
     * */
    public static int distributeCandies(int[] candies) {
        /* 記錄糖果種類，若糖果種類大於數組的一半，
         * 妹妹最多得到candies.size（）/ 2 種糖果，
         * 否則每種糖果都可以得到*/
        Set<Integer> kinds = new HashSet<>();
        //參數不同才加入
        for(int i : candies){
            kinds.add(i);
        }
        //回傳兩個數區間較小值
        return Math.min(kinds.size(),candies.length/2);
    }

    /**
     * 344. Reverse String
     * Given s = "hello", return "olleh".
     * */
    public static String reverseString(String s) {
        /* 解法一
         * 將字串加入StringBuffer內再進行翻轉即可*/

//        return new StringBuffer().append(s).reverse().toString();

        /* 解法二
         * 先將參數每一項 */
        char tmp[] = s.toCharArray();
        String result ="";
        int i = tmp.length -1;
        while(i>=0){
            result += tmp[i];
            i--;
        }
//        for(int i = tmp.length;i>0 ;i--){
//            result.append(tmp[i - 1]);
//        }


        return result;
    }
    /**
     * 521. Longest Uncommon Subsequence I
     * 給定兩個字符串，計算其“最長不公共子序列”。最長不公共子序列是指：兩字符串中某一個的子序列，該子序列不是另一個字符串的子序列，並且長度最長。
     * 子序列是指從一個序列中刪除一些字符，剩餘字符順序保持不變得到的新序列。任何字符串都是其本身的子序列，空串不屬於任意字符串的子序列。
     * 返回最長不公共子序列，若不存在，返回-1。
     * */
    public int findLUSlength(String a, String b) {
        /* 若兩字符串不相等，選擇較長的字符串返回長度即可。
         * 否則返回-1。 （若兩字符串相等，則任意字符串的子串均為另一個的子串*/
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    /**
     * 283. Move Zeroes
     * nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     * */
    public static void moveZeroes(int[] nums) {
//        /*解法一，效率值比較低*/
//        int nums_len = nums.length;
//        int j = 0;
//        for(int i = 0;i<nums_len;i++){
//            /*先將0的寫入暫存，再將排序互換，互換後在將j+1往後依序比對*/
//            if(nums[i] != 0){
//                int temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
//                j++;
//            }
//        }
//        /*解法二*/
//        int i = 0;
//        int j = 0;
//        int len = nums.length;
//
//        while (len > i) {
//            if (nums[i] != 0) {
//                int temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
//                j++;
//            }
//            i++;
//        }

        /*解法三，先將數值不為0的都先移到前面*/
        int index=0;

        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0) nums[index++]=nums[i];
        }
        /*再將後面的參數設為0*/
        while(index<nums.length){
            nums[index++]=0;
        }
    }

    /**
     * 371. Sum of Two Integers
     * 加總兩個參數，但不能使用+號
     * */
    public static int getSum(int a, int b) {
        /*以7+3為例子
        * 先進行互斥取值
        * 7的二次方 = 00000111
        * 3的二次方 = 00000011
        *          = 00000100 = 4
        * 第二步驟
        * 將兩位數值做位元且運算
        * 得到  00000011 在左移 變 00000110 = 6
        * 6+4 = 10
        * done.
        * */
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    /**
     * 728. Self Dividing Numbers
     * 算出區間的數字 分開後原數字%是否都為0
     * 範例 128   128%1 128%2 128%8 都為0
     * */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer>result = new ArrayList<>();
        for(int i = left ; i<=right ; i++){
            boolean isTrue = false;
            for(char a : ("" + i).toCharArray()){
                if(String.valueOf(i).contains("0"))break;
                if(i % Character.getNumericValue(a) != 0){
                    isTrue = false;
                    break;
                }else isTrue = true;
            }
            if(isTrue) result.add(i);
        }
        return  result;
    }

    /**
     * 463. Island Perimeter
     * example
     * {0,1,0,0},
     * {1,1,1,0},
     * {0,1,0,0},
     * {1,1,0,0},
     * */
    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        //先取得總共有幾個排
        for(int i=0;i<grid.length;i++){
            //在取出目前
            for(int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    if (i > 0 && grid[i-1][j] == 1) count -= 2;
                    if (j > 0 && grid[i][j-1] == 1) count -= 2;
                }
            }
        }
        return count;
    }

    /**
     * 136. Single Number
     * 給一個整數陣列 nums, 裡面只有一個數字出現一次，其他都是出現兩次，找出那個孤單的數字。
     * */
    public static int singleNumber(int[] nums) {
        //先進行由小到大的排序
        Arrays.sort(nums);
        int result = 0,i=0;
        for (int num : nums) {
            //前後檢查相符合的參數
            if (!(i + 1 < nums.length && num == nums[i + 1]) && !(i - 1 >= 0 && num == nums[i - 1])) result = num;
            i++;
        }
        return result;
    }

    /**
     * 520. Detect Capital
     * All letters in this word are capitals, like "USA".
     * All letters in this word are not capitals, like "leetcode".
     * Only the first letter in this word is capital if it has more than one letter, like "Google".
     * */
    public static boolean detectCapitalUse(String word) {
        String char_case = "";
        for(int i=0;i<word.length();i++){
            //先檢查第一個字母為大寫或者小寫
            if( i == 0 && Character.isUpperCase(word.charAt(i))) char_case = "U";
            if(i == 0 && Character.isLowerCase(word.charAt(i))) char_case = "L";
            if(i>0){
                switch (char_case){
                    case "U":
                        //2比3，3比4依序類推跟後面比對，不同者就回傳false
                        if(i+1<word.length() && Character.isUpperCase(word.charAt(i)) != Character.isUpperCase(word.charAt(i+1))) return false;
                        break;
                    case "L":
                        //只要不是小寫就回傳false
                        if(!Character.isLowerCase(word.charAt(i))) return false;
                        break;
                }
            }
        }
        return true;
    }

    /**
     * 258. Add Digits
     * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     * */
    public int addDigits(int num) {
        if(num ==0) return 0;
        return num % 9 ==0 ?9:num % 9;
    }
}
