package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 * 
* 
* Copyright: Copyright (c) 2019 Baozi
* @ClassName: OpenFileListener.java
* @Description: ���ļ��¼�
*
* @version: v1.0.0
* @author: baozi
* @date: 2019��10��30�� ����7:04:18 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------*
* 2019��10��30��       	baozi           v1.0.0                                    ��
 */

public class OpenFileListener implements ActionListener {

	private File file;
	private JTextArea code;
	
	public OpenFileListener(JTextArea code) {
		this.code = code;
	}
	
	public void init() throws IOException {
		JFileChooser fileChooser = new JFileChooser(".");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.showOpenDialog(null);
		if (fileChooser.getSelectedFile() != null) {
			file = fileChooser.getSelectedFile();
			FileInputStream inputStream = new FileInputStream(file.getAbsolutePath());
			int size = inputStream.available() + 1;
			byte[] temp = new byte[size];
			inputStream.read(temp);
			String codes = new String(temp);
			code.setText(codes);
			SaveFileListener.setSavePath(file.getAbsolutePath());
			WeaveCode.setSavePath(file.getAbsolutePath());
		} else {
			code.setText("δ���ļ�\n");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			init();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
