package com.albedo.java.common.security.handler;

import com.albedo.java.common.core.util.R;
import com.albedo.java.common.core.util.WebUtil;
import com.albedo.java.modules.sys.service.UserOnlineService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring Security logout handler, specialized for Ajax requests.
 */
@AllArgsConstructor
public class AjaxLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
	implements LogoutSuccessHandler {

	private final UserOnlineService userOnlineService;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
								Authentication authentication) {
		response.setStatus(HttpServletResponse.SC_OK);
		WebUtil.renderJson(response, R.buildOk("退出登录成功"));
	}
}
