package Models;

import Models.Interfaces.GameActions;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class GameLogic implements GameActions {
	
	protected static float speedFactor= 1;

	// This member will be used by the controller to  determine file to save in it or load from it --MO2--
	private String targetFileName;
	private FruitFactory fruitFactory;
	private BombFactory bombFactory;
	
	public GameLogic () {
		fruitFactory = new FruitFactory();
		bombFactory = new BombFactory();
	}

	@Override
	public GameObject createGameObject() {

		GameObject obj;
		int index = (int) MiscUtils.rand(0, 7);
		GameObjects object = GameObjects.values()[index];
		if (index < 5) {
			obj = fruitFactory.createObject(object);
		} else {
			obj = bombFactory.createObject(object);
		}
		return obj;
	}


	@Override
	public void updateObjectsLocation() {
		Game game = Game.getInstance();
		ArrayList<GameObject> list= game.getList();
		for(Iterator<GameObject> itr = list.iterator(); itr.hasNext();)
		{
			GameObject object = itr.next();
			object.move(System.currentTimeMillis());
			if (object.hasMovedOffScreen()) {
				if (!object.isSliced() && !(object.getClass().equals(DangerousBomb.class) 
						|| object.getClass().equals(FatalBomb.class)) && game.getMode()) {
					game.setLives(game.getLives()-1);
					if (game.getLives() < 1) {
						game.gameOver();
					}
					game.changeLivesLabel(game.getLives() + "");
				}
				itr.remove();
			}
		}
	}
	
	@Override
	public void sliceObjects() {
		
		ArrayList<GameObject> list = Game.getInstance().getList();
		for (GameObject object : list) {
			if (!(object.getClass().equals(DangerousBomb.class) || object.getClass().equals(FatalBomb.class) || object.isSliced()))
				object.slice();
		}

	}
	
	public void addDelayTime(double delayTime) {
		
		ArrayList<GameObject> list = Game.getInstance().getList();
		for (GameObject object : list) {
			object.eq.addDelayTime(delayTime);
		}

	}
	
	public void setSlowMotionDelayTime() {
		
		ArrayList<GameObject> list = Game.getInstance().getList();
		for (GameObject object : list) {
			object.setSlowMotionDelayTime(System.currentTimeMillis());
		}

	}

	@Override
	public void saveGame() {
		
		String sep = System.getProperty("file.separator");
		String xmlFilePath = System.getProperty("user.dir") + sep + "saved_data" + sep + targetFileName;
		Game game = Game.getInstance();
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		try {
	        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	        Document document = documentBuilder.newDocument();
	        Element root = document.createElement("Game");
	        document.appendChild(root);
	        
	        Element score = document.createElement("Score");
	        score.appendChild(document.createTextNode(game.getScore() + ""));
	        root.appendChild(score);
	
	        Element lives = document.createElement("Lives");
	        lives.appendChild(document.createTextNode(game.getLives() + ""));
	        root.appendChild(lives);
	        
	        Element diff = document.createElement("Difficulty");
	        diff.appendChild(document.createTextNode(game.getDifficulty() + ""));
	        root.appendChild(diff);
	        
	        Element mode = document.createElement("Mode");
	        mode.appendChild(document.createTextNode(game.getMode() + ""));
	        root.appendChild(mode);
	        
	        Element remainingTime = document.createElement("RemainingTime");
	        remainingTime.appendChild(document.createTextNode(game.getRemainingTime() + ""));
	        root.appendChild(remainingTime);
	        
	        Element gameObjects = document.createElement("GameObjects");
	        Element gameObject;
	        ArrayList<GameObject> list = Game.getInstance().getList();
	        for(GameObject obj: list) {
	        	gameObject = document.createElement("GameObject");
	        	
	        	Attr attr = document.createAttribute("type");
	            attr.setValue(obj.getObjectType().toString());
	            gameObject.setAttributeNode(attr);
	        	
	        	attr = document.createAttribute("x");
	            attr.setValue(obj.getXLocation()+"");
	            gameObject.setAttributeNode(attr);
	        	
	            attr = document.createAttribute("y");
	            attr.setValue(obj.getYLocation()+"");
	            gameObject.setAttributeNode(attr);
	            
	            Element eq = document.createElement("Equation");
	            
	            attr = document.createAttribute("initialSpeed");
	            attr.setValue(obj.getInitialVelocity()+"");
	            eq.setAttributeNode(attr);
	            
	            attr = document.createAttribute("projectionAngle");
	            attr.setValue(obj.eq.getProjectionAngle()+"");
	            eq.setAttributeNode(attr);
	            
	            attr = document.createAttribute("startPoint");
	            attr.setValue(obj.eq.getStartPoint()+"");
	            eq.setAttributeNode(attr);
	            
	            attr = document.createAttribute("playedTime");
	            attr.setValue(obj.getPlayedTime()+"");
	            eq.setAttributeNode(attr);
	            
	            gameObject.appendChild(eq);
	            
	            Element Decorator = document.createElement("Decorator");
	            if (obj.getClass().equals(ScoreDecorator.class) || obj.getClass().equals(SliceAllDecorator.class) 
	            		|| obj.getClass().equals(SlowDownDecorator.class)) {
	            	Decorator.appendChild(document.createTextNode(obj.getClass().getSimpleName()));
	            }
	            else {
	            	Decorator.appendChild(document.createTextNode("None"));
	            }
	            gameObject.appendChild(Decorator);
	            gameObjects.appendChild(gameObject);
	        }
	        root.appendChild(gameObjects);  
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer;
			transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
	        StreamResult streamResult = new StreamResult(new File(xmlFilePath));
	        transformer.transform(domSource, streamResult);
		} catch (Exception e) {
			e.printStackTrace();
			MiscUtils.fileNotFound();
		}

	}

	@Override
	public void loadGame() {
		String sep = System.getProperty("file.separator");
		String xmlFilePath = System.getProperty("user.dir") + sep + "saved_data" + sep + targetFileName;
		Game game = Game.getInstance();
		try {
			File file = new File(xmlFilePath);    
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	        Document document = documentBuilder.parse(file);  
			document.getDocumentElement().normalize();  
			game.setScore(Integer.parseInt(document.getElementsByTagName("Score").item(0).getTextContent()));
			game.setLives(Integer.parseInt(document.getElementsByTagName("Lives").item(0).getTextContent()));
			game.setDifficulty(Integer.parseInt(document.getElementsByTagName("Difficulty").item(0).getTextContent()));
			game.setMode(Boolean.parseBoolean(document.getElementsByTagName("Mode").item(0).getTextContent()));
			game.setRemainingTime(Integer.parseInt(document.getElementsByTagName("RemainingTime").item(0).getTextContent()));
			NodeList nodeList = document.getElementsByTagName("GameObject");    
			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  
				Node node = nodeList.item(itr);  
				Element eElement = (Element) node;
				// Create Object here
				int objectType = GameObjects.valueOf(eElement.getAttribute("type")).ordinal();
				int x = Integer.parseInt(eElement.getAttribute("x"));
				int y = Integer.parseInt(eElement.getAttribute("y"));
				Element equation = (Element) eElement.getElementsByTagName("Equation").item(0);
				float initialSpeed = Float.parseFloat(equation.getAttribute("initialSpeed").toString());
				double projectionAngle = Double.parseDouble(equation.getAttribute("projectionAngle").toString());
				float startPoint = Float.parseFloat(equation.getAttribute("startPoint").toString());
				double playedTime = Double.parseDouble(equation.getAttribute("playedTime").toString());
				GameObject obj;
				if (objectType < 5) {
					obj = fruitFactory.createObject(GameObjects.values()[objectType]);
				} else {
					obj = bombFactory.createObject(GameObjects.values()[objectType]);
				}
				obj.getImageView().setLayoutX(x);
				obj.getImageView().setLayoutY(y);
				obj.startingTime = System.currentTimeMillis() - playedTime;
				obj.setEq(new Equation(Game.screenHeight, Game.screenWidth, initialSpeed,
	            projectionAngle, startPoint));
				
				String Decorator = eElement.getElementsByTagName("Decorator").item(0).getTextContent();
				
				// Then add this object to the objectsList
				if (Decorator.equals("None")) {
					game.getList().add(obj);
				}
				else if(Decorator.equals("ScoreDecorator")) {
					game.getList().add(new ScoreDecorator(obj));
				}
				else if(Decorator.equals("SliceAllDecorator")) {
					game.getList().add(new SliceAllDecorator(obj));
				}
				else if(Decorator.equals("SlowDownDecorator")) {
					game.getList().add(new SlowDownDecorator(obj));
				}
			}  
			
			
		}   
		catch (Exception e)   
		{  
			e.printStackTrace();  
			MiscUtils.fileNotFound();
		} 
	}

	@Override
	public void resetGame() {
		Game.getInstance().setLives(3);
		Game.getInstance().setScore(0);
		Game.getInstance().getList().clear();
		Game.getInstance().setPause(false);
	}
	
	public void setTargetFile(String targetFile) {
		this.targetFileName = targetFile;
	}
}
