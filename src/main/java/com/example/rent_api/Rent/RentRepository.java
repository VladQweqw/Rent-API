package com.example.rent_api.Rent;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentRepository extends MongoRepository<Rent, String> {
}
