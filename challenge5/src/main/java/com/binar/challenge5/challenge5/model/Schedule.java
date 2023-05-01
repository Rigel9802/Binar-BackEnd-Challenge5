package com.binar.challenge5.challenge5.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Schedule {
    @Id
    @SequenceGenerator(name = "schedule_sequence", sequenceName = "schedule_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "schedule_sequence")
    private Long scheduleId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private String studio;
    private Integer price;
    private Long movieFk;
    private String[] seats;

    public List<String> getSeats() {
        List<String> temp = new ArrayList<>();
        char var = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp.add(String.valueOf(var + "" + (j + 1)));
            }
            var++;
        }
        return temp;
    }



    //    @OneToMany(cascade = CascadeType.ALL, targetEntity = Seat.class, orphanRemoval = true)
    //    @JoinColumn(name = "scheduleFk", referencedColumnName = "scheduleId")
    //    private List<Seat> seats;


    public Schedule(Time startTime, Time endTime, String studio, Integer price, Long movieFk) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.studio = studio;
        this.price = price;
        this.movieFk = movieFk;
    }

    public Schedule(Date date, Time startTime, Time endTime, String studio, Integer price, Long movieFk) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.studio = studio;
        this.price = price;
        this.movieFk = movieFk;
    }


}
