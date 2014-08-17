package dota;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainNewInterface extends JFrame
{
	private JPanel contentPane;
	private JTextField txtConfigName;
	private JTextField txtOutputFile;
	private JTextField txtInputFolderPath;

	private JTextArea txtaPreview, txtaStartFile, txtaEndFile;

	private JCheckBox checkAutoJoin;

	private JList<Config> listConfig;

	private ArrayList<Config> configs;

	private DefaultListModel<Config> listModel;

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
	 * Create the frame. Sorry for using the automatic tool and not doing it
	 * manually.
	 */
	public MainNewInterface()
	{

		loadFromFile();

		fillListWithDummyData();

		initInterface();

		initList();
	}

	private void saveToFile()
	{
		try
		{
			FileOutputStream f = new FileOutputStream("config.bin");
			ObjectOutputStream file = new ObjectOutputStream(f);

			for (Config c : configs)
			{
				file.writeObject(c);
			}
			file.flush();
			f.close();

		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "IO ERROR ON SAVE:\n" + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
	}

	private void loadFromFile()
	{
		try
		{
			FileInputStream f = new FileInputStream("config.bin");
			ObjectInputStream file = new ObjectInputStream(f);

			while (true)
			{
				try
				{
					Config c = (Config) file.readObject();
					configs.add(c);
				} catch (EOFException e)
				{
					break;
				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "IO ERROR ON SAVE:\n" + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
					System.exit(-1);
				}
			}
			f.close();
		} catch (IOException e)
		{
			System.out.println("Configs File not found.");
		}

	}

	private void initList()
	{
		listModel = new DefaultListModel<Config>();

		for (Config config : configs)
		{
			listModel.addElement(config);
		}

		listConfig.setModel(listModel);

		listConfig.addListSelectionListener(new ListSelectionListener()
		{

			@Override
			public void valueChanged(ListSelectionEvent event)
			{
				if (!event.getValueIsAdjusting())
				{
					//cool to go
					Config selected = listConfig.getSelectedValue();

					if (selected != null)
					{
						txtConfigName.setText(selected.name);
						txtInputFolderPath.setText(selected.inputFolderPath);
						txtOutputFile.setText(selected.outputFile);

						txtaEndFile.setText(selected.endFile);
						txtaStartFile.setText(selected.startFile);

						checkAutoJoin.setSelected(selected.changeChecker);

						generatePreview();
					}
				}
			}
		});

		if (listModel.size() > 0)
		{
			listConfig.setSelectedIndex(0);
		}
	}

	public void generatePreview()
	{

		String preview = txtaStartFile.getText();

		preview += "\n";
		preview += "\t//Joined files content starts here\n\t...\n\t//Joined files content ends here";
		preview += "\n";
		preview += txtaEndFile.getText();

		txtaPreview.setText(preview);

	}

	private void fillListWithDummyData()
	{
		configs = new ArrayList<Config>();

		configs.add(new Config("heroes", "heroes", "heroes.txt", "{", "}", false));
		configs.add(new Config("units", "units", "units.txt", "{", "}", false));
		configs.add(new Config("resource", "resource", "resource.txt", "{\n'english'", "}", false));

	}

	private void initInterface()
	{
		addWindowListener(new MyWindowListener());

		setTitle("Dota Custom Files Joiner by cris9696");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		listConfig = new JList<Config>();
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
		lblConfigName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfigName.setBounds(10, 11, 90, 14);
		panel.add(lblConfigName);

		txtConfigName = new JTextField();
		txtConfigName.setBounds(110, 8, 166, 20);
		panel.add(txtConfigName);
		txtConfigName.setColumns(10);

		JLabel lblInputFolder = new JLabel("Input Folder:");
		lblInputFolder.setBounds(10, 58, 90, 14);
		panel.add(lblInputFolder);

		txtOutputFile = new JTextField();
		txtOutputFile.setBounds(110, 111, 166, 20);
		panel.add(txtOutputFile);
		txtOutputFile.setColumns(10);

		JLabel lblOutputFile = new JLabel("Output File:");
		lblOutputFile.setBounds(10, 114, 90, 14);
		panel.add(lblOutputFile);

		txtInputFolderPath = new JTextField();
		txtInputFolderPath.setBounds(110, 55, 166, 20);
		panel.add(txtInputFolderPath);
		txtInputFolderPath.setColumns(10);

		JButton btnChooseInputFolder = new JButton("...");
		btnChooseInputFolder.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
				chooser.setDialogTitle("Choose the input folder");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					txtInputFolderPath.setText(chooser.getSelectedFile().toString());
				}
			}
		});
		btnChooseInputFolder.setBounds(276, 55, 19, 19);
		panel.add(btnChooseInputFolder);

		JButton btnChooseOutputFile = new JButton("...");
		btnChooseOutputFile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
				chooser.setDialogTitle("Choose the output file");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setAcceptAllFileFilterUsed(true);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					txtOutputFile.setText(chooser.getSelectedFile().toString());
				}
			}
		});
		btnChooseOutputFile.setBounds(276, 111, 19, 19);
		panel.add(btnChooseOutputFile);

		JLabel lblPreviewOfThe = new JLabel("Preview of the generated file");
		lblPreviewOfThe.setBounds(305, 8, 288, 14);
		panel.add(lblPreviewOfThe);

		txtaPreview = new JTextArea();
		txtaPreview.setEditable(false);
		txtaPreview.setBounds(305, 33, 288, 426);
		txtaPreview.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtaPreview.setTabSize(2);
		panel.add(txtaPreview);

		JLabel lblStartOfGenerated = new JLabel("Start of generated file");
		lblStartOfGenerated.setBounds(10, 144, 250, 14);
		panel.add(lblStartOfGenerated);

		txtaStartFile = new JTextArea();
		txtaStartFile.setBounds(10, 159, 285, 79);
		txtaStartFile.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtaStartFile.setTabSize(2);
		txtaStartFile.getDocument().addDocumentListener(new OnChangeTextArea());
		panel.add(txtaStartFile);

		JLabel lblEndGeneratedFile = new JLabel("End of generated file");
		lblEndGeneratedFile.setBounds(10, 294, 250, 14);
		panel.add(lblEndGeneratedFile);

		txtaEndFile = new JTextArea();
		txtaEndFile.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtaEndFile.setBounds(10, 310, 285, 79);
		txtaEndFile.setTabSize(2);
		txtaEndFile.getDocument().addDocumentListener(new OnChangeTextArea());
		panel.add(txtaEndFile);

		checkAutoJoin = new JCheckBox("Automatic Join on file change");
		checkAutoJoin.setBounds(10, 411, 276, 23);
		panel.add(checkAutoJoin);

		JButton btnApplyJoin = new JButton("Save / Join this config");
		btnApplyJoin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!listConfig.isSelectionEmpty())
				{

					int index = listConfig.getSelectedIndex();

					configs.get(index).name = txtConfigName.getText();
					configs.get(index).endFile = txtaEndFile.getText();
					configs.get(index).startFile = txtaStartFile.getText();
					configs.get(index).inputFolderPath = txtInputFolderPath.getText();
					configs.get(index).outputFile = txtOutputFile.getText();
					configs.get(index).changeChecker = checkAutoJoin.isSelected();

					saveToFile();
				} else
				{
					JOptionPane.showMessageDialog(null, "Nothing selected!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnApplyJoin.setBounds(10, 470, 285, 34);
		panel.add(btnApplyJoin);

		JLabel lblHowManyFiles = new JLabel("%d files found in %s folder");
		lblHowManyFiles.setToolTipText("Click to refresh");
		lblHowManyFiles.setBounds(10, 83, 285, 14);
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
		btnAddNew.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				listConfig.clearSelection();

				resetForm();
			}
		});
		btnAddNew.setBounds(10, 528, 150, 23);
		contentPane.add(btnAddNew);

		JButton btnDeleteCurrent = new JButton("Delete Config");
		btnDeleteCurrent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!listConfig.isSelectionEmpty())
				{
					Config selected = listConfig.getSelectedValue();

					if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete config \"" + selected.name + "\"?", "Question!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
					{
						int index = listConfig.getSelectedIndex();
						listModel.remove(index);
						configs.remove(index);
						if (listModel.size() >= 0)
						{
							listConfig.setSelectedIndex(0);
						} else
						{
							resetForm();
						}
					}
				} else
				{
					JOptionPane.showMessageDialog(null, "Nothing selected!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeleteCurrent.setBounds(10, 506, 150, 23);
		contentPane.add(btnDeleteCurrent);
	}

	private void resetForm()
	{
		txtConfigName.setText("");
		txtInputFolderPath.setText("");
		txtOutputFile.setText("");

		txtaEndFile.setText("");
		txtaStartFile.setText("");

		txtaPreview.setText("");

		checkAutoJoin.setSelected(false);
	}

	private class OnChangeTextArea implements DocumentListener
	{

		public void changedUpdate(DocumentEvent arg0)
		{
			generatePreview();
		}

		public void insertUpdate(DocumentEvent arg0)
		{
			generatePreview();
		}

		public void removeUpdate(DocumentEvent arg0)
		{
			generatePreview();
		}
	}

	class MyWindowListener implements WindowListener
	{
		@Override
		public void windowActivated(WindowEvent arg0)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosed(WindowEvent arg0)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent arg0)
		{
			saveToFile();
		}

		@Override
		public void windowDeactivated(WindowEvent arg0)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent arg0)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent arg0)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(WindowEvent arg0)
		{
			// TODO Auto-generated method stub

		}
	}

}
