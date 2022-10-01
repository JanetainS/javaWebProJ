package pro07.sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿으로 테이블의 회원정보 조희
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
											//요청						//응답
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전송 타입
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//SQL문이란? 데이터 베이스 접근할 수 있는 데이터 베이스 하부 언어
		//SQL문으로 조회할 수 있는 MemberDAO 객체를 생성
		MemberDAO dao = new MemberDAO();
		
		//리스트를 사용하는 이유?
		//회원정보를 조회
		List<MemberVO> list = dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
	    out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
	    
	    
	    //조회한 회원정보를 리스트로 출력
	    for(int i=0; i<list.size(); i++) {
	    	
	    	//MemberVO라는 메서드를 memberVo 담은 것이 list.get(i)의 i가 증가 할때마다 관련된 값을 출력한다.
	    	MemberVO memberVo = list.get(i);
	    	
	    	String id = memberVo.getId();
	    	String pwd = memberVo.getPwd();
	    	String name = memberVo.getName();
	    	String email = memberVo.getEmail();
	    	Date joinDate = memberVo.getJoinDate();
	    	
	    	out.print("<tr><td>"+id+"</td><td>"+
	                			pwd+"</td><td>"+
	                			name+"</td><td>"+
	                			email+"</td><td>"+
	                			joinDate+"</td></tr>");		
	    }
	    out.print("</table></body></html>");
		
	}

}
