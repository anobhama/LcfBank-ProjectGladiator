package com.lcf.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.LoginCredentials;
import com.lcf.app.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	// calling login from DAO layer
	@Override
	public int login(long userId, String password) {
		int flag = loginDao.login(userId, password);
		return flag;
	}

	@Override
	public LoginCredentials getLoginCredentialsById(long id) {
		LoginCredentials loginObj = loginDao.getLoginCredentialsById(id);
		return loginObj;
	}

	@Override
	public long netBankingRegistration(LoginCredentials loginObj) {
		long flag = loginDao.netBankingRegistration(loginObj);
		return flag;
	}

	public boolean resetPassword(LoginCredentials newLoginCredentials) {
		// LoginDao login = new LoginDao();
		boolean success = loginDao.resetPassword(newLoginCredentials);
		return success;

	}

}
