package test.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import test.model.NewModel;
import test.service.INewService;
import test.utils.HttpUtil;

/**
 * Servlet implementation class NewAPI
 */
@WebServlet("/api-admin-new")
public class NewAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewService newService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAPI() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		NewModel newModel =  HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newModel = newService.save(newModel);

		mapper.writeValue(response.getOutputStream(), newModel);
	}
	
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		NewModel updateNew =  HttpUtil.of(request.getReader()).toModel(NewModel.class);
		updateNew = newService.update(updateNew);

		mapper.writeValue(response.getOutputStream(), updateNew);	
	}

	
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		NewModel newModel =  HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newService.delete(newModel.getIds());

		mapper.writeValue(response.getOutputStream(), "{}");	
	}
	
}
