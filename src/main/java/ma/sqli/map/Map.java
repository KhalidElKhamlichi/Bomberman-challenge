package ma.sqli.map;

import ma.sqli.bomberman.Bomb;
import ma.sqli.bomberman.Bomberman;
import ma.sqli.rocks.Rock;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private String[][] data;
    private final List<Rock> rocks = new ArrayList<>();
    private Bomberman bomberman;
    private final List<Bomb> bombs = new ArrayList<>();

    private final int size;

    public Map(int size) {
        this.size = size;
    }
    public String draw() {
        StringBuilder drawing = new StringBuilder();

        updateMap();

        for (int i=0; i<data.length; i++) {
            for (int j=0; j<data.length; j++) {
                if(data[i][j] == null) {
                    drawing.append(" ");
                }
                else {
                    drawing.append(data[i][j]);
                }
            }
            if(i != data.length-1)
                drawing.append("\n");
        }

        return drawing.toString();
    }

    public void updateMap() {
        data = new String[size][size];
        for(Rock rock : rocks) {
            data[rock.getX()][rock.getY()] = rock.getRepresentation();
        }
        for(Bomb bomb : bombs) {
            data[bomb.getX()][bomb.getY()] = bomb.getRepresentation();
        }
        if(bomberman != null)
            data[bomberman.getX()][bomberman.getY()] = bomberman.getRepresentation();

    }

    public void addRock(Rock rock) {
        rocks.add(rock);
    }

    public void addBomber(Bomberman bomber) {
        bomberman = bomber;
    }

    public void addBomb(Bomb bomb) {
        bombs.add(bomb);
    }


    public void trigger() {
        for(Bomb b : bombs) {
            b.explode(rocks, bomberman);
        }
        updateMap();
    }

    public void checkRockCollision(Bomberman bomberman) {
        List<Rock> rocksToRemove = new ArrayList<>();

        for(Rock rock : rocks) {
            if(rock.getY() == bomberman.getY() && rock.getX() == bomberman.getX()) {
                rock.reactTo(bomberman);
                rocksToRemove.add(rock);
            }
        }

        removeDesrtroyedRocks(rocksToRemove);

        updateMap();
    }

    private void removeDesrtroyedRocks(List<Rock> rocksToRemove) {
        for(Rock rock : rocksToRemove) {
            rocks.remove(rock);
        }
    }
}
