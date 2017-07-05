package com.msnake.alex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Catalog model
 *
 * @author shigaevak
 * @since 05.07.2017
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
@Table(name = "catalog")
@ApiModel(value = "Catalog")
public class Catalog implements Serializable {

    /**
     * Catalog id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Catalog Id", dataType = "Integer")
    private Integer id;

    /**
     * Catalog name
     */
    @ApiModelProperty(value = "Catalog name", dataType = "String")
    private String name;

    /**
     * Catalog head Id
     */
    @ApiModelProperty(value = "Catalog head Id", dataType = "Integer")
    private Integer headId;
}
