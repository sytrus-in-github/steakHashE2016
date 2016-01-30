package tools;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * When competing google hash code, the ' ' is most probably the delimitor
 * Prepare a class to accomadate/represent data
 * and then make modifications to loadData(), and then call it somewhere else
 */
public class Reader {
	public BufferedReader br;
	private FileReader fw;
	public char[] delimitor={' ', ','};
	Reader(String path) {
		try {
			fw = new FileReader(path);
			br = new BufferedReader(fw, 1024);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public boolean isDelimitor(char c) {
		for (int i = 0; i < delimitor.length; i++) {
			if (c == delimitor[i]) return true;
		}
		return false;
	}
	public String readWord()
	{
		String s="";char c;
		try {
			c=(char) br.read();
			while(!isDelimitor(c))
			{
				if(c==(char)-1)
					break;
				else if (c=='\n' || c=='\r') {
					if (s.length() != 0)
						break;
					else
						continue;
				} else {
					s += c;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;

	}
	public String readLine()
	{
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";

	}
	public int readInt() throws Exception{
		String word = readWord();
		if (word.length() == 0)
			throw new Exception("No more words left and you are asking for more");
		return Integer.parseInt(word);
	}
	public long readLong() throws Exception{
		String word = readWord();
		if (word.length() == 0)
			throw new Exception("No more words left and you are asking for more");
		return Long.parseLong(word);
	}
	public double readDouble() throws Exception {
		String word = readWord();
		if (word.length() == 0)
			throw new Exception("No more words left and you are asking for more");
		return Double.parseDouble(word);
	}
	public char readChar() throws Exception{
		int c;
		do {
			c = br.read();
		} while (c == (int)'\r' || c == (int)'\n');
		return (char)c;
		
	}
	public void close() {
		try {
			br.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
