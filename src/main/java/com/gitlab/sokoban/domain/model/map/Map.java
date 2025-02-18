package com.gitlab.sokoban.domain.model.map;

import com.gitlab.sokoban.domain.model.tile.Position;
import com.gitlab.sokoban.domain.model.tile.State;
import com.gitlab.sokoban.domain.model.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int width;
    private final int height;
    private final List<Tile> tiles;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new ArrayList<>();
    }

    public boolean isWall(Position position) {
        return tiles.stream()
                .anyMatch(tile -> tile.getPosition().equals(position) && tile.getState() == State.WALL);
    }

    public boolean inside(Position position) {
        return position.getX() > 0 && position.getX() <= width &&
                position.getY() > 0 && position.getY() <= height;
    }

    public void addTile(Tile tile) {
        if (!inside(tile.getPosition())) {
            throw new IllegalArgumentException("Tile is outside of the map");
        }

        tiles.add(tile);
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

    @Override
    public String toString() {
        return "Map{" +
                "width=" + width +
                ", height=" + height +
                ", tiles=" + tiles +
                '}';
    }
}
