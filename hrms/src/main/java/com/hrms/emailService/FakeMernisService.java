package com.hrms.emailService;


public class FakeMernisService {

	public boolean ValidateByPersonalInfo(long nationalIdentity,String firstName, String lastName, int dateOfBirth)
	{
		System.out.println(firstName + " " + lastName + " kişi geçerlidir." );
		return true;
	}


}