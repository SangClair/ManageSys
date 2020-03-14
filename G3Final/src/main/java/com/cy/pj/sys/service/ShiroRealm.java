package com.cy.pj.sys.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysUser;

@Service
public class ShiroRealm extends AuthorizingRealm{

	@Autowired
	SysUserDao sysUserDao;

	@Autowired
	SysUserRoleDao sysUserRoleDao;

	@Autowired
	SysRoleMenuDao sysRoleMenuDao;

	@Autowired
	SysMenuDao sysMenuDao;

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher hcMatcher = new HashedCredentialsMatcher();
		hcMatcher.setHashAlgorithmName("MD5");
		hcMatcher.setHashIterations(1);
		super.setCredentialsMatcher(hcMatcher);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		Integer userId = user.getId();
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(userId);
		if(roleIds==null||roleIds.size()==0)
			throw new AuthorizationException();
		Integer[] generator = new Integer[] {};
		List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds.toArray(generator));
		if(menuIds==null||roleIds.size()==0)
			throw new AuthorizationException();
		List<String> permissions = sysMenuDao.findPermissions(menuIds.toArray(generator));
		if(permissions==null||roleIds.size()==0)
			throw new AuthorizationException();
		Set<String> set = new HashSet<>();
		for (String string : permissions) {
			if (!StringUtils.isEmpty(string)) {
				set.add(string);
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(set);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		SysUser user = sysUserDao.findUserByUserName(username);
		if(user == null) {
			throw new UnknownAccountException();
		}
		if(user.getValid() == 0) {
			throw new LockedAccountException();
		}
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, getName());
		return simpleAuthenticationInfo;
	}

}
