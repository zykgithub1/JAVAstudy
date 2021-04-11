package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;


public class greedyAlgorithm {

	public static void main(String[] args) {
		//创建电台和集合
		HashMap<String,HashSet<String>>broadCasts=new HashMap();
		HashSet<String>set1=new HashSet<>();
		set1.add("北京");
		set1.add("上海");
		set1.add("天津");
		HashSet<String>set2=new HashSet<>();
		set2.add("广州");
		set2.add("北京");
		set2.add("深圳");
		HashSet<String>set3=new HashSet<>();
		set3.add("成都");
		set3.add("上海");
		set3.add("杭州");
		HashSet<String>set4=new HashSet<>();
		set4.add("天津");
		set4.add("上海");
		HashSet<String>set5=new HashSet<>();
		set5.add("杭州");
		set5.add("大连");
		broadCasts.put("K1", set1);
		broadCasts.put("K2", set2);
		broadCasts.put("K3", set3);
		broadCasts.put("K4", set4);
		broadCasts.put("K5", set5);
		
		HashSet<String>allAreas=new HashSet<>();
		for(Entry<String, HashSet<String>> entry:broadCasts.entrySet()) {
			allAreas.addAll(entry.getValue());
		}
		ArrayList<String>selects=new ArrayList<String>();
		HashSet<String>tmpSet=new HashSet<String>();
		while(allAreas.size()!=0) {
			String maxKey=null;
			for(String key:broadCasts.keySet()) {
				tmpSet.clear();
				//System.out.println(key+"|！！！");
				HashSet<String>areas=broadCasts.get(key);
				tmpSet.addAll(areas);
				tmpSet.retainAll(allAreas);
				if(tmpSet.size()>0&&
						(maxKey==null||broadCasts.get(maxKey).size()<tmpSet.size())) {
					maxKey=key;
				}
			}
			if(maxKey!=null) {
				selects.add(maxKey);
				allAreas.removeAll(broadCasts.get(maxKey));
			}
		}
		System.out.println(selects);
	}

}
