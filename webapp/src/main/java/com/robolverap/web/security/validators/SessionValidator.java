package com.robolverap.web.security.validators;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.robolverap.bo.SecurityBo;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.utils.SystemValues;

/**
 * Servlet Filter implementation class SessionValidator
 */
@Component
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
									, urlPatterns = { "/*" })
public class SessionValidator implements Filter {
	
	@Autowired
	@Qualifier( value = "securityBo")
	private SecurityBo securityBo;

    /**
     * Default constructor. 
     */
    public SessionValidator() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = ((HttpServletRequest)request);
		Usuario usr = (Usuario)req.getSession().getAttribute(SystemValues.USER_IN_SESSION.toString());
		String excluidos = "/frameset*|/run*|/login/reset.xhtml|/login/inicio.xhtml|/login/login.xhtml|/login/unautorized.xhtml|/*.ico|/images/*|/javax.faces.resource/*";
		String menu = req.getServletPath();
		
		
		if(menu.equalsIgnoreCase("/login/inicio.xhtml") && usr == null) {
			((HttpServletResponse)response).sendRedirect(req.getContextPath() + "/login/login.xhtml");
			return;
		}
		
		if(Pattern.compile(excluidos).matcher(menu).find() 
				||(usr!= null && securityBo.userCanAccess(usr,menu))
			) {
			chain.doFilter(request, response);	
		}else {
			((HttpServletResponse)response).sendRedirect(req.getContextPath() + "/login/unautorized.xhtml");
			return;
			
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		WebApplicationContext webApplicationContext =
	            WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
	        //reference to bean from app context
		securityBo = webApplicationContext.getBean(SecurityBo.class);
		
	}

}
