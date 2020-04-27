package IN.JIMINCHOI.ONLINEBOOKSTORE.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* 
 * You do not need to make getter and setter and toString method again.
 */

import lombok.Getter; 
import lombok.Setter;  
import lombok.ToString; 

@Entity // 개방형 시스템 간 상호 접속의 계층 구조에서 서비스를 받거나 서비스를 제공하는 하나의 단위.
@Table(name = "tbl_book") // This is for Table name.

/* 
 * You do not need to make 
 * getter and setter and toString method again.
 * because of Lombok from application.property.
 */
@Setter
@Getter
@ToString

public class Book {
	
	
	/*
	 * add id annotation to this id field that will make
	 * the Id field as a primary key which is related mysql.
	 */
	
	@Id
	
	/*
	 * This is working as auto generated the column 
	 * btw mysql column and spring boot. 
	 */
	@GeneratedValue(strategy = GenerationType.AUTO) 
	
	/*
	 * If the sb and sql of name are same we do not need to do the mapping 
	 * However, IF it is not same of name btw sb and sql,
	 * we need to do mapping.
	 */
	
	private Long id;  
	
	private String sku;
	
	private String name;
	
	private String description;
	
	
	@Column(name = "unit_price") // This is annotation.
	private BigDecimal unitPrice;
	
	@Column(name = "image_url") // This is annotation.
	private String imageUrl;
	
	
	private boolean active;
	
	@Column(name = "units_in_stock")
	private int unitsInStock;
	
	@Column(name = "date_created")
	private Date createdOn;
	
	@Column(name = "last_updated")
	private Date updatedOn;
		
	
	@ManyToOne // Many to One
	@JoinColumn(name = "category_id" , nullable = false)
	private BookCategory category;
	
	
}
