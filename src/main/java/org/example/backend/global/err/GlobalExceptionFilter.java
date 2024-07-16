package org.example.backend.global.err;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.backend.global.err.exception.ErrorCode;
import org.example.backend.global.err.exception.BackendException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class GlobalExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BackendException e) {
            ErrorCode errorCode = e.getErrorCode();
            writerErrorResponse(response, ErrorResponse.of(errorCode));
        } catch (Exception e) {
            writerErrorResponse(response, ErrorResponse.of(e.getMessage(), response.getStatus()));
        }
    }

    private void writerErrorResponse(HttpServletResponse response, ErrorResponse errorResponse) throws IOException {
        response.setStatus(errorResponse.getStatus());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        objectMapper.writeValue(response.getWriter(), errorResponse);
    }
}
