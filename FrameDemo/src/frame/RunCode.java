package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class RunCode implements ActionListener {

	private static String savePath;
	private static final String cmdPath = "C:/Windows/System32/cmd.exe /c";
	private JTextArea tips;
	private String fileName;
		
	public RunCode(JTextArea tips) {
		this.tips = tips;
	}

	private synchronized String ReadMessage() throws IOException {
		Process process = Runtime.getRuntime().exec(cmdPath + " java /c" + savePath);
		InputStream inputStream = process.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line;
		StringBuffer output = new StringBuffer();
		int x = 0;
		while ((line = bufferedReader.readLine()) != null) {
			output.append(line + "\r\n");
			x++;
		}
		line = output.toString();
		System.out.println(x);
		return line;
	}
	
	public void init() throws IOException {
		if (savePath == null) {
			tips.setText("没有文件将被编译，请先编译源程序！！！");
		} else {
			System.out.println("gdahd");
			int index = savePath.indexOf(".");
			savePath = savePath.substring(0, index);
			String line = ReadMessage();
			System.out.println(line);
		}
	}
	
	public static void setSavePath(String savePath) {
		RunCode.savePath = savePath;
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
