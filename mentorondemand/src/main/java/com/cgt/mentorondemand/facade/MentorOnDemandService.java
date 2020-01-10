package com.cgt.mentorondemand.facade;

import java.util.List;

import com.cgt.mentorondemand.dto.BooleanResult;
import com.cgt.mentorondemand.dto.LogginCredential;
import com.cgt.mentorondemand.dto.SearchTraining;
import com.cgt.mentorondemand.dto.TechnologyList;
import com.cgt.mentorondemand.dto.UserDto;
import com.cgt.mentorondemand.entities.MentorSlots;
import com.cgt.mentorondemand.entities.Training;
import com.cgt.mentorondemand.mentordto.SlotList;
import com.cgt.mentorondemand.trainingdto.CompletedTraining;
import com.cgt.mentorondemand.trainingdto.RequestTraining;
import com.cgt.mentorondemand.trainingdto.RunningTraining;
import com.cgt.mentorondemand.userdto.UserProfile;


public interface MentorOnDemandService {
	public List<SearchTraining> getSearchResult(Integer tech_id);
	public TechnologyList getTechList();
	public UserDto validateUser(LogginCredential login);
	
	
	// Mentor Service
	public List<RequestTraining> getAllRequest(Integer mentor_id);
	public List<RunningTraining> getAllRunningTraining(Integer mentor_id);
	public SlotList getAllMentorSlots(Integer mentor_id);
	public BooleanResult updateMentorSlots(MentorSlots slot);	
	public BooleanResult addSlot(MentorSlots slot);
	public List<CompletedTraining> completedTraining(Integer mentor_id);
	public UserProfile editUserProfile(Integer id);
	public BooleanResult updateMentorProfile(UserProfile profile);
	
	// Student Service
	
	public BooleanResult sendRequest(Integer user_id,Integer tech_id,Integer mentor_id,Integer slot_id);
	public List<RequestTraining> getPendingRequest(Integer user_id);
	public List<RunningTraining> getUserRunningTraining(Integer user_id);
	public List<CompletedTraining> getUserCompletedTraining(Integer user_id);
}
