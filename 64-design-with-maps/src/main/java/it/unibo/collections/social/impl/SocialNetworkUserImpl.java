/**
 *
 */

package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 *
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     *
     * think of what type of keys and values would best suit the requirements
     */
    private Map <String, Collection<U>> groupFollowing; 
    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        groupFollowing = new HashMap<>(); 
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        this(name, surname, user, -1);
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        Collection<U> followedUsersInGroup = this.getUsersInGroup(circle); // Not using the public this.getFollowedUsersInGroup() because there's no need of a copy
        if (followedUsersInGroup.isEmpty()) {
            groupFollowing.put(circle, followedUsersInGroup);
        }
        boolean exists = followedUsersInGroup.add(user);
        return exists;
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        return new HashSet<>(this.getUsersInGroup(groupName)); // safe-copy for outer use
    }

    private Collection<U> getUsersInGroup(final String groupName) {
        Collection<U> followedInGroup = groupFollowing.get(groupName);
        return followedInGroup != null 
            ? followedInGroup
            : new HashSet<>(); // Set because you can't follow the same user in the same group more than one time
    }

    @Override
    public List<U> getFollowedUsers() {
        List<U> followedUsers = new LinkedList<>(); // Linked cause we're gonna add only
        for (Collection<U> u : groupFollowing.values()) {
            followedUsers.addAll(u); // FIXME O(n^2)?
        }
        return followedUsers;
    }
}
