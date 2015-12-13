package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.User;

public interface UserDAO {
	public User getUserByUsername(String username);

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(Integer id);

}
