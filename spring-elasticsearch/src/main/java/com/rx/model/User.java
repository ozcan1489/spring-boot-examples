package com.rx.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;

@Document(indexName = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

    @Id
    private String id;
    private String name;
    private String surname;
    private String address;
    private Date birthday;
}
