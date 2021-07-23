package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.UserVerification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserVerificationDao extends BaseDao<UserVerification, Integer> {

    @Query(value = "SELECT CASE WHEN COUNT(uv) > 0 THEN true ELSE false END " +
            "FROM UserVerification uv " +
            "WHERE verificationDate is NOT NULL" +
            "AND userId = :userId")
    boolean userIsVerified(@Param("userId") int userId);

    UserVerification findByCode(@Param("code") String code);
    boolean existByCode(@Param("code") String code);

    @Query(value = "SELECT uv.userId FROM UserVerification uv WHERE uv.code = :code")
    int findUserIdByCode(@Param("code") String code);
}
