# spring-jpa-join

# Getting Started


1) creating the database:

* CREATE THE DATABASE */

CREATE DATABASE <database_name>

/*CREATE THE CUSTOMERS TABLE */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*DATA FOR THE TABLE `customers` */

insert  into `customers`(`customer_id`,`customer_name`) values 

(1,'Maruthi Sayampu'),
(2,'Gopaala Sayampu'),
(3,'Sreeprada Sayampy'),
(4,'Vara Sayampu'),
(5,'Eswaramma Sayampu');

/*CREATE THE ORDERS TABLE */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `required_date` date NOT NULL,
  `shipped_date` date DEFAULT NULL,
  `order_status` varchar(15) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  CONSTRAINT FK FOREIGN KEY (customer_id)
  REFERENCES customers (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*DATA FOR THE TABLE `orders` */

insert  into `orders`(`order_id`,`required_date`,`shipped_date`,`order_status`,`customer_id`) values 

(10100,'2003-01-06','2003-01-13','Shipped',1),
(10101,'2003-01-09','2003-01-18','Shipped',2),
(10102,'2003-01-10','2003-01-18','Shipped',2),
(10103,'2003-01-29','2003-02-07','Shipped',3),
(10104,'2003-01-31','2003-02-09','Shipped',5);

2) Enabling the Swagger API 

@Bean
	public Docket JPAApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
	            .paths(PathSelectors.any())
	            .build();            
	} 

3) Entities
  1) Customer Entity
  2) Order Entity 
  
    Here customer has @OneToMany relation with Order by join column is  customer_id 
    
    @OneToMany (fetch = FetchType.LAZY)
	@JoinColumn (name = "customer_id",  referencedColumnName="customer_id")
	private Set<OrderEntity> ordersList;
	
	Note : The name parameter is the name we want to give the referenced column for JPA to use. The referenced column is what the column is called in the database.
	
	FetchType.EAGER - It describes that data should be initialized on the spot
	FetchTyp.LAZY - It describes that data should be initialized as late as possible ( as soon as child entiry started accessing it )
    
  Thank you. Please reach me on maruthi.sayampu@gmail.com for happy coding
  
