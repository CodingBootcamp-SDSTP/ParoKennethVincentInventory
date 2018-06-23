package src;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class AccountListServlet extends HttpServlet
{
	AccountCollection ac;

	public void init() throws ServletException {
		AccountsListDatabase ald = new AccountsListDatabase();
		ac = ald.getAccountCollection();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
		rs.include(request, response);
		ArrayList<Account> account = ac.getAllAccounts();
		StringBuilder sb = new StringBuilder("<div class='table-row'>");
		for(Account a : account) {
			sb.append("<div class='table-cell'>" + a.getId() + "</div>");
			sb.append("<div class='table-cell'>" + a.getUsername() + "</div>");
			sb.append("<div class='table-cell'>" + a.getEmail() + "</div>");
			sb.append("<div class='table-cell'>" + a.getRole() + "</div>");
			sb.append("<div class='table-cell'>" + a.getStatus() + "</div>");
			sb.append("<div class='table-cell'>" + a.getDate() + "</div>");
			sb.append("<div class='table-cell' id='box1'>");
			sb.append("<a class='button' href='#popup2'>");
			sb.append("<i class='fa fa-user-times style='font-size:24px'></i>");
			sb.append("</a>");
			sb.append("<a class='button' id='edit' href='#'>");
			sb.append("<i class='material-icons'>edit</i>");
			sb.append("</a>");
		}
		sb.append("</div>");
		out.println(sb.toString());
	}

	public void destroy(){
		ac = null;
	}
}
