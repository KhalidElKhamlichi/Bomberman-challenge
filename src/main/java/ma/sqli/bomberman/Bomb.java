package ma.sqli.bomberman;

import ma.sqli.Location;
import ma.sqli.rocks.Rock;

import java.util.List;

public class Bomb {

    private final Location location = new Location();

    private String representation = "o";

    private int range;

    public Bomb(int x, int y, int range) {
        this.location.x = x;
        this.location.y = y;
        this.range = range;
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

    public void explode(List<Rock> rocks, Bomberman bomberman) {
        representation = " ";
        destroyRocks(rocks);
        killBomber(bomberman);
    }

    private void destroyRocks(List<Rock> rocks) {
        for(Rock rock : rocks) {
            if(canHit(rock.getX(), rock.getY()))
                rock.destroyed();
        }
    }

    private void killBomber(Bomberman bomberman) {
        if(canHit(bomberman.getX(), bomberman.getY())) {
            bomberman.die();
        }
    }

    private boolean canHit(int x, int y) {
        if(x == this.location.x) {
            if(y <= this.location.y+range && y >= this.location.y-range)
                return true;
        }
        if(y == this.location.y) {
            if(x >= this.location.x-range && x <= this.location.x+range)
                return true;
        }

        return false;

    }



}
