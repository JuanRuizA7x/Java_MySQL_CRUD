package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Person;
import model.PersonDAO;
import view.View;

/**
 * @author juan_ruiz
 *
 */
public class Controller implements ActionListener, MouseListener {
	
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
		this.view.table.addMouseListener(this);
		this.list();
	}
	
	public void list() {
		this.people = personDAO.getPeople();
		
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
	
	public void createPerson() {
		if(view.txtFullName.getText().length() > 0 && 
				view.txtPhoneNumber.getText().length() > 0 && 
				view.txtEmail.getText().length() > 0) {
			if(view.txtID.getText().equals("Autogenerado")) {
				String fullName = view.txtFullName.getText().trim();
				String phoneNumber = view.txtPhoneNumber.getText().trim();
				String email = view.txtEmail.getText().trim();
				this.person = new Person(fullName, phoneNumber, email);
				this.personDAO.createPerson(person);
				list();
				clear();
			} else {
				JOptionPane.showMessageDialog(null, "Ya existe un registro con ID " + view.txtID.getText());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Complete los campos");
		}
	}
	
	public void readPerson() {
		view.txtID.setText(tableModel.getValueAt(view.table.getSelectedRow(), 0).toString());
		view.txtFullName.setText(tableModel.getValueAt(view.table.getSelectedRow(), 1).toString());
		view.txtPhoneNumber.setText(tableModel.getValueAt(view.table.getSelectedRow(), 2).toString());
		view.txtEmail.setText(tableModel.getValueAt(view.table.getSelectedRow(), 3).toString());
	}
	
	public void updatePerson() {
		int personId = Integer.parseInt(view.txtID.getText().trim());
		String fullName = view.txtFullName.getText().trim();
		String phoneNumber = view.txtPhoneNumber.getText().trim();
		String email = view.txtEmail.getText().trim();
		this.person = new Person(personId, fullName, phoneNumber, email);
		this.personDAO.updatePerson(person);
		list();
		clear();
	}
	
	public void deletePerson() {
		int personId = Integer.parseInt(view.txtID.getText().trim());
		this.personDAO.deletePerson(personId);
		list();
		clear();
	}
	
	public void clear() {
		view.txtID.setText("Autogenerado");
		view.txtFullName.setText("");
		view.txtPhoneNumber.setText("");
		view.txtEmail.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Guardar": {
			createPerson();
			break;
		}
		case "Editar": {
			updatePerson();
			break;
		}
		case "Eliminar": {
			deletePerson();
			break;
		}
		case "Limpiar": {
			clear();
			break;
		}
		default:
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			readPerson();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {		
	}

	@Override
	public void mouseReleased(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}

}
