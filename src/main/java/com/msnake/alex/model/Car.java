package com.msnake.alex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Order Model
 *
 * @author shigaevak
 * @since 29.05.2017
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "car")
public class Car implements Serializable{

    /**
     * Order id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Order name
     */
    private String name;

    /**
     * Order full name
     */
    private String fullName;

}
