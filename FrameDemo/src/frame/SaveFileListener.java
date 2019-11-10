package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class SaveFileListener implements ActionListener {
	
	private static String savePath;
	private JTextArea code;
	private File file;
		
	public SaveFileListener(JTextArea code) {
		super();
		this.code = code;
	}

	public static void setSavePath(String savePath) {
		SaveFileListener.savePath = savePath;
	}

	public void init() {
		try {
			if (savePath == null) {
				NewFileWindow newFile = NewFileWindow.getInstance(code);
				newFile.init();
			} else {
				SaveFileMethod.saveCode(savePath, code.getText());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		init();
	}
	
}
