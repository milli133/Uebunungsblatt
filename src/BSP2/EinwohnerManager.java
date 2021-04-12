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
                // Erwähnenswert: Ich nutze die String "split" Methode, so kann ich die Werte ohne großen Aufwand
                // bei der Anlage meines Einwohner-Objektes für die Liste benutzen
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

        // Liste durchiterieren ...
        for (Einwohner e : einwohner) {
            // ... und pro gefundenem neuen Bundesland eine Liste anlegen
            if (!map.containsKey(e.getBundesland())) {
                map.put(e.getBundesland(), new ArrayList<>());
            }
            // Namen an die Liste hängen
            map.get(e.getBundesland()).add(e.getName());
        }
        // hier ist die Aufschlüsselung fertig, es gibt ab hier pro Bundesland ein
        // Entry(key) mit n Namen als String Liste

        // Ausgabe (pro Entry eine Zeile ist schöner als die ganze HasMap per toString() Ausgeben (yuck!)
        for (Map.Entry<String, List<String>> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.toString());
        }
        return map;
    }

    public Map<String, Integer> getAvgAlterByBundesland() {
        // Hier brauchen wir zwei Listen (ist übersichtlicher)
        // Eine für das Durchschnittsalter ...
        Map<String, Integer> map = new HashMap<>();
        // ... und eine für das Mitschreiben der Alterslisten
        Map<String, List<Integer>> alterMap = new HashMap<>();

        for (Einwohner e : einwohner) {
            // Erstmal Bundesländer aufteilen und pro Bundesland eine Liste anlegen
            if (!alterMap.containsKey(e.getBundesland())) {
                alterMap.put(e.getBundesland(), new ArrayList<>());
            }
            // Liste mit Alterseinträgen füllen (Alter = 2021 - Geburtsjahr)
            alterMap.get(e.getBundesland()).add(2021 - e.getGeburtsjahr());
        }

        // Jedes erstellte Entry durchgehen...
        for (Map.Entry<String, List<Integer>> mapEntry : alterMap.entrySet()) {
            // ... und den Datensatz der zum Key passt rausspeichern
            List<Integer> alterListe = mapEntry.getValue();

            double avgAlter = 0;
            int alterSumme = 0;
            int cnt = 0;

            // durch die Liste iterieren und dabei das Alter zusammenzählen und den Counter mitzählen lassen
            for (int entry : alterListe) {
                alterSumme += entry;
                cnt++;
            }

            // Durchschnitt = Summer der Alter / anzahlEinträge
            avgAlter = (double) alterSumme / cnt;

            //System.out.println(mapEntry.getKey() + " | " + new DecimalFormat("#.##").format(avgAlter));

            // nur versuchshalber wieder auf int gecastet, da mit double gerechnet
            map.put(mapEntry.getKey(), (int) avgAlter);
        }

        // Ausgabe
        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.toString());
        }
        return map;
    }
}
