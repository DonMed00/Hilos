package demoretrofit;

import java.util.List;

public class PersonFilms {
    private final String personName;
    private final List<String> filmList;

    public PersonFilms(String personName, List<String> filmList) {
        this.personName = personName;
        this.filmList = filmList;
    }

    public List<String> getFilmList() {
        return filmList;
    }

    public String getPersonName() {
        return personName;
    }

}
