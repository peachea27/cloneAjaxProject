package lee.loosecoupling.factory;

public class ParseManager {

	public static Parseable getParser(String filename) {
		
		Parseable result = null;
		
		String ext = filename.substring(filename.lastIndexOf(".") + 1);
		System.out.println("파일의 확장자 : " + ext);
		
		if (ext.equals("json")) {
			result= new JasonParser();

		} else if ( ext.equals("xml")) {
			result = new XmlParser();
		}else {
			result = new NoParser(); 
		}
		
			return result;
		
	}
	}

