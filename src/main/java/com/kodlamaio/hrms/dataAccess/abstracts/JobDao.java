package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.Job;
import com.kodlamaio.hrms.entities.dtos.JobSummaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobDao extends JpaRepository<Job, Integer> {

    @Query(Query_JobSummaryDto)
    List<JobSummaryDto> getAllJobSummaryDto();

    @Query(Query_JobSummaryDtoByCompanyName)
    List<JobSummaryDto> getAllJobSummaryDtoByCompanyName(@Param("companyName") String companyName);

    @Query(Query_JobSummaryDtoByJobTitle)
    List<JobSummaryDto> getAllJobSummaryDtoByJobTitle(@Param("jobTitle") String jobTitle);

//    String Query_JobSummaryDto = "SELECT new com.kodlamaio.hrms.entity.dtos.JobSummaryDto " +
//            "(j.id as id, " +
//            "u.companyName as companyName " +
//            "jt.title as jobTitle, " +
//            "j.applicantQuota as applicantQuota, " +
//            "j.createdDate as createdDate, " +
//            "j.lastApplicationDate as lastApplicationDate)" +
//
//            "FROM Job j " +
//            "JOIN j.jobTitle jt " +
//            "JOIN j.createdUser u " +
//            "WHERE j.active = true " +
//            "AND j.lastApplicationDate >= CURRENT_DATE ";
//
//    String Query_JobSummaryDtoByCompanyName = Query_JobSummaryDto +
//            "AND lower(u.companyName) like CONCAT('%', lower(:companyName), '%')";
//
//    String Query_JobSummaryDtoByJobTitle = Query_JobSummaryDto +
//            "AND lower(j.title) like CONCAT('%', lower(:jobTitle), '%')";
    String Query_JobSummaryDto = "SELECT new com.kodlamaio.hrms.entities.dtos.JobSummaryDto "
            + 	"(j.id as id, "
            + 	"u.companyName as companyName, "
            + 	"jt.title as jobTitle, "
            +	"j.applicantQuota as applicantQuota, "
            + 	"j.createdDate as createdDate, "
            +	"j.lastApplicationDate as lastApplicationDate)"

            + 	"FROM Job j "
            + 	"JOIN j.jobTitle jt "
            + 	"JOIN j.createdUser u "
            + 	"WHERE j.active = true "
            + 	"AND j.lastApplicationDate >= CURRENT_DATE ";

    String Query_JobSummaryDtoByCompanyName = Query_JobSummaryDto
            + 	"AND lower(u.companyName) like CONCAT('%',lower(:companyName),'%')";

    String Query_JobSummaryDtoByJobTitle = Query_JobSummaryDto
            + 	"AND lower(jt.title) like CONCAT('%',lower(:jobTitle),'%')";
}
