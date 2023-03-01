package com.ccb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] arr = {
                1442, 1449, 1454, 1735, 1909, 2092, 2092, 2108, 2117, 2119, 2158, 2159, 2180, 2198, 2199, 2215, 2217, 2218, 2221, 2225, 2225, 2235, 2236, 2236, 2237, 2238, 2241
        };
        int res = 0;
        for (int a = 0; a < arr.length; a++) {
            res += arr[a];
        }
        System.out.println(res);
    }

    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> ans = new ArrayList<>();
    static boolean[] used;
    static int sum = 0;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ans;
    }

    private static  void backTracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            ans.add(new ArrayList(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
