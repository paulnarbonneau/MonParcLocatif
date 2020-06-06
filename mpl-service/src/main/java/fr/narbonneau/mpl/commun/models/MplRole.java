package fr.narbonneau.mpl.security.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class MplRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long idRole;
	
	@Column
	private String role;
	
	@ManyToOne
	@JoinColumn(name="idRole")
	private MplRole roleParent;
	
	public MplRole() {}

	/**
	 * @return the idRole
	 */
	public long getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole the idRole to set
	 */
	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the roleParent
	 */
	public MplRole getRoleParent() {
		return roleParent;
	}

	/**
	 * @param roleParent the roleParent to set
	 */
	public void setRoleParent(MplRole roleParent) {
		this.roleParent = roleParent;
	}

}
