package project2;

import java.util.List;

public interface PhoneBookDAO {
	
	public List<PhoneBookVO> getList();
	public PhoneBookVO get(String name);
	public boolean insert(PhoneBookVO phonebookvo);
	public boolean delete(Long id);
	public boolean update(PhoneBookVO phonebookvo);

}
