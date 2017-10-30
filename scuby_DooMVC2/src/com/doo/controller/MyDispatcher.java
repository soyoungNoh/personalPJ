package com.doo.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyDispatcher extends HttpServlet {

	private Map<String,Controller> conMap = new HashMap<String,Controller>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		//uriMap.txt 읽어오기
		//무조건 물리경로를 적어줘야함
		String path = config.getInitParameter("txtPath");
		System.out.println("path : "+path);
		
		//서블릿 컨텍스트 값 불러오기
		String context = config.getServletContext().getInitParameter("param_text");
		System.out.println("context : "+context);

		
		try {
			Reader rd = new FileReader(path);
			BufferedReader br = new BufferedReader(rd);
			String readMap;
			while((readMap=br.readLine())!=null){
				System.out.println("readMap : "+readMap);
				String[] readMaps =readMap.split(" ");

				String uri = readMaps[0];
				//Controller conObject = readMaps[1];
				//클래스이름만으로 객체를 만들어줌.
				Controller conObject = (Controller)Class.forName(readMaps[1]).newInstance();
				conMap.put(uri, conObject);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	protected void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		System.out.println("requestURI : "+requestURI);

		Controller controller = conMap.get(requestURI);


		String toMove = controller.execute(request, response);

		String[] toMoves = toMove.split(":");

		if(toMoves[0].equals("redirect")){
			response.sendRedirect(toMoves[1]);

		}else{
			request.getRequestDispatcher(toMove).forward(request, response);
		}


	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request,response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request,response);
	}

}
