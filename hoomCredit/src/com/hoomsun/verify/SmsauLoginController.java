package com.hoomsun.verify;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoomsun.Service.creditImpl.SmsauLoginServiceImpl;
import com.hoomsun.entity.User;
import com.hoomsun.restDemo.client.JsonReqClient;
import com.hoomsun.restDemo.client.XmlReqClient;

@Controller
@RequestMapping("/sslc")
public class SmsauLoginController {

	

	// 短信通知

	// demo短信

	// 短信验证码

	@ResponseBody
	@RequestMapping(value = "Verphone", method = RequestMethod.POST)
	public synchronized int Verphone(String phones, HttpServletRequest req) {
		String phone = phones;
		HttpSession session = req.getSession();

		System.out.println("------------" + phone);
		Random random = new Random();
		int n = random.nextInt(899999) + 100000;
		String nn = String.valueOf(n);
		session.setAttribute("" + phone + "", nn);
		System.out.println("" + phone + "");
		//
		String[] params = new String[2];
		params[0] = "11";
		params[1] = "xml";
		String method = params[0];
		boolean json = true;
		if (params[1].equals("xml")) {
			json = false;
		}
		if (method.equals("11")) { // 短信验证码
			// Account Sid
			String accountSid = "138bc91472ac5b5192195669d9246d71";
			// Auth Token
			String token = "b85406e6f8c9ba1a6dec6d34a66bb52e";
			// 应用列表ID
			String appId = "556782b77e4a40b7bcf663debb846842";
			// 短信模板ID
			String templateId = "25248";
			// 手机号码
			String to = phone;
			String para = n + "";
			System.out.println(to + "\t" + n);

			// String
			// para="：尊敬的客户，感谢您使用红上财富债权信息自助查询系统,您的验证码为"+n+"(红上财富验证码，5分钟内有效)";
			TemplateSMS(json, accountSid, token, appId, templateId, to, para);

		}
		return 0;
	}

	private static void TemplateSMS(boolean b, String accountSid,
			String authToken, String appId, String templateId, String to,
			String param) {

		String result = null;
		if (b) {
			result = new JsonReqClient().templateSMS(accountSid, authToken,
					appId, templateId, to, param);
		} else {
			result = new XmlReqClient().templateSMS(accountSid, authToken,
					appId, templateId, to, param);
		}
	}

	@ResponseBody
	@RequestMapping(value = "smscode", method = RequestMethod.POST)
	public synchronized int smscode(@RequestParam("phones") String phones,
			@RequestParam("ssid") String ssid, HttpServletRequest req) {

		String cod = (String) req.getSession().getAttribute("" + phones + "");
		/* String cods=(String) req.getSession().getAttribute("phone"); */
		System.out.println("++++验证码:" + "" + cod + "===" + ssid);
		/* System.out.println("++++验证码s:" +cods); */

		if (ssid != null && ssid.equals(cod)) {
			System.out.println(0);
			
			
			return 0;
		} else {
			System.out.println(1);
			return 1;
		}
	}

	@RequestMapping(value = "er", method = RequestMethod.GET)
	public String er() {

		return "error";

	}
}
