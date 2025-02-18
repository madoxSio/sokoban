package com.gitlab.sokoban.domain.model.frame;

public class Tile {
    private State state;
    private Position position;

    public Tile(State state, Position position) {
        this.state = state;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tile)) {
            return false;
        }
        Tile tile = (Tile) obj;
        return this.state == tile.state && this.position.equals(tile.position);
    }
}
