package frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
* 
* Copyright: Copyright (c) 2019 Baozi
* @ClassName: NewFileWindow.java
* @Description: �½��ļ�����
*
* @version: v1.0.0
* @author: baozi
* @date: 2019��10��30�� ����7:11:55 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------*
* 2019��10��30��       	baozi           v1.0.0                                    ��
 */

public class NewFileWindow extends JFrame implements ActionListener {
	
	private JTextField savePath;
	private JTextField fileName;
	private JTextArea code;
	private static NewFileWindow instance = new NewFileWindow();
	
	private NewFileWindow() {
		super("�½��ļ�");
	}
	
	public static NewFileWindow getInstance(JTextArea code) {
		instance.code = code;
		return instance;
	}
	
	public JTextArea getCode() {
		return code;
	}

	public JTextField getSavePath() {
		return savePath;
	}

	public void setSavePath(JTextField savePath) {
		this.savePath = savePath;
	}

	public JTextField getFileName() {
		return fileName;
	}

	public void setFileName(JTextField fileName) {
		this.fileName = fileName;
	}

	public void init() {
		File f = new File(".");
		savePath = new JTextField(f.getAbsolutePath(), 20);
		fileName = new JTextField("", 20);
		JButton chooseDir = new JButton("ѡ��·��");
		JButton yes = new JButton("ȷ��");
		JButton no = new JButton("ȡ��");
		Box b1 = Box.createHorizontalBox();
		b1.add(b1.createHorizontalStrut(100));
		b1.add(yes);
		b1.add(b1.createHorizontalStrut(50));
		b1.add(no);
		JPanel p1 = new JPanel();
		p1.setSize(380, 50);
		p1.add(savePath);
		p1.add(fileName);
		Box b3 = Box.createVerticalBox();
		b3.add(b3.createVerticalStrut(5));
		b3.add(new JLabel(" �ļ�·��"));
		b3.add(b3.createVerticalStrut(10));
		b3.add(new JLabel(" �ļ�����"));
		Box b2 = Box.createHorizontalBox();
		b2.add(chooseDir);
		b2.add(b2.createHorizontalStrut(10));
		setLayout(new BorderLayout());
		add(b3, BorderLayout.WEST);
		add(p1, BorderLayout.CENTER);
		add(b2, BorderLayout.EAST);
		add(b1, BorderLayout.SOUTH);
		setSize(400, 120);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		chooseDir.addActionListener(new NewFileListener(savePath, fileName));
		yes.addActionListener(new SureListener(savePath, fileName, instance));
		no.addActionListener(new CancelListener(fileName, instance));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		init();
	}
	
}
