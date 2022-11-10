package kr.or.ddit.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import kr.or.ddit.vo.MemberVOWrapper;

public class AuthMemberAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		MemberVOWrapper wrapper = (MemberVOWrapper) authentication.getPrincipal();
		request.getSession(false).setAttribute("authMember", wrapper.getRealUser());
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
