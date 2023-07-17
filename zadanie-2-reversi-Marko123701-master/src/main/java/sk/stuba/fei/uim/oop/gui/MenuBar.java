package sk.stuba.fei.uim.oop.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {
    private final Game game;
    private final JMenuItem itemX6;
    private final JMenuItem itemX8;
    private final JMenuItem itemX10;
    private final JMenuItem itemX12;
    private final JMenuItem exit;

    MenuBar(Game game){
        this.game = game;
        JMenu file = new JMenu("File");
        this.add(file);
        exit = new JMenuItem("Exit");
        file.add(exit);
        JMenu boardSize = new JMenu("BoardSize");
        this.add(boardSize);
        itemX6 = new JMenuItem("6X6");
        itemX8 = new JMenuItem("8X8");
        itemX10 = new JMenuItem("10X10");
        itemX12 = new JMenuItem("12X12");
        boardSize.add(itemX6);
        boardSize.add(itemX8);
        boardSize.add(itemX10);
        boardSize.add(itemX12);
        itemX6.addActionListener(this);
        itemX8.addActionListener(this);
        itemX10.addActionListener(this);
        itemX12.addActionListener(this);
        exit.addActionListener(this);
        game.setGridSize(new JLabel("  Current BoardSize: " + game.getGameSize() + "   "));
        this.add(new RestartButton(game));
        this.add(game.getGridSize());
        JLabel turn = new JLabel("Turn: Black!   ");
        this.add(turn);
        game.setWinner(new JLabel("Winner: "));
        this.add(game.getWinner());
        JLabel message = new JLabel("                   " +
                "If nothing can be played just click on random tile.");
        this.add(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (itemX6.equals(e.getSource())) {
            game.setGameSize(6);
            game.restartBoard();
        } else if (itemX8.equals(e.getSource())) {
            game.setGameSize(8);
            game.restartBoard();
        } else if (itemX10.equals(e.getSource())) {
            game.setGameSize(10);
            game.restartBoard();
        }else if (itemX12.equals(e.getSource())){
            game.setGameSize(12);
            game.restartBoard();
        } else if (exit.equals(e.getSource())) {
            game.getFrame().dispose();
            System.exit(0);
        }

    }
}
