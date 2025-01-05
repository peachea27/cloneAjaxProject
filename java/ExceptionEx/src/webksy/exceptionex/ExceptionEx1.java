package webksy.exceptionex;

public class ExceptionEx1 {

	public static void main(String[] args) {
		
		try {
			install();
		} catch (InstallException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("설치 종료합니다. ");
		
	} // main끝

	private static void install() throws InstallException {
		try {
			startInstall();
			copyFiles();
			
		} catch (SpaceException e) {
//			e.printStackTrace();
			System.out.println("예외 발생 : " + e.getMessage());
			System.out.println("공간을 확보한 후에 설치해주세요....");
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(e); // 원인예외 
			ie.getCause();
			throw ie;
		} catch (MemoryException e) {
//			e.printStackTrace();
			System.out.println("예외 발생 : " + e.getMessage());
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(e);
			throw ie;
			
		} finally {
			deleteTmpFiles();
		}
	}

	private static void deleteTmpFiles() {
		System.out.println("임시파일을 삭제합니다.....");
	}

	private static void copyFiles() {
		 System.out.println("파일 복사 시작합니다.....");
	}

	private static void startInstall() throws SpaceException, MemoryException {
		System.out.println("설치를 시작합니다......");
		if (!calSpace()) {
			// 예외 발생
			throw new SpaceException("디스크공간이 부족합니다. ");
		}
		
		if (!calMemory()) {
			throw new MemoryException("메모리가 부족합니다.");
			
			// throw new RuntimeException(new MemoryException("메모리부족")); 
			// RuntimeException생성자를 이용한 원인예외설정
			
		}
	}

	private static boolean calMemory() {
		// 메모리 계산 
		return true;
	}

	private static boolean calSpace() {
		// 설치공간 계산 충분 : true, 불충분: false
		return false;
	}

}

class SpaceException extends Exception {
	SpaceException(String msg){
		super(msg);
	}
}

class InstallException extends Exception {
	InstallException(String msg) {
		super(msg);
	}
}

class MemoryException extends Exception {
	MemoryException(String msg){
		super(msg);
	}
}
