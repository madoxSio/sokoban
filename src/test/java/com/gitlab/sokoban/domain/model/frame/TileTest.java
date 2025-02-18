package com.gitlab.sokoban.domain.model.frame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void testEquals() {
        Tile tile1 = new Tile(State.PLAYER, new Position(1, 2));
        Tile tile2 = new Tile(State.WALL, new Position(1, 2));
        Tile tile3 = new Tile(State.PLAYER, new Position(1, 2));
        Tile tile4 = new Tile(State.STORAGE, new Position(1, 3));
        Tile tile5 = new Tile(State.BOX, new Position(1, 3));

        assertNotEquals(tile1, tile2);
        assertEquals(tile1, tile3);
        assertNotEquals(tile1, tile4);
        assertEquals(tile1, tile1);
        assertNotEquals(tile4, tile5);
    }
}
