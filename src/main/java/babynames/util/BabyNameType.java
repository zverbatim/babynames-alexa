package babynames.util;

import java.util.HashMap;
import java.util.Map;

public enum BabyNameType {
    BOY("M","boy"),
    GIRL("F", "girl");

    final String code;
    final String pronounced;
    static Map<String, BabyNameType> map;

    BabyNameType(String code, String pronounced) {
        this.code = code;
        this.pronounced = pronounced;
    }

    private static void initMap() {
        map = new HashMap<>();
        for (BabyNameType babyNameType : BabyNameType.values()) {
            map.put(babyNameType.code, babyNameType);
        }
    }

    static BabyNameType retrieveType(String code) {
        if (map == null){
            initMap();
        }

        return map.get(code);
    }
}