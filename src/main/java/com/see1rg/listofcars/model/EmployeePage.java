package com.see1rg.listofcars.model;

import org.springframework.data.domain.Sort;

public class EmployeePage {
    private int pageNumber = 0;
    private int pageSize = 20;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "fullName";

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
