package com.example.springrestaurant.wishlist.repository;

import com.example.springrestaurant.db.MemoryDbRepositoryAbstract;
import com.example.springrestaurant.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {

}
