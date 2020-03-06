package chess;

import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chess Game class is the main scene of the game.
 * @author Tiffany Gu
 * @version 2.0
 *
 */
public class Game extends Application {
    
    
    /** The tile. */
    Tile tile;
    
    /** The board. */
    private Board board;

    /** Group of all images. */
    private Pane root;
    
    /** The selected piece. */
    public static Piece selectedPiece;
    
    public static double selectedPieceX;
    
    public static double selectedPieceY;
    
    /** The white player. */
    private final Player whitePlayer;
    
    /** The black player. */
    private final Player blackPlayer;
    
    /** The current player. */
    private Player currentPlayer;
    
    /** The Wbishop. */
    public Piece Wbishop;
    
    /** The Wbishop 2. */
    public Piece Wbishop2;
    
    /** The Wrook. */
    public Piece Wrook;
    
    /** The Wrook 2. */
    public Piece Wrook2;
    
    /** The Wpawn. */
    public Piece Wpawn;
    
    /** The Wpawn 2. */
    public Piece Wpawn2;
    
    /** The Wpawn 3. */
    public Piece Wpawn3;
    
    /** The Wpawn 4. */
    public Piece Wpawn4;
    
    /** The Wpawn 5. */
    public Piece Wpawn5;
    
    /** The Wpawn 6. */
    public Piece Wpawn6;
    
    /** The Wpawn 7. */
    public Piece Wpawn7;
    
    /** The Wpawn 8. */
    public Piece Wpawn8;
    
    /** The Wking. */
    public Piece Wking;
    
    /** The Wqueen. */
    public Piece Wqueen;
    
    /** The Wknight. */
    public Piece Wknight;
    
    /** The Wknight 2. */
    public Piece Wknight2;
    
    /** The Bbishop. */
    public Piece Bbishop;
    
    /** The Bbishop 2. */
    public Piece Bbishop2;
    
    /** The Brook. */
    public Piece Brook;
    
    /** The Brook 2. */
    public Piece Brook2;
    
    /** The Bpawn. */
    public Piece Bpawn;
    
    /** The Bpawn 2. */
    public Piece Bpawn2;
    
    /** The Bpawn 3. */
    public Piece Bpawn3;
    
    /** The Bpawn 4. */
    public Piece Bpawn4;
    
    /** The Bpawn 5. */
    public Piece Bpawn5;
    
    /** The Bpawn 6. */
    public Piece Bpawn6;
    
    /** The Bpawn 7. */
    public Piece Bpawn7;
    
    /** The Bpawn 8. */
    public Piece Bpawn8;
    
    /** The Bking. */
    public Piece Bking;
    
    /** The Bqueen. */
    public Piece Bqueen;
    
    /** The Bknight. */
    public Piece Bknight;
    
    /** The Bknight 2. */
    public Piece Bknight2;
    
    /** The game. */
    public Game game;
    
    /** The count text. */
    private Text countText;
    
    /** The status. */
    public GridPane status;
    
    /**
     * Instantiates a new game.
     */
    public Game() {
        this.whitePlayer = new Player(Color.WHITE);
        this.blackPlayer = new Player(Color.BLACK);
        board = new Board();
        status = new GridPane();
        countText = new Text("Black Player Turn");
        
        status.add(countText,0,0);    
    }
    

