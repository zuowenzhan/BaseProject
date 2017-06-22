package com.yaolaizai.ylzx.baseproject.net;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SortUtils {

	private static String newStr;

	public static String sortMap(Map<String, String> map) {
		String result = "";
		Collection<String> keyset = map.keySet();
		Iterator<String> iter = keyset.iterator();
		List<String> list = new ArrayList<String>(keyset);

		// 对key键值按字典升序排序
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareTo(arg1);
			}
		});
		for (int i = 0; i < list.size(); i++) {
			String key = list.get(i);
			if(i != list.size()-1){
				result += key + "," + map.get(key)+",";
			}
			else{
				result += key + "," + map.get(key);
			}
		}
		return result;

	}
}
