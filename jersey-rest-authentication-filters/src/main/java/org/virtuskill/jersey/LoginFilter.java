package org.virtuskill.jersey;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class LoginFilter implements ContainerRequestFilter {
	private static final String AUTHORIZATON_PROPERTY = "Authorization";
	private static final String AUTHORIZATION_BASIC_PROPERTY = "Basic";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		List<String> header_lists = requestContext.getHeaders().get(AUTHORIZATON_PROPERTY);

		if (null != header_lists && header_lists.size() > 0) {
			String authorization = header_lists.get(0);
			authorization = authorization.replaceFirst(AUTHORIZATION_BASIC_PROPERTY + " ", "");
			String decodedStr = Base64.decodeAsString(authorization);
			StringTokenizer tokenizer = new StringTokenizer(decodedStr, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();

			if ("user".equalsIgnoreCase(username) && "password".equals(password)) {
				return;
			}
		}

		Response response = Response.status(Status.UNAUTHORIZED).entity("User authentication failed!!!").build();
		requestContext.abortWith(response);
	}

}
