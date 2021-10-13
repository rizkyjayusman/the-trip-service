package com.cygnus.tripservice.trip;
import com.cygnus.tripservice.exception.CollaboratorCallException;
import com.cygnus.tripservice.user.User;

import java.util.ArrayList;
import java.util.List;

public class TripDAO {

    public static List<Trip> findTripsByUser(User user) {
        throw new CollaboratorCallException(
                "TripDAO should not be invoked on an unit test.");
    }

}
