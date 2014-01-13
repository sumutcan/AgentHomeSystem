package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import Enviroment.BasisEnvironment;
import Enviroment.SecurityProperties;
import ObjectLayer.Contact;
import agents.Organizer;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;

import javax.swing.JTextPane;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdSoyad;
	private JTextField txtTelefon;
	private JList list;
	private Organizer currentAgent = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public UserInterface(Organizer _currentAgent) {
		this.currentAgent = _currentAgent;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel homePanel = new JPanel();
		tabbedPane.addTab("Home", null, homePanel, null);
		homePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblStatuses = new JLabel("Statuses");
		homePanel.add(lblStatuses, BorderLayout.NORTH);

		JTextArea txtStatuses = new JTextArea();
		txtStatuses.setRows(50);
		homePanel.add(txtStatuses, BorderLayout.CENTER);

		JPanel refrigeratorPanel = new JPanel();
		tabbedPane.addTab("Refrigerator", null, refrigeratorPanel, null);
		refrigeratorPanel.setLayout(new BorderLayout(0, 0));

		JPanel securityPanel = new JPanel();
		tabbedPane.addTab("Security", null, securityPanel, null);
		securityPanel.setLayout(new BorderLayout(0, 0));

		JList listSecurity = new JList();
		securityPanel.add(listSecurity, BorderLayout.CENTER);

		DefaultListModel<String> securityModel = new DefaultListModel<String>();
		String[] places = SecurityProperties.getInstance()
				.getNamesOfCheckPoints();
		boolean[] statuses = SecurityProperties.getInstance().getIsSecure();
		String result;
		for (int i = 0; i < places.length; i++) {
			securityModel.addElement(places[i] + " - Status: " + (result = statuses[i] == true ? "Secure":"Insecure") );
		}
		listSecurity.setModel(securityModel);

		JPanel organizerPanel = new JPanel();
		tabbedPane.addTab("Organizer", null, organizerPanel, null);
		organizerPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(37dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("4dlu:grow"), FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(45dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"), }));

		JLabel lblNewLabel = new JLabel("Ad Soyad:");
		organizerPanel.add(lblNewLabel, "2, 2, right, default");

		txtAdSoyad = new JTextField();
		organizerPanel.add(txtAdSoyad, "4, 2, left, default");
		txtAdSoyad.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Telefon:");
		organizerPanel.add(lblNewLabel_1, "2, 4, right, default");

		txtTelefon = new JTextField();
		organizerPanel.add(txtTelefon, "4, 4, left, default");
		txtTelefon.setColumns(10);

		list = new JList(); // Bro o listeyi buraya constructur'a koy. Cok
							// optum.

		JButton btnKaydet = new JButton("Save");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String adSoyad = txtAdSoyad.getText();
				String phone = txtTelefon.getText();

				BasisEnvironment.getInstance().getContactList()
						.add(new Contact(adSoyad, phone));

				DefaultListModel<Contact> model = new DefaultListModel<Contact>();
				for (Contact c : BasisEnvironment.getInstance()
						.getContactList())
					model.addElement(c);

				list.setModel(model);
			}
		});
		organizerPanel.add(btnKaydet, "2, 6, left, center");

		DefaultListModel<Contact> model = new DefaultListModel<Contact>();
		for (Contact c : BasisEnvironment.getInstance().getContactList())
			model.addElement(c);

		model.addElement(new Contact("Yigitcan SENER", "05066421454"));
		model.addElement(new Contact("Umutcan SIMSEK", "09004562514"));

		list.setModel(model);

		organizerPanel.add(list, "6, 1, 23, 12, fill, fill");

		final JTextPane textPaneMessage = new JTextPane();
		organizerPanel.add(textPaneMessage, "2, 8, 3, 3, fill, fill");

		JButton btnGnder = new JButton("Send");
		btnGnder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Contact c = (Contact) list.getSelectedValue();
				String message = textPaneMessage.getText();

				if (c != null && message != "" && message != null
						&& !message.isEmpty()) {
					System.out.println("Send message to:" + c.getName() + " ("
							+ c.getTelNumber() + ")\nMessage:\n" + message);

					if (currentAgent != null) {
						currentAgent.sendMessage(c, message);
					}
				}
			}
		});
		organizerPanel.add(btnGnder, "2, 12");
	}

}
