package com.yaolaizai.ylzx.baseproject.net;

import java.util.Comparator;

/**
 * Created by zwq1 on 2016/7/24.
 */
public class MapKeyComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {

        return str1.compareTo(str2);
    }
}
