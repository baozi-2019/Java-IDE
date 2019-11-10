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
* @Description: 建立一个窗口，以输入信息和操作
*
* @version: v1.0.0
* @author: baozi
* @date: 2019年10月30日 下午6:57:08 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------*
* 2019年10月30日       	baozi           v1.0.0                                    无
 */

public class Frame extends JFrame {
	
	public Frame() {
		super("我的java编译器");
	}

	public void init() {
		JPanel panel = new JPanel();
		JButton newFile = new JButton("新建文件");
		JButton openFile = new JButton("打开文件");
		JButton saveFile = new JButton("保存文件");
		JButton weaveFile = new JButton("编译");
		JButton runCode = new JButton("运行");
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
		add(new JLabel("先保存再编译运行，否则后果自负！！         请在白色区域输入代码！！"), BorderLayout.NORTH);
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
