package br.com.pdv.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.pdv.framework.data.JPAEntity;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
@Entity
@Table(schema="public")
public class PDV  extends JPAEntity<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public PDV() {
	
	}
	
	public PDV(Long cdPdv) {
		setCdPdv(cdPdv);
	}
	
	@Id @GeneratedValue 
	@Column(name="CD_PDV")
	private Long cdPdv;
	
	@NotNull @NotBlank 
	@Column(name="NM_PDV", length=25)
	private String nmPDV;
	
	@Column(name="NU_PHONE", length=15)
	private String nuPhone;
	
	@Column(name="DE_ADDRESS", length=100)
	private String deAddress;
	
	@Column(name="HOUR_BEGIN", length=2)
	private String hourBegin;
	
	@Column(name="HOUR_END", length=2)
	private String hourEnd;
	
	@Column(name="MIN_BEGIN", length=2)
	private String minBegin;
	
	@Column(name="MIN_END", length=2)
	private String minEnd;
	
	public String getNmPDV() {
		return nmPDV;
	}

	public void setNmPDV(String nmPDV) {
		this.nmPDV = nmPDV;
	}

	public String getDeAddress() {
		return deAddress;
	}

	public void setDeAddress(String deAddress) {
		this.deAddress = deAddress;
	}

	public String getNuPhone() {
		return nuPhone;
	}
	
	public void setNuPhone(String nuPhone) {
		this.nuPhone = nuPhone;
	}
	
	@Override
	public String toString() {
		return "PDV {" +	
				", cdPdv='" + cdPdv + '\'' +
				", nmPDV='" + nmPDV + '\'' +
				", nuPhone='" + nuPhone + '\'' +               
				", deAddress='" + deAddress + '\'' +               
				", hourBegin='" + hourBegin + '\'' +               
				", hourEnd='" + hourEnd + '\'' +    
				", minBegin='" + minBegin + '\'' +               
				", minEnd='" + minEnd + '\'' +    
				'}';
	}

	public Long getCdPdv() {
		return cdPdv;
	}

	public void setCdPdv(Long cdPdv) {
		this.cdPdv = cdPdv;
	}

	public String getHourBegin() {
		return hourBegin;
	}

	public void setHourBegin(String hourBegin) {
		this.hourBegin = hourBegin;
	}

	public String getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(String hourEnd) {
		this.hourEnd = hourEnd;
	}

	public String getMinBegin() {
		return minBegin;
	}

	public void setMinBegin(String minBegin) {
		this.minBegin = minBegin;
	}

	public String getMinEnd() {
		return minEnd;
	}

	public void setMinEnd(String minEnd) {
		this.minEnd = minEnd;
	}
}