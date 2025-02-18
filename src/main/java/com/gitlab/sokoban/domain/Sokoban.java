package com.gitlab.sokoban.domain;

import com.gitlab.sokoban.domain.model.map.Map;
import com.gitlab.sokoban.domain.model.tile.Position;
import com.gitlab.sokoban.domain.model.tile.State;
import com.gitlab.sokoban.domain.model.tile.Tile;

import java.util.List;

public class Sokoban {
    private final Map map;
    private final List<Position> storages;
    private final Position playerPosition;

    public Sokoban(Map map, List<Position> storages, Position playerPosition) {
        this.map = map;
        this.storages = storages;
        this.playerPosition = playerPosition;
        initMap();
    }

    private void initMap() {
        map.addTile(new Tile(State.PLAYER, playerPosition));
        storages.forEach(storage -> map.addTile(new Tile(State.STORAGE, storage)));
    }

    public List<Tile> getTiles() {
        return map.getTiles();
    }
}
