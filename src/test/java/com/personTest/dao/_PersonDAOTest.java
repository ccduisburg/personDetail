package com.personTest.dao;


import com.personTest.model.PersonStudent;
import com.personTest.model.Personadress;
import com.personTest.model.Personschule;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class _PersonDAOTest {

    private PDAO<PersonStudent, Integer> dao;

    @Before
    public void setUp() {
        dao = new  _PersonDAO();
    }
    @After
    public void tearDown() {
        dao = null;
    }
    @Test
    public void create() {
        Personschule personschule = new Personschule("foobar schule", "leite 1");
        PersonStudent personStudent = new PersonStudent("foo", "bar", "foobar schule",4);
        Personadress personadress = new Personadress("strasse 1", "123", 123);
        personschule.setStudent(Stream.of(personStudent).collect(Collectors.toSet()));
        personStudent.setSchule(personschule);
        personStudent.setAdress(personadress);
        dao.create(personStudent);

        List<PersonStudent> all = dao.findAll();
        assertThat(all.size(), Is.is(1));
        assertThat(all.get(0).getName(), Is.is("foo"));
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void find() {
    }

    @Test
    public void findByName() {
    }

    @Test
    public void findAll() {
    }
}