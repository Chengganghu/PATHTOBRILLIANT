package com.company.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindRepeatNum {


    // 构建hash的方式，空间换时间
    public static int findRepeatNum(int[] nums) {
        Map<Integer, Integer> mapper = new HashMap<>();
        for (int i =0 ;i < nums.length; i++) {
            if (mapper.containsKey(new Integer(nums[i]))) {
                return nums[i];
            } else {
                mapper.put(nums[i], 1);
            }
        }
        return 0;
    }

    // 原地置换，如果没有重复，则数组下标等于对应位置的值
    public static int findRepeatNum2(int[] nums) {
        for (int i =0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
