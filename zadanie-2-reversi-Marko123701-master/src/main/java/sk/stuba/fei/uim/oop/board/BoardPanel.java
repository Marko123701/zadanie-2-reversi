package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.gui.Game;
import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    public BoardPanel(int length, int[][] data, Tile[][] tileData,Game game)   {

        this.setLayout(new GridLayout(length, length));
        int num = 1;
        Color[] colors = {Color.decode("#19E227"), Color.decode("#0DC00D")};

        for (int i = 0; i < length; i++)
        {
            num = (num == 0) ? 1:0;
            for (int j = 0; j < length; j++)
            {
                if(data[i][j] == 1){
                    Point point = new Point(i,j);
                    Tile tile = new Tile(Color.decode("#000000"),1,point,game);
                    tileData[i][j] = tile;
                    this.add(tile);
                }
                else if(data[i][j] == 2){
                    Point point = new Point(i,j);
                    Tile tile = new Tile(Color.decode("#FFFFFF"),2,point,game);
                    tileData[i][j] = tile;
                    this.add(tile);
                }
                else{
                    Point point = new Point(i,j);
                    Tile tile = new Tile(colors[num],0,point,game);
                    tileData[i][j] = tile;
                    this.add(tile);
                }
                num = (num == 0) ? 1:0;
            }
        }
    }

}
