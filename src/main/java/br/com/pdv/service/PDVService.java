package br.com.pdv.service;

import java.util.List;

import br.com.pdv.framework.data.BaseService;
import br.com.pdv.model.entity.PDV;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
public interface PDVService extends BaseService<PDV, Long> {
	
	PDV insert(PDV pdv);
	List<PDV> findAll();
	void del (PDV pdv);
}
