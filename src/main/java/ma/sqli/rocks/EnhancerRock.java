package ma.sqli.rocks;

import ma.sqli.Location;
import ma.sqli.bomberman.Bomberman;

public class EnhancerRock implements Rock {

    private Location location = new Location();
    private int enhancerRange;

    private boolean isEnhancer = false;

    private String destroyedRepresentation;
    private String representation = "X";

    public EnhancerRock(int x, int y, int enhancerRange) {
        this.location.x = x;
        this.location.y = y;
        this.enhancerRange = enhancerRange;
        destroyedRepresentation = String.valueOf(this.enhancerRange);
    }

    @Override
    public void destroyed() {
        this.representation = this.destroyedRepresentation;
        isEnhancer = true;
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
        if(isEnhancer) {
            bomberman.setBombRange(enhancerRange);
        }
    }
}
