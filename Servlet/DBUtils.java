package Servlets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DBUtils {
	 public static UserAccount findUser(Connection conn, //
			 String userName, String password) throws SQLException {
		 String sql = "Select a.Username, a.Password, a.Gender from user_account a " //
				 + " where a.Username = ? and a.Password= ?";
		 PreparedStatement pstm = conn.prepareStatement(sql);
		 pstm.setString(1, userName);
		 pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}
	public static UserAccount findUser(Connection conn, String userName) throws SQLException {
		String sql = "Select a.Username, a.Password, a.Gender from user_account a "//
		+ " where a.Username = ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
	}
		return null;
	}
	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.id, a.name, a.type, a.price, a.image from Product a ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String type = rs.getString("type");
			int price = rs.getInt("price");
			String image = rs.getString("image");
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setType(type);
			product.setPrice(price);
			product.setImage(image);
			list.add(product);
		}
	return list;
	}
	
	public static List<Product> Search(Connection conn,String txtSearch) throws SQLException {
		List<Product> list = new ArrayList<Product>();
		String sql = "Select * from product where Name like ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "%"+txtSearch+"%");
		ResultSet rs = pstm.executeQuery();
		
		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String type = rs.getString("type");
			int price = rs.getInt("price");
			String image = rs.getString("image");
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setType(type);
			product.setPrice(price);
			product.setImage(image);
			list.add(product);
		}
	return list;
	}
	public static List<NhanVien> SearchNV(Connection conn,String txtSearch) throws SQLException {
		List<NhanVien> list = new ArrayList<NhanVien>();
		String sql = "Select * from nhanvien_account where username like ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "%"+txtSearch+"%");
		ResultSet rs = pstm.executeQuery();
		
		while (rs.next()) {
			String id = rs.getString("id");
			String Username = rs.getString("Username");
			String Gender = rs.getString("gender");
			String Chucvu = rs.getString("chucvu");
			NhanVien nhanvien = new NhanVien();
			nhanvien.setId(id);
			nhanvien.setUsername(Username);
			nhanvien.setGender(Gender);
			nhanvien.setChucvu(Chucvu);			
			list.add(nhanvien);
		}
	return list;
	}
	public static Product findProduct(Connection conn, String id) throws SQLException {
		String sql = "Select a.id, a.name, a.type, a.price, a.image from Product a where a.id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String name = rs.getString("name");
			String type = rs.getString("type");
			int price = rs.getInt("price");
			String image = rs.getString("image");
			Product product = new Product(id, name, type, price, image);
			return product;
		}
		return null;
	}
	
	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set name =?, type =?, price=?, image=? where id=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getName());
		pstm.setString(2, product.getType());
		pstm.setFloat(3, product.getPrice());
		pstm.setString(4, product.getImage());
		pstm.setString(5, product.getId());
        pstm.executeUpdate();
	}
	
	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product(id, name, type, price, image) values (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getId());
		pstm.setString(2, product.getName());
		pstm.setString(3, product.getType());
		pstm.setFloat(4, product.getPrice());
		pstm.setString(5, product.getImage());
		pstm.executeUpdate();
	}
	
	public static void deleteProduct(Connection conn, String id) throws SQLException {
		String sql = "Delete From Product where id= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.executeUpdate();
	}
	
	 public static void insertUserAccount(Connection conn, UserAccount user) throws SQLException {
		String sql = "Insert into user_account(Username, Gender, Password) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getUserName());
		pstm.setString(2, user.getGender());
		pstm.setString(3, user.getPassword());
		pstm.executeUpdate();
	 }
	 public static List<NhanVien> queryNhanVien(Connection conn) throws SQLException {
			String sql = "Select a.id, a.username, a.gender, a.chucvu from nhanvien_account a ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			List<NhanVien> list = new ArrayList<NhanVien>();
			while (rs.next()) {
				String id = rs.getString("id");
				String username = rs.getString("username");
				String gender = rs.getString("gender");
				String chucvu = rs.getString("chucvu");
				NhanVien nhanvien = new NhanVien();
				nhanvien.setId(id);
				nhanvien.setUsername(username);
				nhanvien.setGender(gender);
				nhanvien.setChucvu(chucvu);
				list.add(nhanvien);
			}
		return list;
		}
	 public static NhanVien findNhanVien(Connection conn, String id) throws SQLException {
			String sql = "Select a.id, a.username, a.gender, a.chucvu from nhanvien_account a where a.Id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				String gender = rs.getString("gender");
				String chucvu = rs.getString("chucvu");
				NhanVien nhanvien = new NhanVien(id, username, gender, chucvu);
				return nhanvien;
			}
		return null;
		}
	 public static void updateNhanVien(Connection conn, NhanVien nhanvien) throws SQLException {
			String sql = "Update Nhanvien_account set username =?, gender =?, chucvu=? where id=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, nhanvien.getUsername());
			pstm.setString(2, nhanvien.getGender());
			pstm.setString(3, nhanvien.getChucvu());
			pstm.setString(4, nhanvien.getId());
			pstm.executeUpdate();
		}
	 public static void insertNhanVien(Connection conn, NhanVien nhanvien) throws SQLException {
			String sql = "Insert into nhanvien_account (id, username, gender, chucvu) values (?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, nhanvien.getId());
			pstm.setString(2, nhanvien.getUsername());
			pstm.setString(3, nhanvien.getGender());
			pstm.setString(4, nhanvien.getChucvu());
			pstm.executeUpdate();
		}
	 public static void deleteNhanVien(Connection conn, String id) throws SQLException {
			String sql = "Delete From nhanvien_account where id= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.executeUpdate();
		}
	 
	
}