package com.bamzy.controller;

import com.bamzy.utils.JDBCUtil;
import com.bamzy.webo.Person;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean(name = "personController")
@SessionScoped
public class PersonController {
    ArrayList<Person> persons;

    public void loadPersons(){
        JDBCUtil jdbcUtil = new JDBCUtil();
        jdbcUtil.StartBdd();
    }
}
