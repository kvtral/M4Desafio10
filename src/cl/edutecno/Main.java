package cl.edutecno;

import cl.edutecno.views.Menu;

public class Main {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
				
		try {			
			menu.ejecucionMenu();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
