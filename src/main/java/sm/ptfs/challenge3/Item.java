package sm.ptfs.challenge3;

import lombok.NonNull;

public record Item(String prefix, @NonNull String base, String suffix) {

    @Override
    public String toString() {
        return (prefix != null ? prefix : "")  + ' ' + base + ' ' + (suffix != null ? suffix : "");
    }
}
