package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.timer.Timer;
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
import Enviroment.RefrigeratorEnvironment;
import Enviroment.SecurityProperties;
import ObjectLayer.Contact;
import ObjectLayer.RefrigeratorItem;
import agents.Organizer;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

import javax.swing.JTextPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdSoyad;
	private JTextField txtTelefon;
	private JList list;
	private Organizer currentAgent = null;
	private JTextField txtConsumption;

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

		JPanel refrigeratorPanel = new JPanel();
		tabbedPane.addTab("Refrigerator", null, refrigeratorPanel, null);
		refrigeratorPanel.setLayout(new BorderLayout(0, 0));
		
		final JList listItemsCounts = new JList();
		refrigeratorPanel.add(listItemsCounts, BorderLayout.CENTER);
		refrigeratorListDataBind(listItemsCounts);
		
		JPanel panel = new JPanel();
		refrigeratorPanel.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 41, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_2 = new JLabel("Consumption value:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtConsumption = new JTextField();
		GridBagConstraints gbc_txtConsumption = new GridBagConstraints();
		gbc_txtConsumption.gridwidth = 2;
		gbc_txtConsumption.insets = new Insets(0, 0, 5, 5);
		gbc_txtConsumption.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConsumption.gridx = 0;
		gbc_txtConsumption.gridy = 2;
		panel.add(txtConsumption, gbc_txtConsumption);
		txtConsumption.setColumns(10);
		
		JButton btnConsume = new JButton("Consume");
		btnConsume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RefrigeratorItem selectedItem = (RefrigeratorItem)listItemsCounts.getSelectedValue();
				String consumptionValue = txtConsumption.getText();
				int count;
				double weight;
				if(selectedItem.isBasedOnCount())
				{
					count = Integer.parseInt(consumptionValue);
					RefrigeratorEnvironment.getInstance().AddNewConsumption(selectedItem, count);
				}
				else
				{
					weight = Double.parseDouble(consumptionValue);
					RefrigeratorEnvironment.getInstance().AddNewConsumption(selectedItem, weight);
				}
				
				refrigeratorListDataBind(listItemsCounts);
				txtConsumption.setText("");
			}
		});
		GridBagConstraints gbc_btnConsume = new GridBagConstraints();
		gbc_btnConsume.gridwidth = 2;
		gbc_btnConsume.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsume.gridx = 0;
		gbc_btnConsume.gridy = 3;
		panel.add(btnConsume, gbc_btnConsume);
		
		JButton btnRefreshRefList = new JButton("Refresh");
		btnRefreshRefList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refrigeratorListDataBind(listItemsCounts);
			}
		});
		refrigeratorPanel.add(btnRefreshRefList, BorderLayout.SOUTH);

		JPanel securityPanel = new JPanel();
		tabbedPane.addTab("Security", null, securityPanel, null);
		securityPanel.setLayout(new BorderLayout(0, 0));

		final JList listSecurity = new JList();
		listSecurity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = listSecurity.getSelectedIndex();
				SecurityProperties.getInstance().changeState(index);

				securityListDataBind(listSecurity);
			}
		});
		securityPanel.add(listSecurity, BorderLayout.CENTER);
		securityListDataBind(listSecurity);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				securityListDataBind(listSecurity);
			}
		});
		securityPanel.add(btnRefresh, BorderLayout.SOUTH);

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

				txtAdSoyad.setText("");
				txtTelefon.setText("");
			}
		});
		organizerPanel.add(btnKaydet, "2, 6, left, center");

		DefaultListModel<Contact> model = new DefaultListModel<Contact>();
		for (Contact c : BasisEnvironment.getInstance().getContactList())
			model.addElement(c);

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

				textPaneMessage.setText("");
			}
		});
		organizerPanel.add(btnGnder, "2, 12");
	}

	private void securityListDataBind(JList list) {
		DefaultListModel<String> securityModel = new DefaultListModel<String>();
		String[] places = SecurityProperties.getInstance()
				.getNamesOfCheckPoints();
		boolean[] statuses = SecurityProperties.getInstance().getIsSecure();
		String result;
		for (int i = 0; i < places.length; i++) {
			securityModel.addElement(places[i] + " - Status: "
					+ (result = statuses[i] == true ? "Secure" : "Insecure"));
		}
		list.setModel(securityModel);
	}
	
	private void refrigeratorListDataBind(JList list) {
		DefaultListModel<RefrigeratorItem> securityModel = new DefaultListModel<RefrigeratorItem>();
		ArrayList<RefrigeratorItem> items = RefrigeratorEnvironment.getInstance()
				.getItems();
		
		for (RefrigeratorItem item : items) {
			securityModel.addElement(item);
		}
		list.setModel(securityModel);
	}

}
