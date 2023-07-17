package sk.stuba.fei.uim.oop.controls;

import sk.stuba.fei.uim.oop.board.Tile;
import sk.stuba.fei.uim.oop.gui.Game;
import javax.swing.*;
import java.awt.*;

public class GameLogic {

    public void checkPossibleMove( int player, Tile[][] tileData, int gameSize) {

        checkUp(player, tileData, gameSize);
        checkDown(player, tileData, gameSize);
        checkLeft(player, tileData, gameSize);
        checkRight(player, tileData, gameSize);
        checkDiagonalLeftDown(player, tileData, gameSize);
        checkDiagonalRightDown(player, tileData, gameSize);
        checkDiagonalLeftUp(player, tileData, gameSize);
        checkDiagonalRightUp(player, tileData, gameSize);

    }

    public void checkUp(int player, Tile[][] tileData, int gameSize) {
        int pointX;
        int pointY;
        boolean end;
        int notPlayer = 1;
        if (player == 1) {
            notPlayer = 2;
        }

        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                end = false;
                pointX = (int) tile.getPoint().getX();
                pointY = (int) tile.getPoint().getY();
                if(tile.getPlayer() == player){
                while (pointX - 1 >= 0 && pointX - 1 < gameSize && pointY >= 0 && pointY < gameSize && !end) {
                    if (tileData[pointX - 1][pointY].getPlayer() == notPlayer) {
                        if (pointX - 2 >= 0 && pointX - 2 < gameSize) {
                            if (tileData[pointX - 2][pointY].getPlayer() == 0) {
                                tileData[pointX - 2][pointY].setBorder(BorderFactory.createLineBorder(Color.decode("#2A21AB"), 4));
                                tileData[pointX - 2][pointY].setPlayable(true);
                                end = true;
                            } else if (tileData[pointX - 2][pointY].getPlayer() == notPlayer) {
                                pointX = pointX - 1;
                            } else {
                                end = true;
                            }
                        } else {
                            end = true;
                        }
                    } else {
                        end = true;
                    }
                }
                }
            }
        }
    }

    public void checkDown(int player, Tile[][] tileData, int gameSize) {
        int pointX;
        int pointY;
        boolean end;
        int notPlayer = 1;
        if (player == 1) {
            notPlayer = 2;
        }
        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                end = false;
                pointX = (int) tile.getPoint().getX();
                pointY = (int) tile.getPoint().getY();
                if (tile.getPlayer() == player) {
                    while (pointX + 1 >= 0 && pointX + 1 < gameSize && pointY >= 0 && pointY < gameSize && !end) {
                        if (tileData[pointX + 1][pointY].getPlayer() == notPlayer) {
                            if (pointX + 2 < gameSize) {
                                if (tileData[pointX + 2][pointY].getPlayer() == 0) {
                                    tileData[pointX + 2][pointY].setBorder(BorderFactory.createLineBorder(Color.decode("#2A21AB"), 4));
                                    tileData[pointX + 2][pointY].setPlayable(true);
                                    end = true;
                                } else if (tileData[pointX + 2][pointY].getPlayer() == notPlayer) {
                                    pointX = pointX + 1;
                                } else {
                                    end = true;
                                }
                            } else {
                                end = true;
                            }
                        } else {
                            end = true;
                        }
                    }
                }
            }
        }
    }

    public void checkLeft(int player, Tile[][] tileData, int gameSize) {
        int pointX;
        int pointY;
        boolean end;
        int notPlayer = 1;
        if (player == 1) {
            notPlayer = 2;
        }

        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                end = false;
                pointX = (int) tile.getPoint().getX();
                pointY = (int) tile.getPoint().getY();
                if (tile.getPlayer() == player) {
                    while (pointX >= 0 && pointX < gameSize && pointY - 1 >= 0 && pointY - 1 < gameSize && !end) {
                        if (tileData[pointX][pointY - 1].getPlayer() == notPlayer) {
                            if (pointY - 2 >= 0 && pointY - 2 < gameSize) {
                                if (tileData[pointX][pointY - 2].getPlayer() == 0) {
                                    tileData[pointX][pointY - 2].setBorder(BorderFactory.createLineBorder(Color.decode("#2A21AB"), 4));
                                    tileData[pointX][pointY - 2].setPlayable(true);
                                    end = true;
                                } else if (tileData[pointX][pointY - 2].getPlayer() == notPlayer) {
                                    pointY = pointY - 1;
                                } else {
                                    end = true;
                                }
                            } else {
                                end = true;
                            }
                        } else {
                            end = true;
                        }
                    }

                }
            }
        }
    }

    public void checkRight(int player, Tile[][] tileData, int gameSize) {
        int pointX;
        int pointY;
        boolean end;
        int notPlayer = 1;
        if (player == 1) {
            notPlayer = 2;
        }

        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                end = false;
                pointX = (int) tile.getPoint().getX();
                pointY = (int) tile.getPoint().getY();
                if (tile.getPlayer() == player) {
                    while (pointX >= 0 && pointX < gameSize && pointY + 1 >= 0 && pointY + 1 < gameSize && !end) {
                        if (tileData[pointX][pointY + 1].getPlayer() == notPlayer) {
                            if (pointY + 2 < gameSize) {
                                if (tileData[pointX][pointY + 2].getPlayer() == 0) {
                                    tileData[pointX][pointY + 2].setBorder(BorderFactory.createLineBorder(Color.decode("#2A21AB"), 4));
                                    tileData[pointX][pointY + 2].setPlayable(true);
                                    end = true;
                                } else if (tileData[pointX][pointY + 2].getPlayer() == notPlayer) {
                                    pointY = pointY + 1;
                                } else {
                                    end = true;
                                }
                            } else {
                                end = true;
                            }
                        } else {
                            end = true;
                        }
                    }
                }
            }
        }
    }

    public void checkDiagonalRightDown(int player, Tile[][] tileData, int gameSize) {
        int pointX;
        int pointY;
        boolean end;
        int notPlayer = 1;
        if (player == 1) {
            notPlayer = 2;
        }

        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                end = false;
                pointX = (int) tile.getPoint().getX();
                pointY = (int) tile.getPoint().getY();
                if (tile.getPlayer() == player) {
                    while (pointX - 1 >= 0 && pointX - 1 < gameSize && pointY + 1 >= 0 && pointY + 1 < gameSize && !end) {
                        if (tileData[pointX - 1][pointY + 1].getPlayer() == notPlayer) {
                            if (pointX - 2 >= 0 && pointX - 2 < gameSize && pointY + 2 < gameSize) {
                                if (tileData[pointX - 2][pointY + 2].getPlayer() == 0) {
                                    tileData[pointX - 2][pointY + 2].setBorder(BorderFactory.createLineBorder(Color.decode("#2A21AB"), 4));
                                    tileData[pointX - 2][pointY + 2].setPlayable(true);
                                    end = true;
                                } else if (tileData[pointX - 2][pointY + 2].getPlayer() == notPlayer) {
                                    pointY = pointY + 1;
                                    pointX = pointX - 1;
                                } else {
                                    end = true;
                                }
                            } else {
                                end = true;
                            }
                        } else {
                            end = true;
                        }
                    }

                }
            }
        }
    }

    public void checkDiagonalLeftDown(int player,Tile[][] tileData,int gameSize) {
        int pointX;
        int pointY;
        boolean end;
        int notPlayer = 1;
        if (player == 1) {
            notPlayer = 2;
        }
        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                end = false;
                pointX = (int) tile.getPoint().getX();
                pointY = (int) tile.getPoint().getY();
                if (tile.getPlayer() == player) {
                    while (pointX + 1 >= 0 && pointX + 1 < gameSize && pointY + 1 >= 0 && pointY + 1 < gameSize && !end) {
                        if (tileData[pointX + 1][pointY + 1].getPlayer() == notPlayer) {
                            if (pointX + 2 < gameSize && pointY + 2 < gameSize) {
                                if (tileData[pointX + 2][pointY + 2].getPlayer() == 0) {
                                    tileData[pointX + 2][pointY + 2].setBorder(BorderFactory.createLineBorder(Color.decode("#2A21AB"), 4));
                                    tileData[pointX + 2][pointY + 2].setPlayable(true);
                                    end = true;
                                } else if (tileData[pointX + 2][pointY + 2].getPlayer() == notPlayer) {
                                    pointX = pointX + 1;
                                    pointY = pointY + 1;
                                } else {
                                    end = true;
                                }
                            } else {
                                end = true;
                            }
                        } else {
                            end = true;
                        }
                    }

                }
            }
        }
    }

    public void checkDiagonalRightUp(int player,Tile[][] tileData,int gameSize) {
        int pointX;
        int pointY;
        boolean end;
        int notPlayer = 1;
        if (player == 1) {
            notPlayer = 2;
        }

        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                end = false;
                pointX = (int) tile.getPoint().getX();
                pointY = (int) tile.getPoint().getY();
                if (tile.getPlayer() == player) {
                    while (pointX + 1 >= 0 && pointX + 1 < gameSize && pointY - 1 >= 0 && pointY - 1 < gameSize && !end) {
                        if (tileData[pointX + 1][pointY - 1].getPlayer() == notPlayer) {
                            if (pointX + 2 < gameSize && pointY - 2 >= 0 && pointY - 2 < gameSize) {
                                if (tileData[pointX + 2][pointY - 2].getPlayer() == 0) {
                                    tileData[pointX + 2][pointY - 2].setBorder(BorderFactory.createLineBorder(Color.decode("#2A21AB"), 4));
                                    tileData[pointX + 2][pointY - 2].setPlayable(true);
                                    end = true;
                                } else if (tileData[pointX + 2][pointY - 2].getPlayer() == notPlayer) {
                                    pointY = pointY - 1;
                                    pointX = pointX + 1;
                                } else {
                                    end = true;
                                }
                            } else {
                                end = true;
                            }
                        } else {
                            end = true;
                        }
                    }
                }
            }
        }
    }

    public void checkDiagonalLeftUp(int player,Tile[][] tileData,int gameSize) {
        int pointX;
        int pointY;
        boolean end;
        int notPlayer = 1;
        if (player == 1) {
            notPlayer = 2;
        }
        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                end = false;
                pointX = (int) tile.getPoint().getX();
                pointY = (int) tile.getPoint().getY();
                if (tile.getPlayer() == player) {
                    while (pointX - 1 >= 0 && pointX - 1 < gameSize && pointY - 1 >= 0 && pointY - 1 < gameSize && !end) {
                        if (tileData[pointX - 1][pointY - 1].getPlayer() == notPlayer) {
                            if (pointX - 2 >= 0 && pointX - 2 < gameSize && pointY - 2 >= 0 && pointY - 2 < gameSize) {
                                if (tileData[pointX - 2][pointY - 2].getPlayer() == 0) {
                                    tileData[pointX - 2][pointY - 2].setBorder(BorderFactory.createLineBorder(Color.decode("#2A21AB"), 4));
                                    tileData[pointX - 2][pointY - 2].setPlayable(true);
                                    end = true;
                                } else if (tileData[pointX - 2][pointY - 2].getPlayer() == notPlayer) {
                                    pointX = pointX - 1;
                                    pointY = pointY - 1;
                                } else {
                                    end = true;
                                }
                            } else {
                                end = true;
                            }
                        } else {
                            end = true;
                        }
                    }
                }
            }
        }
    }

    public void flipTiles(int player,Tile tile,Tile[][] tileData,int gameSize) {
        int notPlayer = 1;
        if (player == 1) {
            notPlayer = 2;
        }
        flipDown(player,notPlayer,tile,tileData,gameSize);
        flipUp(player,notPlayer,tile,tileData,gameSize);
        flipLeft(player,notPlayer,tile,tileData,gameSize);
        flipRight(player,notPlayer,tile,tileData,gameSize);
        flipDiagonalRightUp(player,notPlayer,tile,tileData,gameSize);
        flipDiagonalLeftUp(player,notPlayer,tile,tileData,gameSize);
        flipDiagonalLeftDown(player,notPlayer,tile,tileData,gameSize);
        flipDiagonalRightDown(player,notPlayer,tile,tileData,gameSize);
    }

    public void flipDown(int player, int notPlayer,Tile tile,Tile[][] tileData,int gameSize) {
        int pointX;
        int pointY;
        boolean end;

        end = false;
        pointX = (int) tile.getPoint().getX();
        pointY = (int) tile.getPoint().getY();
        while (pointX + 1 >= 0 && pointX + 1 < gameSize && pointY >= 0 && pointY < gameSize && !end) {
            if (tileData[pointX + 1][pointY].getPlayer() == notPlayer) {
                if (pointX + 2 < gameSize) {
                    if (tileData[pointX + 2][pointY].getPlayer() == player) {
                        for (int k = pointX + 1; k > tile.getPoint().getX(); k--) {
                            if (player == 1) tileData[k][pointY].setBackground(Color.decode("#000000"));
                            else tileData[k][pointY].setBackground(Color.decode("#FFFFFF"));
                            tileData[k][pointY].setPlayer(player);
                        }
                        end = true;
                    } else if (tileData[pointX + 2][pointY].getPlayer() == notPlayer) {
                        pointX = pointX + 1;
                    } else {
                        end = true;
                    }
                } else {
                    end = true;
                }
            } else {
                end = true;
            }
        }
    }

    public void flipUp(int player, int notPlayer,Tile tile,Tile[][] tileData,int gameSize) {
        int pointX;
        int pointY;
        boolean end;

        end = false;
        pointX = (int) tile.getPoint().getX();
        pointY = (int) tile.getPoint().getY();
        while (pointX - 1 >= 0 && pointX - 1 < gameSize && pointY >= 0 && pointY < gameSize && !end) {
            if (tileData[pointX - 1][pointY].getPlayer() == notPlayer) {
                if (pointX - 2 >= 0 && pointX - 2 < gameSize) {
                    if (tileData[pointX - 2][pointY].getPlayer() == player) {
                        for (int k = pointX - 2; k < (int)tile.getPoint().getX(); k++) {
                            if (player == 1) tileData[k][pointY].setBackground(Color.decode("#000000"));
                            else tileData[k][pointY].setBackground(Color.decode("#FFFFFF"));
                            tileData[k][pointY].setPlayer(player);
                        }
                        end = true;
                    } else if (tileData[pointX - 2][pointY].getPlayer() == notPlayer) {
                        pointX = pointX - 1;
                    } else {
                        end = true;
                    }
                } else {
                    end = true;
                }
            } else {
                end = true;
            }
        }
    }

    public void flipLeft(int player, int notPlayer,Tile tile,Tile[][] tileData,int gameSize) {
        int pointX;
        int pointY;
        boolean end;

        end = false;
        pointX = (int) tile.getPoint().getX();
        pointY = (int) tile.getPoint().getY();

        while (pointX >= 0 && pointX < gameSize && pointY - 1 >= 0 && pointY - 1 < gameSize && !end) {
            if (tileData[pointX][pointY - 1].getPlayer() == notPlayer) {
                if (pointY - 2 >= 0 && pointY - 2 < gameSize) {
                    if (tileData[pointX][pointY - 2].getPlayer() == player) {
                        for (int k = pointY - 1; k <= (int)tile.getPoint().getY(); k++) {
                            if (player == 1) tileData[pointX][k].setBackground(Color.decode("#000000"));
                            else tileData[pointX][k].setBackground(Color.decode("#FFFFFF"));
                            tileData[pointX][k].setPlayer(player);
                        }
                        end = true;
                    } else if (tileData[pointX][pointY - 2].getPlayer() == notPlayer) {
                        pointY = pointY - 1;
                    } else {
                        end = true;
                    }
                } else {
                    end = true;
                }
            } else {
                end = true;
            }
        }
    }

    public void flipRight(int player, int notPlayer,Tile tile,Tile[][] tileData,int gameSize){
        int pointX;
        int pointY;
        boolean end;

        end = false;
        pointX = (int) tile.getPoint().getX();
        pointY = (int) tile.getPoint().getY();

         while (pointX >= 0 && pointX < gameSize && pointY + 1 >= 0 && pointY + 1 < gameSize && !end) {
             if (tileData[pointX][pointY + 1].getPlayer() == notPlayer) {
                 if (pointY + 2 < gameSize) {
                     if (tileData[pointX][pointY + 2].getPlayer() == player) {
                         for (int k = pointY + 1; k > (int)tile.getPoint().getY(); k--) {
                             if (player == 1) tileData[pointX][k].setBackground(Color.decode("#000000"));
                             else tileData[pointX][k].setBackground(Color.decode("#FFFFFF"));
                             tileData[pointX][k].setPlayer(player);
                         }
                         end = true;
                     } else if (tileData[pointX][pointY + 2].getPlayer() == notPlayer) {
                         pointY = pointY + 1;
                     } else {
                         end = true;
                     }
                 } else {
                     end = true;
                 }
             } else {
                 end = true;
             }
         }
    }

    public void flipDiagonalLeftDown(int player, int notPlayer,Tile tile,Tile[][] tileData,int gameSize){
        int pointX;
        int pointY;
        boolean end;

        end = false;
        pointX = (int) tile.getPoint().getX();
        pointY = (int) tile.getPoint().getY();

        while (pointX + 1 >= 0 && pointX + 1 < gameSize && pointY - 1 >= 0 && pointY - 1 < gameSize && !end) {
            if (tileData[pointX + 1][pointY - 1].getPlayer() == notPlayer) {
                if (pointX + 2 < gameSize && pointY - 2 >= 0 && pointY - 2 < gameSize) {
                    if (tileData[pointX + 2][pointY - 2].getPlayer() == player) {
                        int m = pointX + 1;
                        for (int k = pointY - 1; k < (int)tile.getPoint().getY(); k++) {
                            if (player == 1) tileData[m][k].setBackground(Color.decode("#000000"));
                            else tileData[m][k].setBackground(Color.decode("#FFFFFF"));
                            tileData[m][k].setPlayer(player);
                            m--;
                        }
                        end = true;
                    } else if (tileData[pointX + 2][pointY - 2].getPlayer() == notPlayer) {
                        pointY = pointY - 1;
                        pointX = pointX + 1;
                    } else {
                        end = true;
                    }
                } else {
                    end = true;
                }
            } else {
                end = true;
            }
        }
    }

    public void flipDiagonalRightUp(int player, int notPlayer,Tile tile,Tile[][] tileData,int gameSize){
        int pointX;
        int pointY;
        boolean end;

        end = false;
        pointX = (int) tile.getPoint().getX();
        pointY = (int) tile.getPoint().getY();

        while (pointX - 1 >= 0 && pointX - 1 < gameSize && pointY + 1 >= 0 && pointY + 1 < gameSize && !end) {
            if (tileData[pointX - 1][pointY + 1].getPlayer() == notPlayer) {
                if (pointX - 2 >= 0 && pointX - 2 < gameSize && pointY + 2 < gameSize) {
                    if (tileData[pointX - 2][pointY + 2].getPlayer() == player) {
                        int m = pointX - 1;
                        for (int k = pointY + 1; k > (int)tile.getPoint().getY(); k--) {
                            if (player == 1) tileData[m][k].setBackground(Color.decode("#000000"));
                            else tileData[m][k].setBackground(Color.decode("#FFFFFF"));
                            tileData[m][k].setPlayer(player);
                            if (m < gameSize - 1) {
                                m++;
                            }
                        }
                        end = true;
                    } else if (tileData[pointX - 2][pointY + 2].getPlayer() == notPlayer) {
                        pointY = pointY + 1;
                        pointX = pointX - 1;
                    } else {
                        end = true;
                    }
                } else {
                    end = true;
                }
            } else {
                end = true;
            }
        }
    }

    public void flipDiagonalLeftUp(int player, int notPlayer,Tile tile,Tile[][] tileData,int gameSize){
        int pointX;
        int pointY;
        boolean end;

        end = false;
        pointX = (int) tile.getPoint().getX();
        pointY = (int) tile.getPoint().getY();

        while (pointX - 1 >= 0 && pointX - 1 < gameSize && pointY - 1 >= 0 && pointY - 1 < gameSize && !end) {
            if (tileData[pointX - 1][pointY - 1].getPlayer() == notPlayer) {
                if (pointX - 2 >= 0 && pointX - 2 < gameSize && pointY - 2 >= 0 && pointY - 2 < gameSize) {
                    if (tileData[pointX - 2][pointY - 2].getPlayer() == player) {
                        int m = pointX - 1;
                        for (int k = pointY - 1; k < (int)tile.getPoint().getY(); k++) {
                            if (player == 1) tileData[m][k].setBackground(Color.decode("#000000"));
                            else tileData[m][k].setBackground(Color.decode("#FFFFFF"));
                            tileData[m][k].setPlayer(player);
                            m++;
                        }
                        end = true;
                    } else if (tileData[pointX - 2][pointY - 2].getPlayer() == notPlayer) {
                        pointX = pointX - 1;
                        pointY = pointY - 1;
                    } else {
                        end = true;
                    }
                } else {
                    end = true;
                }
            } else {
                end = true;
        }
    }
    }

    public void flipDiagonalRightDown(int player, int notPlayer,Tile tile,Tile[][] tileData,int gameSize) {
        int pointX;
        int pointY;
        boolean end;

        end = false;
        pointX = (int) tile.getPoint().getX();
        pointY = (int) tile.getPoint().getY();

        while (pointX + 1 >= 0 && pointX + 1 < gameSize && pointY + 1 >= 0 && pointY + 1 < gameSize && !end) {
            if (tileData[pointX + 1][pointY + 1].getPlayer() == notPlayer) {
                if (pointX + 2 < gameSize && pointY + 2 < gameSize) {
                    if (tileData[pointX + 2][pointY + 2].getPlayer() == player) {
                        int m = pointX + 1;
                        for (int k = pointY + 1; k > (int)tile.getPoint().getY(); k--) {
                            if (player == 1) tileData[m][k].setBackground(Color.decode("#000000"));
                            else tileData[m][k].setBackground(Color.decode("#FFFFFF"));
                            tileData[m][k].setPlayer(player);
                            if (m > 0) {
                                m--;
                            }
                        }
                        end = true;
                    } else if (tileData[pointX + 2][pointY + 2].getPlayer() == notPlayer) {
                        pointX = pointX + 1;
                        pointY = pointY + 1;
                    } else {
                        end = true;
                    }
                } else {
                    end = true;
                }
            } else {
                end = true;
            }
        }
    }

    public void resetPlayable(Tile[][] tileData){
        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                if(tile.isPlayable()) {
                    tile.setPlayable(false);
                }
            }
        }
    }

    public void resetPossibleMoves(Tile[][] tileData){
        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                tile.setBorder(BorderFactory.createLineBorder(Color.decode("#2F2323")));
            }
        }
    }

    public boolean nothingPlayable(Tile[][] tileData){
        boolean somethingPlayable = false;

        outerLoop:
        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                if (tile.isPlayable()) {
                    somethingPlayable = true;
                    break outerLoop;
                }
            }
        }
        return !somethingPlayable;
    }

    public int tilesCount(Tile[][] tileData,int player){
        int tilesCount = 0;
        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                if(tile.getPlayer() == player){
                    tilesCount++;
                }
            }
        }
        return tilesCount;
    }

    public void getWinner(Game game){
        int winner;
        int player1Tiles = this.tilesCount(game.getTileData(),1);
        int player2Tiles = this.tilesCount(game.getTileData(),2);

        if(player1Tiles > player2Tiles){
            winner = 1;
        } else if (player2Tiles > player1Tiles) {
            winner = 2;
        }
        else winner = 0;

        switch (winner) {
            case 0:
                game.getWinner().setText("Winner: DRAW!");
                JOptionPane.showMessageDialog(game.getFrame(),
                        "ITS DRAW\nBLACK " + player1Tiles + "\nWHITE " + player2Tiles,"Game is over",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                game.getWinner().setText("Winner: BLACK!");
                JOptionPane.showMessageDialog(game.getFrame(),
                        "PLAYER BLACK WINS!\nBLACK " + player1Tiles + "\nWHITE " + player2Tiles,"Game is over",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                game.getWinner().setText("Winner: WHITE!");
                JOptionPane.showMessageDialog(game.getFrame(),
                        "PLAYER WHITE WINS!\nBLACK " + player1Tiles + "\nWHITE " + player2Tiles,"Game is over",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public boolean allFilled(Tile[][] tileData){
        for (Tile[] tiles : tileData) {
            for (var tile : tiles) {
                if(tile.getPlayer() == 0){
                    return false;
                }
            }
        }
        return true;
    }
}