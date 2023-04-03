package com.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.weather.entity.DiceUser;

@Component
public interface UserRepository extends JpaRepository<DiceUser,Integer> {
	
	DiceUser findByUserName(String username);

}
