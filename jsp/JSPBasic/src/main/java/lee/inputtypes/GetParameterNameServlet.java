package lee.inputtypes;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lee.inputtypes.vo.Member;

@WebServlet("/GetParameterNamesServlet")
public class GetParameterNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetParameterNameServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> params = request.getParameterNames();
		
		Map<String, List<String>>map = new HashMap<String, List<String>>();
		
		while (params.hasMoreElements()) { /* 다음 요소가 있는 동안 반복 */
			String paraName = params.nextElement(); /* 넘겨진 파라미터 이름 얻기 */
//			System.out.println(paraName);
//			String value = request.getParameter(paraName); /* 해당 파라미터에 대한 값 얻기 */
//			System.out.println(paraName+": "+value);
			
			List<String> valueList = new ArrayList<String>();
			String[] valueArr = request.getParameterValues(paraName);
			
			/*
			 * 일반 배열을 ArrayList에 담는 방법 1)
			 */
//			for (String value : valueArr) {
//				valueList.add(value);
//				 
//			}
//			
			/* 방법2) */
			valueList =Arrays.asList(valueArr);
			
			System.out.println("params -"+paraName+":"+valueList);
		}
		
		Map<String, String[]>paraMap = request.getParameterMap();
		
		for(Map.Entry<String, String[]>entry: paraMap.entrySet()) {
			String key =entry.getKey();
			String[] values =entry.getValue();
			System.out.println("paraMap-"+key +":"+Arrays.toString(values));
		}
	}
}
