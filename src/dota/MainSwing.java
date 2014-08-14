package dota;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainSwing extends JFrame
{
	private JLabel[] labels;
	
	private JButton start,exit;
	
	private boolean[] notExists;
	
	public static void main(String[] args)
	{
		new MainSwing().setVisible(true);
	}
	
	public MainSwing(){
		
		setTitle(Main.PROGRAM_NAME + " by cris9696");
		
		labels = new JLabel[Main.folders.length];
		notExists = new boolean[Main.folders.length];
		
		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		main.setLayout(new GridLayout(5,2,10,10));
		
		for(int i=0;i<Main.folders.length;i++){
			main.add(new JLabel(Main.folders[i] + " folder"));
			
			File test = new File(Main.folders[i]);
			
			if(!test.exists())
			{
				labels[i] = new JLabel("Not Found");
				labels[i].setForeground(Color.red);
				notExists[i] = true;
			}else{
				labels[i] = new JLabel("Found");
				labels[i].setForeground(Color.green);
			}
			
			main.add(labels[i]);
		}
		
		
		start = new JButton("Join files");
		start.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				boolean emptyArray = true;
				for (int i = 0; i < notExists.length; i++) 
				{
					  if (!notExists[i]) {
						  emptyArray = false;
						  break;
					  }
				}
				if(emptyArray){
					JOptionPane.showMessageDialog(null,"No source folder found!","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				for(int i=0;i<Main.folders.length;i++){
					if (!notExists[i])
					{
						String result = Main.generateFileForFolder(Main.folders[i], Main.files[i], Main.keys[i]);
						if (!result.equals("OK")){
							JOptionPane.showMessageDialog(null,result,"Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}
				
				JOptionPane.showMessageDialog(null,"Operation Completed. Your files are ready","Ok",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		
		main.add(start);

		getContentPane().add(main);
		
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}

}
