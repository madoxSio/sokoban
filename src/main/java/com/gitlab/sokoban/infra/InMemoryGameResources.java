package com.gitlab.sokoban.infra;


import com.gitlab.sokoban.domain.Sokoban;
import com.gitlab.sokoban.domain.features.GameResources;
import com.gitlab.sokoban.domain.livingdoc.Stub;
import com.gitlab.sokoban.domain.model.map.MapBuilder;
import com.gitlab.sokoban.domain.model.tile.Position;

import java.util.Arrays;

@Stub
public class InMemoryGameResources implements GameResources {
    @Override
    public Sokoban get() {
        return new Sokoban(MapBuilder.build(
                """
                        01234567890123456789
                        0     #####
                        1     #   #
                        2     #$  #
                        3   ###  $##
                        4   #  $ $ #
                        5 ### # ## #   ######
                        6 #   # ## #####  ..#
                        7 # $  $          ..#
                        8 ##### ### #@##  ..#
                        9     #     #########
                        0     ########
                        """
        ), Arrays.asList(
                new Position(7, 9),
                new Position(0, 7),
                new Position(6, 7),
                new Position(4, 6),
                new Position(5, 4)
        ), new Position(8, 2));
    }
}


