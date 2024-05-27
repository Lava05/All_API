package com.api.Hibernate.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Data
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

        @Column(name="employee_id")
        private Integer employeeID;

        @Setter
        @Getter
        @Column(name="first_name")
        private String firstName;

        @Getter
        @Setter
        @Column(name="last_name")
        private String lastName;

        @Column(name="age")
        private int age;

        @Column(name="mobile_no")
        private String mobileNo;

        public User(String firstName, String lastName,int age,String mobileNo) {
            super();
            this.firstName = firstName;
            this.lastName = lastName;
            this.age=age;
            this.mobileNo=mobileNo;
        }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }


}
