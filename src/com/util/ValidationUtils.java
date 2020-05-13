package com.util;

public class ValidationUtils {
	public static boolean isEmpty(String fname)
	{
		boolean isEmpty=false;
		if(fname==""||fname.trim().length()<=0)
		{
			isEmpty=true;
		}
		return isEmpty;
		
	}
	public static boolean isEmpty1(String lname)
	{
		boolean isEmpty1=false;
		if(lname==""||lname.trim().length()<=0)
		{
			isEmpty1=true;
		}
		return isEmpty1;
		
	}
}
