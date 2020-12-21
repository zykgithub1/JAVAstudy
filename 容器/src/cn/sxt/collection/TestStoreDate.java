package cn.sxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestStoreDate {
	public static void main(String[] args) {
		Map<String,Object> row1=new HashMap<>();
		row1.put("id",1001);
		row1.put("name","张三");
		row1.put("salary",20000);
		row1.put("入职日期","2018.3.4");
		Map<String,Object> row2=new HashMap<>();
		row2.put("id",1002);
		row2.put("name","李四");
		row2.put("salary",30000);
		row2.put("入职日期","2005.5.5");
		Map<String,Object> row3=new HashMap<>();
		row3.put("id",1003);
		row3.put("name","王五");
		row3.put("salary",3000);
		row3.put("入职日期","2020.2.5");
		
		List<Map<String,Object>> table=new ArrayList<>();
		table.add(row1);
		table.add(row2);
		table.add(row3);
		for(Map<String,Object> row:table) {
			Set<String> keyset=row.keySet();
			for(String key:keyset) {
				System.out.print(key+":"+row.get(key)+"\t");
			}
			System.out.println();
		}
	}

}
