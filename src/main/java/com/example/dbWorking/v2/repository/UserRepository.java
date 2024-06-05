package com.example.dbWorking.v2.repository;

import com.example.dbWorking.v2.entitie.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> { //CrudRepository<User, Long>

    User findFirstByFirstNameLike(String filter); //поиск формируется названием метода

    @Query(value = "select u from User u where u.email like :filter") //jpql --название объекта и его полей а не название таблиц и колонок
    List<User> findByMail(@Param("filter") String filter);

    @Query(value = "select * from users where email like :filter", nativeQuery = true) //sql --название таблиц и колонок
    List<User> findByMail2(@Param("filter") String filter);

    @Query(name = "UserJPA.findAllByLastName")  //именованные запросы в классах сущностях
    List<User> findByLastName(@Param("filter") String filter);

    @Query(name = "UserJPA.findAllByFirstName")  //именованные запросы в классах сущностях
    List<User> findByFirstName(@Param("filter") String filter);

    @Query(name = "UserJPA.findAllByFirstName2")  //именованные запросы в классах сущностях
    List<User> findByFirstName2(@Param("filter") String filter);

    @Query(name = "UserJPA.findAllByFirstNameAndLastName")  //именованные запросы в пропертях
    List<User> findAllByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query(name = "UserJPA.findAllByFirstNameAndLastName2", nativeQuery = true)  //именованные запросы в пропертях
    List<User> findAllByFirstNameAndLastName2(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
