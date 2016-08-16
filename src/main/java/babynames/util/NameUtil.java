package babynames.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Using the social security data for 2015 suggest a name
 */
public class NameUtil {

    static final String NAMES_PATH = "babynames/yob2015.txt";

    List<Name> boys;
    List<Name> girls;

    public NameUtil() {
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
            NameType type = NameType.retrieveType(details[1]);
            int count = Integer.parseInt(details[2]);

            if (type == NameType.BOY) {
                boys.add(new Name(name, type, count));
            } else {
                girls.add(new Name(name, type, count));
            }
        }
    }

    public Name randomName() {
        if (Math.random() > 0.5) {
            return girlName();
        } else {
            return boyName();
        }
    }

    public Name boyName() {
        int limit = boys.size() - 1;
        int index = (int) (Math.random() * limit);
        return boys.get(index);
    }

    public Name girlName() {
        int limit = girls.size() - 1;
        int index = (int) (Math.random() * limit);
        return girls.get(index);
    }

    public static void main(String[] args) {
        NameUtil nameUtil = new NameUtil();
        System.out.println("random" + nameUtil.randomName());
        System.out.println("random" + nameUtil.randomName());
        System.out.println("boy" + nameUtil.boyName());
        System.out.println("girl" + nameUtil.girlName());
    }
}
