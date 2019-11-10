package frame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
* 
* Copyright: Copyright (c) 2019 Baozi
* @ClassName: NewFileListener.java
* @Description: ������ļ��¼�
*
* @version: v1.0.0
* @author: baozi
* @date: 2019��10��30�� ����7:03:43 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------*
* 2019��10��30��       	baozi           v1.0.0                                    ��
 */

public class NewFileListener extends JFrame implements ActionListener {
	
	private JTextField savePath;
	private JTextField fileName;
	private File file;
	
	public NewFileListener(JTextField savePath, JTextField fileName) throws HeadlessException {
		super();
		this.savePath = savePath;
		this.fileName = fileName;
	}

	public void init() {
		JFileChooser fileChooser = new  JFileChooser(".");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.showSaveDialog(null);
		if (fileChooser.getSelectedFile() != null) {
			file = fileChooser.getSelectedFile();
		} else {
			file = new File(".");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		init();
		savePath.setText(file.getAbsolutePath());
	}

}
