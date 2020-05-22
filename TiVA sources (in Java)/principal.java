import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Cursor;


public class principal extends JFrame {
	
	private JTextArea textPane_0,textPane_1,textPane_2,textPane_3;
	public principal() {
		
		setTitle("TiVA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(143, 188, 143));
		setBackground(new Color(255, 255, 255));
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		dim.setSize(dim.getWidth()-50, dim.getHeight()-100);
		setSize(dim);
		setLocationRelativeTo(null);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.7);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		panel.add(splitPane_1, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_6);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_2 = new JSplitPane();
		panel_1.add(splitPane_2, BorderLayout.CENTER);
		
		
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(SystemColor.activeCaption);
		panel_6.add(panel_11, BorderLayout.SOUTH);
		
		JButton btnLoad_1 = new JButton("Load");
		btnLoad_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoad_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLoad_1.setPreferredSize(new Dimension(70, 25));
		btnLoad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("XTA File", "xta");
				fc.setDialogTitle("Choisir un Fichier de type XTA");
				fc.addChoosableFileFilter(filter);
				fc. setAcceptAllFileFilterUsed(false);
				int val_retour = fc.showOpenDialog(null);

                if (val_retour == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile();
                	textPane_1.setText("");
                	FileReader fr;
					try {
						fr = new FileReader(file);
						BufferedReader br=new BufferedReader(fr);
        			String ligne= br.readLine();
        			
        			while(ligne!=null){
        				textPane_1.setText(textPane_1.getText()+ligne+"\n");
        				
        				ligne=br.readLine();
        				}
        			
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
                }
			
                }
                }
		});
		btnLoad_1.setBackground(Color.WHITE);
		panel_11.add(btnLoad_1);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSave_1.setPreferredSize(new Dimension(70, 25));
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("XTA File", "xta");
				fc.setDialogTitle("Choisir un Fichier de type XTA");
				fc.addChoosableFileFilter(filter);
				fc. setAcceptAllFileFilterUsed(false);
				int val_retour = fc.showSaveDialog(null);

                if (val_retour == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile();
                	 String path = file.getAbsolutePath();

                	  String extension[] = filter.getExtensions();
                	  System.out.println(extension[0]);

                	  if(!path.endsWith(extension[0]))
                	  {
                	    file = new File(path +"."+ extension[0]);
                	  }
                	FileWriter fr;
					try {
						fr = new FileWriter(file);
						BufferedWriter br=new BufferedWriter(fr);
					
        			String ligne= textPane_1.getText();
        			
        		    br.write(ligne);
        			
					br.close();
					fr.close();
        			
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			
                	
                	
                }
			
			}
			
		});
		btnSave_1.setBackground(Color.WHITE);
		panel_11.add(btnSave_1);
		
		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClear_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnClear_1.setPreferredSize(new Dimension(70, 25));
		btnClear_1.setBackground(Color.WHITE);
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_1.setText("");
			}
		});
		panel_11.add(btnClear_1);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(SystemColor.activeCaption);
		panel_6.add(panel_16, BorderLayout.NORTH);
		
		JLabel lblCodeXta = new JLabel("XTA Code");
		lblCodeXta.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_16.add(lblCodeXta);
		
		
		
		textPane_1 = new JTextArea();
		textPane_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setBackground(Color.BLACK);
		
		JScrollPane scrollPane_1 = new JScrollPane(textPane_1);
		panel_6.add(scrollPane_1, BorderLayout.CENTER);
		JPanel panel_4 = new JPanel();
		splitPane_1.setLeftComponent(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.activeCaption);
		panel_4.add(panel_10, BorderLayout.SOUTH);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoad.setPreferredSize(new Dimension(70, 25));
		btnLoad.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Tiva File", "tiva");
				fc.setDialogTitle("Choisir un Fichier de type Tiva");
				fc.addChoosableFileFilter(filter);
				fc. setAcceptAllFileFilterUsed(false);
				int val_retour = fc.showOpenDialog(null);
                if (val_retour == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile();
                	textPane_0.setText("");
                	FileReader fr;
					try {
						fr = new FileReader(file);
						BufferedReader br=new BufferedReader(fr);
        			String ligne= br.readLine();
        			
        			while(ligne!=null){
        				textPane_0.setText(textPane_0.getText()+ligne+"\n");
        				
        				ligne=br.readLine();
        				}
        			br.close();
        			fr.close();
        			
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			
                }
			}
		});
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnLoad.setBackground(Color.WHITE);
		panel_10.add(btnLoad);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSave.setPreferredSize(new Dimension(70, 25));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Tiva File", "tiva");
				fc.setDialogTitle("Choisir un Fichier de type Tiva");
				fc.addChoosableFileFilter(filter);
				fc. setAcceptAllFileFilterUsed(false);
				int val_retour = fc.showSaveDialog(null);

                if (val_retour == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile();
                	 String path = file.getAbsolutePath();

                	  String extension[] = filter.getExtensions();
                	  System.out.println(extension[0]);

                	  if(!path.endsWith(extension[0]))
                	  {
                	    file = new File(path +"."+ extension[0]);
                	  }
                	FileWriter fr;
					try {
						fr = new FileWriter(file);
						BufferedWriter br=new BufferedWriter(fr);
					
        			String ligne= textPane_0.getText();
        			
        		    br.write(ligne);
        			
					br.close();
					fr.close();
        			
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			
                	
                	
                }
			
			
			}
		});
		btnSave.setBackground(Color.WHITE);
		panel_10.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClear.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnClear.setPreferredSize(new Dimension(70, 25));
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_0.setText("");
			}
		});
		panel_10.add(btnClear);
		
		JButton translate = new JButton("Translate ->>");
		translate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_10.add(translate);
		translate.setPreferredSize(new Dimension(110, 25));
		translate.setMinimumSize(new Dimension(110, 23));
		translate.setMaximumSize(new Dimension(110, 110));
		translate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		translate.setBackground(Color.WHITE);
		translate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dsltoxta();
			}
		});
		
		textPane_0 = new JTextArea();
		textPane_0.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textPane_0.setFont(new Font("Monospaced", Font.PLAIN, 15));
		//panel_10.add();
		textPane_0.setForeground(Color.WHITE);
		textPane_0.setBackground(Color.BLACK);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(SystemColor.activeCaption);
		panel_4.add(panel_17, BorderLayout.NORTH);
		
		JLabel lblCodeDsl = new JLabel("DSL Code");
		lblCodeDsl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_17.add(lblCodeDsl);
		
		JScrollPane scrollPane = new JScrollPane(textPane_0);
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setResizeWeight(0.5);
		panel_2.add(splitPane_3, BorderLayout.CENTER);
		
		
		JPanel panel_9 = new JPanel();
		
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		splitPane_3.setRightComponent(panel_9);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_4 = new JSplitPane();
		panel_3.add(splitPane_4, BorderLayout.CENTER);
		
		
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(SystemColor.activeCaption);
		panel_9.add(panel_19, BorderLayout.NORTH);
		
		JLabel lblRsultatDeLa = new JLabel("Verification Results");
		lblRsultatDeLa.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_19.add(lblRsultatDeLa);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(SystemColor.activeCaption);
		panel_9.add(panel_21, BorderLayout.SOUTH);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCopy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCopy.setPreferredSize(new Dimension(70, 25));
		btnCopy.setBackground(Color.WHITE);
		panel_21.add(btnCopy);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setPreferredSize(new Dimension(70, 25));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Result File", "res");
				fc.setDialogTitle("Choisir un Fichier de type RES");
				fc.addChoosableFileFilter(filter);
				fc. setAcceptAllFileFilterUsed(false);
				int val_retour = fc.showSaveDialog(null);

                if (val_retour == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile();
                	 String path = file.getAbsolutePath();

                	  String extension[] = filter.getExtensions();
                	  System.out.println(extension[0]);

                	  if(!path.endsWith(extension[0]))
                	  {
                	    file = new File(path +"."+ extension[0]);
                	  }
                	FileWriter fr;
					try {
						fr = new FileWriter(file);
						BufferedWriter br=new BufferedWriter(fr);
					
        			String ligne= textPane_2.getText();
        			
        		    br.write(ligne);
        			
					br.close();
					fr.close();
        			
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			
                	
                	
                }
			
			
			
			
			
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		panel_21.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_2.setPreferredSize(new Dimension(70, 25));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_2.setText("");
			}
		});
		panel_21.add(btnNewButton_2);
		
		
		
		textPane_2 = new JTextArea();
		textPane_2.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textPane_2.setForeground(Color.WHITE);
		textPane_2.setBackground(Color.BLACK);
		JScrollPane scrollPane_3 = new JScrollPane(textPane_2);
		panel_9.add(scrollPane_3, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		splitPane_3.setLeftComponent(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(SystemColor.activeCaption);
		panel_7.add(panel_12, BorderLayout.SOUTH);
		
		JButton btnLoad_2 = new JButton("Load");
		btnLoad_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoad_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLoad_2.setPreferredSize(new Dimension(70, 25));
		btnLoad_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("query File", "q");
				fc.setDialogTitle("Choisir un Fichier de type queries");
				fc.addChoosableFileFilter(filter);
				fc. setAcceptAllFileFilterUsed(false);
				int val_retour = fc.showOpenDialog(null);

                if (val_retour == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile();
                	textPane_3.setText("");
                	FileReader fr;
					try {
						fr = new FileReader(file);
						BufferedReader br=new BufferedReader(fr);
        			String ligne= br.readLine();
        			
        			while(ligne!=null){
        				textPane_3.setText(textPane_3.getText()+ligne+"\n");
        				
        				ligne=br.readLine();
        				}
        			
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
                }
                }
			}
		});
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnLoad_2.setBackground(Color.WHITE);
		panel_12.add(btnLoad_2);
		
		JButton btnSave_2 = new JButton("Save");
		btnSave_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSave_2.setPreferredSize(new Dimension(70, 25));
		btnSave_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("query File", "q");
				fc.setDialogTitle("Choisir un Fichier de type query");
				fc.addChoosableFileFilter(filter);
				fc. setAcceptAllFileFilterUsed(false);
				int val_retour = fc.showSaveDialog(null);

                if (val_retour == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile();
                	 String path = file.getAbsolutePath();

                	  String extension[] = filter.getExtensions();
                	  System.out.println(extension[0]);

                	  if(!path.endsWith(extension[0]))
                	  {
                	    file = new File(path +"."+ extension[0]);
                	  }
                	FileWriter fr;
					try {
						fr = new FileWriter(file);
						BufferedWriter br=new BufferedWriter(fr);
					
        			String ligne= textPane_3.getText();
        			
        		    br.write(ligne);
        			
					br.close();
					fr.close();
        			
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			
                	
                	
                }
			
			
			}	
		});
		btnSave_2.setBackground(Color.WHITE);
		panel_12.add(btnSave_2);
		
		JButton btnClear_2 = new JButton("Clear");
		btnClear_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClear_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnClear_2.setPreferredSize(new Dimension(70, 25));
		btnClear_2.setBackground(Color.WHITE);
		btnClear_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_3.setText("");
			}
			
		});
		panel_12.add(btnClear_2);
		
		JButton btnVrifier = new JButton("Verify ->>");
		btnVrifier.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVrifier.setPreferredSize(new Dimension(110, 25));
		panel_12.add(btnVrifier);
		btnVrifier.setMinimumSize(new Dimension(110, 110));
		btnVrifier.setMaximumSize(new Dimension(110, 110));
		btnVrifier.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnVrifier.setBackground(Color.WHITE);
		btnVrifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verify();
			}
		});
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(SystemColor.activeCaption);
		panel_7.add(panel_15, BorderLayout.NORTH);
		
		JLabel lblPropritsVrifier = new JLabel("UPPAAL CTL Properties");
		lblPropritsVrifier.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_15.add(lblPropritsVrifier);
		
		
		
		textPane_3 = new JTextArea();
		textPane_3.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textPane_3.setForeground(Color.WHITE);
		textPane_3.setBackground(Color.BLACK);
		JScrollPane scrollPane_2 = new JScrollPane(textPane_3);
		panel_7.add(scrollPane_2, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	protected void verify() {
		
		Main process =new Main();
		
		String source1="c:\\temp\\source.xta";
		String source2="c:\\temp\\source.q";
		
		
		
		File fs1=new File(source1);
		File fs2=new File(source2);
     	
     	
		try {
			
		FileWriter frs1;	
		frs1 = new FileWriter(fs1);
		BufferedWriter brs1=new BufferedWriter(frs1);
		
		String ligne= textPane_1.getText();
		
	    brs1.write(ligne);
	    brs1.flush();
		brs1.close();
		frs1.close();
		
		
		
	   	
		FileWriter frs2 = new FileWriter(fs2);
		BufferedWriter brs2=new BufferedWriter(frs2);
			
		ligne= textPane_3.getText();
			
		brs2.write(ligne);
		brs2.flush();	
		brs2.close();
		frs2.close();
		
		textPane_2.setText("");
		process.verify(fs1,fs2);
		File fr=new File ("c:\\temp\\resultat.txt");
		
		System.out.println(fr.getAbsolutePath());
		
		if(fr.exists()) {
		FileReader frr= new FileReader(fr);
		BufferedReader brr=new BufferedReader(frr);
		ligne= brr.readLine();
		
		while(ligne!=null){
			textPane_2.setText(textPane_2.getText()+ligne+"\n");
			ligne=brr.readLine();
			}
		
		brr.close();
		frr.close();
		
		}else textPane_2.setText("fichier resultat non généré"+"\n");
		
//		fs1.delete();
//		fs2.delete();
//		fr.delete();
//		
//		
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		}
	
		}
	
	protected void dsltoxta() {
		Main process =new Main();
		
		File fdsl=new File("c:\\temp\\source.dsl");
		textPane_1.setText("");
   	
   	FileWriter fr;
		try {
			fr = new FileWriter(fdsl);
			BufferedWriter br=new BufferedWriter(fr);
		
		String ligne= textPane_0.getText();
		
	    br.write(ligne);
		
		br.close();
		fr.close();
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		File fd=new File("c:\\temp\\dest.xta");
		process.principal(fdsl,fd);
		
		FileReader fxta;
		try {
			fxta = new FileReader(fd);
			BufferedReader bxta=new BufferedReader(fxta);
		String ligne= bxta.readLine();
		
		while(ligne!=null){
			textPane_1.setText(textPane_1.getText()+ligne+"\n");
			
			ligne=bxta.readLine();
			}
		bxta.close();
		fxta.close();
		fdsl.delete();
		fd.delete();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
    }
		
	}

	public static void main(String[] args) {
		new principal();
		
		//new Main().principal(new File("C:\\Users\\Baaziz\\Desktop\\Test UPPAAL\\test1.dsl"), null);
	}

}
