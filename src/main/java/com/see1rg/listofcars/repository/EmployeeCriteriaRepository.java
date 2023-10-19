package com.see1rg.listofcars.repository;

import com.see1rg.listofcars.model.EmployeePage;
import com.see1rg.listofcars.model.EmployeeSearchCriteria;
import com.see1rg.listofcars.model.entity.Employee;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeCriteriaRepository {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public EmployeeCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Employee> findAllWithFilters(EmployeePage employeePage,
                                             EmployeeSearchCriteria employeeSearchCriteria) {

        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);


        Predicate predicate = getPredicate(employeeSearchCriteria, employeeRoot);
        criteriaQuery.where(predicate);
        setOrder(employeePage, criteriaQuery, employeeRoot);

        TypedQuery<Employee> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(employeePage.getPageNumber() * employeePage.getPageSize());
        typedQuery.setMaxResults(employeePage.getPageSize());

        List<Employee> employees = typedQuery.getResultList();

        Pageable pageable = getPageable(employeePage);

        long employeesCount = getEmployeesCount(predicate);
        return new PageImpl<>(employees, pageable, employeesCount);
    }

    private Predicate getPredicate(EmployeeSearchCriteria employeeSearchCriteria, Root<Employee> employeeRoot) {

        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(employeeSearchCriteria.getFullName())) {
            predicates.add(criteriaBuilder.like(employeeRoot.get("fullName"),
                    "%" + employeeSearchCriteria.getFullName() + "%"));
        }

        if (Objects.nonNull(employeeSearchCriteria.getDescription())) {
            predicates.add(criteriaBuilder.like(employeeRoot.get("description"),
                    "%" + employeeSearchCriteria.getDescription() + "%"));
        }

        if (Objects.nonNull(employeeSearchCriteria.getExperience())) {
            predicates.add(criteriaBuilder.equal(employeeRoot.get("experience"),
                    employeeSearchCriteria.getExperience()));
        }

        if (Objects.nonNull(employeeSearchCriteria.getDepartmentId())) {
            predicates.add(criteriaBuilder.equal(employeeRoot.get("departmentId"),
                    employeeSearchCriteria.getDepartmentId()));
        }

        if (Objects.nonNull(employeeSearchCriteria.getManagerId())) {
            predicates.add(criteriaBuilder.equal(employeeRoot.get("managerId"),
                    employeeSearchCriteria.getManagerId()));
        }

        if (Objects.nonNull(employeeSearchCriteria.getSalary())) {
            predicates.add(criteriaBuilder.equal(employeeRoot.get("salary"),
                    employeeSearchCriteria.getSalary()));
        }


        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private long getEmployeesCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Employee> countRoot = countQuery.from(Employee.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private Pageable getPageable(EmployeePage employeePage) {
        Sort sort = Sort.by(employeePage.getSortDirection(), employeePage.getSortBy());
        return PageRequest.of(employeePage.getPageNumber(), employeePage.getPageSize(), sort);
    }

    private void setOrder(EmployeePage employeePage, CriteriaQuery<Employee> criteriaQuery,
                          Root<Employee> employeeRoot) {

        if (employeePage.getSortDirection() == Sort.Direction.ASC) {
            criteriaQuery.orderBy(criteriaBuilder.asc(employeeRoot.get(employeePage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(employeeRoot.get(employeePage.getSortBy())));
        }
    }
}
