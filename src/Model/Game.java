package Model;

import java.util.List;
import java.util.Stack;

import Model.Piece.*;

/**
 * this is the engine class that will control all the game and its logic.
 * 
 * @author mohammed
 *
 */
public class Game {

	private List<Player> players;
	private Player currPlayer;
	private int curr;
	private Piece selecetdPiece;
	private Square selectedSquare;
	private BoardBase board;
	private Stack<MovePiece>sharkStackUndo;
	private Stack<MovePiece>eagleStackUndo;
	private Stack<MovePiece>sharkStackRedo;
	private Stack<MovePiece>eagleStackRedo;

	public Game(Board board) {
		sharkStackUndo = new Stack<MovePiece>();
		sharkStackRedo = new Stack<MovePiece>();
		eagleStackUndo = new Stack<MovePiece>();
		eagleStackRedo = new Stack<MovePiece>();
		curr=0;
		
		this.board = board;
	}
	
	public Game(Board2 board) {
		sharkStackUndo = new Stack<MovePiece>();
		sharkStackRedo = new Stack<MovePiece>();
		eagleStackUndo = new Stack<MovePiece>();
		eagleStackRedo = new Stack<MovePiece>();
		curr=0;
		
		this.board = board;
	}
	
	public Game(Board3 board) {
		sharkStackUndo = new Stack<MovePiece>();
		sharkStackRedo = new Stack<MovePiece>();
		eagleStackUndo = new Stack<MovePiece>();
		eagleStackRedo = new Stack<MovePiece>();
		curr=0;
		
		this.board = board;
	}

	/**
	 * 
	 */
	public void startGame() {

	}

	/**
	 * get current player to play
	 * 
	 * @return player
	 */
	public Player getCurrentPlayer() {
		return currPlayer;
	}

	/**
	 * set current player to play
	 * 
	 * @param turn
	 */
	public void setTurn(Player p) {
		this.currPlayer = p;
	}

	/**
	 * get Piece that is selected on board
	 * 
	 * @return piece
	 */
	public Piece getSelecetdPiece() {
		return selecetdPiece;
	}

	/**
	 * set Piece that is selected on board
	 * 
	 * @param selecetdPiece
	 */
	public void setSelecetdPiece(Piece selecetdPiece) {
		this.selecetdPiece = selecetdPiece;
	}

	/**
	 * get Square that is selected on board
	 * 
	 * @return
	 */
	public Square getSelectedSquare() {
		return selectedSquare;
	}

	/**
	 * set Square that is selected on board
	 * 
	 * @param selectedSquare
	 */
	public void setSelectedSquare(Square selectedSquare) {
		this.selectedSquare = selectedSquare;
	}

	/**
	 * get players array
	 * 
	 * @return
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * get board object
	 * 
	 * @return
	 */
	public BoardBase getBoard() {
		return board;
	}

	/**
	 * this will check if given targetSquare is attackable by square and will return
	 * boolean
	 * 
	 * @param square
	 * @param targetSquare
	 * @return boolean
	 */
	public boolean attackable(Square square, Square targetSquare) {
		// obstacle is not attackable and implement code so that piece that attacks it
		// is knocked

		if (null == targetSquare.getPiece())
			return true;
		
		if (null != targetSquare.getPiece() && targetSquare.getPiece().isKnocked())
			return true;

		if(null != targetSquare.getPiece() && targetSquare.getPiece().iconName().contains("obstacle"))
			return false;

		if(null != targetSquare.getPiece() && null != square.getPiece() && targetSquare.getPiece().iconName().contains("shark") && square.getPiece().iconName().contains("shark"))
			return false;
		
		if(null != targetSquare.getPiece() && null != square.getPiece() && targetSquare.getPiece().iconName().contains("eagle") && square.getPiece().iconName().contains("eagle"))
			return false;
			
		return true;
	}

