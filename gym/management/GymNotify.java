package gym.management;

import gym.customers.Client;
import gym.management.Sessions.Session;

import java.util.ArrayList;
/**
 *This class provides static methods to send notifications to gym clients or session participants.
 *The methods handle different scenarios, such as notifying all clients, notifying based on session date,
 *or notifying participants of a specific session.
 */
public class GymNotify {
    // Sends a general notification to all clients in the gym.
    // Adds a log to logs arrayList if the message was sent.
    public static void notify(String str, ArrayList<Client> allClients, ArrayList<String> logs){
        boolean flag=false;
        for(int i=0; i<allClients.size();i++){
            allClients.get(i).update(str);
            flag=true;
        }

        if (flag){
            logs.add("A message was sent to all gym clients: Happy New Year to all our valued clients!");
        }

    }

    // Sends a notification to clients registered for sessions on a specific date.
    // Adds a log entry if the message was sent.
    public static void notify(String str1, String str2,ArrayList<Client> allClients, ArrayList<String> logs ){

        boolean flag=false;
        for (int i=0; i<allClients.size(); i++){
            for (int j=0; j<allClients.get(i).getpersonalSessionList().size();j++){

                String sub=allClients.get(i).getpersonalSessionList().get(j).getDate().substring(0,10);
                if (str1.equals(sub) && !allClients.get(i).getNotifications().contains(str2)){
                    allClients.get(i).update(str2);
                    flag=true;
                }
            }

        }
        if (flag){
            logs.add("A message was sent to everyone registered for a session on "+PatternModify.strPattern(str1+"T11:11").substring(0,10)+" : Heavy traffic reported around the gym today. Plan ahead to avoid missing your session!");//neww
        }

    }
    // Sends a notification to all participants of a specific session.
    // Adds a log entry with session details.
    public static void notify(Session s, String str, ArrayList<String> logs){
        for(int i=0; i<s.getPartArr().size();i++){
            s.getPartArr().get(i).update(str);
        }
        logs.add("A message was sent to everyone registered for session "+s.getType()+" on "+PatternModify.strPattern(s.getDate())+" : The instructor will be a few minutes late for the session");

    }


}
