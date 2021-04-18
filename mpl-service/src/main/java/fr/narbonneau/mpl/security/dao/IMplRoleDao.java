/**
 * 
 */
package fr.narbonneau.mpl.security.dao;

import fr.narbonneau.mpl.security.models.MplRole;

/**
 * @author narbonneau
 *
 */
public interface IMplRoleDao {
	
	MplRole findByName(String name);

}
