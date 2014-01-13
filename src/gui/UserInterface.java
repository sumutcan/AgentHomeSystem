package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JList;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdSoyad;
	private JTextField txtTelefon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
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
	public UserInterface() {
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
		
		JPanel organizerPanel = new JPanel();
		tabbedPane.addTab("Organizer", null, organizerPanel, null);
		organizerPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(37dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("4dlu:grow"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
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
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String adSoyad = txtAdSoyad.getText();
				String phone = txtTelefon.getText();
				System.out.println("Ad Soyad: " + adSoyad + "\nTelefon: " + phone );
			}
		});
		organizerPanel.add(btnKaydet, "2, 6, left, center");
		
		JList list = new JList(); // Bro o listeyi buraya constructur'a koy. Cok optum.
		
		organizerPanel.add(list, "5, 1, 24, 8, fill, fill");
	}

}
