package Models;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.PriorityQueue;



public class ScoreBoard {
	
	private final static String sbPath= System.getProperty("user.dir")+File.separator+"saved_data"+File.separator+"scoreboard.xml";
	
	private PriorityQueue<Player> scoreBoard=new PriorityQueue<Player>(10,new PlayerComparator()); 
	
	public ScoreBoard()
	{}
	

	
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
	
	public ScoreBoard loadScoreBoard()
	{
		  ScoreBoard sb=null;
		try {
			XMLDecoder e = new XMLDecoder( new BufferedInputStream(
			        new FileInputStream(sbPath)));
		    sb=(ScoreBoard) e.readObject();
			e.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
		
	}




	public PriorityQueue<Player> getScoreBoard() {
		return scoreBoard;
	}



	public void setScoreBoard(PriorityQueue<Player> scoreBoard) {
		this.scoreBoard = scoreBoard;
	}
	
	
	

}
