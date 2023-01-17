package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmploymentExamDAO;
import dto.Account;
import dto.EmploymentExam;

/**
 * Servlet implementation class ListCompanyServlet
 */
@WebServlet("/ListCompanyServlet")
public class ListCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//処理の始めにログイン状態のチェックを行う。
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("user");

		if(account == null){
			//セッションの中身がnullであれば不正アクセスと判断し
			//ログイン画面へ戻る
			String view = "./";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		
		int accountId = account.getId();
		List<EmploymentExam> list = EmploymentExamDAO.selectAllExamByUser(accountId);
		
		request.setAttribute("list", list);
		
		// 正常な画面を表示
		String view = "WEB-INF/view/sample-list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
