package edu.uniupo.coltivazioni.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExecutionTimeModel {
    private LocalTime startTime;
    private LocalTime endTime;

}
