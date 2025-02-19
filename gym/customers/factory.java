package gym.customers;
import gym.customers.Client;
import gym.customers.Gender;
import gym.customers.Instructor;
import gym.customers.Person;
import gym.management.Gym;
import gym.management.Secretary;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;

/**
 * This class provides static factory methods to create instances of various roles in the gym,
 * such as Instructor, Secretary, and Client.
 */
public class factory {

    public static Instructor createInstructor(Person p1, int p_rate, ArrayList<SessionType> arr) {
        return Instructor.myContructor(p1, p_rate, arr);
    }
    public static Client createClient(Person p1) {
        return Client.myContructor(p1);
    }
}

