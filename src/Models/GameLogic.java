package Models;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Models.Interfaces.GameActions;
import Models.Interfaces.GameObject;

public class GameLogic implements GameActions {

	private static GameLogic instance;
	private static GameProperties gameProperties;
	private static ArrayList<GameObject> objectsList;
	
	private GameLogic() {
		if (instance != null)
			throw new RuntimeException("use getInstance method");
		objectsList = new ArrayList<GameObject>();
		
		objectsList.add(new Apple());
		objectsList.add(new Watermelon());
	}

	public static GameLogic getInstance() {
		if (instance == null) {
			synchronized (GameLogic.class) {
				if (instance == null) {
					instance = new GameLogic();
					gameProperties = new GameProperties();

				}

			}
		}
		return instance;
	}
	
	
	@Override
	public GameObject createGameObject() {
	 
		GameObjectfactory factory;
		GameObject obj;
		int index=(int) MiscUtils.rand(0,7);
		GameObjects object=GameObjects.values()[index];
		if(index<5) {
			factory=new FruitFactory();
			obj=factory.createObject(object);
		}
		else {
			factory=new BombFactory();
			obj=factory.createObject(object);
		}
	//System.out.println(index);
		return obj;
	}


	@Override
	public void updateObjectsLocation() {

	}

	@Override
	public void sliceObjects() {

	}

	@Override
	public void saveGame() {
		
		//String fileName = saveFileSelection();
		String fileName = "file1.xml"; 
		String sep = System.getProperty("file.separator");
		String xmlFilePath = System.getProperty("user.dir") + sep + "saved_data" + sep + fileName;
		
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		try {
	        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	
	        Document document = documentBuilder.newDocument();
	
	        // root element
	        Element root = document.createElement("Game");
	        document.appendChild(root);
	        
	        Element score = document.createElement("Score");
	        score.appendChild(document.createTextNode(gameProperties.getScore() + ""));
	        root.appendChild(score);
	
	        Element lives = document.createElement("Lives");
	        lives.appendChild(document.createTextNode(gameProperties.getLives() + ""));
	        root.appendChild(lives);
	
	        Element gameObjects = document.createElement("GameObject");
	        Element gameObject;
	        for(GameObject obj: objectsList) {
	        	gameObject = document.createElement(obj.getObjectType().toString());
	        	Attr attr = document.createAttribute("x");
	            attr.setValue(obj.getXLocation()+"");
	            gameObject.setAttributeNode(attr);
	        	
	            attr = document.createAttribute("y");
	            attr.setValue(obj.getYLocation()+"");
	            gameObject.setAttributeNode(attr);
	            
	            gameObjects.appendChild(gameObject);
	        }
	        
	        root.appendChild(gameObjects);
	
	        // create the xml file
	        //transform the DOM Object to an XML File
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

	}

	@Override
	public void resetGame() {

	}

	public String[] showSavedFiles() {
		return null;
	}
	
	public String saveFileSelection() {
		return null;
	}
}