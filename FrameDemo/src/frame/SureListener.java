package frame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SureListener extends JFrame implements ActionListener {

	private JTextField savePath;
	private JTextField fileName;
	private NewFileWindow fileWindow;

	public SureListener(JTextField savePath, JTextField fileName, NewFileWindow fileWindow) throws HeadlessException {
		super();
		this.savePath = savePath;
		this.fileName = fileName;
		this.fileWindow = fileWindow;
	}

	public void init() {
		String savePaths = savePath.getText();
		String fileNames = fileName.getText();
		if ("".equals(fileNames) || "".equals(savePaths)) {
			JOptionPane.showMessageDialog(null, "文件名或路径为空！！！", "错误", JOptionPane.WARNING_MESSAGE);
		} else {
			savePaths += "/";
			savePaths += fileNames;
			try {
				SaveFileMethod.saveFile(savePaths);
				SaveFileMethod.saveCode(savePaths, fileWindow.getCode().getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
			SaveFileListener.setSavePath(savePaths);
			WeaveCode.setSavePath(savePaths);
			fileName.setText("");
			fileWindow.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		init();
	}

}
