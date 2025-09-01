package com.agenda.fabiana;

import com.agenda.fabiana.controller.AgendaController;
import com.agenda.fabiana.model.AgendaModel;
import com.agenda.fabiana.view.AgendaView;

public class FabianaApplication {
	public static void main(String[] args) {
		AgendaModel model = new AgendaModel();
		AgendaController controller = new AgendaController(model);
		AgendaView view = new AgendaView(controller);
		view.displayMenu();
	}
}