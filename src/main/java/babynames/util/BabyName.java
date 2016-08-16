package babynames.util;

public class BabyName {
    public String name;
    public BabyNameType babyNameType;
    public int count;

    public BabyName(String name, BabyNameType babyNameType, int count) {
        this.name = name;
        this.babyNameType = babyNameType;
        this.count = count;
    }

    @Override
    public String toString() {
        return "BabyName{" +
                "name='" + name + '\'' +
                ", babyNameType=" + babyNameType +
                ", count=" + count +
                '}';
    }
}
