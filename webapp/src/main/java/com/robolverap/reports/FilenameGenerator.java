/**
 * 
 */
package com.robolverap.reports;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.birt.report.context.ViewerAttributeBean;
import org.eclipse.birt.report.utility.filename.IFilenameGenerator;

/**
 * @author jrobolvp
 *
 */
public class FilenameGenerator implements IFilenameGenerator {

	public String getFilename(String baseName, String extension, String outputType, Map options) {
		ViewerAttributeBean params = ((ViewerAttributeBean)options.get("viewerAttributesBean"));
		HttpServletRequest request =((HttpServletRequest)options.get("httpRequest"));
		return request.getParameter("fileName")+"."+params.getFormat();
	}

}
