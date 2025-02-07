package com.food.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.food.model.MyErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails>LoginException(LoginException loginException,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(loginException.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<MyErrorDetails>BillException(BillException billException,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(billException.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails>CartException(CartException cartException,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(cartException.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails>CategoryException(CategoryException categoryException,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(categoryException.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<MyErrorDetails>ItemException(ItemException itemException,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(itemException.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails>OrderException(OrderException orderException,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(orderException.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<MyErrorDetails>RestaurantException(RestaurantException restaurantException,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(restaurantException.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails>NoHandlerFoundException(NoHandlerFoundException noHandlerFoundException,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(noHandlerFoundException.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails>MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(methodArgumentNotValidException.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyErrorDetails>IllegalArgumentException(IllegalArgumentException illegalArgumentException,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(illegalArgumentException.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<MyErrorDetails>CustomerNotFound(CustomerNotFound customerNotFound,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(customerNotFound.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails>Exception(Exception exception,WebRequest webRequest)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(exception.getMessage());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	

}

