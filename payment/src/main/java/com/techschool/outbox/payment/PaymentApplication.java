package com.techschool.outbox.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

}



@Entity(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Payment {

	@Id
	@GeneratedValue
	private Integer id;

	private Integer orderId;

	private BigDecimal price;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;

}

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
interface PaymentRepository extends JpaRepository<Payment, Integer> {

}