package chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Chess PiecePawn is a child class of Piece.
 * @author Tiffany Gu
 * @version 2.0
 *
 */
public class PiecePawn extends Piece{
    private Image image;
   
//    private Tile initSQR=getTile();
    public double xPos;
    public double yPos;
    public ImageView iv;
    public Player type;
    public PiecePawn(Player type, double x, double y) {
        super(type,x, y);
        String img;
        if(type.getColour()==Color.WHITE){
            
            img = "file:src/ChessPiece/White_Pawn.png";  
            xPos = x;
            yPos = y;
        }
        else{
            img = "file:src/ChessPiece/Black_Pawn.png";

            
            xPos = x;
            yPos = y;
        }
        this.type = type;
        this.image = new Image(img);
        iv = new ImageView(image);

        iv.setY(yPos);
        iv.setX(xPos);
        getChildren().add(iv);
    }
    
    @Override
    public boolean validMove() {
      
        
        
        
        
        
        
        return true;
    }
    
    public void move(double xCoor, double yCoor) {
        
  
            iv.setX(xCoor);
            iv.setY(yCoor);

        
    }
    public void setIsNotValid() {
        iv.setX(1000.0);
        iv.setY(1000.0);
    }
    
}
