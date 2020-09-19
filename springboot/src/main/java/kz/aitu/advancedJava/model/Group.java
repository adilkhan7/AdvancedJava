package kz.aitu.advancedJava.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {
    @Id
    private long id;
    private String name;
}
