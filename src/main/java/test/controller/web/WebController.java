package test.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.model.CategoryModel;
import test.model.NewModel;
import test.service.ICategoryService;
import test.service.INewService;

/**
 * Servlet implementation class controller
 */
@WebServlet(urlPatterns = {"/web-trang-chu"})
public class WebController extends HttpServlet {
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Long categoryId = 1L; 
		
		  //save method test
			/*
			 * NewModel newModel = new NewModel();
			 * newModel.setContent("Content 5"); newModel.setTitle("Bài viết 5");
			 * newModel.setCategoryId(1L); newService.save(newModel);
			 */
		  
		  //find method test
		  List<NewModel> newList = newService.findByCategoryId(categoryId);
		  for(NewModel item : newList) { System.out.println(item.toString()); }
		 
		
//		request.setAttribute("news", newList);
		request.setAttribute("categories", categoryService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
