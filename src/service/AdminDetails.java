package service;
import java.util.ArrayList;
import dao.AdminDao;
import model.AdminModel;

public class AdminDetails {
        AdminDao  adminDao = new AdminDao();
        ArrayList<AdminModel> adminlist = new ArrayList<>();
	public void AddAdminModel(AdminModel admin) throws ClassNotFoundException {
		adminlist.add(admin);
		adminDao.storeAdminRecord(adminlist);;
	}

	
}
