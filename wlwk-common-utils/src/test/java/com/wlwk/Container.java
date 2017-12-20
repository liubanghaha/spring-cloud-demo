package com.wlwk;

import cn.org.rapid_framework.generator.GeneratorFacade;

public class Container {
	final static GeneratorFacade facade = new GeneratorFacade();

	static {
		facade.getGenerator().addTemplateRootDir("src/test/template/domain");
		facade.getGenerator().addTemplateRootDir("src/test/template/repository");
		facade.getGenerator().setSourceEncoding("UTF-8");
		facade.getGenerator().setOutputEncoding("UTF-8");
		facade.getGenerator().setOutRootDir("src/test/out");
		facade.getGenerator().setCopyBinaryFile(false);
	}

	public static void main(String[] args) throws Exception {
		facade.deleteOutRootDir();
		facade.generateByTable("t_user_account", "t_role_auth", "t_role_info", "t_sys_auth_info", "t_user_role", "t_user_staff");
	}

}