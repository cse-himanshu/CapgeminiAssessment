package org.assignment.assignment_first;

import jakarta.persistence.*;

public class App {
    public static void main( String[] args ){
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    	EntityManager em = emf.createEntityManager();
    	
    	Employee employee = new Employee("Arjun", "123456789");
    	IdCard idCard = new IdCard("987654321", "12-2-2026");
    	
    	employee.setIdCard(idCard);
    	idCard.setEmployee(employee);
    	
    	em.getTransaction().begin();
    	
    	em.persist(employee);
    	em.persist(idCard);
    	
    	em.getTransaction().commit();

    	
    	System.out.println("Employee Created Successfully");
    	
    	Employee emp = em.get(Employee.class, 1);
    	IdCard idc = em.get(IdCard.class, 1);
    	
    	System.out.println("Employee Details: ");
    	System.out.println("Id: " + idc.getId());
    	System.out.println("Name: " + idc.getEmployee().getName());
    	System.out.println("Email: " + idc.getEmployee().getEmail());
    	System.out.println();
    	System.out.println("ID Card Details: ");
    	System.out.println("Card Number: " + emp.getIdCard().getCardNumber());
    	System.out.println("Issue Date: " + emp.getIdCard().getIssueDate());
    	
    	em.close();

    }
}
