package IN.JIMINCHOI.ONLINEBOOKSTORE.config;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import IN.JIMINCHOI.ONLINEBOOKSTORE.entity.Book;


// entity = 개방형 시스템 간 상호 접속의 계층 구조에서 서비스를 받거나 서비스를 제공하는 하나의 단위.
@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {		
		/*
		 * This method that we will pass the entity name 
		 * which you want to expose the Id.
		 * let's specify the book entity.class.
		 * WE CAN DO AUTOMATICALLY EXPOSE ID BY CREATING
		 * A NEW ENTITY.
		 * 
		 */
		//config.exposeIdsFor(Book.class);
		//config.exposeIdsFor(Book.class);
		
		/*
		 * What I have done is I make the use of this
		 * entity manager to get all the entity and  
		 * also make the use of the stream from java 8
		 * And I got the java type and then will convert
		 * it into the array. So this will expose all IDs
		 * in all the entity.
		 */
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
				.map(Type::getJavaType)
				.toArray(Class[]::new));
		
		
	}

}
