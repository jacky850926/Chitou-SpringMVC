package originalversion;

import javax.transaction.Transactional;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


//@Repository
//@Transactional
public class MemberBeanDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	C
	public MemberBean insert(MemberBean bean) {
		Session session = sessionFactory.openSession();
		if(bean!=null) {
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
	
	public int update(MemberBean mb) {
		
		Session session = sessionFactory.openSession();
		String hql="update MemberBean set password = :a , name = :b, nickname =:c, phone=:d, nationality=:e, birth=:f, gender=:g, address=:h, email=:i where memberid = :j ";
		
		
		int success = session.createQuery(hql).setParameter("a", mb.getPassword())
		.setParameter("b", mb.getName()).setParameter("c", mb.getNickname()).setParameter("d", mb.getPhone()).setParameter("e", mb.getNationality()).setParameter("f", mb.getBirth())
		.setParameter("g",(mb.getGender())).setParameter("h", mb.getAddress()).setParameter("i", mb.getEmail()).setParameter("j", mb.getMemberid()).executeUpdate();
		System.out.println(success);
		return success;
	}
	
	
//	R
	public List<MemberBean> searchInDB(String hql) {
		Session session = sessionFactory.openSession();
		Query<MemberBean> query = session.createQuery(hql , MemberBean.class);
		return query.getResultList();
	}
	
	public List<MemberBean> searchAll() {
		Session session = sessionFactory.openSession();
		String hqlstr="from MemberBean ";
		Query<MemberBean> query = session.createQuery(hqlstr,MemberBean.class);
		return query.getResultList();
	}
	
	
//	D
	public boolean delete(String memberid) {
		Session session = sessionFactory.openSession();
		MemberBean memberBean = session.get(MemberBean.class, memberid);
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
	public boolean checkLogin(MemberBean bean) {
		Session session = sessionFactory.openSession();
//		javabean的東西 而不是資料庫的東西
		String hqlstr="from MemberBean where userid = :user and password = :pwd";
		
		Query<MemberBean> query = session.createQuery(hqlstr,MemberBean.class);
		
		query.setParameter("user", bean.getUserid());
		
		query.setParameter("pwd", bean.getPassword());
		
		
//		把hibernate的query物件在轉型成 bean的物件->去利用
		MemberBean resultBean = query.uniqueResult();
		session.close();
		
		if(resultBean!=null) {
			return true;
		}
		return false;
	}
}
