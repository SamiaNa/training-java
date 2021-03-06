package com.excilys.formation.core.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import javax.persistence.ForeignKey;



@Entity
@Table(name = "computer")
public class Computer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long id;
	@Column(name = "name")
    private String name;
	@Column(name = "introduced")
    private LocalDate introduced;
	@Column(name = "discontinued")
    private LocalDate discontinued;
    @ManyToOne(optional = true)
    @JoinColumn(name="company_id", foreignKey=@ForeignKey(name="fk_computer_company_1"))
    private Company company;

    public Computer() {
        super();
    }

    public Computer(long id, String name, LocalDate introduced, LocalDate discontinued, Company company) {
        this.id = id;
        this.name = name;
        this.introduced = introduced;
        this.discontinued = discontinued;
        this.company = company;
    }

    public Computer(String name, LocalDate introduced, LocalDate discontinued, Company company) {
        this.id = -1;
        this.name = name;
        this.introduced = introduced;
        this.discontinued = discontinued;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getIntroduced() {
        return introduced;
    }

    public void setIntroduced(LocalDate introduced) {
        this.introduced = introduced;
    }

    public LocalDate getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(LocalDate discontinued) {
        this.discontinued = discontinued;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Id=").append(this.id).append(", name=").append(this.name).append(", introduced=")
        .append(this.introduced).append(", discontinued=").append(this.discontinued).append(", company= ")
        .append(this.company);
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Computer)) {
            return false;
        }
        Computer computer = (Computer) o;
        return (this.id == computer.id &&
                this.name.equals(computer.name) &&
                this.introduced.equals(computer.introduced) &&
                this.discontinued.equals(computer.discontinued) &&
                this.company.equals(computer.company));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, introduced, discontinued, company);
    }

    public static class ComputerBuilder{
        private long id;
        private String name;
        private LocalDate introduced;
        private LocalDate discontinued;
        private Company company;

        public ComputerBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public ComputerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ComputerBuilder withIntroduced(LocalDate introduced) {
            this.introduced = introduced;
            return this;
        }

        public ComputerBuilder withDiscontinued(LocalDate discontinued) {
            this.discontinued = discontinued;
            return this;
        }

        public ComputerBuilder withCompany(Company company) {
            this.company = company;
            return this;
        }

        public Computer build() {
            Computer computer = new Computer();
            computer.setId(id);
            computer.setName(name);
            computer.setIntroduced(introduced);
            computer.setDiscontinued(discontinued);
            computer.setCompany(company);
            return computer;
        }

    }

}
