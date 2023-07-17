package sk.stuba.fei.uim.oop.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartButton extends JButton implements ActionListener {
    private final Game game;
    RestartButton(Game game){
        this.game = game;
        this.setText("RESTART");
        this.setBorder(null);
        this.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setFocusable(false);
        game.restartBoard();
    }
}
