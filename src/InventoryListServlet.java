package src;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class InventoryListServlet extends HttpServlet
{
	InventoryCollection ic;

	public void init() throws ServletException {
		AccountsListDatabase ald = new AccountsListDatabase();
		ic = ald.getInventoryCollection();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ArrayList<Inventory> inventory = ic.getAllInventory();
		StringBuilder sb = new StringBuilder("<inventory>");
		for(Inventory i : inventory) {
			sb.append("<houseandlot><listprice>");
			sb.append(i.getListPrice());
			sb.append("</listprice>");
			sb.append("<saleprice>");
			sb.append(i.getSaleprice());
			sb.append("</saleprice>");
			sb.append("<housetype>");
			sb.append(i.getHouseType());
			sb.append("</housetype>");
			sb.append("<lotarea>");
			sb.append(i.getLotArea());
			sb.append("</lotarea>");
			sb.append("<bedroom>");
			sb.append(i.getBedroom());
			sb.append("</bedroom>");
			sb.append("<toilet>");
			sb.append(i.getToilet());
			sb.append("</toilet>");
			sb.append("<carport>");
			sb.append(i.getCarport());
			sb.append("</carport>");
			sb.append("<balcony>");
			sb.append(i.getBalcony());
			sb.append("</balcony>");
			sb.append("<available>");
			sb.append(i.getAvailable());
			sb.append("</available></houseandlot>");
		}
		sb.append("</inventory>");
		out.println(sb.toString());
	}

	public void destroy(){
		ic = null;
	}
}
