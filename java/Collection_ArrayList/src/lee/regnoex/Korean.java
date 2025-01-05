package lee.regnoex;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Korean {
	private String regNo;
	private String name;
	
	Korean(String regNo, String name){
		//super();가 기본으로 들어있다//
		this.regNo = regNo;
		this.name = name;
	}
	

	//getter, setter
	//주민등록번호 (regNo)는 수정불가
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegNo() {
		return regNo;
	}

	//equals(),hashCode() 오버라이딩 --set가 같은객체인지 판단할 때 자체적으로 equals와 hashcode를 사용, 오버라이딩해놓으니 이 메서드들을 우선사용해서 동일한 객체로 인식
		@Override
		public boolean equals(Object obj) {
			boolean result = false;
			if(obj instanceof Korean) {
			Korean tmp =(Korean)obj;
			if(this.regNo.equals(tmp.regNo) && this.name.equals(tmp.name)) {
				result =true;
				}
			}
			// java.lang.ClassCastException: lee.regnoex.Student cannot be cast to lee.regnoex.Korean// student를 넣을 수는 없을까?
			return result;
		}

		@Override
		public int hashCode() {
			return (this.regNo + this.name).hashCode();//따옴표 안의 내용이 같다면 hashcode가 같아야
		}
	
	@Override
	public String toString() {
		return "Korean [regNo=" + regNo + ", name=" + name + "]";
	}

//자동으로 만들어주는 hashcode와 equals(sources)
//	@Override
//	public int hashCode() {
//		return Objects.hash(name, regNo);
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Korean other = (Korean) obj;
//		return Objects.equals(name, other.name) && Objects.equals(regNo, other.regNo);
//	}
//	
//	
}
