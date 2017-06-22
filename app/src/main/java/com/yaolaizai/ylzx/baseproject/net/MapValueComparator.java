package com.yaolaizai.ylzx.baseproject.net;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by zwq1 on 2016/7/24.
 */
public class MapValueComparator implements Comparator<Map.Entry<String, String>> {

    @Override
    public int compare(Map.Entry<String, String> me1, Map.Entry<String, String> me2) {

        return me1.getValue().compareTo(me2.getValue());
    }
}
