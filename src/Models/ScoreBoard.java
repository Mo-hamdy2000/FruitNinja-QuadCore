package Models;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.PriorityQueue;



public class ScoreBoard {
	
	private final static String sbPath= System.getProperty("user.dir")+File.separator+"saved_data"+File.separator+"scoreboard.xml";
	
	private PriorityQueue<Player> scoreBoard = new PriorityQueue<Player>(10,new PlayerComparator()); 
	
	public void saveScoreBoard()
	{
		  
	   	try {
			XMLEncoder e = new XMLEncoder( new BufferedOutputStream(
			        new FileOutputStream(sbPath)));
			e.writeObject(this);
			e.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	   
	}
	
	static public ScoreBoard loadScoreBoard()
	{
		ScoreBoard sb=null;
		try {
			XMLDecoder e = new XMLDecoder( new BufferedInputStream(
			        new FileInputStream(sbPath)));
		    sb=(ScoreBoard) e.readObject();
			e.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sb;
		
	}
	
	public PriorityQueue<Player> getScoreBoard() {
		return scoreBoard;
	}
	
	
	/*
	 * 3 for new high score
	 * 2 for achieving new score
	 * 1 for not achieving new score but already in the scoreboard
	 * 0 for not entering the scoreboard
	 * */
	public int addPlayer(Player player) {
		Iterator<Player> it = scoreBoard.iterator();
		while (it.hasNext()) {
			Player plyr = (Player) it.next();
			if (plyr.getName().toLowerCase().equals(player.getName().toLowerCase())) {
				if (player.getScore() > plyr.getScore()) {
					plyr.setScore(player.getScore());
					if (scoreBoard.peek().getScore() == player.getScore()) {
						return 3;
					}
					else {
						return 2;
					}
				}
				else {
					return 1;
				}
			}
		}
		
		if (scoreBoard.size() < 10) {
			scoreBoard.add(player);
			if (scoreBoard.peek().getScore() == player.getScore()) {
				return 3;
			}
			else{
				return 2;
			}
		}
		else {
			scoreBoard.add(player);
			Player minPlayer = getMinimum();
			scoreBoard.remove(minPlayer);
			if (minPlayer.equals(player)) {
				return 0;
			}
			else {
				return 2;
			}
		}
	}
	
	public Player getMinimum () {
		Iterator<Player> it = scoreBoard.iterator();
		if (scoreBoard.isEmpty()) {
			return null;
		}
		Player minPlayer = scoreBoard.peek();
		while (it.hasNext()) {
			Player plyr = (Player)it.next();
			if (plyr.getScore() < minPlayer.getScore()) {
				minPlayer = plyr;
			}
		}
		return minPlayer;
	}
	
	public void setScoreBoard(PriorityQueue<Player> scoreBoard) {
		this.scoreBoard = scoreBoard;
	}
	
	
	

}
