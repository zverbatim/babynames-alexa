package babynames.util;

import java.util.HashMap;
import java.util.Map;

public enum NameType {
    BOY("M","boy"),
    GIRL("F", "girl");

    final String code;
    final String pronounced;
    static Map<String, NameType> map;

    NameType(String code, String pronounced) {
        this.code = code;
        this.pronounced = pronounced;
    }

    private static void initMap() {
        map = new HashMap<>();
        for (NameType nameType : NameType.values()) {
            map.put(nameType.code, nameType);
        }
    }

    static NameType retrieveType(String code) {
        if (map == null){
            initMap();
        }

        return map.get(code);
    }
}