    /**
     * Initialize the board and pieces.
     *
     * @param primaryStage the primary stage
     */
    public void start(Stage primaryStage) {
        // create the board with 75 for each tile

        
        root = new Pane(board,status);
        instantiate();
        
        //app size
        final int appWidth = 600;
        final int appHeight = 600;
        Scene scene = new Scene(root, appWidth, appHeight, Color.WHITE);
        //Scene scene = new Scene(board);
        root.getChildren().addAll(Wbishop, Wbishop2, Bbishop, Bbishop2,
                
                Wrook,Wrook2, Brook,Brook2,
                Wpawn,Wpawn2,Wpawn3,Wpawn4,Wpawn5,Wpawn6,Wpawn7,Wpawn8,
                Bpawn,Bpawn2,Bpawn3,Bpawn4,Bpawn5,Bpawn6,Bpawn7,Bpawn8,
                Wking, Bking, Wqueen,Bqueen, Wknight,Wknight2,Bknight,Bknight2);
        /* disable the resizing function of window */
        //primaryStage.setResizable(false);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    
    
        
        
        
        /* Display the position respect to the mouse click */
       
        
        scene.setOnMousePressed(
                /**
                 * Mouse event.
                 */
                new EventHandler<MouseEvent>() {
            
                    /**
                     * Handle.
                     *
                     * @param event the event
                     */
                    public void handle(MouseEvent event) {
                        
                        board.getTile(event.getX(), event.getY()).setFill(Color.ANTIQUEWHITE);
      
                        
                        selectedPiece= board.getTile(event.getX(), event.getY()).returnPiece();
                        selectedPiece.setTile(board.getTile(event.getX(), event.getY()));
                        selectedPieceX = event.getX();
                        selectedPieceY = event.getY();
                        
                        System.out.println("game"+selectedPiece);
                        System.out.println(board.getTile(event.getX(), event.getY()));
                        if(currentPlayer.getColour()==Color.BLACK) {
                           
                            
                            board.selectBlackPiece(selectedPiece);
                            
                        } else {
                            
                            board.selectWhitePiece(selectedPiece);
                        }
                        
                       
                        
                        

                
                
                    }

                });
        scene.setOnMouseReleased(
                /**
                 * Mouse Event.
                 */
                new EventHandler<MouseEvent>() {
            
            /**
             * Handle.
             *
             * @param event the event
             */
                    public void handle(MouseEvent event) {              
                        board.getTile(selectedPieceX, selectedPieceY).setFill(board.getTile(selectedPieceX, selectedPieceY).getColor());
                        try{System.out.println("board.getTile(event.getX(), event.getY()).getActive()"
                                +board.getTile(event.getX(), event.getY()).getActive());
                            
                            if(currentPlayer == blackPlayer
                                    &&board.getTile(event.getX(), event.getY()).getActive()) {
                                
                                System.out.println("board.getTile(event.getX(), event.getY()).getActive()"
                                        +board.getTile(event.getX(), event.getY()).getActive());
                                board.moveBlackPiece(event.getX(),event.getY());
                            } else if (currentPlayer == whitePlayer
                                    &&board.getTile(event.getX(), event.getY()).getActive()) {
                                
                               
                                board.moveWhitePiece(event.getX(),event.getY());
                            }else 
                                System.out.println("random test");}catch (Exception e){
                            
                                System.out.println("Error!");
                            }
                
                        
                        if(currentPlayer == blackPlayer&&Board.pointerBlackMoveSuccess == true) {
                            switchPlayers();
                            System.out.println("tester move success");
                            Board.pointerBlackMoveSuccess = false;
                        } 
                        else if (currentPlayer == whitePlayer&&Board.pointerWhiteMoveSuccess == true) {
                            System.out.println("tester move success2");
                            switchPlayers();  
                
                        Board.pointerWhiteMoveSuccess = false;
                        }
                        
                    }
                    

                });

        
        }
    
