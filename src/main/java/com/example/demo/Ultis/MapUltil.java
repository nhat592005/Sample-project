package com.example.demo.Ultis;

import java.util.Map;

public class MapUltil {
    // tclass là cái trả về từ cái field mà ng dùng trả về tức là trả về 1 kiểu dữ
    // liệu;
    // đảm bảo rằng giá trị được lấy từ params có thể được chuyển đổi đúng kiểu dữ
    // liệu và không gây ra ngoại lệ khi chuyển đổi
    // kiểm tra xem có value hay j không và chuyển đổi nó

    public static <T> T getObject(Map<String, Object> params, String key, Class<T> tClass) {
        // cai nay de lay du lieu tu column nếu có trong đấy nếu không có value thì trả
        // về null;
        Object obj = params.getOrDefault(key, null);
        if (obj != null) {
            if (tClass.getTypeName().equals("java.lang.Long")) {
                obj = obj != "" ? Long.valueOf(obj.toString()) : null;
            } else if (tClass.getTypeName().equals("java.lang.Integer")) {
                obj = obj != "" ? Integer.getInteger(obj.toString()) : null;
            }
            // gettypename có nghĩa là sẽ trả về cái kiểu dữ liệu
            else if (tClass.getTypeName().equals("java.lang.String")) {
                obj = obj.toString();
            }
            return tClass.cast(obj);
        }
        return null;
        // cast tra ve doi tuong dua theo cai field cua tclass;
    }
}
