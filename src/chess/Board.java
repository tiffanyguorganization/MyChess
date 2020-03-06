package chess;

import javafx.scene.Group;

import javafx.scene.paint.Color;

/**
 * Chess Board is the class with tiles layout and 
 * other functions.
 * @author Tiffany Gu
 * @version 2.0
 *
 */
public class Board extends Group {
    
    /** The tiles. */
    private final Tile[][] tiles = new Tile[SIZE][SIZE];

    /** The Constant SIZE. */
    static final int SIZE = 8;
    

    /** The selected piece. */
    public static Piece selectedPiece;
    
    /** The pointer white move fail. */
    public static boolean pointerWhiteMoveFail;
    
    /** The pointer white move success. */
    public static boolean pointerWhiteMoveSuccess;
    
    /** The pointer black move fail. */
    public static boolean pointerBlackMoveFail;
    
    /** The pointer black move success. */
    public static boolean pointerBlackMoveSuccess;
    
    public static int counterBlack = 16;
    
    public static int counterWhite = 16;
    /**
     * Instantiates a new board.
     */
    public Board() {
        /* Generate all tiles */
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i+j) % 2 == 0 )
                tiles[i][j] = new Tile(i, j, Color.BLUE);
                else 
                    tiles[i][j] = new Tile(i, j, Color.YELLOW);
            }
        }
        
        /* Add tiles to board */
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                getChildren().addAll(tiles[i][j]);
            }
        }   
        
    }
    

    /**
     * Gets the array.
     *
     * @return the array
     */
    public Tile[][] getArray() {
        
        return tiles;
    }
    
    /**
     * Gets the tile.
     *
     * @param xCoor the x coor
     * @param yCoor the y coor
     * @return the tile
     */
    public Tile getTile(double xCoor,double yCoor) {
        double temp1 = xCoor;
        int counterx = 0;
        double temp2 = yCoor;
        int countery = 0;
        while (temp1 > 75.0) {
            temp1 = temp1 - 75;
            counterx++;        
            
        }
        while (temp2 > 75.0) {
            temp2 = temp2 - 75;
            countery++;              
        }
      
        return tiles[counterx][countery];      
    }
    
    /**
     * Gets the tilex.
     *
     * @param xCoor the x coor
     * @param yCoor the y coor
     * @return the tilex
     */
    public int getTilex(double xCoor,double yCoor) {
        double temp1 = xCoor;
        int counterx = 0;

        while (temp1 > 75.0) {
            temp1 = temp1 - 75;
            counterx++;         
        }

        return counterx;      
    }
    
    /**
     * Gets the tiley.
     *
     * @param xCoor the x coor
     * @param yCoor the y coor
     * @return the tiley
     */
    public int getTiley(double xCoor,double yCoor) {

        double temp2 = yCoor;
        int countery = 0;

        while (temp2 > 75) {
            temp2 = temp2 - 75;
            countery++;      
        }
        return countery;      
    }
    
    
    /**
     * Gets the num rows.
     *
     * @return the num rows
     */
    public int getNumRows() {
        return 8;
        
    }
    
    /**
     * Gets the num cols.
     *
     * @return the num cols
     */
    public int getNumCols() {
        return 8;
        
    }
    
    /**
     * Inits the pieces.
     */
    public void initPieces() {

        
        
        
        tiles[0][0].setOccupied(true);
        tiles[1][0].setOccupied(true);
        tiles[2][0].setOccupied(true);
        tiles[3][0].setOccupied(true);
        tiles[4][0].setOccupied(true);
        tiles[5][0].setOccupied(true);
        tiles[6][0].setOccupied(true);
        tiles[7][0].setOccupied(true);
        
        tiles[0][1].setOccupied(true);
        tiles[1][1].setOccupied(true);
        tiles[2][1].setOccupied(true);
        tiles[3][1].setOccupied(true);
        tiles[4][1].setOccupied(true);
        tiles[5][1].setOccupied(true);
        tiles[6][1].setOccupied(true);
        tiles[7][1].setOccupied(true);
        
        tiles[0][6].setOccupied(true);
        tiles[1][6].setOccupied(true);
        tiles[2][6].setOccupied(true);
        tiles[3][6].setOccupied(true);
        tiles[4][6].setOccupied(true);
        tiles[5][6].setOccupied(true);
        tiles[6][6].setOccupied(true);
        tiles[7][6].setOccupied(true);
        
        tiles[0][7].setOccupied(true);
        tiles[1][7].setOccupied(true);
        tiles[2][7].setOccupied(true);
        tiles[3][7].setOccupied(true);
        tiles[4][7].setOccupied(true);
        tiles[5][7].setOccupied(true);
        tiles[6][7].setOccupied(true);
        tiles[7][7].setOccupied(true);
     
    }
    

    
    /**
     * Select black piece.
     *
     * @param piece1 the piece 1
     */
    public void selectBlackPiece(Piece piece1) {
        
        if(piece1.getOwner().getColour()!=Color.WHITE) {
        piece1.getTile().setActive(true);
        
        }
        if(piece1.getTile().getActive()&&piece1.getOwner().getColour()!=Color.WHITE) {
            
            
            
            piece1.getTile().setOccupied(false);
            piece1.setTile(null);
            selectedPiece = piece1;
            

            }
        if (selectedPiece instanceof PiecePawn) {
            
            System.out.println("this is a testersssssss"+(int)Game.selectedPieceY/75);
            
            
            
            if((int)(Game.selectedPieceY/75)==1) {
                
                for (int i = 1; i < 3; i++) {
                    getTile(Game.selectedPieceX, Game.selectedPieceY+75*i).setActive(true);
                }
            } else if ((int)(Game.selectedPieceY/75)!=1) {
                for (int i = 1; i < 2; i++) {
                if(getTile(Game.selectedPieceX, Game.selectedPieceY+75*i).isOccupied()) {
                    break;
                }
                getTile(Game.selectedPieceX, Game.selectedPieceY+75*i).setActive(true);
                }
            }
            
            
        }
        else if (selectedPiece instanceof PieceQueen) {
            try {
            for (int j = 0; j < 7; j++) {
                if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY).isOccupied()) {
                    break;
                }
                getTile(Game.selectedPieceX-75*j, Game.selectedPieceY).setActive(true);
                
            }} catch (Exception e){
                System.out.println("");
            }
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX+75*j, Game.selectedPieceY).setActive(true);
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY-75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY-75*j).setActive(true);
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            try {
                for (int j = 0; j < 7; j++) {
                    
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY+75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY+75*j).setActive(true);
                    
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            try {
                for (int j = 0; j < 7; j++) {
                    
                    
                    if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY-75*j).isOccupied()) {
                        break;
                    }
                    
                    getTile(Game.selectedPieceX-75*j, Game.selectedPieceY-75*j).setActive(true);
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            try {
                for (int j = 0; j < 7; j++) {
                    
                    
                    if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY+75*j).isOccupied()) {
                        break;
                    }
                    
                    
                    getTile(Game.selectedPieceX+75*j, Game.selectedPieceY+75*j).setActive(true);
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            try {
                for (int j = 0; j < 7; j++) {
                    
                    
                    
                    if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY+75*j).isOccupied()) {
                        break;
                    }
                    
                    
                    getTile(Game.selectedPieceX-75*j, Game.selectedPieceY+75*j).setActive(true);
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            
            try {
                for (int j = 0; j < 7; j++) {
                    
                    
                    if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY-75*j).isOccupied()) {
                        break;
                    }
                    
                    
                    
                    
                    getTile(Game.selectedPieceX+75*j, Game.selectedPieceY-75*j).setActive(true);
                }} catch (Exception e){
                    System.out.println("");
                }
            
            
            
        }
        
        else if (selectedPiece instanceof PieceKnight) {
            try {
            
                System.out.println("selected"+Game.selectedPieceX);
                getTile(Game.selectedPieceX+150, Game.selectedPieceY+75).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            try {
                getTile(Game.selectedPieceX+75, Game.selectedPieceY+150).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX-75, Game.selectedPieceY+150).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX-150, Game.selectedPieceY+75).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX+75, Game.selectedPieceY-150).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX+150, Game.selectedPieceY-75).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX-75, Game.selectedPieceY-150).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX-150, Game.selectedPieceY-75).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            System.out.println("debug"+getTile(Game.selectedPieceX+75, Game.selectedPieceY+75).getActive());
            
            
            
            
            
            
            
        }
        else if (selectedPiece instanceof PieceKing) {
            try {
                for (int i = 1; i < 2; i++) {
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY+75*i).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY+75*i).setActive(true);
                    }
              
            } catch (Exception e) {
                System.out.println();
            } 
            
            try {
                
                for (int i = 1; i < 2; i++) {
                    if(getTile(Game.selectedPieceX+75*i, Game.selectedPieceY).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX+75*i, Game.selectedPieceY).setActive(true);
                    }

                
              } catch (Exception e) {
                  System.out.println();
              }
            
            try {

                for (int i = 1; i < 2; i++) {
                    if(getTile(Game.selectedPieceX-75*i, Game.selectedPieceY).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX-75*i, Game.selectedPieceY).setActive(true);
                    }
                
              } catch (Exception e) {
                  System.out.println();
              }
            
            
            try {

                for (int i = 1; i < 2; i++) {
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY-75*i).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY-75*i).setActive(true);
                    }
                
                
              } catch (Exception e) {
                  System.out.println();
              }
            
            try {
                for (int i = 1; i < 2; i++) {
                    if(getTile(Game.selectedPieceX - 75 *i, Game.selectedPieceY- 75 *i).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX-75*i, Game.selectedPieceY-75*i).setActive(true);
                    }
                
              } catch (Exception e) {
                  System.out.println();
              }
            
            
            try {

                for (int i = 1; i < 2; i++) {
                    if(getTile(Game.selectedPieceX - 75 *i, Game.selectedPieceY+ 75 *i).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX-75*i, Game.selectedPieceY+75*i).setActive(true);
                    }
                
                
              } catch (Exception e) {
                  System.out.println();
              }
            
            
            try {

                for (int i = 1; i < 2; i++) {
                    if(getTile(Game.selectedPieceX + 75 *i, Game.selectedPieceY+ 75 *i).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX+75*i, Game.selectedPieceY+75*i).setActive(true);
                    }
                
                
                
              } catch (Exception e) {
                  System.out.println();
              }
            
            try {
                for (int i = 1; i < 2; i++) {
                    if(getTile(Game.selectedPieceX + 75 *i, Game.selectedPieceY- 75 *i).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX+75*i, Game.selectedPieceY-75*i).setActive(true);
                    }
                
    
              
        } catch (Exception e) {
            System.out.println();
        }
          }
        else if (selectedPiece instanceof PieceBishop) {
//            int index_x = (int)Game.selectedPieceX / 75;
//            int index_y = (int)Game.selectedPieceY / 75;
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY-75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX-75*j, Game.selectedPieceY-75*j).setActive(true);
                    
                }
            } catch (Exception e) {
                System.out.println();
            }
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY-75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX+75*j, Game.selectedPieceY-75*j).setActive(true);
                    
                }
            } catch (Exception e) {
                System.out.println();
            }
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY+75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX+75*j, Game.selectedPieceY+75*j).setActive(true);
                    
                }
            } catch (Exception e) {
                System.out.println();
            }
            
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY+75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX-75*j, Game.selectedPieceY+75*j).setActive(true);
                }
            } catch (Exception e) {
                System.out.println();
            }
          
          }
        else if (selectedPiece instanceof PieceRook) {
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX-75*j, Game.selectedPieceY).setActive(true);
                }
            } catch (Exception e) {
                System.out.println();
            }
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX+75*j, Game.selectedPieceY).setActive(true);
                }
            } catch (Exception e) {
                System.out.println();
            }
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY+75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY+75*j).setActive(true);
                }
            } catch (Exception e) {
                System.out.println();
            }
            
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY-75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY-75*j).setActive(true);
                }
            } catch (Exception e) {
                System.out.println();
            }
            
            
          }

        
        }
        
        
    
    /**
     * Select white piece.
     *
     * @param piece1 the piece 1
     */
    public void selectWhitePiece(Piece piece1) {
        
        if(piece1.getOwner().getColour()!=Color.BLACK) {
        piece1.getTile().setActive(true);
        
        }
        
       
        if(piece1.getTile().getActive()&&piece1.getOwner().getColour()!=Color.BLACK) {
            
           
        
        piece1.getTile().setOccupied(false);
        piece1.setTile(null);
        selectedPiece = piece1;
        

        }
        if (selectedPiece instanceof PiecePawn) {
            
            System.out.println("this is a testersssssss"+(int)Game.selectedPieceY/75);
            
            
            
            if((int)(Game.selectedPieceY/75)==6) {
                
                for (int i = 1; i < 3; i++) {
                    getTile(Game.selectedPieceX, Game.selectedPieceY-75*i).setActive(true);
                }
            } else if ((int)(Game.selectedPieceY/75)!=6) {
                for (int i = 1; i < 2; i++) {
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY-75*i).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY-75*i).setActive(true);
                    }
            }
            
            
        }
        else if (selectedPiece instanceof PieceQueen) {
            try {
            for (int j = 0; j < 7; j++) {
                if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY).isOccupied()) {
                    break;
                }
                getTile(Game.selectedPieceX-75*j, Game.selectedPieceY).setActive(true);
                
            }} catch (Exception e){
                System.out.println("");
            }
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX+75*j, Game.selectedPieceY).setActive(true);
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY-75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY-75*j).setActive(true);
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            try {
                for (int j = 0; j < 7; j++) {
                    
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY+75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY+75*j).setActive(true);
                    
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            try {
                for (int j = 0; j < 7; j++) {
                    
                    
                    if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY-75*j).isOccupied()) {
                        break;
                    }
                    
                    getTile(Game.selectedPieceX-75*j, Game.selectedPieceY-75*j).setActive(true);
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            try {
                for (int j = 0; j < 7; j++) {
                    
                    
                    if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY+75*j).isOccupied()) {
                        break;
                    }
                    
                    
                    getTile(Game.selectedPieceX+75*j, Game.selectedPieceY+75*j).setActive(true);
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            try {
                for (int j = 0; j < 7; j++) {
                    
                    
                    
                    if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY+75*j).isOccupied()) {
                        break;
                    }
                    
                    
                    getTile(Game.selectedPieceX-75*j, Game.selectedPieceY+75*j).setActive(true);
                    
                }} catch (Exception e){
                    System.out.println("");
                }
            
            
            try {
                for (int j = 0; j < 7; j++) {
                    
                    
                    if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY-75*j).isOccupied()) {
                        break;
                    }
                    
                    
                    
                    
                    getTile(Game.selectedPieceX+75*j, Game.selectedPieceY-75*j).setActive(true);
                }} catch (Exception e){
                    System.out.println("");
                }
            
            
            
        }
        else if (selectedPiece instanceof PieceKnight) {
            try {
            
                System.out.println("selected"+Game.selectedPieceX);
                getTile(Game.selectedPieceX+150, Game.selectedPieceY+75).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            try {
                getTile(Game.selectedPieceX+75, Game.selectedPieceY+150).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX-75, Game.selectedPieceY+150).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX-150, Game.selectedPieceY+75).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX+75, Game.selectedPieceY-150).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX+150, Game.selectedPieceY-75).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX-75, Game.selectedPieceY-150).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            try {
                getTile(Game.selectedPieceX-150, Game.selectedPieceY-75).setActive(true);
            } catch (Exception e){
                System.out.println("");
            }
            
            
            
            
            
            
            
            
            
        }
        else if (selectedPiece instanceof PieceKing) {
          try {
              for (int i = 1; i < 2; i++) {
                  if(getTile(Game.selectedPieceX, Game.selectedPieceY+75*i).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX, Game.selectedPieceY+75*i).setActive(true);
                  }
            
          } catch (Exception e) {
              System.out.println();
          } 
          
          try {
              
              for (int i = 1; i < 2; i++) {
                  if(getTile(Game.selectedPieceX+75*i, Game.selectedPieceY).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX+75*i, Game.selectedPieceY).setActive(true);
                  }

              
            } catch (Exception e) {
                System.out.println();
            }
          
          try {

              for (int i = 1; i < 2; i++) {
                  if(getTile(Game.selectedPieceX-75*i, Game.selectedPieceY).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX-75*i, Game.selectedPieceY).setActive(true);
                  }
              
            } catch (Exception e) {
                System.out.println();
            }
          
          
          try {

              for (int i = 1; i < 2; i++) {
                  if(getTile(Game.selectedPieceX, Game.selectedPieceY-75*i).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX, Game.selectedPieceY-75*i).setActive(true);
                  }
              
              
            } catch (Exception e) {
                System.out.println();
            }
          
          try {
              for (int i = 1; i < 2; i++) {
                  if(getTile(Game.selectedPieceX - 75 *i, Game.selectedPieceY- 75 *i).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX-75*i, Game.selectedPieceY-75*i).setActive(true);
                  }
              
            } catch (Exception e) {
                System.out.println();
            }
          
          
          try {

              for (int i = 1; i < 2; i++) {
                  if(getTile(Game.selectedPieceX - 75 *i, Game.selectedPieceY+ 75 *i).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX-75*i, Game.selectedPieceY+75*i).setActive(true);
                  }
              
              
            } catch (Exception e) {
                System.out.println();
            }
          
          
          try {

              for (int i = 1; i < 2; i++) {
                  if(getTile(Game.selectedPieceX + 75 *i, Game.selectedPieceY+ 75 *i).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX+75*i, Game.selectedPieceY+75*i).setActive(true);
                  }
              
              
              
            } catch (Exception e) {
                System.out.println();
            }
          
          try {
              for (int i = 1; i < 2; i++) {
                  if(getTile(Game.selectedPieceX + 75 *i, Game.selectedPieceY- 75 *i).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX+75*i, Game.selectedPieceY-75*i).setActive(true);
                  }
              
  
            
      } catch (Exception e) {
          System.out.println();
      }
        }
        
        else if (selectedPiece instanceof PieceBishop) {
//          int index_x = (int)Game.selectedPieceX / 75;
//          int index_y = (int)Game.selectedPieceY / 75;
          
          try {
              for (int j = 0; j < 7; j++) {
                  if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY-75*j).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX-75*j, Game.selectedPieceY-75*j).setActive(true);
                  
              }
          } catch (Exception e) {
              System.out.println();
          }
          try {
              for (int j = 0; j < 7; j++) {
                  if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY-75*j).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX+75*j, Game.selectedPieceY-75*j).setActive(true);
                  
              }
          } catch (Exception e) {
              System.out.println();
          }
          
          try {
              for (int j = 0; j < 7; j++) {
                  if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY+75*j).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX+75*j, Game.selectedPieceY+75*j).setActive(true);
                  
              }
          } catch (Exception e) {
              System.out.println();
          }
          
          
          try {
              for (int j = 0; j < 7; j++) {
                  if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY+75*j).isOccupied()) {
                      break;
                  }
                  getTile(Game.selectedPieceX-75*j, Game.selectedPieceY+75*j).setActive(true);
              }
          } catch (Exception e) {
              System.out.println();
          }
        
        }
        
        
        
        else if (selectedPiece instanceof PieceRook) {
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX-75*j, Game.selectedPieceY).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX-75*j, Game.selectedPieceY).setActive(true);
                }
            } catch (Exception e) {
                System.out.println();
            }
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX+75*j, Game.selectedPieceY).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX+75*j, Game.selectedPieceY).setActive(true);
                }
            } catch (Exception e) {
                System.out.println();
            }
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY+75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY+75*j).setActive(true);
                }
            } catch (Exception e) {
                System.out.println();
            }
            
            
            try {
                for (int j = 0; j < 7; j++) {
                    if(getTile(Game.selectedPieceX, Game.selectedPieceY-75*j).isOccupied()) {
                        break;
                    }
                    getTile(Game.selectedPieceX, Game.selectedPieceY-75*j).setActive(true);
                }
            } catch (Exception e) {
                System.out.println();
            }
            
            
          }
        
        
        
        
        
      }
    
    
    /**
     * Move black piece.
     *
     * @param x the x
     * @param y the y
     */
    public void moveBlackPiece(double x, double y) {
        double newx;
        double newy;
        
        if(selectedPiece.getOwner().getColour()!=Color.WHITE) {
            if (!getTile(x, y).isOccupied()) {
            newx = 75*(getTile(x,y).getxCoor()) + 0.1;
            newy = 75*(getTile(x,y).getyCoor()) + 0.1;         
            selectedPiece.move(newx,newy);
            getTile(newx,newy).setPiece(selectedPiece);
            selectedPiece.setTile(getTile(newx,newy));
            getTile(newx,newy).setOccupied(true);
        
            pointerBlackMoveSuccess = true;
         } else if (getTile(x, y).isOccupied()){
                newx = 75*(getTile(x,y).getxCoor()) + 0.1;
                newy = 75*(getTile(x,y).getyCoor()) + 0.1;            
                getTile(x, y).returnPiece().setIsNotValid();                 
                selectedPiece.move(newx,newy);          
                getTile(newx,newy).setPiece(selectedPiece);
                selectedPiece.setTile(getTile(newx,newy));
                getTile(newx,newy).setOccupied(true);
            
                pointerBlackMoveSuccess = true;
           }
 
            } 
        
  
        
        
    }
    
    /**
     * Move white piece.
     *
     * @param x the x
     * @param y the y
     */
    public void moveWhitePiece(double x, double y) {
        double newx;
        double newy;
      

        if(selectedPiece.getOwner().getColour()!=Color.BLACK) {
           if (!getTile(x, y).isOccupied()) {
               newx = 75*(getTile(x,y).getxCoor()) + 0.1;
           

            newy = 75*(getTile(x,y).getyCoor()) + 0.1;
            
            
           
           
        selectedPiece.move(newx,newy);
        getTile(newx,newy).setPiece(selectedPiece);
        selectedPiece.setTile(getTile(newx,newy));
        getTile(newx,newy).setOccupied(true);
        pointerWhiteMoveSuccess = true;
             
            } else if (getTile(x, y).isOccupied()){
               newx = 75*(getTile(x,y).getxCoor()) + 0.1;
               

               newy = 75*(getTile(x,y).getyCoor()) + 0.1;
               
               
               getTile(x, y).returnPiece().setIsNotValid();
               
           selectedPiece.move(newx,newy);
           getTile(newx,newy).setPiece(selectedPiece);
           selectedPiece.setTile(getTile(newx,newy));
           getTile(newx,newy).setOccupied(true);
          
              
           pointerWhiteMoveSuccess = true;
           }
           
           
         }
    }
    
    /**
     * Gets the selected piece.
     *
     * @return the selected piece
     */
    public Piece getSelectedPiece() {
        return selectedPiece;
    }
}