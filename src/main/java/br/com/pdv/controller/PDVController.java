package br.com.pdv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pdv.framework.api.APIResponse;
import br.com.pdv.framework.controller.BaseController;
import br.com.pdv.model.entity.PDV;
import br.com.pdv.service.PDVService;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
@Controller
@RequestMapping("pdv")
public class PDVController extends BaseController {
	
    private static Logger LOG = LoggerFactory.getLogger(PDVController.class);
	private @Autowired  PDVService pdvService;
	    
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = {JSON_API_CONTENT_HEADER})
	public @ResponseBody APIResponse save(@RequestBody PDV pdv) throws Exception {
		
		if (pdv.getCdPdv() == null) {
			pdvService.insert(pdv);
			LOG.info("Creating pdv: " + pdv.getNmPDV());       
			return APIResponse.toOkResponse("Ponto de Venda cadastrado com sucesso.");
		}
		pdvService.update(pdv);
		LOG.info("Updating pdv: " + pdv.getNmPDV());       
		return APIResponse.toOkResponse("Ponto de Venda atualizado com sucesso.");
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody APIResponse list() {   	
		
		return APIResponse.toOkResponse(pdvService.findAll());
	}
	
	@RequestMapping(value = "/delete/{cdPdv}", method = RequestMethod.DELETE)
	public @ResponseBody APIResponse delete(
			@PathVariable("cdPdv") Long cdPdv) throws Exception {
		
		pdvService.del(new PDV(cdPdv));
		return APIResponse.toOkResponse("Registro deletado com sucesso.");
	}	    
}