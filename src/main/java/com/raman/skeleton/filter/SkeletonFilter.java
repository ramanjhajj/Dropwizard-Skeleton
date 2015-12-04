package com.raman.skeleton.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Raman on 04/12/2015.
 *
 * Skeleton Servlet Filter for the Application.
 */
public class SkeletonFilter implements Filter {
    protected static final Logger logger = LoggerFactory.getLogger(SkeletonFilter.class);

    /**
     * Initialization method
     * @param filterConfig Filter configuration
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Main filter method for the reuqests and response
     * @param servletRequest Servlet Request
     * @param servletResponse Servlet Response
     * @param filterChain Filter Chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * Destroy method of the filter
     */
    @Override
    public void destroy() {

    }
}
