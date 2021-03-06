package com.excilys.formation.core.dtos;

import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompanyDTO {

    private String name;
    private long id;
    private static Logger logger = LoggerFactory.getLogger(CompanyDTO.class);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static CompanyDTO getCompanyDTOFromString(String companyIdStr) {
        CompanyDTO companyDTO = new CompanyDTO();
        try {
            long id = Long.parseUnsignedLong(companyIdStr);
            logger.info("Add computer id : {}", id);
            if (id != 0) {
                companyDTO.setId(id);
            } else {
                companyDTO = null;
            }
        } catch (NumberFormatException e) {
            logger.info("company dto null");
            companyDTO = null;
        }
        return companyDTO;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Id=").append(this.id).append(", name=").append(this.name);
        return str.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CompanyDTO)) {
            return false;
        }
        CompanyDTO company = (CompanyDTO) o;
        return (this.name.equals(company.name) && this.id == company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
