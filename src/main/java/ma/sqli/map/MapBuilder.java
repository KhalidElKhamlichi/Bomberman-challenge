package ma.sqli.map;

import ma.sqli.rocks.BasicRock;
import ma.sqli.rocks.EnhancerRock;
import ma.sqli.rocks.StarRock;

public class MapBuilder {

    private Map map;

    public MapBuilder(int i) {
        map = new Map(i);
    }

    public MapBuilder addRock(int x, int y) {
        map.addRock(new BasicRock(x, y));
        return this;
    }

    public Map build() {
        map.updateMap();
        return map;
    }


    public MapBuilder addStarRock(int x, int y) {
        map.addRock(new StarRock(x, y));
        return this;
    }

    public MapBuilder addEnhancerRock(int x, int y, int range) {

        map.addRock(new EnhancerRock(x, y, range));
        return this;
    }
}
