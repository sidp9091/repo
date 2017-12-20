package com.example.springDemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Student")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
public class Student  implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="student_id")
	    private Long sId;
		@Column(name="student_nm")
	    private String sName;
		@Column(name="student_age")
	    private String sAge;
		@JsonIgnore
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name = "class_id", insertable = false, updatable = false)
		private Classes classes;
		public Long getsId() {
			return sId;
		}
		public void setsId(Long sId) {
			this.sId = sId;
		}
		public String getsName() {
			return sName;
		}
		public void setsName(String sName) {
			this.sName = sName;
		}
		public String getsAge() {
			return sAge;
		}
		public void setsAge(String sAge) {
			this.sAge = sAge;
		}
		public Classes getClasses() {
			return classes;
		}
		public void setClasses(Classes classes) {
			this.classes = classes;
		}
	    
}
