package com.nishantkp.bus;

import android.annotation.SuppressLint;
import android.util.SparseArray;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * Use this class for implementing bus architecture
 * It implements Rx publish and subscribe fundamentals
 * <p>
 * Here channel_id '0' is reserved for DEFAULT channel
 */
public final class Bus {
    private static final int DEFAULT = 0;  /* Default channel Id */
    private static final CopyOnWriteArrayList<Integer> sChannelList = new CopyOnWriteArrayList<>();
    private static SparseArray<PublishSubject<Object>> sSubjectMap = new SparseArray<>();
    private static ConcurrentHashMap<Object, CompositeDisposable> sSubscriptionsMap =
            new ConcurrentHashMap<>();

    private Bus() {
        // hidden constructor
    }

    /**
     * Get the chanel or create it if it's not already in memory.
     */
    @SuppressLint("CheckResult")
    @NonNull
    private static PublishSubject<Object> getChannel(int channelId) {

        // Maintain a copy of available channels
        if (!sChannelList.contains(channelId)) {
            sChannelList.add(channelId);
        }

        PublishSubject<Object> subject = sSubjectMap.get(channelId);
        if (subject == null) {
            subject = PublishSubject.create();
            subject.subscribeOn(AndroidSchedulers.mainThread());
            sSubjectMap.put(channelId, subject);
        }
        return subject;
    }

    /**
     * Get the CompositeDisposable or create it if it's not already in memory.
     */
    @NonNull
    private static CompositeDisposable getCompositeDisposable(@NonNull Object lifecycle) {
        CompositeDisposable compositeDisposable = sSubscriptionsMap.get(lifecycle);
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
            sSubscriptionsMap.put(lifecycle, compositeDisposable);
        }
        return compositeDisposable;
    }

    /**
     * Subscribe to the specified channel and listen for updates on that channel. Pass in an
     * channel to associate your registration with, so that you can unsubscribe later.
     * <br/><br/>
     * <b>Note:</b> Make sure to call {@link Bus#unregister(Object)} to avoid memory leaks.
     */
    public static void observe(@IntRange(from = 1, to = Integer.MAX_VALUE) int channelId,
                               @NonNull Object lifecycle,
                               @NonNull Consumer<Object> action) {
        Disposable disposable = getChannel(channelId).subscribe(action);
        getCompositeDisposable(lifecycle.toString() + channelId).add(disposable);
    }

    /**
     * Subscribe to the specified channel and listen for updates on that channel. Pass in an
     * channel to associate your registration with, so that you can unsubscribe later.
     * <br/><br/>
     * <b>Note:</b> Make sure to call {@link Bus#unregister(Object)} to avoid memory leaks.
     *
     * @param channelId  Id of a channel you want to listen to
     * @param lifecycle  object instance
     * @param eventClass class into which you want to cast your result
     * @param action     consumer
     */
    @SuppressWarnings("unchecked")
    public static <T> void observe(@IntRange(from = 1, to = Integer.MAX_VALUE) int channelId,
                                   @NonNull Object lifecycle,
                                   @NonNull Class<T> eventClass,
                                   @NonNull Consumer<T> action) {
        Disposable disposable = getChannel(channelId)
                .filter(o -> o.getClass().equals(eventClass))
                .map(o -> (T) o)
                .subscribe(action);
        getCompositeDisposable(lifecycle.toString() + channelId).add(disposable);
    }

    /**
     * Subscribe to the default channel and listen for updates on that channel.
     * <br/><br/>
     * <b>Note:</b> Make sure to call {@link Bus#unregister(Object)} to avoid memory leaks.
     */
    public static void observe(@NonNull Object lifecycle,
                               @NonNull Consumer<Object> action) {
        Disposable disposable = getChannel(DEFAULT).subscribe(action);
        getCompositeDisposable(lifecycle.toString() + DEFAULT).add(disposable);
    }

    /**
     * Subscribe to the default channel and listen for updates on that channel.
     * <br/><br/>
     * <b>Note:</b> Make sure to call {@link Bus#unregister(Object)} to avoid memory leaks.
     *
     * @param lifecycle  object instance
     * @param eventClass class into which you want to cast your result
     * @param action     consumer
     */
    @SuppressWarnings("unchecked")
    public static <T> void observe(@NonNull Object lifecycle,
                                   @NonNull Class<T> eventClass,
                                   @NonNull Consumer<T> action) {
        Disposable disposable = getChannel(DEFAULT)
                .filter(o -> o.getClass().equals(eventClass))
                .map(o -> (T) o)
                .subscribe(action);
        getCompositeDisposable(lifecycle.toString() + DEFAULT).add(disposable);
    }

    /**
     * Unregisters this object from the bus, removing all subscriptions.
     * This should be called when the object is going to go out of memory.
     */
    public static void unregister(@NonNull Object lifecycle) {
        // We have to remove the composition from the map, because once you dispose it can't be
        // used anymore
        for (Integer channelId : sChannelList) {
            CompositeDisposable compositeDisposable =
                    sSubscriptionsMap.remove(lifecycle.toString() + channelId);
            if (compositeDisposable != null) {
                compositeDisposable.dispose();
            }
        }
    }

    /**
     * Publish an object to the specified channel for all subscribers of that channel.
     */
    public static void post(@IntRange(from = 1, to = Integer.MAX_VALUE) int channelId,
                            @NonNull Object message) {
        getChannel(channelId).onNext(message);
    }

    /**
     * Publish an object to the default channel for all subscribers of that channel.
     */
    public static void post(@NonNull Object message) {
        getChannel(DEFAULT).onNext(message);
    }
}
