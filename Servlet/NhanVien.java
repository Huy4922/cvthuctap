package Servlets;

public class NhanVien {
	private String id;
	private String Username;
	private String gender;
	private String chucvu;
	
	public NhanVien() {
	}
	public NhanVien(String id, String Username, String Gender, String Chucvu){
		 this.id=id;
		 this.Username=Username;
		 this.gender=Gender;
		 this.chucvu=Chucvu;
	}
	public NhanVien(String Username, String Chucvu){
		 this.Username=Username;
		 this.chucvu=Chucvu;
	}
	public NhanVien(NhanVien nv){
		 this.Username=nv.Username;
		 this.gender=nv.gender;
		 this.chucvu=nv.chucvu;
	}
	public String getId() {
		return id;
	}
	 public String getUsername() {
		 return Username;
	 }
	 public String getGender() {
		 return gender;
	 }
	 public String getChucvu() {
		 return chucvu;
	 }
	 public void setId(String id) {
		 this.id = id;
	 }
	 public void setUsername(String Username) {
		 this.Username = Username;
	 }
	 public void setGender(String Gender) {
		 this.gender = Gender;
	 }
	 public void setChucvu(String Chucvu) {
		 this.chucvu = Chucvu;
	 }
}
