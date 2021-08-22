package com.one.util;

import com.one.domain.ResultInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class ResultInfoData2Vector {

    public static Vector<Vector> convertResultInfoData2Vector(ResultInfo info){
        List list = (List) info.getData();
        Vector<Vector> vectors = new Vector<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap map = (HashMap) list.get(i);
            Vector vector = new Vector();
            vector.addAll(map.values());
            vectors.add(vector);
        }
        return vectors;
    }
}
