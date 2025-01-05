import lee.loosecoupling.ex.ParseService;

public class ParseMain {

	public static void main(String[] args) {
	ParserService service = new ParserService();
	
		
		service.processParse("data.json");
		service.processParse("data.xml");
		service.processParse("data.dat");

	}

}
