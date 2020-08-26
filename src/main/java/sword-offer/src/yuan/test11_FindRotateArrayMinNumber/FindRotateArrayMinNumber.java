package yuan.test11_FindRotateArrayMinNumber;

import org.junit.Test;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/8/27 1:57
 */
public class FindRotateArrayMinNumber {
    /**
     * 解法一：二分查找（寻找变化点）
     * 时间复杂度：O(log n)，空间复杂度：O(1)
     */
    public static int findRotateArrayMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        if (numbers.length == 1 || numbers[numbers.length - 1] > numbers[0]) {
            return numbers[0];
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = right - (right - left) / 2;

            if (numbers[mid] > numbers[mid + 1]) {
                return numbers[mid + 1];
            }

            if (numbers[mid - 1] > numbers[mid]) {
                return numbers[mid];
            }

            if (numbers[mid] > numbers[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 解法二：二分查找（最左下标）
     * 时间复杂度：O(log n)，空间复杂度：O(1)
     */
    public int findRotateArrayMinNumber2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return numbers[left];
    }

    /**
     * 第8.1题：若非递减排序数组中有重复元素，求最小元素
     * 时间复杂度：O(log n)，空间复杂度：O(1)
     */
    public int findMin(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    @Test
    public void test() {
//        System.out.println(findRotateArrayMinNumber(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findRotateArrayMinNumber(new int[]{1, 1}));
        System.out.println(findRotateArrayMinNumber(new int[]{2, 2, 2, 0, 1}));
        System.out.println(findRotateArrayMinNumber2(new int[]{3, 3, 1, 3}));

    }
}