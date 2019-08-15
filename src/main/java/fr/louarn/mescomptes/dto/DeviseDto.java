package fr.louarn.mescomptes.dto;

import lombok.*;

// Lombok annotations
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DeviseDto {


    private String code;

    private String libelle;

}
