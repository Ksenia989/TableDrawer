package Parts;

import java.util.ArrayList;
import java.util.List;

public class PartsInitializer {
    public static List<Part> partList = new ArrayList<>();

    static {
        partList.add(new Part("2", -8, -6));
        partList.add(new Part("0.25 * x + 0.25", -6, -2));
        partList.add(new Part("(-1) * sqrt(4 - (x + 2) * (x + 2)) + 2", -2, 0));
        partList.add(new Part("sqrt(4 - x * x)", 0, 2));
        partList.add(new Part("(-1) * x + 2", 2,10));
    }

    public List<Part> getPartList() {
        return partList;
    }
}
