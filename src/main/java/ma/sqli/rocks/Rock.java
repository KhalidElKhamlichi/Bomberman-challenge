package ma.sqli.rocks;

import ma.sqli.bomberman.Bomberman;

public interface Rock {

    public void destroyed();

    public int getX();

    public int getY();

    public String getRepresentation();

    public void reactTo(Bomberman bomberman);
}
