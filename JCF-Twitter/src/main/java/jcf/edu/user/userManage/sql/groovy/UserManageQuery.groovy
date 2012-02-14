package jcf.edu.user.userManage.sql.groovy

class UserManageQuery {

 public static String selectAll = '''
  select * from twitter_user
 '''

 public static String updateAt = '''
  update twitter_user set
   user_id = :user_id
   user_name = :user_name
   user_email = :user_email,

  where id = :id
 '''

 public static String insertAt = '''
  insert into twitter_user values(
   :user_id,
   :user_name,
   :user_email
  )
 '''

 public static String deleteat = '''
  delete from twitter_user where user_id = :user_id
 '''

}