package com.example.jpa.model;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */
public class UserDetails {
	User user;
	UserProfile userProfile;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "{user:{" + user + "}, userProfile:{" + userProfile + "}}";
	}

}
