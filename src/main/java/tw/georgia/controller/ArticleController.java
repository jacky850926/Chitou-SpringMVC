package tw.georgia.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.georgia.model.Article;
import tw.georgia.model.ArticleDao;

@Controller
//@SessionAttributes(names = {""})
public class ArticleController {

	@Autowired
	private ArticleDao articleDao;
	
	String mainUrl="article.main";
	
//	**********文章首頁********************************************
	@RequestMapping(path = "/article.main",method = RequestMethod.GET)
	public String articleMain(Model m) {

		List<Article> list = articleDao.selectAll();
		m.addAttribute("list", list);
		//request.setAttribute("list",list);
		return "georgia-ArticleMain";
	}
	
//	**********前往新增文章*********************************************
	@RequestMapping(path = "/article.new",method = RequestMethod.GET)
	public String newArticle() {
		return "georgia-CreateArticle";
	}
	
//	*********新增文章*************************************************
	@PostMapping(path = "/article.insert")
	public String insertArticle(@RequestParam("posterID") int posterID,
								@RequestParam("title") String title,
								@RequestParam("chooseCountry") String chooseCountry,
								@RequestParam("chooseType") String chooseType,
								@RequestParam("photo") String photo,
								@RequestParam("content") String content) {
		int articleClassID = Integer.parseInt(chooseCountry+chooseType);
		int bigClassID = Integer.parseInt(chooseCountry);
		String articleDate =DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now());
		Article insertBean = new Article(posterID,bigClassID,articleClassID,title,content,articleDate,photo);
		articleDao.insertArticle(insertBean);
		return "redirect:"+mainUrl;
	}
//	*********刪除文章*************************************************
	@DeleteMapping(path = "/article.delete")
	public String deleteArticle(@RequestParam("postID") int postID) {
		Article deleteBean=new Article();
		articleDao.deleteArticle(postID);
		return "redirect:"+mainUrl;
	}
//	*********前往更新文章*************************************************
	@RequestMapping(path = "/article.renew",method = RequestMethod.POST)
	public String renewArticle(@RequestParam("postID") int postID,Model m) {
//		int articleClassID = Integer.parseInt(chooseType.substring(3));
		
		Article selectByIdBean = articleDao.selectById(postID);
		m.addAttribute("selectByIdBean", selectByIdBean);
		return "georgia-UpdateArticle";
	}
	
//	*********更新文章*************************************************
	@PutMapping(path = "/article.update")
	public String updateArticle(@RequestParam("postID") int postID,
								@RequestParam("posterID") int posterID,
								@RequestParam("chooseCountry") String chooseCountry,
								@RequestParam("chooseType") String chooseType,
								@RequestParam("title") String title,
								@RequestParam("content") String content,
								@RequestParam("articleDate") String articleDate,
								@RequestParam("photo") String photo) {
		int articleClassID = Integer.parseInt(chooseCountry+chooseType);
		int bigClassID = Integer.parseInt(chooseCountry);
		Article updateBean = new Article(postID, posterID, bigClassID, articleClassID, title, content,articleDate, photo);
		articleDao.updateArticle(updateBean);
		return "redirect:"+mainUrl;
	}
//	*********查詢*************************************************
	@RequestMapping(path = "/article.read",method = RequestMethod.POST)
	public String readArticle(@RequestParam("chooseCountry") String chooseCountry,
								@RequestParam("chooseType") String chooseType,
								Model m) {
		if (chooseType == "") {
			int bigClassID = Integer.parseInt(chooseCountry);
			List<Article> searchBean = articleDao.SearchBC(bigClassID);
			m.addAttribute("searchBean", searchBean);
		}else {
			int articleClassID = Integer.parseInt(chooseCountry+chooseType);
			List<Article> searchBean = articleDao.SearchLC(articleClassID);
			m.addAttribute("searchBean", searchBean);
		}
		return "georgia-ReadArticle";
	}
}

















