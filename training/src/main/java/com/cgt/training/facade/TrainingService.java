 package com.cgt.training.facade;

import java.util.List;

import com.cgt.training.entity.Training;

public interface TrainingService {
	public boolean addTraining(Training training);
	public boolean deleteTraining(Integer id);
	public Training getTraining(Integer id);
	public List<Training> getAllTraining();
	public boolean updateTraining(Training training);
	public List<Training> getTrainingByMentorId(Integer mentor_id);
	public List<Training> getTrainingByTechId(Integer tech_id);
	public Boolean checkSlot(Integer slot_id);
	//For Mentor
		public List<Training> getAllRequest(Integer mentor_id);
		public List<Training> getCompletedTraining(Integer mentor_id);
		
		//For Student
		
		public List<Training> getUserPendingRequest(Integer user_id);
		public List<Training> getUserRunTraining(Integer user_id);
		public List<Training> getUserCompletedTraining(Integer user_id);
}
