package com.gitlab.sokoban.domain.model.frame;

import javax.swing.text.Position;

public class Tile {
    private State state;
    private Position position;


    public Tile(State state, Position position) {
        this.state = state;
        this.position = position;
    }
}
