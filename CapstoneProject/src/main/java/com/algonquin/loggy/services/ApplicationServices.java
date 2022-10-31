package com.algonquin.loggy.services;

import java.util.Map;
import java.util.UUID;

import com.algonquin.loggy.beans.User;

public interface ApplicationServices {
	
//------Sign Up/In/Out
	public Map<UUID, User> RegisterUsers();
	
//  registration and email verification 
    public void registerUser(User user);    
    public void verification(User user);
    
//	Authentication  and  password recovery
    public User readUserInfo(String id);    
    public void signIn(User user);    
    public void PasswordRecovery(User user); 
    
//	sign out    
    public void signOut(User user);      
    
    
//-------CURD operation on user profile
    public void CreatProfile(User user);    
    public void UpdateProfile(User user);
    public void deleteProfile(String id);
    public void createOrUpdateProfile(User user);    
    
    
//-------Search books
    public void searchBook(String id);
	
}
