package tw.jacky.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MemberService {


		@Autowired
		private MemberBasicInfoDAO mDao;
		
		@Autowired
		private AdminDAO adminDao;
		
		public MemberBasicInfo insert(MemberBasicInfo bean) {
			return mDao.insert(bean);
		}
		public int update(MemberBasicInfo bean) {
			System.out.println("enter to service");
			return mDao.update(bean);
		}
		

		public boolean delete(Integer memberid) {
			return mDao.delete(memberid);
		}
		
		public boolean memberCheckLogin(MemberBasicInfo bean) {
			return mDao.checkLogin(bean);
		}
		
		public List<MemberBasicInfo> searchMemberAll(){
			return mDao.searchAll();
		}
		
		public List<MemberBasicInfo> searchInDB(String hql){
			return mDao.searchInDB(hql);
		}
		
		public String mergeHql(String dbcolumn, String value) {
			String hql="from MemberBasicInfo where " + dbcolumn + " like '%" + value + "%' or " 
			+ dbcolumn + " like '" + value + "%' or "  
			+ dbcolumn + " like '%" + value + "'";
			return hql;
		}
		
//		admin 相關
		
		public boolean adminCheckLogin(AdminChitou bean) {
			
			return adminDao.checkLogin(bean);
		}
		
		public Integer adminCheckStatus(AdminChitou bean) {
			
			if(bean == null) {
				return 0;
			};
			return bean.getAdminstatus();
		}
		
		public AdminChitou adminSearchOne(String username) {
			return adminDao.searchOne(username);
		}
		
		public List<AdminChitou> searchAdminAll(){
			return adminDao.searchAll();
		}
		
		public AdminChitou insertAdmin(AdminChitou bean) {
			return adminDao.insert(bean);
		}
		
		
		public boolean deleteAdmin(Integer memberid) {
			return adminDao.delete(memberid);
		}
		
		public int updateAdmin(AdminChitou bean) {
			System.out.println("enter to service");
			return adminDao.update(bean);
		}
		
	
}
