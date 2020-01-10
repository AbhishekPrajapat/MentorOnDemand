package com.cgt.mentorondemand.service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.cgt.mentorondemand.dto.BooleanResult;
import com.cgt.mentorondemand.dto.LogginCredential;
import com.cgt.mentorondemand.dto.MentorSkillList;
import com.cgt.mentorondemand.dto.SearchList;
import com.cgt.mentorondemand.dto.SearchTraining;
import com.cgt.mentorondemand.dto.TechnologyList;
import com.cgt.mentorondemand.dto.UserDto;
import com.cgt.mentorondemand.facade.MentorOnDemandService;
import com.cgt.mentorondemand.mentordto.SlotList;
import com.cgt.mentorondemand.trainingdto.CompletedTraining;
import com.cgt.mentorondemand.trainingdto.CompletedTrainingList;
import com.cgt.mentorondemand.trainingdto.RequestTraining;
import com.cgt.mentorondemand.trainingdto.RunningTraining;
import com.cgt.mentorondemand.trainingdto.TrainingList;
import com.cgt.mentorondemand.userdto.UserProfile;
import com.cgt.mentorondemand.entities.*;

@Service
@Transactional
public class MentorOnDemandServiceImpl implements MentorOnDemandService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<SearchTraining> getSearchResult(Integer tech_id) {
		List<SearchTraining> searchList = new LinkedList<SearchTraining>();
		Technologies tech = this.restTemplate.getForEntity("http://technology/getTech/"+tech_id, Technologies.class).getBody();
		MentorSkillList mentorSkill = this.restTemplate.getForObject("http://mentorskill/getMentorByTech/"+tech_id, MentorSkillList.class);
		List<MentorSkills> skills =mentorSkill.getMentorSkillList();  
		for (MentorSkills skill : skills) {
		    UserDto user = this.restTemplate.getForObject("http://user/getUser/"+skill.getMentor_id(),UserDto.class);
			SlotList slots = this.restTemplate.getForObject("http://mentor-slots/getSlotByMentorId/"+skill.getMentor_id(), SlotList.class);
			List<MentorSlots> getslots = slots.getMentorSlots();
				for (MentorSlots mentorSlots : getslots) {
					BooleanResult status =this.restTemplate.getForObject("http://training/checkSlot/"+mentorSlots.getId(), BooleanResult.class);
							if(status.isStatus()){
							searchList.add(new SearchTraining(tech_id, skill.getMentor_id(), mentorSlots.getId(), 
							tech.getTechnology_name(),user.getName() ,user.getYear_of_exp(), skill.getToc(), skill.getPrerequisites(),
							user.getLinkedin_url(),mentorSlots.getTime_from().toString()+"-"+mentorSlots.getTime_to().toString(), 
							skill.getFee()));
					}
				}
		}
		return searchList;
	}

	@Override
	public TechnologyList getTechList() {
		ResponseEntity<TechnologyList> tech = this.restTemplate.getForEntity("http://technology/getAllTech", TechnologyList.class);
		return tech.getBody();
	}

	@Override
	public UserDto validateUser(LogginCredential login) {
		try {
			UserDto user = this.restTemplate.postForObject("http://user/validUser", login, UserDto.class);
			return user;
		}catch (Exception ex) {
			return null;
		}
		
	
	}

	//Mentor Service Impl
	
	@Override
	public List<RequestTraining> getAllRequest(Integer mentor_id) {
		try {
			TrainingList trainingList = this.restTemplate.getForObject("http://training/getRequests/"+mentor_id, TrainingList.class);
			List<Training> trainings = trainingList.getTrainingList();
			return trainings.stream().map(training->{
				Technologies tech = this.restTemplate.getForObject("http://technology/getTech/"+training.getTech_id(), Technologies.class);
				UserDto user = this.restTemplate.getForObject("http://user/getUser/"+training.getUser_id(), UserDto.class);
				MentorSlots mentor_slot = this.restTemplate.getForObject("http://mentor-slots/getMentorslot/"+training.getSlot_id(), MentorSlots.class);
				return new RequestTraining(training.getId(), user.getName(),
						mentor_slot.getTime_from().toString() + "-" +mentor_slot.getTime_to().toString(), tech.getTechnology_name());
			})
					.collect(Collectors.toList());

		}catch(Exception ex) {
			return null;
		}
		
	}

	@Override
	public List<RunningTraining> getAllRunningTraining(Integer mentor_id) {
	try {
		TrainingList runningTraining = this.restTemplate.getForObject("http://training/getTrainingByMentorId/"+mentor_id, TrainingList.class);
		List<Training> trainings = runningTraining.getTrainingList();
		return trainings.stream().map(training->{
			Technologies tech = this.restTemplate.getForObject("http://technology/getTech/"+training.getTech_id(), Technologies.class);
			UserDto user = this.restTemplate.getForObject("http://user/getUser/"+training.getUser_id(), UserDto.class);
			MentorSlots mentor_slot = this.restTemplate.getForObject("http://mentor-slots/getMentorslot/"+training.getSlot_id(), MentorSlots.class);
			return new RunningTraining(training.getId(), user.getName(), mentor_slot.getTime_from().toString() + "-" +mentor_slot.getTime_to().toString(),
					tech.getTechnology_name(), training.getProgress(), training.getStart_date().toString(), 
					training.getEnd_date().toString(),training.getAmount_received());
		})
				.collect(Collectors.toList());
	}catch(Exception ex) {
		return null;
	}
	}

	@Override
	public SlotList getAllMentorSlots(Integer mentor_id) {
		try {
			SlotList slotList = this.restTemplate.getForObject("http://mentor-slots/getSlotByMentorId/"+mentor_id, SlotList.class);
			return slotList;
			
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public BooleanResult updateMentorSlots(MentorSlots slot) {
		BooleanResult res = this.restTemplate.postForObject("http://mentor-slots/updateMentorSlot", slot, BooleanResult.class);
		return res;
	}

	@Override
	public BooleanResult addSlot(MentorSlots slot) {
		BooleanResult res = this.restTemplate.postForObject("http://mentor-slots/addMentorSlot", slot, BooleanResult.class);
		return res;
	}

	@Override
	public List<CompletedTraining> completedTraining(Integer mentor_id) {
		
		try {
			TrainingList trainingList = this.restTemplate.getForObject("http://training/getCompletedTraining/"+mentor_id, TrainingList.class);
			List<Training> trainings = trainingList.getTrainingList();
			return trainings.stream().map(training->{
				Technologies tech = this.restTemplate.getForObject("http://technology/getTech/"+training.getTech_id(), Technologies.class);
				UserDto user = this.restTemplate.getForObject("http://user/getUser/"+training.getUser_id(), UserDto.class);
				MentorSlots mentor_slot = this.restTemplate.getForObject("http://mentor-slots/getMentorslot/"+training.getSlot_id(), MentorSlots.class);
				return new CompletedTraining(training.getId(), user.getName(), mentor_slot.getTime_from().toString() + "-"+mentor_slot.getTime_to().toString(), 
						tech.getTechnology_name(), training.getProgress(), training.getStart_date().toString(), 
						training.getEnd_date().toString(), training.getAmount_received());
				
			})
					.collect(Collectors.toList());
			
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public UserProfile editUserProfile(Integer id) {
		UserProfile userProfile = this.restTemplate.getForObject("http://user/getProfile/"+id, UserProfile.class);
		return userProfile;
	}

	@Override
	public BooleanResult updateMentorProfile(UserProfile profile) {
		BooleanResult res = this.restTemplate.postForObject("http://user/updateMentorProfile", profile, BooleanResult.class);
		return res;
	}

	@Override
	public BooleanResult sendRequest(Integer user_id, Integer tech_id, Integer mentor_id, Integer slot_id) {
		Training training = new Training();
		training.setUser_id(user_id);
		training.setTech_id(tech_id);
		training.setMentor_id(mentor_id);
		training.setSlot_id(slot_id);
		BooleanResult result = this.restTemplate.postForObject("http://training/addTraining", training, BooleanResult.class);
		return result;
	}

	
	@Override
	public List<RunningTraining> getUserRunningTraining(Integer user_id) {
		try {
			TrainingList runningTraining = this.restTemplate.getForObject("http://training/getUserRunningTraining/"+user_id, TrainingList.class);
			List<Training> trainings = runningTraining.getTrainingList();
			return trainings.stream().map(training->{
				Technologies tech = this.restTemplate.getForObject("http://technology/getTech/"+training.getTech_id(), Technologies.class);
				UserDto user = this.restTemplate.getForObject("http://user/getUser/"+training.getMentor_id(), UserDto.class);
				MentorSlots mentor_slot = this.restTemplate.getForObject("http://mentor-slots/getMentorslot/"+training.getSlot_id(), MentorSlots.class);
				return new RunningTraining(training.getId(), user.getName(), mentor_slot.getTime_from().toString() + "-" +mentor_slot.getTime_to().toString(),
						tech.getTechnology_name(), training.getProgress(), training.getStart_date().toString(), 
						training.getEnd_date().toString(),training.getAmount_received());
			})
					.collect(Collectors.toList());
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public List<CompletedTraining> getUserCompletedTraining(Integer user_id) {
		try {
			TrainingList trainingList = this.restTemplate.getForObject("http://training/getUserCompletedTraining/"+user_id, TrainingList.class);
			List<Training> trainings = trainingList.getTrainingList();
			return trainings.stream().map(training->{
				Technologies tech = this.restTemplate.getForObject("http://technology/getTech/"+training.getTech_id(), Technologies.class);
				UserDto user = this.restTemplate.getForObject("http://user/getUser/"+training.getMentor_id(), UserDto.class);
				MentorSlots mentor_slot = this.restTemplate.getForObject("http://mentor-slots/getMentorslot/"+training.getSlot_id(), MentorSlots.class);
				return new CompletedTraining(training.getId(), user.getName(), mentor_slot.getTime_from().toString() + "-"+mentor_slot.getTime_to().toString(), 
						tech.getTechnology_name(), training.getProgress(), training.getStart_date().toString(), 
						training.getEnd_date().toString(), training.getAmount_received());
				
			})
					.collect(Collectors.toList());
			
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public List<RequestTraining> getPendingRequest(Integer user_id) {
		try {
			TrainingList trainingList = this.restTemplate.getForObject("http://training/getUserPendingRequest/"+user_id, TrainingList.class);
			List<Training> trainings = trainingList.getTrainingList();
			return trainings.stream().map(training->{
				Technologies tech = this.restTemplate.getForObject("http://technology/getTech/"+training.getTech_id(), Technologies.class);
				UserDto user = this.restTemplate.getForObject("http://user/getUser/"+training.getMentor_id(), UserDto.class);
				MentorSlots mentor_slot = this.restTemplate.getForObject("http://mentor-slots/getMentorslot/"+training.getSlot_id(), MentorSlots.class);
				return new RequestTraining(training.getId(), user.getName(),
						mentor_slot.getTime_from().toString() + "-" +mentor_slot.getTime_to().toString(),tech.getTechnology_name());
			})
					.collect(Collectors.toList());

		}catch(Exception ex) {
			return null;
		}

	}	
}
