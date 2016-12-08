package br.com.pdv.framework.data;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class JPAEntity<T extends Serializable> implements Entity {
}
