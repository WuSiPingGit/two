package wsp.com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IoUtil {
	public static void save(InputStream inputStream, String path) {
		File file = new File(path);
		if (file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileOutputStream fileOutputStream =null;
		try {
			fileOutputStream = new FileOutputStream(file);
			int read = -1;
			byte[] b = new byte[1024*10];
			while((read=inputStream.read(b, 0, b.length))!=-1) {
				fileOutputStream.write(b, 0, read);
			}
			fileOutputStream.flush();
			if (fileOutputStream!=null) {
				fileOutputStream.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileOutputStream!=null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
