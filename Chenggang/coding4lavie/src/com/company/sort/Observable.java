package com.company.sort;

public class Observable {
    public interface Listener {
        void call();
    }

    static Observable.Listener mListener = null;

    public static Observable create (Listener listener) {
        mListener = listener;
        return new Observable();
    }
}
