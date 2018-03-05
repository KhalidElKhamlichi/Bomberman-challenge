package ma.sqli.rocks;

import ma.sqli.Location;
import ma.sqli.bomberman.Bomberman;

public class BasicRock implements Rock {

    private Location location = new Location();

    private final String destroyedRepresentation = " ";
    private String representation = "X";

    public BasicRock(int x, int y) {
        this.location.x = x;
        this.location.y = y;
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    @Override
    public String getRepresentation() {
        return representation;
    }

    @Override
    public void destroyed() {
        this.representation = this.destroyedRepresentation;
    }

    @Override
    public void reactTo(Bomberman bomberman) {

    }
}
