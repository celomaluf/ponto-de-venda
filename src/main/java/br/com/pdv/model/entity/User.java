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
public class User extends JPAEntity<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue 
	@Column(name="CD_USER")
	private Long cdUser;
	
	@NotNull @NotBlank 
	@Column(name="DE_LOGIN", length=15)
	private String deLogin;
	
	@NotNull @NotBlank 
	@Column(name="DE_PASSWORD", length=15) 
	private String dePassword;    
  

    public void setDeEmail(String deEmail) {
        this.dePassword = deEmail;
    }   

	public Long getCdUser() {
		return cdUser;
	}

	public void setCdUser(Long cdUser) {
		this.cdUser = cdUser;
	}
	
	public String getDeLogin() {
		return deLogin;
	}
	
	public void setDeLogin(String deLogin) {
		this.deLogin = deLogin;
	}
    public String getDePassword() {
        return this.dePassword;
    }

    public void setDePassword(String dePassword) {
        this.dePassword = dePassword;
    }  
	
	@Override
    public String toString() {
        return "User{" +
        		", deLogin='" + deLogin + '\'' +
                ", dePassword='" + dePassword + '\'' +               
                '}';
    }
}