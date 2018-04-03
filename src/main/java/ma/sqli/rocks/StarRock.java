package ma.sqli.rocks;

import ma.sqli.Location;
import ma.sqli.bomberman.Bomberman;

public class StarRock implements Rock {

    private final Location location = new Location();

    private boolean isStar = false;
    private final String destroyedRepresentation = "*";
    private String representation = "X";

    public StarRock(int x, int y) {
        this.location.x = x;
        this.location.y = y;
    }

    @Override
    public void destroyed() {
        this.representation = this.destroyedRepresentation;
        isStar = true;
    }

    @Override
    public int getX() {
        return location.x;
    }

    @Override
    public int getY() {
        return location.y;
    }

    @Override
    public String getRepresentation() {
        return representation;
    }

    @Override
    public void reactTo(Bomberman bomberman) {
        if(isStar) {
            bomberman.moveFaster();

        }
    }
}
