package com.food.serviceImpl;

import java.time.LocalDateTime;
import java.util.Random;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.model.CurrentUserSession;
import com.food.model.Customer;
import com.food.model.Login;
import com.food.repository.CurrentUserSessionRepo;
import com.food.repository.CustomerRepo;
import com.food.service.LoginService;

import net.bytebuddy.utility.RandomString;



@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;

	@Override
	public String loginAccount(Login dto) throws LoginException
	{
		Customer customer = customerRepo.findByEmail(dto.getUserName());
		if(customer!=null)
		{
			if(customer.getPassword().equals(dto.getPassword()))
			{
				CurrentUserSession currentUserSession = currentUserSessionRepo.findByEmail(dto.getUserName());
				
				if(currentUserSession!=null)
				{
					throw new LoginException("User Already Login !");
				}
				else 
				{
					CurrentUserSession currentUserSession2 = new CurrentUserSession();
					currentUserSession2.setEmail(dto.getUserName());
					currentUserSession2.setLoginDateTime(LocalDateTime.now());	
					
					String key = RandomString.make(6);
					currentUserSession.setPrivateKey(key);
					
					currentUserSessionRepo.save(currentUserSession);
					return"Login Sucessful";
				}
			}
			else
			{
				throw new LoginException("Please Enter Valid PAssword !");
			}
		}
		else
		{
			throw new LoginException("Please Enter Valid username !");
		}
	}

	@Override
	public String logoutAccount(String key) throws LoginException
	{
		CurrentUserSession currentUserSession = currentUserSessionRepo.findByPrivateKey(key);
		if(currentUserSession!=null)
		{
			currentUserSessionRepo.delete(currentUserSession);
			return"logout";
		}
		else
		{
			throw new LoginException("This User Not Login");
		}
	}

} 

