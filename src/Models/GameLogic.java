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

public class GameLogic implements GameActions {
	

	private GameProperties gameProperties;
	protected ArrayList<GameObject> objectsList;
	protected static float speedFactor=1;

	// This member will be used by the controller to  determine file to save in it or load from it --MO2--
	private String targetFileName;

	public GameProperties getGameProperties() {
		return gameProperties;
	}

	public ArrayList<GameObject> getGameObjects()
	{
		return objectsList;
	}


	@Override
	public GameObject createGameObject() {

		GameObjectfactory factory;
		GameObject obj;
		int index = (int) MiscUtils.rand(0, 7);
		GameObjects object = GameObjects.values()[index];
		if (index < 5) {
			factory = new FruitFactory();
			obj = factory.createObject(object);
		} else {
			factory = new BombFactory();
			obj = factory.createObject(object);
		}
		//System.out.println(index);
		return obj;
	}


	@Override
	public void updateObjectsLocation() {
		
		ArrayList<GameObject> list=Game.getInstance().getList();
		for(GameObject object:list)
			object.move(System.currentTimeMillis());
		
	}

	@Override
	public void sliceObjects() {
		
		ArrayList<GameObject> list = Game.getInstance().getList();
		for (GameObject object : list) {
			if (!(object.getClass().equals(Bomb.class) || object.isSliced()))
				object.slice();
		}

	}

	@Override
	public void saveGame() {
		
		this.targetFileName = "file1.xml"; 
		String sep = System.getProperty("file.separator");
		String xmlFilePath = System.getProperty("user.dir") + sep + "saved_data" + sep + targetFileName;
		
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		try {
	        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	        Document document = documentBuilder.newDocument();
	        Element root = document.createElement("Game");
	        document.appendChild(root);
	        
	        Element score = document.createElement("Score");
	        score.appendChild(document.createTextNode(gameProperties.getScore() + ""));
	        root.appendChild(score);
	
	        Element lives = document.createElement("Lives");
	        lives.appendChild(document.createTextNode(gameProperties.getLives() + ""));
	        root.appendChild(lives);
	
	        Element gameObjects = document.createElement("GameObjects");
	        Element gameObject;
	        for(GameObject obj: objectsList) {
	        	gameObject = document.createElement("GameObject");
	        	gameObject.appendChild(document.createTextNode(obj.getObjectType().toString()));
	        	Attr attr = document.createAttribute("x");
	            attr.setValue(obj.getXLocation()+"");
	            gameObject.setAttributeNode(attr);
	        	
	            attr = document.createAttribute("y");
	            attr.setValue(obj.getYLocation()+"");
	            gameObject.setAttributeNode(attr);
	            
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

        System.out.println("Done creating XML File");
	}

	@Override
	public void loadGame() {
		this.targetFileName = "file1.xml";
		String sep = System.getProperty("file.separator");
		String xmlFilePath = System.getProperty("user.dir") + sep + "saved_data" + sep + targetFileName;
		try {
			File file = new File(xmlFilePath);    
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	        Document document = documentBuilder.parse(file);  
			document.getDocumentElement().normalize();  
			System.out.println("Root element: " + document.getDocumentElement().getNodeName());
			System.out.println("Score: " + document.getElementsByTagName("Score").item(0).getTextContent());
			System.out.println("Lives: " + document.getElementsByTagName("Lives").item(0).getTextContent());
			NodeList nodeList = document.getElementsByTagName("GameObject");    
			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  
				Node node = nodeList.item(itr);  
				Element eElement = (Element) node;
				// Create Object here --MO2--
				GameObjects objectType = GameObjects.valueOf(eElement.getTextContent());
				System.out.println("Type: "+ objectType);
				System.out.println("X: "+ eElement.getAttribute("x"));
				System.out.println("Y: "+ eElement.getAttribute("y"));
				// Then add this object to the objectsList --MO2--
			}  
			// Then call Start function here
		}   
		catch (Exception e)   
		{  
			e.printStackTrace();  
		} 
	}

	@Override
	public void resetGame() {
		this.gameProperties.setLives(3);
		this.gameProperties.setScore(0);
		// And reset the time member if it's implemented
		// Then call Start function here --MO2--
	}

	public String[] showSavedFiles() {
		String[] files = null;
		String sep = System.getProperty("file.separator");
		File file = new File(System.getProperty("user.dir") + sep + "saved_data");
		if (file.exists()) {
			files = file.list();
		}
		return files;
	}
}