	/**
	 * attack piece
	 * 
	 * @param attackerPiece
	 * @param square
	 * @return 
	 */
	public boolean attack(Square attackerPiece, Square defencePiece) {

		if(null == attackerPiece.getPiece() || null == defencePiece.getPiece())
			return true;
		
		
		int attackPower = attackerPiece.getPiece().getAttackPower();
		int defencePower = defencePiece.getPiece().getDefencePower();
		int outcome = defencePower - attackPower; 
		System.err.println("attackPower: "+attackPower);
		System.err.println("defencePower: "+defencePower);
		System.err.println("outcome: "+outcome);
		if(outcome <= 0)
		{
			System.out.println("Attacked Success");
			defencePiece.getPiece().setDefencePower(0);
			return true;
		}
		else
		{	
			System.out.println("Attacked Failed");
			defencePiece.getPiece().setDefencePower(outcome);
			return false;			
		}
		
	}

	/**
	 * moves selected piece to selected square
	 * 
	 * @param srcSquare
	 * @param targetSquare
	 */
	public boolean move(Square srcSquare, Square targetSquare) {
		MovePiece m = new MovePiece(srcSquare, targetSquare);
		if (!attackable(srcSquare, targetSquare))
			{
			System.out.println(attackable(srcSquare, targetSquare));
			return false;
			
			}
		else
		{
			System.out.println("Attacking");
			if(!attack(srcSquare, targetSquare))
				return false;
		}
		boolean isMoved =  m.move();
		
		if(isMoved) {
			toggleCurrentTurn();
			if(targetSquare.getPiece() instanceof Shark1 ||
					targetSquare.getPiece() instanceof Shark2 ||
					targetSquare.getPiece() instanceof Shark3 ||
					targetSquare.getPiece() instanceof Shark4 ||
					targetSquare.getPiece() instanceof Shark5) {
				sharkStackUndo.push(m);
				
			}else {
				eagleStackUndo.push(m);
			}
		}
		
		return isMoved;
	}
	
	public void undo() {
		MovePiece m;
		Square s;
		Square t;
		if(curr == 0) {
			if(sharkStackUndo.isEmpty()) return;
			m = sharkStackUndo.pop();
			s = m.getSrcSquare();
			t = m.getTargetSquare();
			
			this.board.getSquare(s.getRow(), s.getCol()).setPiece(t.getPiece());
			this.board.getSquare(t.getRow(), t.getCol()).setPiece(null);
			
			sharkStackRedo.push(m);
		}else {
			if(eagleStackUndo.isEmpty()) return;
			m = eagleStackUndo.pop();
			s = m.getSrcSquare();
			t = m.getTargetSquare();
			
			this.board.getSquare(s.getRow(), s.getCol()).setPiece(t.getPiece());
			this.board.getSquare(t.getRow(), t.getCol()).setPiece(null);
			
			eagleStackRedo.push(m);
		}
	}
	
	public void redo() {
		MovePiece m;
		Square s;
		Square t;
		if(curr == 0) {
			if(sharkStackRedo.isEmpty()) return;
			m = sharkStackRedo.pop();
			s = m.getSrcSquare();
			t = m.getTargetSquare();
			
			this.board.getSquare(t.getRow(), t.getCol()).setPiece(s.getPiece());
			this.board.getSquare(s.getRow(), s.getCol()).setPiece(null);
			
			sharkStackUndo.push(m);
		}else {
			if(eagleStackRedo.isEmpty()) return;
			m = eagleStackRedo.pop();
			s = m.getSrcSquare();
			t = m.getTargetSquare();
			
			this.board.getSquare(t.getRow(), t.getCol()).setPiece(s.getPiece());
			this.board.getSquare(s.getRow(), s.getCol()).setPiece(null);
			
			eagleStackUndo.push(m);
		}
	}
	
	public void toggleCurrentTurn() {
		curr += 1;
		if(curr == 2) curr = 0;
	}
}
