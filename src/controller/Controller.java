package controller;
//   controller/Controller.java
import java.util.ArrayList;

import model.Database;
import model.Host;;
public class Controller {
	Database db = new Database();
	
	public void listHosts() {
		db.listHosts();
	}
	
	public ArrayList<Host> getHostArray(){
		return db.getHostArray();
	}
}