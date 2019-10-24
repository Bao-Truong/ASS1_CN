/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_assignment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author dell
 */
public class ServerInfo {

    /**
     *
     */
    private static ParseRoute pr = ParseRoute.getInstance();
    public static String IP = "10.1.1.25";
    public static Object getIP() throws UnknownHostException
    {
        return InetAddress.getLocalHost();
    }
   
     
    //public static String IP = ;
}
