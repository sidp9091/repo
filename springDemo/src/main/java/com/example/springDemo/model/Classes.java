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
@Table(name = "Classes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
public class Classes  implements Serializable {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	 	@Column(name="class_id")
	    private Long classId;
	 	@Column(name="class_nm")
	    private String className;
	 	@JsonIgnore
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name = "teacher_id", insertable = false, updatable = false)
		private Teachers teachers;
		public Long getClassId() {
			return classId;
		}
		public void setClassId(Long classId) {
			this.classId = classId;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public Teachers getTeachers() {
			return teachers;
		}
		public void setTeachers(Teachers teachers) {
			this.teachers = teachers;
		}
		
	    
}
