package fr.insa.moove.bdd.jo;

public class JoLocation {

    private final int id;
    private final String name, adress;
    private final int maxSpectators;

    public JoLocation(String name, int id, String adress, int maxSpectators) {
        this.name = name;
        this.id = id;
        this.adress = adress;
        this.maxSpectators = maxSpectators;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAdress() {
        return adress;
    }

    public int getMaxSpectators() {
        return maxSpectators;
    }
}
