package com.gitlab.sokoban.domain.model.frame;

import java.util.List;

public class Map {
    private final int width;
    private final int height;
    private final List<Tile> tiles;

    public Map(int width, int height, List<Tile> tiles) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
    }

    public boolean isWall(Position position) {
        return tiles.stream()
                .anyMatch(tile -> tile.getPosition().equals(position) && tile.getState() == State.WALL);
    }

    public boolean inside(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
                position.getY() >= 0 && position.getY() < height;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Map map = (Map) obj;
        return width == map.width && height == map.height && tiles.equals(map.tiles);
    }

    @Override
    public int hashCode() {
        return 31 * width + 31 * height + tiles.hashCode();
    }
}
