package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CancelListener implements ActionListener {
	
	private JTextField fileName;
	private NewFileWindow fileWindow;
	
	
	public CancelListener(JTextField fileName, NewFileWindow fileWindow) {
		super();
		this.fileName = fileName;
		this.fileWindow = fileWindow;
	}

	public void init() {
		fileName.setText("");
		fileWindow.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		init();
	}
	
}
