package sk.stuba.fei.uim.oop.board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.gui.Game;

@Setter
@Getter
public class Tile extends JPanel implements MouseListener {
    private int player=0;
    private final Point point;
    private boolean isPlayable;
    private final Game game;

    Tile(Color color, int player,Point point,Game game) {
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#2F2323")));
        this.setPlayer(player);
        this.setOpaque(true);
        this.setBackground(color);
        this.addMouseListener(this);
        this.isPlayable = false;
        this.point = point;
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        boolean nothingPlayable = this.game.getGameLogic().nothingPlayable(this.game.getTileData());

        if(!nothingPlayable) {
            if (this.player == 0 && this.isPlayable) {
                this.setPlayer(1);
                this.setBackground(Color.decode("#000000"));
                this.game.getGameLogic().flipTiles(1,this, this.game.getTileData(), this.game.getGameSize());
                this.game.getBasicAi().turn(game, false);

            }
        }else this.game.getBasicAi().turn(game, true);
        if(this.game.getGameLogic().allFilled(this.game.getTileData())){
            this.game.getGameLogic().getWinner(this.getGame());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(this.isPlayable){
            this.setBorder(BorderFactory.createLineBorder(Color.decode("#B50303"),4));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(this.isPlayable){
            this.setBorder(BorderFactory.createLineBorder(Color.decode("#2A21AB"), 4));
        }
        else this.setBorder(BorderFactory.createLineBorder(Color.decode("#2F2323")));
    }
}
