package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.entity.Document;
import com.hrm.mapper.DocumentMapper;
import com.hrm.service.DocumentService;
import com.hrm.utils.PageModel;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentMapper documentMapper;
	
	@Override
	public List<Document> findDocument(Document document, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDocument(Document document) {
		// TODO Auto-generated method stub

	}

	@Override
	public Document findDocumentById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeDocumentById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyDocument(Document document) {
		// TODO Auto-generated method stub

	}

}
