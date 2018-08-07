package ru.job4j.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class ru.job4j.filters.
 *
 * @author edzabarov
 * @since 03.08.2018
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (req.getRequestURI().contains("/singin") || req.getRequestURI().contains("/create")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = req.getSession();
                if (session.getAttribute("login") == null) {
                    resp.sendRedirect("./singin");
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
        }
    }

    @Override
    public void destroy() {

    }
}
