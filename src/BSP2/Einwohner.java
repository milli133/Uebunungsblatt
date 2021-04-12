package BSP2;

public class Einwohner implements Comparable<Einwohner> {
    private int id, geburtsjahr;
    private String name, bundesland;

    public Einwohner(int id, String name, String bundesland, int geburtsjahr) {
        this.id = id;
        this.geburtsjahr = geburtsjahr;
        this.name = name;
        this.bundesland = bundesland;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }

    @Override
    public String toString() {
        return "Einwohner{" +
                "id=" + id +
                ", geburtsjahr=" + geburtsjahr +
                ", name='" + name + '\'' +
                ", bundesland='" + bundesland + '\'' +
                "}\n";
    }

    @Override
    public int compareTo(Einwohner o) {
        return this.getName().compareTo(o.getName());
    }
}
