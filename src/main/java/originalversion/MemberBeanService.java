package originalversion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;



//@Service
//@Transactional
public class MemberBeanService {
	@Autowired
	private MemberBeanDAO mDao;
	
	public MemberBean insert(MemberBean bean) {
		return mDao.insert(bean);
	}
	public int update(MemberBean bean) {
		return mDao.update(bean);
	}
	

	public boolean delete(String memberid) {
		return mDao.delete(memberid);
	}
	
	public boolean checkLogin(MemberBean bean) {
		return mDao.checkLogin(bean);
	}
	
	public List<MemberBean> searchAll(){
		return mDao.searchAll();
	}
	
	public List<MemberBean> searchInDB(String hql){
		return mDao.searchInDB(hql);
	}
	
	public String mergeHql(String dbcolumn, String value) {
		String hql="from MemberBean where " + dbcolumn + " like '%" + value + "%' or " 
		+ dbcolumn + " like '" + value + "%' or "  
		+ dbcolumn + " like '%" + value + "'";
		return hql;
	}

}
