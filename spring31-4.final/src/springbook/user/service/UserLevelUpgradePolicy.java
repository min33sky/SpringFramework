package springbook.user.service;

import springbook.user.domain.User;

public interface UserLevelUpgradePolicy {
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECOMMEND_FOR_GOLD = 30;
	
	public abstract boolean canUpgradeLevel(User user);
	public abstract void upgradeLevel(User user);
}
