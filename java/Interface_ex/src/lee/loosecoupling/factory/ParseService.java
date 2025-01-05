package lee.loosecoupling.factory;

public class ParseService {

	public void processParse(String filename) {
		
		boolean result = false;
		
		Parseable parser = ParseManager.getParser(filename);
		result = parser.parse();
	
		if(result) {
			System.out.println("파싱완료!");
				
		}else {
			System.out.println("파싱 실패!");
			}
		}
	}

