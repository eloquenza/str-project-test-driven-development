package hsh.master.exercise.str.externalServices;

public class BlacklistImpl implements Blacklist {

    @Override
    public boolean isOnBlacklist(String name) {
        return false;
    }
}
