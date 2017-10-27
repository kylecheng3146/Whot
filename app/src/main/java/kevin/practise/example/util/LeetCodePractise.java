package kevin.practise.example.util;

/**
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
            /*再將值位元且做運算取漢明距離知道值為0
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
}
