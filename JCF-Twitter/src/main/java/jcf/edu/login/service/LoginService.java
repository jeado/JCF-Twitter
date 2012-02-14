package jcf.edu.login.service;
import java.util.List;
import java.util.Map;

import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcf.edu.user.model.UserVO;

@Service
public class LoginService {

 @Autowired
 private QueryExecutor excutor;

 public List<UserVO> getAllCustomer(){
  return excutor.queryForList("customer.select", null, UserVO.class);
//  return excutor.queryForList(CustomerQuery.selectAll, null, Customer.class);
 }

 public List<UserVO> findCustomer(Map<String, String> map){
  return excutor.queryForList("customer.find", map, UserVO.class);
 }

// public void insertCustomer(Customer customer){
//  excutor.update("customer.insert", customer);
////  excutor.update(CustomerQuery.insertAt, customer);
// }
//
// public void updateCustomer(Customer customer){
//  excutor.update("customer.update", customer);
////  excutor.update(CustomerQuery.updateAt, customer);
// }
//
// public void deleteCustomer(Customer customer){
//  excutor.update("customer.delete", customer);
////  excutor.update(CustomerQuery.deleteat, customer);
// }

}
