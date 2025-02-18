package com.gitlab.sokoban.domain.model.frame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    void testEquals() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(1, 2);
        Position position3 = new Position(2, 2);
        Position position4 = new Position(1, 3);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
        assertNotEquals(position1, position4);
        assertEquals(position1, position1);
    }
}
