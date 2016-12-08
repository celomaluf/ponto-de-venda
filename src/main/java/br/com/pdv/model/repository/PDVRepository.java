package br.com.pdv.model.repository;

import java.util.List;

import br.com.pdv.framework.data.BaseJPARepository;
import br.com.pdv.model.entity.PDV;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
public interface PDVRepository extends BaseJPARepository<PDV, Long> {

	List<PDV> findAll();
   
}
