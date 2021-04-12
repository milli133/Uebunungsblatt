package BSP2;

import java.io.File;
import java.io.FileNotFoundException;

public class EinwohnerDemoApp {

    public static void main(String[] args) throws DataFileException {
        EinwohnerManager manager = new EinwohnerManager();
        try {
            manager.load("src/BSP2/data/testdata-einwohner.csv");
            System.out.println("\n ----------- Aufteilung auf Bundesland: -----------");
            manager.getAllNamenByBundesland();
            System.out.println("\n ----------- Durchschnittsalter pro Bundesland: -----------");
            manager.getAvgAlterByBundesland();
        } catch (FileNotFoundException e) {
            throw new DataFileException("FILE LOAD ERROR",e);
        }
    }
}
