package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After (finally) method: " + method);
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theException")
	public void afterThrowingFindAccountsAdvice(
					JoinPoint joinPoint, Throwable theException) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing method: " + method);
		
		// log the exception
		System.out.println("\n=====>>> The exception is: " + theException);
	}
	
	@AfterReturning(
			pointcut= "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(
					JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning method: " + method);
		
		// print out the results of the method call
		System.out.println("\n=====>>> result is: " + result);
		
		// let's post-process the data ... let's modify it
		
		
		// convert the account names to uppercase
		
		
		// convert the accounts names to uppercase
		convertAccountsNamesToUpperCases(result);
		
		System.out.println("\n=====>>> result is: " + result);
		
	}
	
	private void convertAccountsNamesToUpperCases(List<Account> result) {
		
		// loop through accounts 
		for(Account tempAccount : result) {
			
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update name on the account
			tempAccount.setName(theUpperName);
			
		}
		
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>>> Executing @Before advice on method");
		
		// display the method signatura
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display the method arguments
		
		
		// get arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop throght arguments
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount  = (Account) tempArg;
				
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
			
		
	}
	
}
