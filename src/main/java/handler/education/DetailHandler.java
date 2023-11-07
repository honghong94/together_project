package handler.education;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import handler.Handler;
import education.Education;
import education.EducationDao;
import education.EducationService;

public class DetailHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		String view = "/education/detail.jsp";
		String urlstr = "http://openapi.seoul.go.kr:8088/API_KEY/xml/TEducProg/1/100/";
		try {
			URL url = new URL(urlstr);
			URLConnection conn = url.openConnection();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(conn.getInputStream());
			Element root = doc.getDocumentElement();
			NodeList locs = root.getElementsByTagName("row");

			int num = Integer.parseInt(request.getParameter("num"));
			Element data = (Element) locs.item(num-1);
			String title = data.getElementsByTagName("TITL_NM").item(0).getTextContent();
			String content = data.getElementsByTagName("CONT").item(0).getTextContent();
			String lang = data.getElementsByTagName("LANG_GB").item(0).getTextContent();
			String endyn = data.getElementsByTagName("APP_END_YN").item(0).getTextContent();
			String qual = data.getElementsByTagName("APP_QUAL").item(0).getTextContent();
			String temp = data.getElementsByTagName("REG_DT").item(0).getTextContent();
			
			String year = temp.substring(0,4);
			String month = temp.substring(4,6);
			String day = temp.substring(6,8);
			String date = year+"-"+month+"-"+day;

			request.setAttribute("num", num);
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("lang", lang);
			request.setAttribute("endyn", endyn);
			request.setAttribute("qual", qual);
			request.setAttribute("date", date);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("view", "/education/list.jsp");
		return view;
	}
}
