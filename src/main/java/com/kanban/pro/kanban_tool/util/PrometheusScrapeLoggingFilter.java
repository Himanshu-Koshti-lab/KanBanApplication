package com.kanban.pro.kanban_tool.util;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PrometheusScrapeLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(PrometheusScrapeLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        String path = httpReq.getRequestURI();

        if ("/actuator/prometheus".equals(path)) {
            logger.info("🔄 Prometheus scraped metrics at {}", System.currentTimeMillis());
        }
        chain.doFilter(request, response);
    }
}
