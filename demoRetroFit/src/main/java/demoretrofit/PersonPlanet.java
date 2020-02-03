package demoretrofit;

public class PersonPlanet {

    private final String personName;

    public String getPersonName() {
        return personName;
    }

    public String getPlanetName() {
        return planetName;
    }

    public PersonPlanet(String personName, String planetName) {
        this.personName = personName;
        this.planetName = planetName;
    }

    private final String planetName;

}
