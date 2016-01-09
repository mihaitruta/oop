import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Word {
	
	public static ArrayList<String> load(Reader r) throws IOException {
		BufferedReader buff = new BufferedReader(r);
		ArrayList<String> list = new ArrayList<String>();
		String str = new String("Mihai");
		while(str != null) {
			str = buff.readLine();
			if(str != null)
				list.add(str);
		}
		
		return list;
		
	}

	
	public static ArrayList<String> loadFromURL(String url) throws IOException {
		URL destination = new URL(url);
		URLConnection conn = destination.openConnection();
		return load(new InputStreamReader(conn.getInputStream()));
	}
	
}
