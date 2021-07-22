package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.Job;
import com.kodlamaio.hrms.entities.dtos.JobSummaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface JobDao extends JpaRepository<Job, Integer> {

    @Query(Query_JobSummaryDto)
    List<JobSummaryDto> getAllJobSummaryDto();

//    @Query(Query_JobSummaryDtoById)
//    Optional<JobSummaryDto> getJobSummaryDtoById(@Param("id") int id);

    @Query(Query_ActiveJobSummaryDto)
    List<JobSummaryDto> getAllActiveJobSummaryDto();

    @Query(Query_DeactiveJobSummaryDto)
    List<JobSummaryDto> getAllDeactiveJobSummaryDto();

    @Query(Query_JobSummaryDto)
    List<JobSummaryDto> getAllJobSummaryDtoBySalary(
            @Param("maxSalary") BigDecimal maxSalary, @Param("minSalary") BigDecimal minSalary);

    @Query(Query_JobSummaryDtoByState)
    List<JobSummaryDto> getAllJobSummaryDtoByState(@Param("state") String state);

    @Query(Query_JobSummaryDtoByCompanyName)
    List<JobSummaryDto> getAllJobSummaryDtoByCompanyName(@Param("companyName") String companyName);

    @Query(Query_JobSummaryDtoByJobTitle)
    List<JobSummaryDto> getAllJobSummaryDtoByJobTitle(@Param("jobTitle") String jobTitle);

    String Query_JobSummaryDto = "SELECT new com.kodlamaio.hrms.entities.dtos.JobSummaryDto "
            + 	"(j.id as id, "
            + 	"u.companyName as companyName, "
            + 	"u.email as email, "
            + 	"u.phone as phone, "
            + 	"u.website as website, "
            + 	"u.linkedin as linkedin, "
            +   "s.name as name, "
            + 	"jt.title as jobTitle, "
            +	"j.applicantQuota as applicantQuota, "
            + 	"j.createdDate as createdDate, "
            +	"j.lastApplicationDate as lastApplicationDate, "
            +   "j.title as title, "
            +   "j.description as description, "
            +   "j.maxSalary as maxSalary, "
            +   "j.minSalary as minSalary, "
            +   "j.active as active)"

            + 	"FROM Job j "
            + 	"JOIN j.jobTitle jt "
            + 	"JOIN j.createdUser u "
            +   "JOIN j.state s "
            + 	"WHERE j.lastApplicationDate >= CURRENT_DATE ";

    String Query_ActiveJobSummaryDto = Query_JobSummaryDto
            + "AND j.active = true";

    String Query_DeactiveJobSummaryDto = Query_JobSummaryDto
            + "AND j.active = false";

    String Query_JobSummaryDtoBySalary = Query_JobSummaryDto
            +  "AND j.minSalary=:minSalary";

    String Query_JobSummaryDtoByState = Query_JobSummaryDto
            + "AND lower(s.name) like CONCAT('%',lower(:state),'%')";

    String Query_JobSummaryDtoByCompanyName = Query_JobSummaryDto
            + 	"AND lower(u.companyName) like CONCAT('%',lower(:companyName),'%')";

    String Query_JobSummaryDtoByJobTitle = Query_JobSummaryDto
            + 	"AND lower(jt.title) like CONCAT('%',lower(:jobTitle),'%')";
}
