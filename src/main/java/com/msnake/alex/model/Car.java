package com.msnake.alex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Car")
public class Car implements Serializable{

    /**
     * Car id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Car Id", dataType = "Integer")
    private Integer id;

    /**
     * Car name
     */
    @ApiModelProperty(value = "Car name", dataType = "String")
    private String name;

    /**
     * Car full name
     */
    @ApiModelProperty(value = "Car full name", dataType = "String")
    private String fullName;

}
