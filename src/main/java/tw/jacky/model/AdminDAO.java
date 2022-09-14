package tw.jacky.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Where;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AdminDAO {
	


	@Autowired
	private SessionFactory sessionFactory;
	
//	C
	public AdminChitou insert(AdminChitou bean) {
		Session session = sessionFactory.openSession();
		if(bean!=null) {
//			用一個new bean取代本來的bean 來解決 identity的ID問題
			System.out.println("adminid:"+ bean.getAdminid());
			System.out.println(bean.getAdminstatus());
			System.out.println(bean.getUsername());
			System.out.println(bean.getPassword());
			System.out.println(bean.getPermission());
			session.save(bean);
		}
		session.close();
		return bean;
	}
	
//	U
//	public MemberBean update(MemberBean bean) {
//		Session session = sessionFactory.openSession();
//		
//		if(bean!=null) {
//			session.update(bean);
//			session.flush();
//		}
//		session.close();
//		return bean;		
//	}
	
	
	
//	for boss
	public Integer update(AdminChitou mb) {
		
		Session session = sessionFactory.openSession();
		String hql="update AdminChitou set adminstatus =:s ,  username =:u , password =:a , permission =:b where adminid = :d ";
		
		
		Integer success = session.createQuery(hql).setParameter("s", mb.getAdminstatus()).setParameter("u", mb.getUsername()).
				setParameter("a", mb.getPassword()).setParameter("b", mb.getPermission()).setParameter("d", mb.getAdminid()).executeUpdate();
		System.out.println(success);
		return success;
	}
	
	
//	R
	public List<AdminChitou> searchInDB(String hql) {
		Session session = sessionFactory.openSession();
		Query<AdminChitou> query = session.createQuery(hql , AdminChitou.class);
		return query.getResultList();
	}
	
	public List<AdminChitou> searchAll() {
		Session session = sessionFactory.openSession();
		String hqlstr="from AdminChitou ";
		Query<AdminChitou> query = session.createQuery(hqlstr,AdminChitou.class);
		return query.getResultList();
	}
	
	public AdminChitou searchOne(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr="from AdminChitou where username = :a";
		Query<AdminChitou> query = session.createQuery(hqlstr,AdminChitou.class);
		query.setParameter("a", username);
		AdminChitou resultBean = query.uniqueResult();
		return resultBean;
	}
	
	
//	D
	public boolean delete(int memberid) {
		Session session = sessionFactory.openSession();
		AdminChitou memberBean = session.get(AdminChitou.class, memberid);
		if(memberBean!=null) {
			session.delete(memberBean);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	
//	賬號密碼確認
	public boolean checkLogin(AdminChitou bean) {
		Session session = sessionFactory.openSession();
//		javabean的東西 而不是資料庫的東西
		String hqlstr="from AdminChitou where username = :user and password = :pwd";
		
		try {			
			Query<AdminChitou> query = session.createQuery(hqlstr,AdminChitou.class);
			query.setParameter("user", bean.getUsername());
			
			query.setParameter("pwd", bean.getPassword());
			
			
//		把hibernate的query物件在轉型成 bean的物件->去利用
			AdminChitou resultBean = query.uniqueResult();
			session.close();
			
			if(resultBean!=null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	

	
	

	
	

}
