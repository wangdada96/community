package com.zhisheng.community;

import com.zhisheng.community.Conf.AlphaConf;
import com.zhisheng.community.dao.AlphaDao;
import com.zhisheng.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

	@Autowired
	@Qualifier("alphahibenate")
	private AlphaDao alphadao;
	@Autowired
	private AlphaService alphaService;
	@Autowired
	private AlphaConf alphaConf;
	@Test
	public void testDI(){
		System.out.println(alphadao);
		System.out.println(alphaService);
		System.out.println(alphaConf);
	}
}
