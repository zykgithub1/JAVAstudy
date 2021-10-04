package demo_2021_9_27_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class transformLocationString {
	public List<List<String>> groupAnagrams(String[] strs) {
	       
        Map<String,List<String>>map=new HashMap();
        for(String str:strs){
            char[]chs=str.toCharArray();
            Arrays.sort(chs);
            String key=String.valueOf(chs);
            map.put(key,map.getOrDefault(key,new ArrayList()));
            map.get(key).add(str);
        }
         List<List<String>>ans=new ArrayList(map.values());
        return ans;

    }
}
