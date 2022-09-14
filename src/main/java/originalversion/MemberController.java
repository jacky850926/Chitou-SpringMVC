package originalversion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("memberlist")
public class MemberController {

	@Autowired
	private MemberBeanService mService;

	
	@RequestMapping(path = "/loginmain.controller", method=RequestMethod.GET)
	public String processMainAction() {
		return "Jacky-Login";
	}
	
	@RequestMapping(path = "/adminhomepage", method=RequestMethod.GET)
	public String adminHomePage() {
		return "Jacky-AdminHomePage";
	}
	
	
	
	@RequestMapping(path = "/entercreatememberpage",method = RequestMethod.POST)
	public String enterpage() {
		return "Jacky-AdminCreateMember";
	}
	
	@RequestMapping(path = "/adminmodifypage",method = RequestMethod.POST)
	public String processadminmodifypage(HttpServletRequest request, HttpServletResponse response) {
		String memberid;
		String statusid;
		String userid;
		String password;
		String name;
		String nickname;
		String phone;
		String nationality;
		String birth;
		String gender;
		String address;
		String email;
		String createtime;
		String modifytime;
		
		memberid = request.getParameter("memberid");
		statusid = request.getParameter("statusid");
		userid = request.getParameter("userid");
		password = request.getParameter("password");
		name = request.getParameter("name");
		nickname = request.getParameter("nickname");
		phone = request.getParameter("phone");
		nationality = request.getParameter("nationality");
		birth = request.getParameter("birth");
		gender = request.getParameter("gender");
		address = request.getParameter("address");
		email = request.getParameter("email");
		createtime = request.getParameter("createtime");
		modifytime = request.getParameter("modifytime");
		
		MemberBean modifymemberbean = new MemberBean(memberid,statusid,userid, password, name, nickname, phone, nationality,
				birth, gender, address, email, createtime, modifytime);
		request.getSession().setAttribute("modifymemberbean", modifymemberbean);
		
		return "Jacky-AdminModifyPage";
	}
	
	
	
	
	@RequestMapping(path = "/admininsertmember",method = RequestMethod.POST)
	public String processAdminInsertMember(@ModelAttribute("memberinfo") MemberBean mb, Model m) {
		mService.insert(mb);
		List<MemberBean> memberlist = mService.searchAll();
		m.addAttribute("memberlist",memberlist);
		return "Jacky-AdminHomePage";
	}
	
	
//	@RequestMapping(path = "/admindeletemember",method = RequestMethod.POST)
//	public String processAdminDeleteMember(@ModelAttribute("memberlistinfo") MemberBean mb, Model m,
//			@RequestParam("td_memberid")String memberid) {
//		System.out.println(memberid);
//		System.out.println(mb.getMemberid());
//		boolean delete = mService.delete(mb);
//		if (delete) {
//			System.out.println("delete successfully");			
//		}else {
//			System.out.println("failed");
//		}
//		
//		return "Jacky-AdminHomePage";
//	}
	
	@RequestMapping(path = "/admindeletemember",method = RequestMethod.POST)
	public String processAdminDeleteMember(
			@RequestParam("td_memberid")String memberid,Model m) {
		System.out.println(memberid);
		boolean delete = mService.delete(memberid);
		if (delete) {
			System.out.println("delete successfully");			
		}else {
			System.out.println("failed");
		}
		
		List<MemberBean> memberlist = mService.searchAll();
		m.addAttribute("memberlist",memberlist);
		
		return "Jacky-AdminHomePage";
	}
	
	@RequestMapping(path = "/adminupdatemember",method = RequestMethod.POST)
	public String processAdminUPdateMember(HttpServletRequest request, HttpServletResponse response,Model m) {
		String memberid;
		String statusid;
		String userid;
		String password;
		String name;
		String nickname;
		String phone;
		String nationality;
		String birth;
		String gender;
		String address;
		String email;
		String createtime;
		String modifytime;
		
		memberid = request.getParameter("td_memberid");
		statusid = request.getParameter("td_statusid");
		userid = request.getParameter("td_userid");
		password = request.getParameter("td_password");
		name = request.getParameter("td_name");
		nickname = request.getParameter("td_nickname");
		phone = request.getParameter("td_phone");
		nationality = request.getParameter("td_nationality");
		birth = request.getParameter("td_birth");
		gender = request.getParameter("td_gender");
		address = request.getParameter("td_address");
		email = request.getParameter("td_email");
		createtime = request.getParameter("td_createtime");
		modifytime = request.getParameter("td_modifytime");
		
		MemberBean modifymemberbean = new MemberBean(memberid,statusid,userid, password, name, nickname, phone, nationality,
				birth, gender, address, email, createtime, modifytime);
		
		int result = mService.update(modifymemberbean);
		
		if(result == 1) {
			System.out.println("update successfully");
		}else {
			System.out.println("failed update");
		}
		
		List<MemberBean> memberlist = mService.searchAll();
		m.addAttribute("memberlist",memberlist);
		
		return "Jacky-AdminHomePage";
	}
	
	@RequestMapping(path= "/adminsearchindb",method = RequestMethod.POST)
	public String processAdminSearchInDB(@RequestParam("searchinfo")String columnname, @RequestParam("searchtext") String value,Model m) {
		String hql = mService.mergeHql(columnname, value);
		List<MemberBean> result = mService.searchInDB(hql);
		m.addAttribute("result",result);
		
		return "Jacky-SearchPage";
	}
	
	
	
	@RequestMapping(path = "/checklogin.controller",method = RequestMethod.POST)
	public String processCheckLogin(@RequestParam("loginuserid")String user,@RequestParam("loginpw")String pwd,Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors",errors);
		
		if(user == null || user.length()==0) {
			errors.put("name","name is required");
		}
		
		if(pwd==null||pwd.length()==0) {
			errors.put("pwd","password is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "Jacky-Login";
		}
		
		boolean result = mService.checkLogin(new MemberBean(user,pwd));
		
		if(result) {
			m.addAttribute("user",user);
			m.addAttribute("pwd",pwd);
			List<MemberBean> memberlist = mService.searchAll();
			m.addAttribute("memberlist",memberlist);
			return "Jacky-AdminHomePage";
			
		}
		
		errors.put("msg","please input correct username or passward");
		return "Jacky-Login";
	}
	

	

	
	
}
