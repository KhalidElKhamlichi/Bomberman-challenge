package ma.sqli.bomberman;

import ma.sqli.Location;
import ma.sqli.map.Map;

public class Bomberman {

    private final Location location = new Location();

    private Direction facingDirection = Direction.RIGHT;

    private Map map;

    private String representation;
    private final String deadRepresentation = "D";

    private int step = 1;

    private int bombRange = 1;

    public Bomberman(String name) {
        representation = name.substring(0, 1).toLowerCase();
    }

    public void startIn(Map map) {
        map.addBomber(this);
        this.map = map;
        map.updateMap();
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    public String getRepresentation() {
        return representation;
    }

    public Bomberman forward() {

        switch (facingDirection) {
            case UP:
                location.x-=step;
                break;
            case DOWN:
                location.x+=step;
                break;
            case LEFT:
                location.y-=step;
                break;
            case RIGHT:
                location.y+=step;
                break;
        }

        map.checkRockCollision(this);

        return this;
    }

    public Bomberman bomb() {
        Bomb bomb = new Bomb(location.x, location.y, bombRange);
        map.addBomb(bomb);
        return this;
    }

    public Bomberman right() {
        switch (facingDirection) {
            case UP:
                facingDirection = Direction.RIGHT;
                break;
            case DOWN:
                facingDirection = Direction.LEFT;
                break;
            case LEFT:
                facingDirection = Direction.UP;
                break;
            case RIGHT:
                facingDirection = Direction.DOWN;
                break;
        }
        return  this;
    }

    public void moveFaster() {
        step++;
    }

    public Bomberman left() {
        switch (facingDirection) {
            case UP:
                facingDirection = Direction.LEFT;
                break;
            case DOWN:
                facingDirection = Direction.RIGHT;
                break;
            case LEFT:
                facingDirection = Direction.DOWN;
                break;
            case RIGHT:
                facingDirection = Direction.UP;
                break;
        }
        return  this;
    }

    public void die() {
        representation = deadRepresentation;
    }

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public void setBombRange(int range) {
        this.bombRange = range;
    }
}
