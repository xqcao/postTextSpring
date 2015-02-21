package com.postxml.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamcrest.core.Is;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PostXmlController {

	private static final Logger logger = LoggerFactory
			.getLogger(PostXmlController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/xml", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "homePostXml";
	}

	@RequestMapping(value = "/doxml", method = RequestMethod.POST)
	public void doXmlAndReturnXml(Model model,@RequestParam String name,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/xml; charset=utf-8");//ע������xml����,
		//text/html��firefox���Խ���     ��ie����
		
		PrintWriter out = response.getWriter();
		

		StringBuilder sb = new StringBuilder();
		
		sb.append("<message>");
		if("adam".equals(name)){
			sb.append("user[" + name + "]  is login").append("</message>");
		}else{
			
			sb.append("please regist an account frist, user[" + name + "]  is not exist,").append("</message>");
		}
		//System.out.println(name+"---------------------------------------");
		
		out.println(sb.toString());

	}
}
