package com.gitlab.sokoban.domain.model.map;

import com.gitlab.sokoban.domain.model.tile.Position;
import com.gitlab.sokoban.domain.model.tile.State;
import com.gitlab.sokoban.domain.model.tile.Tile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapBuilderTest {

    @Test
    void testToTiles() {
        // Carte Sokoban sous forme de String
        String mapString =
                "###\n" +
                        "#.@\n" +
                        "###";

        // Conversion en Tiles
        List<Tile> tiles = MapBuilder.toTiles(mapString);

        // Vérifier que la liste contient le bon nombre de Tiles
        assertEquals(9, tiles.size());

        // Vérifier la position et l'état des tiles
        assertTrue(tiles.contains(new Tile(State.WALL, new Position(0, 0))));
        assertTrue(tiles.contains(new Tile(State.WALL, new Position(1, 0))));
        assertTrue(tiles.contains(new Tile(State.WALL, new Position(2, 0))));
        assertTrue(tiles.contains(new Tile(State.WALL, new Position(0, 2))));
        assertTrue(tiles.contains(new Tile(State.WALL, new Position(1, 2))));
        assertTrue(tiles.contains(new Tile(State.WALL, new Position(2, 2))));
        assertTrue(tiles.contains(new Tile(State.PLAYER, new Position(2, 1))));
    }

    @Test
    void testBuild() {
        // Carte Sokoban sous forme de String
        String mapString =
                "####\n" +
                        "#  #\n" +
                        "####";

        // Construire la carte
        Map map = MapBuilder.build(mapString);

        // Vérifier la largeur et la hauteur
        assertEquals(4, map.getWidth());
        assertEquals(3, map.getHeight());
    }
}
