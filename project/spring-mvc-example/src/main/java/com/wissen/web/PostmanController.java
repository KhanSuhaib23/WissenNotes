package com.wissen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wissen.model.Todo;

@Controller
public class PostmanController {

	@RequestMapping(value = "/product.htm", method = RequestMethod.GET) 
	public @ResponseBody String getAllProduct() {
		return "Method: GET -> PostmanController::getAllProduct()";
	}
	
	@RequestMapping(value = "/product.htm", method = RequestMethod.GET, params = {"filter"}) 
	public @ResponseBody String getProductWithOtherFilter() {
		return "Method: GET -> PostmanController::getProductWithOtherFilter()";
	}
	
	@RequestMapping(value = "/product.htm", method = RequestMethod.GET, params = {"filter=all"}) 
	public @ResponseBody String getProductWithAllFilter() {
		return "Method: GET -> PostmanController::getProductWithAllFilter()";
	}
	
	@RequestMapping(value = "/product.htm", method = RequestMethod.GET, params = {"filter=all", "id"}) 
	public @ResponseBody String getProductWithAllFilterAndId() {
		return "Method: GET -> PostmanController::getProductWithAllFilterAndId()";
	}
	
	@RequestMapping(value = "/product.htm", method = RequestMethod.GET, headers = {"Accept-Language"}) 
	public @ResponseBody String getAllProductInLanguage() {
		return "Method: GET -> PostmanController::getAllProductInLanguage()";
	}
	
	@RequestMapping(value = "/product.htm", method = RequestMethod.GET, headers = {"Accept-Language=ar"}) 
	public @ResponseBody String getAllProductInArabic() {
		return "Method: GET -> PostmanController::getAllProductInArabic()";
	}
	
//	@RequestMapping(value = "/product.htm", method = RequestMethod.POST) 
//	public @ResponseBody String getAllProductInTodo(@ModelAttribute Todo todo) {
//		System.out.println(todo.toString());
//		return todo.toString();
//	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST, consumes= {"application/xml"}, produces = {"application/xml"}) 
	public @ResponseBody Todo getAllProductInTodoByXml(@RequestBody Todo todo) {
		System.out.println(todo.toString());
		return todo;
	}
	
}
