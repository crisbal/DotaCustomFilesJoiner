package dota;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;

public class MainNewInterface extends JFrame
{

	private JPanel contentPane;
	private JTextField txtConfigName;
	private JTextField txtInputFolder;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainNewInterface frame = new MainNewInterface();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Sorry for using the automatic tool and not doing it manually.
	 */
	public MainNewInterface()
	{
		setTitle("Dota Custom Files Joiner by cris9696");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listConfig = new JList();
		listConfig.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listConfig.setBorder(new LineBorder(new Color(0, 0, 0)));
		listConfig.setBounds(10, 36, 150, 469);
		contentPane.add(listConfig);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(171, 36, 604, 515);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConfigName = new JLabel("Config Name:");
		lblConfigName.setBounds(10, 11, 90, 14);
		panel.add(lblConfigName);
		
		txtConfigName = new JTextField();
		txtConfigName.setBounds(110, 8, 166, 20);
		panel.add(txtConfigName);
		txtConfigName.setColumns(10);
		
		JLabel lblInputFolder = new JLabel("Input Folder:");
		lblInputFolder.setBounds(10, 58, 90, 14);
		panel.add(lblInputFolder);
		
		txtInputFolder = new JTextField();
		txtInputFolder.setBounds(110, 111, 166, 20);
		panel.add(txtInputFolder);
		txtInputFolder.setColumns(10);
		
		JLabel lblOutputFile = new JLabel("Output File:");
		lblOutputFile.setBounds(10, 114, 90, 14);
		panel.add(lblOutputFile);
		
		textField = new JTextField();
		textField.setBounds(110, 55, 166, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnChooseInputFolder = new JButton("...");
		btnChooseInputFolder.setBounds(276, 56, 19, 19);
		panel.add(btnChooseInputFolder);
		
		JButton btnChooseOutputFile = new JButton("...");
		btnChooseOutputFile.setBounds(276, 112, 19, 19);
		panel.add(btnChooseOutputFile);
		
		JLabel lblPreviewOfThe = new JLabel("Preview of the generated file");
		lblPreviewOfThe.setBounds(305, 8, 288, 14);
		panel.add(lblPreviewOfThe);
		
		JTextArea txtaPreview = new JTextArea();
		txtaPreview.setEditable(false);
		txtaPreview.setBounds(305, 33, 288, 426);
		txtaPreview.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(txtaPreview);
		
		JLabel lblStartOfGenerated = new JLabel("Start of generated file");
		lblStartOfGenerated.setBounds(10, 144, 250, 14);
		panel.add(lblStartOfGenerated);
		
		JTextArea txtaStartFile = new JTextArea();
		txtaStartFile.setBounds(10, 159, 285, 79);
		txtaStartFile.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(txtaStartFile);
		
		JLabel lblEndGeneratedFile = new JLabel("End of generated file");
		lblEndGeneratedFile.setBounds(10, 294, 250, 14);
		panel.add(lblEndGeneratedFile);
		
		JTextArea txtaEndFile = new JTextArea();
		txtaEndFile.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtaEndFile.setBounds(10, 310, 285, 79);
		panel.add(txtaEndFile);
		
		JCheckBox chckbxAutomaticJoin = new JCheckBox("Automatic Join on file change");
		chckbxAutomaticJoin.setBounds(10, 411, 276, 23);
		panel.add(chckbxAutomaticJoin);
		
		JButton btnApplyJoin = new JButton("Save / Join this config");
		btnApplyJoin.setBounds(10, 470, 285, 34);
		panel.add(btnApplyJoin);
		
		JLabel lblHowManyFiles = new JLabel("%d files found in %s folder");
		lblHowManyFiles.setBounds(10, 83, 250, 14);
		panel.add(lblHowManyFiles);
		
		JButton btnJoinAll = new JButton("Join all configs");
		btnJoinAll.setBounds(305, 470, 289, 34);
		panel.add(btnJoinAll);
		
		JLabel lblYourConfigs = new JLabel("Your Configs");
		lblYourConfigs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYourConfigs.setBounds(10, 11, 150, 25);
		contentPane.add(lblYourConfigs);
		
		JLabel lblConfigYouAre = new JLabel("Config you are now editing");
		lblConfigYouAre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfigYouAre.setBounds(171, 11, 253, 25);
		contentPane.add(lblConfigYouAre);
		
		JButton btnAddNew = new JButton("Add New Config");
		btnAddNew.setBounds(10, 528, 150, 23);
		contentPane.add(btnAddNew);
		
		JButton btnDeleteCurrent = new JButton("Delete Config");
		btnDeleteCurrent.setBounds(10, 506, 150, 23);
		contentPane.add(btnDeleteCurrent);
	}
}
