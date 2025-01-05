
public class ParserService {
	

	public void processParse(String filename) {
		
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		System.out.println("파일의 확장자:"+ext);
		boolean result=false;
		if(ext.equals("json")) {
			
			JasonParser jp = new JasonParser();
			result = jp.parser();
			
		}else if (ext.equals("xml")) {
			
			XmlParser xp = new XmlParser();
			result = xp.parser();
			
		}else {
			System.out.println("파서가 없습니다.");
		}
		
		if(result) {
			System.out.println("파싱 성공!");
		}else {
			System.out.println("파싱 실패!");
		}
	}
}
