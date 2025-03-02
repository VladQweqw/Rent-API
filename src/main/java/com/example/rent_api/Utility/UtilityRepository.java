package com.example.rent_api.Utility;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityRepository extends MongoRepository<Utility, String> {


}
