package cart.com.entity;
// Generated 18-jul-2016 22:56:46 by Hibernate Tools 4.3.1.Final

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

	private int roleId;
	private String name;

	public Role() {
	}

	public Role(int roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
