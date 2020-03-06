package chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Chess PieceQueen
 * @author Tiffany Gu
 * @version 2.0
 *
 */
public class PieceQueen extends Piece{
    private Image image;
   

    public double xPos;
    public double yPos;
    public ImageView iv;
    public PieceQueen(Player type, double x, double y) {
        super(type,x, y);
        String img;
        if(type.getColour()==Color.WHITE){
            //image = new Image("file:src/ChessPiece/White_Bishop.png");
            img = "file:src/ChessPiece/White_Queen.png";
            //ImageView imageView = new ImageView();
            //imageView.setImage(image);
            //setSquare(initSQR);
//            imageView.fitHeightProperty();
//            imageView.fitWidthProperty();
//            imageView.setPreserveRatio(true);
//            imageView.setSmooth(true);
//            imageView.setCache(true);
            
            
            
            
            
            
            xPos = x;
            yPos = y;
        }
        else{
            img = "file:src/ChessPiece/Black_Queen.png";

            
            xPos = x;
            yPos = y;
        }
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
