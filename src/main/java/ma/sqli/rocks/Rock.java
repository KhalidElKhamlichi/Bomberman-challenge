package ma.sqli.rocks;

import ma.sqli.bomberman.Bomberman;

public interface Rock {

    void destroyed();

    int getX();

    int getY();

    String getRepresentation();

    void reactTo(Bomberman bomberman);
}
