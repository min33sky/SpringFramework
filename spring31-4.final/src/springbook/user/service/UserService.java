package springbook.user.service;

import java.util.List;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserService {
	
	UserDao userDao;
	UserLevelUpgradePolicy userLevelPolicy;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

	public void setUserLevelPolicy(UserLevelUpgradePolicy userLevelPolicy) {
		this.userLevelPolicy = userLevelPolicy;
	}

	public void upgradeLevels(){
		List<User> users = userDao.getAll();
		for(User user : users){
			if(userLevelPolicy.canUpgradeLevel(user)){
				userLevelPolicy.upgradeLevel(user);
			}
		}
	}

	public void add(User user) {
		if(user.getLevel() == null){
			user.setLevel(Level.BASIC);
		}
		userDao.add(user);
	}
}
