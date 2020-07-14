package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * @author juan_ruiz
 *
 */
public class PersonDAO {

	private ConnectionDB connect;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public PersonDAO() {
		connect = new ConnectionDB();
		con = connect.getConnection();
	}

	public List<Person> getPeople() {
		List<Person> people = new ArrayList<Person>();
		String query = "SELECT * FROM people";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Person person = new Person();
				person.setPersonId(rs.getInt(1));
				person.setFullName(rs.getString(2));
				person.setPhoneNumber(rs.getString(3));
				person.setEmail(rs.getString(4));
				person.setCreatedAt(rs.getDate(5));
				people.add(person);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar los registros\n"
					+ e.getClass().getName() + "\n" + e.getMessage());
			e.printStackTrace();
		}
		return people;
	}
	
	public void createPerson(Person person) {
		String query = "INSERT INTO registry.people(full_name, phone_number, email) "
				+ "VALUES(?, ?, ?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, person.getFullName());
			ps.setString(2, person.getPhoneNumber());
			ps.setString(3, person.getEmail());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Persona guardada correctamente");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al guardar registro\n"
					+ e.getClass().getName() + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