    /**
     * Instantiate.
     */
    public void instantiate() {
        this.currentPlayer = blackPlayer;
        Wbishop = new PieceBishop(whitePlayer,150.1,525.1);
        Wbishop.setTile(board.getTile(150.1, 525.1));
       
       
        
        
        board.getTile(150.1, 525.1).setPiece(Wbishop);
        
        Wbishop2 = new PieceBishop(whitePlayer,375.1,525.1);
        Wbishop2.setTile(board.getTile(375.1,525.1));
        board.getTile(375.1,525.1).setPiece(Wbishop2);
        
        Bbishop = new PieceBishop(blackPlayer,150.1,0.1);
        Bbishop.setTile(board.getTile(150.1,0.1));
        board.getTile(150.1,0.1).setPiece(Bbishop);
        
        
        
        Bbishop2 = new PieceBishop(blackPlayer,375.1,0.1);
        Bbishop2.setTile(board.getTile(375.1,0.1));
        board.getTile(375.1,0.1).setPiece(Bbishop2);
        
        Wrook = new PieceRook(blackPlayer,0.1,0.1);
        Wrook.setTile(board.getTile(0.1,0.1));
        board.getTile(0.1,0.1).setPiece(Wrook);
        
        
        
        
        Wrook2 = new PieceRook(blackPlayer,525.1,0.1);
        Wrook2.setTile(board.getTile(525.1,0.1));
        board.getTile(525.1,0.1).setPiece(Wrook2);
        
        
        
        
        Brook = new PieceRook(whitePlayer,0.1,525.1);
        Brook.setTile(board.getTile(0.1,525.1));
        board.getTile(0.1,525.1).setPiece(Brook);   
        
        
        Brook2 = new PieceRook(whitePlayer,525.1, 525.1);
        Brook2.setTile(board.getTile(525.1, 525.1));
        board.getTile(525.1, 525.1).setPiece(Brook2);   
        
        
        
        Wpawn = new PiecePawn(blackPlayer,0.1,75.1);
        Wpawn.setTile(board.getTile(0.1,75.1));
        board.getTile(0.1,75.1).setPiece(Wpawn); 
        
        
        Wpawn2 = new PiecePawn(blackPlayer,75.1,75.1);
        Wpawn2.setTile(board.getTile(75.1,75.1));
        board.getTile(75.1,75.1).setPiece(Wpawn2); 
        
        Wpawn3 = new PiecePawn(blackPlayer,150.1,75.1);
        Wpawn3.setTile(board.getTile(150.1,75.1));
        board.getTile(150.1,75.1).setPiece(Wpawn3); 
        
        Wpawn4 = new PiecePawn(blackPlayer,225.1,75.1);
        Wpawn4.setTile(board.getTile(225.1,75.1));
        board.getTile(225.1,75.1).setPiece(Wpawn4); 
        
        
        Wpawn5 = new PiecePawn(blackPlayer,300.1,75.1);
        Wpawn5.setTile(board.getTile(300.1,75.1));
        board.getTile(300.1,75.1).setPiece(Wpawn5); 
        
        Wpawn6 = new PiecePawn(blackPlayer,375.1,75.1);
        Wpawn6.setTile(board.getTile(375.1,75.1));
        board.getTile(375.1,75.1).setPiece(Wpawn6); 
        
        Wpawn7 = new PiecePawn(blackPlayer,450.1,75.1);
        Wpawn7.setTile(board.getTile(450.1,75.1));
        board.getTile(450.1,75.1).setPiece(Wpawn7); 
        
        Wpawn8 = new PiecePawn(blackPlayer,525.1,75.1);
        Wpawn8.setTile(board.getTile(525.1,75.1));
        board.getTile(525.1,75.1).setPiece(Wpawn8); 
        
        
        
        
        Bpawn = new PiecePawn(whitePlayer,0.1,450.1);
        Bpawn.setTile(board.getTile(0.1,450.1));
        board.getTile(0.1,450.1).setPiece(Bpawn); 
        
        Bpawn2 = new PiecePawn(whitePlayer,75.1,450.1);
        Bpawn2.setTile(board.getTile(75.1,450.1));
        board.getTile(75.1,450.1).setPiece(Bpawn2); 
        
        Bpawn3 = new PiecePawn(whitePlayer,150.1,450.1);
        Bpawn3.setTile(board.getTile(150.1,450.1));
        board.getTile(150.1,450.1).setPiece(Bpawn3); 
        
        Bpawn4 = new PiecePawn(whitePlayer,225.1,450.1);
        Bpawn4.setTile(board.getTile(225.1,450.1));
        board.getTile(225.1,450.1).setPiece(Bpawn4); 
        
        Bpawn5 = new PiecePawn(whitePlayer,300.1,450.1);
        Bpawn5.setTile(board.getTile(300.1,450.1));
        board.getTile(300.1,450.1).setPiece(Bpawn5); 
        
        Bpawn6 = new PiecePawn(whitePlayer,375.1,450.1);
        Bpawn6.setTile(board.getTile(375.1,450.1));
        board.getTile(375.1,450.1).setPiece(Bpawn6); 
        
        
        Bpawn7 = new PiecePawn(whitePlayer,450.1,450.1);
        Bpawn7.setTile(board.getTile(450.1,450.1));
        board.getTile(450.1,450.1).setPiece(Bpawn7); 
        
        Bpawn8 = new PiecePawn(whitePlayer,525.1,450.1);
        Bpawn8.setTile(board.getTile(525.1,450.1));
        board.getTile(525.1,450.1).setPiece(Bpawn8); 
        
        Wking = new PieceKing(blackPlayer,300.1,0.1);
        Wking.setTile(board.getTile(300.1,0.1));
        board.getTile(300.1,0.1).setPiece(Wking); 
        
        
        Bking = new PieceKing(whitePlayer,300.1,525.1);
        Bking.setTile(board.getTile(300.1,525.1));
        board.getTile(300.1,525.1).setPiece(Bking); 
        
        Wqueen = new PieceQueen(blackPlayer,225.1,0.1);
        Wqueen.setTile(board.getTile(225.1,0.1));
        board.getTile(225.1,0.1).setPiece(Wqueen); 
        
        Bqueen = new PieceQueen(whitePlayer,225.1,525.1);
        Bqueen.setTile(board.getTile(225.1,525.1));
        board.getTile(225.1,525.1).setPiece(Bqueen); 
        
        Wknight = new PieceKnight(blackPlayer, 75.1,0.1);
        Wknight.setTile(board.getTile(75.1,0.1));
        board.getTile(75.1,0.1).setPiece(Wknight); 
        
        Wknight2 = new PieceKnight(blackPlayer, 450.1,0.1);
        Wknight2.setTile(board.getTile(450.1,0.1));
        board.getTile(450.1,0.1).setPiece(Wknight2); 
        
        Bknight = new PieceKnight(whitePlayer, 75.1,525.1);
        Bknight.setTile(board.getTile(75.1,525.1));
        board.getTile(75.1,525.1).setPiece(Bknight); 
        
        Bknight2 = new PieceKnight(whitePlayer, 450.1, 525.1);
        Bknight2.setTile(board.getTile(450.1, 525.1));
        board.getTile(450.1, 525.1).setPiece(Bknight2); 
        
        board.initPieces();
        activateBlack();
    }




