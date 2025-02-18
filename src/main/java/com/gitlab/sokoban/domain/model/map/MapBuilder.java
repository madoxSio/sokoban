package com.gitlab.sokoban.domain.model.map;

import com.gitlab.sokoban.domain.model.tile.Position;
import com.gitlab.sokoban.domain.model.tile.State;
import com.gitlab.sokoban.domain.model.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class MapBuilder {

    public static List<Tile> toTiles(String mapString) {
        List<Tile> tiles = new ArrayList<>();
        String[] lines = mapString.split("\n");

        for (int y = 0; y < lines.length; y++) {
            String line = lines[y];

            for (int x = 0; x < line.length(); x++) {
                char symbol = line.charAt(x);
                State state = charToState(symbol);

                if (state != null) {
                    tiles.add(new Tile(state, new Position(x, y)));
                }
            }
        }
        return tiles;
    }

    public static Map build(String mapString) {
        List<Tile> tiles = toTiles(mapString);

        int width = mapString.indexOf("\n"); // Largeur = longueur de la première ligne
        int height = mapString.split("\n").length; // Hauteur = nombre de lignes

        return new Map(width, height);
    }

    private static State charToState(char symbol) {
        return switch (symbol) {
            case '#' -> State.WALL;
            case '$' -> State.BOX;
            case '.' -> State.STORAGE;
            case '@' -> State.PLAYER;
            case ' ' -> State.EMPTY;
            default -> null;
        };
    }
}
