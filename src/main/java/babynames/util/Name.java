package babynames.util;

public class Name {
    String name;
    NameType nameType;
    int count;

    public Name(String name, NameType nameType, int count) {
        this.name = name;
        this.nameType = nameType;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", nameType=" + nameType +
                ", count=" + count +
                '}';
    }
}
