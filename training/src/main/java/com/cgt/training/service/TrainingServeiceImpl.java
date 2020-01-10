package com.cgt.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.training.entity.Training;
import com.cgt.training.facade.TrainingDao;
import com.cgt.training.facade.TrainingService;
@Repository
@Transactional
public class TrainingServeiceImpl implements TrainingService {

	@Autowired
	private TrainingDao trainingDao;
	
	
	@Override
	public boolean addTraining(Training training) {
		return  this.trainingDao.addTraining(training);
	}

	@Override
	public boolean deleteTraining(Integer id) {
		return this.trainingDao.deleteTraining(id);
	}

	@Override
	public Training getTraining(Integer id) {
		return this.trainingDao.getTraining(id);
	}

	@Override
	public List<Training> getAllTraining() {
		return this.trainingDao.getAllTraining();
	}

	@Override
	public boolean updateTraining(Training training) {
		return this.trainingDao.updateTraining(training);
	}

	@Override
	public List<Training> getTrainingByMentorId(Integer mentor_id) {
		return this.trainingDao.getTrainingByMentorId(mentor_id);
	}

	@Override
	public List<Training> getTrainingByTechId(Integer tech_id) {
		return this.trainingDao.getTrainingByTechId(tech_id);
	}

	@Override
	public Boolean checkSlot(Integer slot_id) {
		return this.trainingDao.checkSlot(slot_id);
	}

	@Override
	public List<Training> getAllRequest(Integer mentor_id) {
		return this.trainingDao.getAllRequest(mentor_id);
	}

	@Override
	public List<Training> getCompletedTraining(Integer mentor_id) {
		return this.trainingDao.getCompletedTraining(mentor_id);
	}

	@Override
	public List<Training> getUserPendingRequest(Integer user_id) {
		return this.trainingDao.getUserPendingRequest(user_id);
	}

	@Override
	public List<Training> getUserRunTraining(Integer user_id) {
		return this.trainingDao.getUserRunTraining(user_id);
	}

	@Override
	public List<Training> getUserCompletedTraining(Integer user_id) {
		return this.trainingDao.getUserCompletedTraining(user_id);
	}

}
