package frame;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveFileMethod {
	
	public static void saveFile(String savePath) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(savePath);
		outputStream.close();
	}
	
	public static void saveCode(String savePath, String codes) throws IOException {
			FileOutputStream outputStream = new FileOutputStream(savePath, false);
			outputStream.write(codes.getBytes());
			outputStream.close();
	}
	
}
