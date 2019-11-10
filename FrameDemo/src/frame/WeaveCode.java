package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

public class WeaveCode implements ActionListener {

	private static String savePath;
	private static final String cmdPath = "C:/Windows/System32/cmd.exe /c";
	private JTextArea tips;
	private String fileName;
	
	public WeaveCode(JTextArea tips) {
		this.tips = tips;
	}
	
	public static void setSavePath(String savePath) {
		WeaveCode.savePath = savePath;
	}

	public void init() throws IOException {
		if (savePath == null) {
			tips.setText("没有文件将被编译，请先选择或创建文件！！！");
		} else {
			RunCode.setSavePath(savePath);
			Runtime.getRuntime().exec(cmdPath + " javac " + savePath);
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
