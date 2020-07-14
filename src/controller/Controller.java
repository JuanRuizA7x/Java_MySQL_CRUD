package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Person;
import model.PersonDAO;
import view.View;

/**
 * @author juan_ruiz
 *
 */
public class Controller implements ActionListener {
	
	private PersonDAO personDAO;
	private Person person;
	private View view;
	private DefaultTableModel tableModel;
	private List<Person> people;

	/**
	 * @param view
	 */
	public Controller(View view) {
		this.personDAO = new PersonDAO();
		this.person = new Person();
		this.view = view;
		this.view.btnSave.addActionListener(this);
		this.view.btnEdit.addActionListener(this);
		this.view.btnDelete.addActionListener(this);
		this.view.btnClear.addActionListener(this);
		this.people = personDAO.getPeople();
		this.list();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Guardar": {
			System.out.println("Se pulsó el botón guardar");
			break;
		}
		case "Editar": {
			System.out.println("Se pulsó el botón editar");
			break;
		}
		case "Eliminar": {
			System.out.println("Se pulsó el botón eliminar");
			break;
		}
		case "Limpiar": {
			System.out.println("Se pulsó el botón limpiar");
			break;
		}
		default:
			break;
		}
	}
	
	public void list() {
		Object object[][] = new Object[people.size()][5];
		
		for (int i = 0; i < people.size(); i++) {
			object[i][0] = people.get(i).getPersonId();
			object[i][1] = people.get(i).getFullName();
			object[i][2] = people.get(i).getPhoneNumber();
			object[i][3] = people.get(i).getEmail();
			object[i][4] = people.get(i).getCreatedAt();
		}
		
		tableModel = new DefaultTableModel(object, new String[] {
				"Id", "Nombre completo", "Teléfono", "Email", "Fecha de creación"
		});
		
		this.view.table.setModel(tableModel);
	}

}