    /**
     * Switch players.
     */
    public void switchPlayers() {
        if(Board.counterBlack ==1 && Board.counterWhite >1) {
            
            countText.setText("Black player lost!");
            
        } else if(Board.counterWhite ==1 && Board.counterBlack >1) {
            
            countText.setText("White player lost!");
        }
        
        
        else if (this.currentPlayer == this.blackPlayer) {
            this.currentPlayer = this.whitePlayer;
            countText.setText("White Player Turn");    
            
        } else if (this.currentPlayer == this.whitePlayer){
            this.currentPlayer = this.blackPlayer;
            countText.setText("Black Player Turn");
        }
        for (int x = 0; x < board.getNumCols();x++) {
            for(int y = 0; y < board.getNumCols();y++) {
                board.getArray()[x][y].setActive(false);
//                System.out.println("tsterejiofjeoijfioewj");
            }
        }
    }
    
    /**
     * Gets the current player.
     *
     * @return the current player
     */
    public Player getCurrentPlayer() {
        
        return currentPlayer;
    }
    
    /**
     * Activate black.
     */
    public void activateBlack() {
        
        Bbishop.getTile().setActive(true);
        
        Bbishop2.getTile().setActive(true);
        Brook.getTile().setActive(true);
        Brook2.getTile().setActive(true);
        Bpawn.getTile().setActive(true);
        Bpawn2.getTile().setActive(true);
        Bpawn3.getTile().setActive(true);
        Bpawn4.getTile().setActive(true);
        Bpawn5.getTile().setActive(true);
        Bpawn6.getTile().setActive(true);
        Bpawn7.getTile().setActive(true);
        Bpawn8.getTile().setActive(true);
        Bking.getTile().setActive(true);
        Bqueen.getTile().setActive(true);
        Bknight.getTile().setActive(true);
        Bknight2.getTile().setActive(true);
        
    }

}