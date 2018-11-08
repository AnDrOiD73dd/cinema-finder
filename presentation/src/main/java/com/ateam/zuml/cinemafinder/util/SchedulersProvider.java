package com.ateam.zuml.cinemafinder.util;

import io.reactivex.Scheduler;

public interface SchedulersProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
