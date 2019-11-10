package frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.TextArea;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
* 
* Copyright: Copyright (c) 2019 Baozi
* @ClassName: Frame.java
* @Description: ����һ�����ڣ���������Ϣ�Ͳ���
*
* @version: v1.0.0
* @author: baozi
* @date: 2019��10��30�� ����6:57:08 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------*
* 2019��10��30��       	baozi           v1.0.0                                    ��
 */

public class Frame extends JFrame {
	
	public Frame() {
		super("�ҵ�java������");
	}

	public void init() {
		JPanel panel = new JPanel();
		JButton newFile = new JButton("�½��ļ�");
		JButton openFile = new JButton("���ļ�");
		JButton saveFile = new JButton("�����ļ�");
		JButton weaveFile = new JButton("����");
		JButton runCode = new JButton("����");
		setLayout(new BorderLayout());
		Box b = Box.createVerticalBox();
		b.add(newFile);
		b.add(b.createVerticalStrut(20));
		b.add(newFile);
		b.add(b.createVerticalStrut(10));
		b.add(saveFile);
		b.add(b.createVerticalStrut(10));
		b.add(openFile);
		b.add(b.createVerticalStrut(10));
		b.add(weaveFile);
		b.add(b.createVerticalStrut(10));
		b.add(runCode);
		panel.add(b);
		JPanel p = new JPanel();
		JTextArea codesArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(codesArea);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		p.add(scroll);
		add(scroll, BorderLayout.CENTER);
		add(panel, BorderLayout.EAST);
		add(new JLabel("�ȱ����ٱ������У��������Ը�����         ���ڰ�ɫ����������룡��"), BorderLayout.NORTH);
		setSize(500, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		newFile.addActionListener(NewFileWindow.getInstance(codesArea));
		saveFile.addActionListener(new SaveFileListener(codesArea));
		openFile.addActionListener(new OpenFileListener(codesArea));
		weaveFile.addActionListener(new WeaveCode(codesArea));
		runCode.addActionListener(new RunCode(codesArea));
	}
	
}
