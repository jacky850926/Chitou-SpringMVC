package tw.weber.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HotelBackService {
	
	@Autowired
	private HotelBackDao hotelDao;
	
	public List<Hotel> selectAll(){
		return hotelDao.selectAll();
	}
	
	public Hotel select(int hotelID){
		return hotelDao.select(hotelID);
	}
	
	public List<Hotel> selectByKey(String type,String keyword){
		return hotelDao.selectByKey(type, keyword);
	}
	
	public Hotel insert(Hotel hotel) {
		return hotelDao.insert(hotel);
	}
	
	public Hotel delete(int hotelID) {
		return hotelDao.delete(hotelID);
	}
	
	public Hotel update(Hotel hotel) {
		return hotelDao.update(hotel);
	}
}
