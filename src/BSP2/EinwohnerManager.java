package BSP2;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class EinwohnerManager {

    ArrayList<Einwohner> einwohner = new ArrayList<>();

    public void load(String path) throws DataFileException, FileNotFoundException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        try {
            BufferedReader br = new BufferedReader(fr);

            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] splitLine = line.split(";");
                einwohner.add(new Einwohner(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2], Integer.parseInt(splitLine[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Collections.sort(einwohner);
        //System.out.println(einwohner.toString());
    }

    public void sortByBirthYear() {
        einwohner.sort(new SortByBirthYear());
        //System.out.println(einwohner.toString());
    }

    public Map<String, List<String>> getAllNamenByBundesland() {
        Map<String, List<String>> map = new HashMap<>();

        for (Einwohner e : einwohner) {
            if (!map.containsKey(e.getBundesland())) {
                map.put(e.getBundesland(), new ArrayList<>());
            }
            map.get(e.getBundesland()).add(e.getName());
        }
        for (Map.Entry<String, List<String>> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.toString());
        }
        return map;
    }

    public Map<String, Integer> getAvgAlterByBundesland() {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Integer>> alterMap = new HashMap<>();

        for (Einwohner e : einwohner) {
            if (!alterMap.containsKey(e.getBundesland())) {
                alterMap.put(e.getBundesland(), new ArrayList<>());
            }
            alterMap.get(e.getBundesland()).add(2021 - e.getGeburtsjahr());
        }

        for (Map.Entry<String, List<Integer>> mapEntry : alterMap.entrySet()) {
            List<Integer> alterListe = mapEntry.getValue();

            double avgAlter = 0;
            int alterSumme = 0;
            int cnt = 0;

            for (int entry : alterListe) {
                alterSumme += entry;
                cnt++;
            }

            avgAlter = (double) alterSumme / cnt;

            //System.out.println(mapEntry.getKey() + " | " + new DecimalFormat("#.##").format(avgAlter));

            map.put(mapEntry.getKey(), (int) avgAlter);
        }
        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.toString());
        }
        return map;
    }
}
