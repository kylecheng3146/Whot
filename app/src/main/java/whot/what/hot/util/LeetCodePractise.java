package whot.what.hot.util;

import java.util.Arrays;
import java.util.HashSet;
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
        ex: 1 = 00000001 ,4 = 00000100x
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

}
