package br.com.pdv.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pdv.framework.data.BaseJPAServiceImpl;
import br.com.pdv.model.entity.PDV;
import br.com.pdv.model.repository.PDVRepository;
import br.com.pdv.service.PDVService;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
@Service
@Transactional
public class PDVServiceImpl extends BaseJPAServiceImpl<PDV, Long> implements PDVService {
	
	private @Autowired PDVRepository pdvRepository;
    
    @PostConstruct
    public void setupService() {
        this.baseJpaRepository = pdvRepository;
        this.entityClass = PDV.class;
        this.baseJpaRepository.setupEntityClass(PDV.class);
    }

    @Override
    public PDV insert(PDV pdv) {
        return pdvRepository.insert(pdv);
    }

	@Override
	public List<PDV> findAll() {
		return pdvRepository.findAll();
	}

	@Override
	public void del(PDV pdv) {
		pdvRepository.delete(pdv);		
	}
	
}
