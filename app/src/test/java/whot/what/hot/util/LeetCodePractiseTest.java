package whot.what.hot.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** leetcode testing
 * Created by Kevin on 2018/2/27.
 */
public class LeetCodePractiseTest {
    @Test
    public void hammingDistance() throws Exception {
        Assert.assertEquals(2,LeetCodePractise.hammingDistance(1,2));
    }

    @Test
    public void arrayPairSum() throws Exception {
        Assert.assertEquals(4,LeetCodePractise.arrayPairSum(new int[]{1,2,3}));
    }

    @Test
    public void findComplement() throws Exception {
        Assert.assertEquals(1,LeetCodePractise.findComplement(2));
    }

    @Test
    public void distributeCandies() throws Exception {
        Assert.assertEquals(1,LeetCodePractise.distributeCandies(new int[]{2,3,4}));
    }

    @Test
    public void reverseString() throws Exception {
        Assert.assertEquals("olleh",LeetCodePractise.reverseString("hello"));
    }

    @Test
    public void findLUSlength() throws Exception {
        Assert.assertEquals(3,LeetCodePractise.findLUSlength("a","qwe"));
    }

    @Test
    public void moveZeroes() throws Exception {
        Assert.assertArrayEquals(new int[]{1,3,2,0,0},LeetCodePractise.moveZeroes(new int[]{0,1,0,3,2}));
    }

    @Test
    public void getSum() throws Exception {
        Assert.assertEquals(3,LeetCodePractise.getSum(1,2));
    }

    @Test
    public void selfDividingNumbers() throws Exception {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        Assert.assertEquals(expected, LeetCodePractise.selfDividingNumbers(1,3));
    }

    @Test
    public void islandPerimeter() throws Exception {
        Assert.assertEquals(16,LeetCodePractise.islandPerimeter(new int[][]{ {0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}}));
    }

    @Test
    public void singleNumber() throws Exception {
        Assert.assertEquals(1,LeetCodePractise.singleNumber(new int[]{2,2,1}));
    }

    @Test
    public void detectCapitalUse() throws Exception {
        Assert.assertEquals(true,LeetCodePractise.detectCapitalUse("USA"));
        Assert.assertEquals(false,LeetCodePractise.detectCapitalUse("uSa"));
    }

    @Test
    public void addDigits() throws Exception {
        Assert.assertEquals(9,LeetCodePractise.addDigits(9));

    }

    @Test
    public void canConstruct() throws Exception {
        Assert.assertEquals(true,LeetCodePractise.canConstruct("aa", "aab"));
    }

    @Test
    public void anagramMappings() throws Exception {
        Assert.assertArrayEquals(new int[]{1, 4, 3, 2, 0},LeetCodePractise.anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28}));
    }

    @Test
    public void findDisappearedNumbers() throws Exception {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(6);
        Assert.assertEquals(expected,LeetCodePractise.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    @Test
    public void findWords() throws Exception {
        Assert.assertArrayEquals(new String[]{"Alaska", "Dad"} ,LeetCodePractise.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
    }

    @Test
    public void isToeplitzMatrix() throws Exception {
        Assert.assertEquals(false,LeetCodePractise.isToeplitzMatrix(new int[][]{{11,74,0,93},{40,11,74,7}}));
        Assert.assertEquals(true,LeetCodePractise.isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
    }

    @Test
    public void findMaxConsecutiveOnes() throws Exception {
        Assert.assertEquals(2,LeetCodePractise.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }

    @Test
    public void intersection() throws Exception {
        Assert.assertArrayEquals(new int[]{1},LeetCodePractise.intersection(new int[]{3,1,2},new int[]{1}));
    }

    @Test
    public void titleToNumber() throws Exception {
        Assert.assertEquals(703,LeetCodePractise.titleToNumber("AAA"));
    }

    @Test
    public void missingNumber() throws Exception {
        Assert.assertEquals(8,LeetCodePractise.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        Assert.assertEquals(0,LeetCodePractise.missingNumber(new int[]{9,6,4,2,3,5,7,8,1}));
    }

    @Test
    public void isAnagram() throws Exception {
        Assert.assertEquals(false,LeetCodePractise.isAnagram("rat","car"));
        Assert.assertEquals(false,LeetCodePractise.isAnagram("rat","carasd"));
        Assert.assertEquals(true,LeetCodePractise.isAnagram("",""));
        Assert.assertEquals(true,LeetCodePractise.isAnagram("anagram","nagaram"));
    }

    @Test
    public void twoSum() throws Exception {
        Assert.assertArrayEquals(new int[]{1,2},LeetCodePractise.twoSum(new int[]{2,7,11,15},9));
    }

    @Test
    public void firstUniqChar() throws Exception {
        Assert.assertEquals(-1,LeetCodePractise.firstUniqChar("cc"));
        Assert.assertEquals(0,LeetCodePractise.firstUniqChar("b"));
    }

    @Test
    public void majorityElement() throws Exception {
        Assert.assertEquals(1,LeetCodePractise.majorityElement(new int[]{1}));
        Assert.assertEquals(0,LeetCodePractise.majorityElement(new int[]{1,2,3,4}));
    }

    @Test
    public void maximumProduct() throws Exception {
        Assert.assertEquals(720,LeetCodePractise.maximumProduct(new int[]{-4,-3,-2,-1,60}));
    }

    @Test
    public void containsDuplicate() throws Exception {
        Assert.assertEquals(true,LeetCodePractise.containsDuplicate(new int[]{1,2,2}));
        Assert.assertEquals(false,LeetCodePractise.containsDuplicate(new int[]{1,2}));
    }

    @Test
    public void toHex() throws Exception {
        Assert.assertEquals("0",LeetCodePractise.toHex(0));
        Assert.assertEquals("64",LeetCodePractise.toHex(100));
    }

}
