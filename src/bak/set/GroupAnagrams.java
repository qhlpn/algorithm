package bak.set;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Stream<String> stream = Arrays.stream(strs);

        Map<String, List<String>> collect = stream.collect(Collectors.groupingBy(str -> {
            // 按排序后的结果来 grouping by
            char[] array = str.toCharArray();
            Arrays.sort(array);
            return new String(array);
        }));

        return new ArrayList<>(collect.values());

    }


    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

}
