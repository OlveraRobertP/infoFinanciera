/**
 * 
 */
package com.robolverap.web.vm.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;

import com.robolverap.bo.security.FuncionBo;
import com.robolverap.bo.security.ModuloBo;
import com.robolverap.bo.security.PermisoBo;
import com.robolverap.bo.security.RolBo;
import com.robolverap.model.app.security.Funcion;
import com.robolverap.model.app.security.Modulo;
import com.robolverap.model.app.security.Rol;
import com.robolverap.utils.SystemValues;
import com.robolverap.web.jsf.JsfAppUtils;

/**
 * @author jrobolvp
 *
 */
@ManagedBean(name = "funcionRolVM")
public class FuncionRolVM {
	
	private String rolSelected;

	public String getRolSelected() {
		return rolSelected;
	}
	
	public void setRolSelected(String rolSelected) {
		this.rolSelected = rolSelected;
	}

	private TreeNode[] menusSelected ;

	public TreeNode[] getMenusSelected() {
		return menusSelected;
	}

	public void setMenusSelected(TreeNode[] menusSelected) {
		this.menusSelected = menusSelected;
	}

	private TreeNode menus = new CheckboxTreeNode();

	public TreeNode getMenus() {
		return menus;
	}

	public void setMenus(TreeNode menus) {
		this.menus = menus;
	}

	private List<Rol> rolesDisponibles;

	public List<Rol> getRolesDisponibles() {
		return rolesDisponibles;
	}

	@ManagedProperty("#{funcionBo}")
	private FuncionBo funcionBo;

	public void setFuncionBo(FuncionBo funcionBo) {
		this.funcionBo = funcionBo;
	}
	
	@ManagedProperty("#{moduloBo}")
	private ModuloBo moduloBo;
	
	public void setModuloBo(ModuloBo moduloBo) {
		this.moduloBo = moduloBo;
	}

	@ManagedProperty("#{rolBo}")
	private RolBo rolBo;

	public void setRolBo(RolBo rolBo) {
		this.rolBo = rolBo;
	}
	
	@ManagedProperty("#{permisoBo}")
	private PermisoBo permisoBo;
	
	public void setPermisoBo(PermisoBo permisoBo) {
		this.permisoBo = permisoBo;
	}
	
	@ManagedProperty("#{msg}")
	private ResourceBundle msgBundle;
	
	public void setMsgBundle(ResourceBundle msgBundle) {
		this.msgBundle = msgBundle;
	}

	

	@PostConstruct
	public void init() {
		this.rolesDisponibles = this.rolBo.findAll();
		this.menus = getMenusTree();
	}
	
	
	/**
	 * Busca una funcion en el tree principal
	 * @param func
	 * @return
	 */
	private TreeNode findMenuTree (Funcion func, TreeNode men) {
		if (men != null) {
			for(TreeNode node : men.getChildren()) {
				for(TreeNode nodeFunc:node.getChildren()) {
					if(nodeFunc.getData() instanceof Funcion) {
						Funcion f = (Funcion) nodeFunc.getData();
						if(f.getClave().equals(func.getClave())) {
							return nodeFunc;
						}
					}
				}
				
			}
		}
		return null;
	}
	

	public void cargaPrivilegios() {
		this.menus = getMenusTree();
		if (this.rolSelected != null && this.rolSelected.trim().length()>0) {
			this.menusSelected = new CheckboxTreeNode[200];
			List<Funcion> funcs = this.funcionBo.findByCveRol(this.rolSelected);
			for(int i = 0 ; i< funcs.size(); i++) {
				TreeNode nod = findMenuTree(funcs.get(i),this.menus);
				if(nod!=null) {
					nod.setSelected(true);
				}
			}
		}
	}

	public void asignarPrivilegios() {
		
		List<Funcion> priv = new ArrayList<Funcion>();

		for (TreeNode menuSave : this.menusSelected) {
			if(menuSave.getData() instanceof Funcion) {
				Funcion fun = (Funcion) menuSave.getData();
				priv.add(fun);
			}
		}

		this.permisoBo.asignarPrivilegios(this.rolSelected,priv);
		cargaPrivilegios();
		
		JsfAppUtils.addResultMessage(FacesMessage.SEVERITY_INFO, msgBundle.getString("funrol.asigna.success"),msgBundle.getString("funrol.asigna.success.detail"));
		
	}



	/**
	 * Construye el arbol de menus
	 * 
	 * @return
	 */
	public TreeNode getMenusTree() {
		List<Modulo> menus = this.moduloBo.findAll();
		TreeNode root = new CheckboxTreeNode(new Modulo(""), null);
		for (Modulo m : menus) {
			// colocamos el modulo en el arbol
			TreeNode modNode = new CheckboxTreeNode(m, root);
			List<Funcion> funciones = m.getFunciones().stream().collect(Collectors.toList());
			for(Funcion fun : funciones) {
				TreeNode funcNode = new CheckboxTreeNode(fun,modNode);
			}
		}
		return root;
	}

}
