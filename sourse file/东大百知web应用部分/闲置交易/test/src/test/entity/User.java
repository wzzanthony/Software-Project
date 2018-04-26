package test.entity;

public class User extends IdEntity {
	private String name;
	private String password;
	private String email;

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", email="
				+ email + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
