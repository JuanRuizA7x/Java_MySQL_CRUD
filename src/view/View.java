package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author juan_ruiz
 *
 */
public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtID;
	public JTextField txtFullName;
	public JTextField txtPhoneNumber;
	public JTextField txtEmail;
	public JButton btnSave;
	public JButton btnEdit;
	public JButton btnDelete;
	public JButton btnClear;
	public DefaultTableModel tableModel;
	public JTable table;

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelData = new JPanel();
		panelData.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Datos", TitledBorder.TRAILING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelData.setBounds(12, 12, 626, 160);
		contentPane.add(panelData);
		panelData.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 12, 130, 25);
		panelData.add(lblId);
		
		JLabel lblFullName = new JLabel("Nombre completo");
		lblFullName.setBounds(12, 49, 130, 25);
		panelData.add(lblFullName);
		
		JLabel lblPhoneNumber = new JLabel("Teléfono");
		lblPhoneNumber.setBounds(12, 86, 130, 25);
		panelData.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 123, 130, 25);
		panelData.add(lblEmail);
		
		txtID = new JTextField();
		txtID.setText("Autogenerado");
		txtID.setEnabled(false);
		txtID.setBounds(160, 12, 280, 25);
		panelData.add(txtID);
		txtID.setColumns(10);
		
		txtFullName = new JTextField();
		txtFullName.setColumns(10);
		txtFullName.setBounds(160, 49, 280, 25);
		panelData.add(txtFullName);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(160, 89, 280, 25);
		panelData.add(txtPhoneNumber);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(160, 126, 280, 25);
		panelData.add(txtEmail);
		
		btnSave = new JButton("Guardar");
		btnSave.setBounds(452, 12, 117, 25);
		panelData.add(btnSave);
		
		btnEdit = new JButton("Editar");
		btnEdit.setBounds(452, 49, 117, 25);
		panelData.add(btnEdit);
		
		btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(452, 86, 117, 25);
		panelData.add(btnDelete);
		
		btnClear = new JButton("Limpiar");
		btnClear.setBounds(452, 123, 117, 25);
		panelData.add(btnClear);
		
		JPanel panelDetails = new JPanel();
		panelDetails.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Detalles", TitledBorder.TRAILING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelDetails.setBounds(12, 184, 626, 279);
		contentPane.add(panelDetails);
		panelDetails.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 25, 602, 242);
		panelDetails.add(scrollPane);
		
		tableModel = new DefaultTableModel(null, new String[] {
				"Id", "Nombre completo", "Teléfono", "Email", "Fecha de creación"
		});
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
	}
}
