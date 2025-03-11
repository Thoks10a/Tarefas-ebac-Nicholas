package br.com.rpires;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class MyCustomFilter extends HttpFilter {

    private static final long serialVersionUID = -1L;
    private static Logger log = Logger.getLogger(MyCustomFilter.class.getName());

    public MyCustomFilter() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        super.doFilter(req, res, chain);
        log.info("filter Request");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

}