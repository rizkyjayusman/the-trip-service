package com.cygnus.tripservice.trip;

import com.cygnus.tripservice.exception.CollaboratorCallException;

import java.util.ArrayList;
import java.util.List;


import com.cygnus.tripservice.exception.UserNotLoggedInException;
import com.cygnus.tripservice.user.User;
import com.cygnus.tripservice.user.UserSession;

public class TripService {

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        List<Trip> tripList = new ArrayList<Trip>();
        User loggedUser = UserSession.getInstance().getLoggedUser();
        boolean isFriend = false;
        if (loggedUser != null) {
            for (User friend : user.getFriends()) {
                if (friend.equals(loggedUser)) {
                    isFriend = true;
                    break;
                }
            }
            if (isFriend) {
                tripList = TripDAO.findTripsByUser(user);
            }
            return tripList;
        } else {
            throw new UserNotLoggedInException();
        }
    }

}