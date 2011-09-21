package com.sungardhe.demo.portlets.bookportlet;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sungardhe.demo.portlets.bookportlet.util.ConnectionPool;

public class DAOPortlet extends GenericPortlet {

	private static Log _log = LogFactory.getLog(DAOPortlet.class);

	@Override
	public void destroy() {
		super.destroy();
		if (_log.isInfoEnabled()) {
			_log.info("Destroying portlet");
		}
		
		try {
			ConnectionPool.destroy();
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletContext portletContext = getPortletContext();
		PortletRequestDispatcher portletRequestDispatcher = portletContext.getRequestDispatcher("/WEB-INF/jsp/view.jsp");
		
		if (portletRequestDispatcher == null) {
			_log.error("/WEB-INF/jsp/view.jsp is not available");
		} else {
			try {
				portletRequestDispatcher.include(request, response);
			}
			catch (Exception e) {
				_log.error(e, e);
			}
			//portletRequestDispatcher.include(request, response);
		}
	}

	@Override
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		if (_log.isInfoEnabled()) {
			_log.info("Initializing portlet");
		}
	}
	
	
}
