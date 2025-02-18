package com.gitlab.sokoban.domain.model.map;

import com.gitlab.sokoban.domain.model.tile.Position;
import com.gitlab.sokoban.domain.model.tile.State;
import com.gitlab.sokoban.domain.model.tile.Tile;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    private static final Map map = new Map(5, 5);

    @BeforeAll
    static void setUp() {
        map.addTile(new Tile(State.WALL, new Position(1, 1)));
        map.addTile(new Tile(State.WALL, new Position(1, 2)));
        map.addTile(new Tile(State.WALL, new Position(1, 3)));
        map.addTile(new Tile(State.EMPTY, new Position(2, 3)));
        map.addTile(new Tile(State.BOX, new Position(2, 4)));
        map.addTile(new Tile(State.BOX_STORED, new Position(3, 2)));
        map.addTile(new Tile(State.PLAYER, new Position(4, 2)));
        map.addTile(new Tile(State.STORAGE, new Position(4, 4)));

    }

    @Test
    void isWall() {
        assertTrue(map.isWall(new Position(1, 1)));
        assertTrue(map.isWall(new Position(1, 2)));
        assertTrue(map.isWall(new Position(1, 3)));

        assertFalse(map.isWall(new Position(2, 3)));
        assertFalse(map.isWall(new Position(2, 4)));
        assertFalse(map.isWall(new Position(3, 2)));
        assertFalse(map.isWall(new Position(4, 2)));
        assertFalse(map.isWall(new Position(4, 4)));
    }

    @Test
    void inside() {
        assertTrue(map.inside(new Position(1, 1)));
        assertTrue(map.inside(new Position(1, 2)));
        assertTrue(map.inside(new Position(5, 5)));

        assertFalse(map.inside(new Position(0, 0)));
        assertFalse(map.inside(new Position(0, 1)));
        assertFalse(map.inside(new Position(1, 0)));
        assertFalse(map.inside(new Position(6, 5)));
    }

    @Test
    void testEquals() {
        Map map2 = new Map(5, 5);
        map2.addTile(new Tile(State.WALL, new Position(1, 1)));
        map2.addTile(new Tile(State.WALL, new Position(1, 2)));
        map2.addTile(new Tile(State.WALL, new Position(1, 3)));
        map2.addTile(new Tile(State.EMPTY, new Position(2, 3)));
        map2.addTile(new Tile(State.BOX, new Position(2, 4)));
        map2.addTile(new Tile(State.BOX_STORED, new Position(3, 2)));
        map2.addTile(new Tile(State.PLAYER, new Position(4, 2)));
        map2.addTile(new Tile(State.STORAGE, new Position(4, 4)));
        assertEquals(map, map2);

        map2.addTile(new Tile(State.PLAYER, new Position(1, 1)));
        assertNotEquals(map, map2);

        Map map3 = new Map(6, 6);
        map.addTile(new Tile(State.WALL, new Position(1, 1)));
        map.addTile(new Tile(State.WALL, new Position(1, 2)));
        map.addTile(new Tile(State.WALL, new Position(1, 3)));
        map.addTile(new Tile(State.EMPTY, new Position(2, 3)));
        map.addTile(new Tile(State.BOX, new Position(2, 4)));
        map.addTile(new Tile(State.BOX_STORED, new Position(3, 2)));
        map.addTile(new Tile(State.PLAYER, new Position(4, 2)));
        map.addTile(new Tile(State.STORAGE, new Position(4, 4)));
        assertNotEquals(map, map3);
    }
}
