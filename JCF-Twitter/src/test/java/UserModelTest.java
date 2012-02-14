

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dukeShop.model.Customer;
import com.dukeShop.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
public class UserModelTest {

//	@Autowired
//	private QueryExecutor queryExcutor;

	@Autowired
	private CustomerService customerService;

	private Customer customer;

	@Before
	public void 셋업(){
		customer = new Customer();
		customer.setId("woori");
		customer.setPasswd("bank");
		customer.setPhone("02-555-6666");
		customer.setEmail("woori@bank.com");
		customer.setName("우리은행");
	}

	@Test
	public void 고객_입력테스트(){

//		Customer customer = new Customer("woori","bank","02-555-6666","woori@bank.com","우리은행");
		customerService.insertCustomer(customer);
	}

	@Test
	public void 고객_조회테스트(){

		List<Customer> allCustomer = customerService.getAllCustomer();

		for(Customer customer : allCustomer){
			System.out.println(customer.getName());
		}

//		List<Customer> queryForListCustomer = queryExcutor.queryForList("customer.select", null, Customer.class);
//
//		for(Customer customer : queryForListCustomer){
//			System.out.println(customer.getName());
//		}
	}

	@Test
	public void 고객_검색테스트(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "dw");
		List<Customer> findCustomer = customerService.findCustomer(map);

		for(Customer customer : findCustomer){
			System.out.println(customer.getName());
		}
	}

	@Test
	public void 고객_수정테스트(){

//		Customer customer = new Customer();
//		customer.setId("woori");
//		customer.setPasswd("woori");
//		customer.setPhone("02-555-6666");
//		customer.setEmail("woori@bank.com");
//		customer.setName("My우리은행");
//		queryExcutor.update("customer.update", customer);

		customer.setName("우리은행");
		customerService.updateCustomer(customer);
	}

	@Test
	public void 고객_삭제테스트(){

//		Customer customer = new Customer();
//		customer.setId("woori");
//		customer.setPasswd("bank");
//		customer.setPhone("02-1111-2222");
//		customer.setEmail("woori@bank.net");
//		customer.setName("우리은행");
//
//		queryExcutor.queryForList("customer.delete", "woori", Customer.class);

		customerService.deleteCustomer(customer);
	}

}
