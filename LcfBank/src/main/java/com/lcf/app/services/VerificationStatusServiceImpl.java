package com.lcf.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.VerificationStatus;
import com.lcf.app.dao.VerificationStatusDao;

@Service
public class VerificationStatusServiceImpl implements VerificationStatusService {
	
	@Autowired
	VerificationStatusDao referenceDao;

	@Override
	public long createReference(VerificationStatus reference) {
		long referenceId = referenceDao.createReference(reference);
		return referenceId;
	}

	@Override
	public VerificationStatus getReferenceById(long id) {
		VerificationStatus reference = referenceDao.getReferenceById(id);
		return reference;
	}

	@Override
	public List<VerificationStatus> displayAll() {
		List<VerificationStatus> referenceList = referenceDao.displayAll();
		return referenceList;
	}

	@Override
	public boolean getStatusByReferenceId(long referenceId) {
		boolean flag = referenceDao.getStatusByReferenceId(referenceId);
		return flag;
	}
}
