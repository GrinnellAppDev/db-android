package edu.grinnell.appdev.grinnelldirectory.Interfaces;

import java.util.List;

import edu.grinnell.appdev.grinnelldirectory.Model.Person;
import edu.grinnell.appdev.grinnelldirectory.User;

/**
 * Created by nicholasroberson on 2/15/17.
 */

public interface APICallerInterface {

    List<Person> simpleSearchCallSuccess(List<Person> people);

    List<Person> advancedSearchCallSuccess(List<Person> people);

    boolean authenticateUserCallSuccess(List<Person> people);

    String simpleSearchCallFailure(String fail_message);

    String advancedSearchCallFailure(String fail_message);

    boolean authenticateUserCallFailure(String fail_message);

    boolean connectionError(String fail_message);
}
