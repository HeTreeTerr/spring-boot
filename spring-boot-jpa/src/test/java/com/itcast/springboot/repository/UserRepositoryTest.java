package com.itcast.springboot.repository;

import com.itcast.springboot.dto.Users;
import com.itcast.springboot.entity.Hobby;
import com.itcast.springboot.entity.User;
import com.itcast.springboot.enums.SexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 保存
     */
    @Test
    public void save(){
        //基本信息
        User user = new User();
        user.setLastName("hss2");
        user.setEmail("3110708879@qq.com");
        user.setSex(SexEnum.男);
        user.setBirthday(new Date());
        user.setPhone("18628466845");
        //爱好信息(在保存基础信息前，不能获取主键值。这种方法在新增场景下不可行)
        /*Set<Hobby> hobbySet = new HashSet<Hobby>();
        Hobby hobby1 = new Hobby("游戏");
        Hobby hobby2 = new Hobby("绘画");
        hobbySet.add(hobby1);
        hobbySet.add(hobby2);

        user.setHobbySet(hobbySet);*/

        User save = userRepository.save(user);
        System.out.println(save);
    }

    /**
     * 修改
     */
    @Test
    public void update(){
        /*User user = new User();
        user.setId(11);
        user.setLastName("hss1");
        user.setEmail("3110708871@qq.com");
        user.setSex(SexEnum.男);
        user.setBirthday(new Date());*/
        /**
         * 由id查找记录，
         * 有记录：修改
         * 无记录：新增
         */
        Optional<User> userOpt = userRepository.findById(17);
        User user = userOpt.get();
        user.setSex(SexEnum.女);

        //一对多关系，修改场景中可以直接修改多（set<Object>）。遵循规律：存在则修改，不存在则新增。不想触发修改，则set<Object>对象赋值null
        /*Set<Hobby> hobbySet = new HashSet<Hobby>();
        Hobby hobby1 = new Hobby(7,"游戏123",new User(user.getId()));
        Hobby hobby2 = new Hobby(8,"lol123",new User(user.getId()));
        hobbySet.add(hobby1);
        hobbySet.add(hobby2);
        user.setHobbySet(hobbySet);*/

        User save = userRepository.save(user);
        System.out.println(save);
    }

    /**
     * 统计
     */
    @Test
    public void count(){
        //select count(*) as col_0_0_ from tbl_user user0_
        /*Long count = userRepository.count();*/

        //select count(user0_.id) as col_0_0_ from tbl_user user0_ where user0_.last_name=?
        /*User user = new User();
        user.setLastName("hss");
        Example<User> example = Example.of(user);
        long count = userRepository.count(example);*/

        //select count(user0_.id) as col_0_0_ from tbl_user user0_ where user0_.email like ?
        User user = new User();
        user.setEmail("3110708879@qq.com");
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        //原写法
        exampleMatcher = exampleMatcher.withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains());
        //简化版写法
        //exampleMatcher.withMatcher("email",math -> math.contains());
        // user 指定需要比对的值  exampleMatcher 指定比对的规则
        Example<User> example = Example.of(user,exampleMatcher);
        long count = userRepository.count(example);

        System.out.println(count);
    }

    /**
     * 存在
     */
    @Test
    public void exists(){
        //select count(*) as col_0_0_ from tbl_user user0_ where user0_.id=?
        /*boolean exists = userRepository.existsById(1);*/

        //select user0_.id as id1_0_, user0_.birthday as birthday2_0_, user0_.email as email3_0_, user0_.last_name as last_nam4_0_, user0_.sex as sex5_0_ from tbl_user user0_ where user0_.email=?
        /*User user = new User();
        user.setEmail("3110708879@qq.com1");
        Example<User> example = Example.of(user);
        boolean exists = userRepository.exists(example);*/

        //select user0_.id as id1_0_, user0_.birthday as birthday2_0_, user0_.email as email3_0_, user0_.last_name as last_nam4_0_, user0_.sex as sex5_0_ from tbl_user user0_ where user0_.last_name=? and (user0_.email like ?)
        User user = new User();
        user.setEmail("3110708879@qq.com");
        user.setLastName("hss");
        user.setSex(SexEnum.男);
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny();
        //原写法
        exampleMatcher = exampleMatcher.withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains());

        Example<User> example = Example.of(user,exampleMatcher);
        boolean exists = userRepository.exists(example);
        System.out.println(exists);
    }

    /**
     * 条件查询,自定义查询
     */
    @Test
    public void findUsersByLastNameIsStartingWithAndEmailContains(){
        String name = "ss";
        String email = "3110708879@qq.com";
        //List<User> users = userRepository.findUsersByLastNameIsStartingWithAndEmailContains(name, email);
        //List<User> users = userRepository.findUsersByLastNameIsStartingWith(name);
        //List<User> users = userRepository.findUsersByLastNameIsEndingWith(name);
        List<User> user = userRepository.findUserById(15);
        //Optional<User> user = userRepository.findById(15);
        System.out.println(user);
    }

    /**
     * 修改
     */
    @Test
    @Transactional
    public void updateEmailByUserId(){

        userRepository.updateEmailByUserId(6,"133789456@qq.com", "hssE");
        System.out.println("------修改成功-----");
    }

    /**
     * 删除
     */
    @Test
    public void delete(){

        //由id删除
        //userRepository.deleteById(5);

        //删除表所有记录
        //userRepository.deleteAll();

        /**
         * 重点还是在主键上
         *  delete
         *     from
         *         tbl_user
         *     where
         *         id=?
         */
        Optional<User> userOpt = userRepository.findById(17);
        User user = userOpt.get();

        /*User user = new User();
        user.setId(15);*/
        //在一对多的关系中，如果传入的对象拥有多（Set<Object>），则连同关系表一块清除。不想触发这设置set<object>为空
        user.setHobbySet(null);
        userRepository.delete(user);

        //批量删除
        /*Users users = new Users();

        User user1 = new User();
        user1.setId(13);

        User user2 = new User();
        user2.setId(14);

        User[] usersArr = {user1,user2};
        users.setUsers(usersArr);

        userRepository.deleteAll(users);*/
        System.out.println("------删除成功-----");
    }

    @Test
    public void pageQuery(){
        // page 0是第一页 1是第二页 ...
        int page = 0,size = 10;
        //排序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //分页条件
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        User user = new User();
        user.setEmail("3110708871@qq.com");
        user.setLastName("hss");

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny();
        //原写法
        exampleMatcher = exampleMatcher.withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("email",ExampleMatcher.GenericPropertyMatchers.exact());

        Example<User> example = Example.of(user,exampleMatcher);

        //Page<User> userPage = userRepository.findAll(pageRequest);
        Page<User> userPage = userRepository.findAll(example, pageRequest);
        System.out.println("总记录数：" + userPage.getTotalElements());
        System.out.println("总页数：" + userPage.getTotalPages());
        System.out.println(userPage.getContent());
    }

    @Test
    public void pageQuery1(){
        String lastName = "hss";

        Integer sex = 1;

        String startTime = "2021-1-11";
        String endTime = "2021-1-11";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfmat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // page 0是第一页 1是第二页 ...
        int page = 0,size = 10;
        //排序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //分页条件
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();
                try {
                    //模糊匹配
                    if(StringUtils.isNoneBlank(lastName)){
                        predicate.add(cb.like(root.get("lastName").as(String.class), "%" + lastName + "%"));
                    }
                    if(sex != null){
                        //精准查找
                        //predicate.add(cb.equal(root.get("sex").as(String.class), sex));
                        //小于
                        predicate.add(cb.lt(root.get("sex").as(Integer.class),0));
                        //大于
                        predicate.add(cb.gt(root.get("sex").as(Integer.class),3));
                    }
                    //日期范围
                    if(StringUtils.isNotEmpty(startTime) && StringUtils.isNotEmpty(endTime)){
                        /**
                         * 使用between and 可以提高语句的简洁度
                         * between and包含临界值（即包含两个边界值）
                         * between and的两个临界值不要乱调换顺序（数值小的放前面，数值大的放后面）
                         */
                        predicate.add(cb.between(root.get("birthday"),
                                sdf.parse(startTime),
                                sdf.parse(endTime)));
                    }

                    Predicate[] pre = new Predicate[predicate.size()];
                    return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        Page<User> userPage = userRepository.findAll(specification, pageRequest);
        System.out.println("总记录数：" + userPage.getTotalElements());
        System.out.println("总页数：" + userPage.getTotalPages());
        System.out.println(userPage.getContent());
    }
}