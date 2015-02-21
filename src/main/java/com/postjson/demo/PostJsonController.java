package com.postjson.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PostJsonController {

	private static final Logger logger = LoggerFactory
			.getLogger(PostJsonController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "homePostJson";
	}

	@RequestMapping(value = "/dojson", method = RequestMethod.POST)
	public void doXmlAndReturnXml(Model model,@RequestParam String name,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("age", new Integer(28));
		obj.put("sex", "famale");
			  
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		
		if("adam".equals(name)){
			obj.put("msg", "adam login");
		}else{
			obj.put("msg","please regist an account frist");
		}
		System.out.println(name+"---------------------------------------");
		System.out.println(obj.toString());
		out.println(obj.toString());

	}
}
