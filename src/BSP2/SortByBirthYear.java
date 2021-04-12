package BSP2;

import java.util.Comparator;

public class SortByBirthYear implements Comparator<Einwohner> {
    @Override
    public int compare(Einwohner e1, Einwohner e2) {
        if (e1.getGeburtsjahr() < e2.getGeburtsjahr())
            return -1;
        if (e1.getGeburtsjahr() > e2.getGeburtsjahr())
            return 1;
        return 0;
    }
}
