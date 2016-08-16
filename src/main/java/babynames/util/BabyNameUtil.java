package babynames.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Using the social security data for 2015 suggest a name
 */
public class BabyNameUtil {

    static final String NAMES_PATH = "babynames/yob2015.txt";

    List<BabyName> boys;
    List<BabyName> girls;

    public BabyNameUtil() {
        initNames();
    }

    private void initNames() {
        boys = new ArrayList<>();
        girls = new ArrayList<>();
        FileIo fileIo = new FileIo();
        String content = fileIo.retrieveContent(NAMES_PATH);
        String[] entries = content.split("\r\n");
        for (String entry : entries) {
            String[] details = entry.split(",");
            String name = details[0];
            BabyNameType type = BabyNameType.retrieveType(details[1]);
            int count = Integer.parseInt(details[2]);

            if (type == BabyNameType.BOY) {
                boys.add(new BabyName(name, type, count));
            } else {
                girls.add(new BabyName(name, type, count));
            }
        }
    }

    public BabyName randomName() {
        if (Math.random() > 0.5) {
            return girlName();
        } else {
            return boyName();
        }
    }

    public BabyName boyName() {
        int limit = boys.size() - 1;
        int index = (int) (Math.random() * limit);
        return boys.get(index);
    }

    public BabyName girlName() {
        int limit = girls.size() - 1;
        int index = (int) (Math.random() * limit);
        return girls.get(index);
    }

    public static void main(String[] args) {
        BabyNameUtil babyNameUtil = new BabyNameUtil();
        System.out.println("random" + babyNameUtil.randomName());
        System.out.println("random" + babyNameUtil.randomName());
        System.out.println("boy" + babyNameUtil.boyName());
        System.out.println("girl" + babyNameUtil.girlName());
    }
}
