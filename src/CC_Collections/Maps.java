package CC_Collections;

import java.util.HashMap;

public class Maps {
    public static void main(String[] args) {

        HashMap<String, String> states = new HashMap<String, String>();

        /// INPUT ///
        states.put("OR", "Oregon");
        states.put("WA", "Washington");

        /// OUTPUT ///
        System.out.println(states.get("WA"));
    }
}