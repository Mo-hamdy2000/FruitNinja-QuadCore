package Test;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.PriorityQueue;

import Models.Player;
import Models.PlayerComparator;
import Models.ScoreBoard;

public class TestScoreboard {

	
	public static void main(String[] args) {
		ScoreBoard sb= new ScoreBoard();
       
		/* setScoreBoard method must be used
		 * *
		 */
		PriorityQueue<Player> scores = new PriorityQueue<Player>(10,new PlayerComparator());
		sb.setScoreBoard(scores);
		
		sb.getScoreBoard().add(new Player("mariam",106));
		sb.getScoreBoard().add(new Player("asmaa",69));
		sb.getScoreBoard().add(new Player("ahmad",76));
		sb.getScoreBoard().add(new Player("momen",300));
		
		sb.saveScoreBoard();
		sb=sb.loadScoreBoard();
		sb.getScoreBoard().add(new Player("jncnskn",333));
		
	 	
	     while (!sb.getScoreBoard().isEmpty()) { 
             System.out.println(sb.getScoreBoard().poll().getName()); 
             
             
     }  
	     
	     //System.out.println(System.getProperty("user.dir"+File.separator+"saved_data"));
	}
	   	
	   	
	   	
	   	
		

	}

