package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	
	@Autowired
	AdminMemberService adminMemberService;
	
  /**
	* 회원 가입
	* 2024-01-30
	*/
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		System.out.println("[AdminMemberController] createAccountForm()");
		
		String nextPage = "admin/member/create_account_form";
		
		return nextPage;
		
	}
	
  /**
	* 회원 가입 확인
	* 2024-01-30
	*/
	@PostMapping("/createAccountConfirm")
	public String createAccountConfirm(AdminMemberVo adminMemberVo) {
		System.out.println("[AdminMemberController] createAccountConfirm()");
		
		String nextPage = "admin/member/create_account_ok";
		
		int result = adminMemberService.createAccountConfirm(adminMemberVo);
		
		if (result <= 0)
			nextPage = "admin/member/create_account_ng";
		
		return nextPage;
		
	}
	
	/**
      * 로그인
	  * 2024-02-01
	  */
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("[AdminMemberController] loginForm()");
		
		String nextPage = "admin/member/login_form";
		
		return nextPage;
	}
	
	/**
     * 로그인 확인
	 * 2024-02-02
	 */
	@PostMapping("/loginConfirm")
	public String loginConfirm(AdminMemberVo adminMemberVo) {
		System.out.println("[AdminMemberController] loginConfirm()");
		
		String nextPage = "admin/member/login_ok";
		
		AdminMemberVo loginedAdminMemberVo = adminMemberService.loginConfirm(adminMemberVo);
		
		if(loginedAdminMemberVo == null) nextPage = "admin/member/login_ng";
		
		return nextPage;
	}
}