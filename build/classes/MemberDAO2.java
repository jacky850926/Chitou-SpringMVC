
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import membershipbean.MemberBean;


public class MemberDAO2 {
private Connection conn;
	
	public MemberDAO2(Connection conn) {
		this.conn = conn;
	}
	QueryRunner queryRunner = new QueryRunner();
	public List<MemberBean> searchMemberAll() {
		String sql="select * from membership";
		
		try {
			List<MemberBean> resultList = queryRunner.query(conn, sql, new BeanListHandler<MemberBean>(MemberBean.class));
			return resultList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
//			queryRunner.update(conn, sql, null)

		
//		try {
//			String sqlString = "select * from journey";
//			Statement stmt = conn.createStatement();
//			System.out.println(sqlString);
//			ResultSet rs = stmt.executeQuery(sqlString);
//			stmt.close();
//			String[] result = new String[result.getMetaData().getColumnCount()];
//			while(rs.next()) {
//				string[]
//			}
//		}catch (Exception e) {
//			String[] result = {"查詢資料錯誤"};
//			return result;
//		}
		
//		BeanListHandler<T>
	}
	
	public MemberBean searchMemberOne() {
		String sql="select top 1 * from membership";
		
		try {
			MemberBean result = queryRunner.query(conn, sql, new BeanHandler<MemberBean>(MemberBean.class));
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insert(MemberBean bean) {
		String sql = "insert into membership(statusID,account,password,name,nickName,phone,"
				+ "nationality,birth,gender,address,email,createTime,modifyTime) values(?,?,?,?,?,?,?,getDate(),?,?,?,"
				+ "getDate(),getDate())";
		
		try {
			int result = queryRunner.update(conn,sql, bean.getStatusid(),bean.getUserid(), bean.getPassword(),
					bean.getName(),bean.getNickname(),bean.getPhone(),bean.getNationality(),bean.getBirth(),
					bean.getGender(),bean.getAddress(),bean.getEmail(),bean.getCreatetime(),bean.getModifytime());
			return result;
			// update one row
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int delete(int memberID) {
		String sql="delete from membership where memberID = ?";
		
		try {
			int result = queryRunner.update(conn, sql, (int)memberID );
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
//	
//	public int update(MemberBean bean, String param,int jid) {
//		String sqljName= "update journey set jName = ? where jID = ?";
//		String sqljStartDate= "update journey set jStartDate = ? where jID = ?";
//		String sqljEndDate= "update journey set jEndDate = ? where jID = ?";
//		
//		try {
//			int result = queryRunner.update(conn, sqljName,bean.getjName(),(int)jid );
//			int result2 = queryRunner.update(conn, sqljStartDate,bean.getjStartDate(),(int)jid );
//			int result3 = queryRunner.update(conn, sqljEndDate,bean.getjEndDate(),(int)jid );
//			return result+result2+result3;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return -1;
//		}
//	}

}
