package chess;

import javafx.scene.Group;


/**
 * Chess Piece class is a class with functions 
 * related to parent class of piece.
 * @author Tiffany Gu
 * @version 1.0
 *
 */
public abstract class Piece extends Group {
    protected double xPos;
    protected double yPos;
    public Player player;
    public Tile tile;
    
    public Piece(Player player, double x, double y) {
      this.xPos = x;
      this.yPos = y;
      this.player = player;
      
      
    }
    public Player getOwner() {
      return player;
      
    }
    public void setTile(Tile tile1) {
      tile = tile1;   
    }
    public Tile getTile() {
      return tile;
      
    }
    public void setIsNotValid() {
       
    }
    
    public abstract boolean validMove();
    public abstract void move(double x, double y);
    }
