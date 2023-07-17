package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.board.BoardPanel;
import sk.stuba.fei.uim.oop.board.Tile;
import sk.stuba.fei.uim.oop.controls.BasicAi;
import sk.stuba.fei.uim.oop.controls.GameLogic;
import javax.swing.*;
import java.awt.event.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game extends JFrame implements KeyListener {
    private int[][] data;
    private Tile[][] tileData;
    private int gameSize;
    private JFrame frame;
    private GameLogic gameLogic;
    private BasicAi basicAi;
    private JLabel gridSize;
    private JLabel winner;

    public Game() {
        frame = new JFrame("Reversi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(930, 670);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.addKeyListener(this);
        gameLogic = new GameLogic();
        basicAi = new BasicAi();
        gameSize = 6;
        tileData = new Tile[gameSize][gameSize];
        data = new int[gameSize][gameSize];
        frame.setJMenuBar(new MenuBar(this));

        //Start
        initialize();
        BoardPanel boardPanel = new BoardPanel(gameSize, data, tileData, this);
        frame.add(boardPanel);
        gameLogic.checkPossibleMove(1, tileData, gameSize);

        frame.setVisible(true);
    }

    void initialize() {
        this.data[(gameSize / 2) - 1][(gameSize / 2) - 1] = 1;
        this.data[gameSize / 2][gameSize / 2] = 1;
        this.data[gameSize / 2][(gameSize / 2) - 1] = 2;
        this.data[(gameSize / 2) - 1][gameSize / 2] = 2;

    }

    void restartBoard() {
        data = new int[gameSize][gameSize];
        tileData = new Tile[gameSize][gameSize];
        initialize();
        frame.getContentPane().removeAll();
        frame.add(new BoardPanel(gameSize, data, tileData, this));
        gameLogic.checkPossibleMove(1, tileData, gameSize);
        gridSize.setText("  Current BoardSize: " + gameSize + "   ");
        winner.setText("Winner: ");
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.setFocusable(true);
        if (e.getKeyChar() == 'r') {
            restartBoard();
        }
        if ((int) e.getKeyChar() == 27) {
            frame.dispose();
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
