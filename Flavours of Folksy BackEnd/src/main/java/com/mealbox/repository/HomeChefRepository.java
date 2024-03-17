package com.mealbox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mealbox.entity.HomeChef;


@Repository
public interface HomeChefRepository extends JpaRepository<HomeChef, Long> {

	Optional<HomeChef> findByEmailIdAndPassword(String emailId,String password);
	Optional<HomeChef> findByEmailId(String emailId);
}
