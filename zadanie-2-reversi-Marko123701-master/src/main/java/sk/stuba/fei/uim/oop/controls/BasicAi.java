package sk.stuba.fei.uim.oop.controls;

import sk.stuba.fei.uim.oop.board.Tile;
import sk.stuba.fei.uim.oop.gui.Game;
import java.awt.*;

public class BasicAi {
    public void turn(Game game,boolean nothingPlayable) {
        game.getGameLogic().resetPossibleMoves(game.getTileData());
        game.getGameLogic().resetPlayable(game.getTileData());
        game.getGameLogic().checkPossibleMove(2, game.getTileData(), game.getGameSize());

        if(game.getGameLogic().nothingPlayable(game.getTileData()) && nothingPlayable){
            game.getGameLogic().getWinner(game);
        }
        else if(!game.getGameLogic().nothingPlayable(game.getTileData())) {
            outerLoop:
            for (Tile[] tiles : game.getTileData()) {
                for (var tile : tiles) {
                    if (tile.isPlayable()) {
                        tile.setPlayer(2);
                        tile.setBackground(Color.decode("#FFFFFF"));
                        game.getGameLogic().flipTiles(2, tile, game.getTileData(), game.getGameSize());
                        break outerLoop;
                    }
                }
            }
            game.getGameLogic().resetPossibleMoves(game.getTileData());
            game.getGameLogic().resetPlayable(game.getTileData());
            game.getGameLogic().checkPossibleMove(1, game.getTileData(), game.getGameSize());
            if(game.getGameLogic().nothingPlayable(game.getTileData()) && nothingPlayable){
                turn(game,true);
            }
        }
    }
}
