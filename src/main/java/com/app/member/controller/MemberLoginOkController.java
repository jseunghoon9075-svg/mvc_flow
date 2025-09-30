package com.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.Action;
import com.app.Result;
import com.app.dao.MemberDAO;
import com.app.vo.MemberVO;

public class MemberLoginOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		String memberEmail = null, memberPassword = null, foundMemberEmail = null;
		MemberVO memberVO = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		HttpSession session = req.getSession();
		
		
		memberEmail = req.getParameter("memberEmail");
		memberPassword = req.getParameter("memberPassword");
		
		memberVO.setMemberEmail(memberEmail);
		memberVO.setMemberPassword(memberPassword);
		
		foundMemberEmail = memberDAO.select(memberVO);
		
		result.setRedirect(true);
//		아이디 또는 비밀번호 틀림(회원 정보x)
		if(foundMemberEmail == null) {
			result.setPath("/flow/login.member?isFail=true");
			return result;
		}
		
//		정상로그인
		session.setAttribute("memberEmail", foundMemberEmail);
		
		result.setRedirect(true);
		result.setPath("/flow");
		return result;
	}

}
