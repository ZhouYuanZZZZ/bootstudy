package com.zy.study.bootstudy;

import com.zy.study.bootstudy.aspect.AspectService;
import com.zy.study.bootstudy.async.TestService;
import com.zy.study.bootstudy.utils.poi.PoiUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootstudyApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(BootstudyApplicationTests.class);

//	@Resource
//	private CityMapper cityMapper;

	@Resource
	private AspectService aspectService;

	@Resource
	private TestService testService;

//	@Test
//	public void contextLoads() {
//		List<City> cities = cityMapper.selectByExample(null);
//		System.out.println(cities.size() );
//	}

	@Test
	public void testAop01(){
		aspectService.testAop01();
	}

	@Test
	public void testAop02(){
		aspectService.testAop02();
	}

	@Test
	public void testAop03(){
		aspectService.testAop03();
	}

	@Test
	public void testAop04(){
		aspectService.testAop04("zzz");
	}

	@Test
	public void testAsy01(){
		logger.info("--------------------------");
		testService.test();
		logger.info("--------------------------");
	}

//	@Test
//	public void downExcel0() throws IOException {
//		List<City> cities = cityMapper.selectByExample(null);
//		long startTime = System.currentTimeMillis();
//		ByteArrayOutputStream  outputStream =  PoiUtil.exportExcel(cities, City.class);
//		long endTime = System.currentTimeMillis();
//		logger.info("time:{}",endTime-startTime);
//
//		File file = new File("C:\\Users\\zy\\Desktop\\a.xls");
//		FileOutputStream fileOutputStream = new FileOutputStream(file);
//
//		fileOutputStream.write(outputStream.toByteArray());
//		fileOutputStream.flush();
//	}

//	@Test
//	public void testSelectData() throws IOException {
//		List<City> cities = cityMapper.selectByExample(null);
//
////		Example example = new Example(TbInvoice.class);
////		Example.Criteria criteria = example.createCriteria();
////		criteria.andEqualTo("invoiceUid",2563);
//		//List<TbInvoice> tbInvoices = tbInvoiceMapper.selectAll();
//
//		long startTime = System.currentTimeMillis();
//		//ByteArrayOutputStream  outputStream =  PoiUtil.exportExcel(tbInvoices, TbInvoice.class);
//		long endTime = System.currentTimeMillis();
//		logger.info("time:{}",endTime-startTime);
//
//		File file = new File("C:\\Users\\zy127\\Desktop\\Invoice.xls");
//		FileOutputStream fileOutputStream = new FileOutputStream(file);
//
//		//fileOutputStream.write(outputStream.toByteArray());
//		fileOutputStream.flush();
//
//		logger.info(cities.size()+"");
//		//logger.info(tbInvoices.size()+"");
//
//	}

}
