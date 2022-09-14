package tw.georgia.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArticleDao {

	@Autowired
	private SessionFactory sessionFactory;
	

//	************新增文章***********************
	public Article insertArticle(Article Bean) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(Bean.getArticleClassID());
		System.out.println(Bean.getArticleDate());
		System.out.println(Bean.getTitle());
		
//		if(atBean != null) {
		session.save(Bean);
//		}
//		session.close();
		return Bean;
//		return null;
	}

//	***********刪除文章************************
	public boolean deleteArticle(int postID) {
		Session session = sessionFactory.getCurrentSession();
		Article atc = session.get(Article.class, postID);

		if (atc != null) {
			session.delete(atc);
//			session.close();
			return true;
		}
//		session.close();
		return false;
	}

//	***********修改文章************************
	public Article updateArticle(Article atBean) {
		Session session = sessionFactory.getCurrentSession();
		session.update(atBean);
//		session.flush();
//		session.close();
		return atBean;
	}

//	***********查詢全部****************************
	public List<Article> selectAll() {
		Session session = sessionFactory.getCurrentSession();

		Query<Article> queryAll = session.createQuery("from Article", Article.class);
		List<Article> resultList = queryAll.getResultList();
		
//		session.close();
		return resultList;
	}

//	***********查詢ID****************************
	public Article selectById(int postID) {
		Session session = sessionFactory.openSession();
		
		Article resultBean = session.get(Article.class, postID);		
		session.close();
		
		return resultBean;
	}
	
	
//	***********查詢國家****************************
	public List<Article> SearchBC(int bigClassID) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Article a where a.bigClassID=:BCID";

			List<Article> queryBC = session.createQuery(hql, Article.class)
					.setParameter("BCID", bigClassID)
					.getResultList();
			return queryBC;

	}
	
//	***********查詢分類****************************
	public List<Article> SearchLC(int articleClassID) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Article a where a.articleClassID=:LCID";
		
		List<Article> queryLC = session.createQuery(hql, Article.class)
				.setParameter("LCID", articleClassID)
				.getResultList();
		return queryLC;
		
	}
}


