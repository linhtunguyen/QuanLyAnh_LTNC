package code;

import model.*;
import java.util.List;

import javax.swing.plaf.metal.MetalButtonUI;

import org.hibernate.*;

public class SanPhamHelper {

	Session session = null;


	public List getProductTitles() {
		this.session = HibernateUtil.getSessionFactory().openSession();
		List<Albums> prodList = null;
		try {
			Query q = session.createQuery("from ALBUMS");
			prodList = (List<Albums>) q.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		} finally{
			session.close();
		}
		System.out.println(prodList);
		return prodList;
	}

	public static void main(String[] args) {
		SanPhamHelper pro = new SanPhamHelper();
		pro.getProductTitles();
	}

}