package org.odk.collect.android.myapplication.activitygroup;

import android.content.Context;

import org.odk.collect.android.application.Collect;
import org.odk.collect.android.myapplication.activitygroup.model.Activitygroup;
import org.odk.collect.android.myapplication.database.PracticalActionDatabase;
import org.odk.collect.android.myapplication.database.base.BaseLocalDataSourceRX;
import org.odk.collect.android.myapplication.database.dao.ActivityGroupDAO;

import java.util.ArrayList;

import io.reactivex.Completable;

public class ActivityGroupLocalSouce implements BaseLocalDataSourceRX<Activitygroup> {
    private static ActivityGroupLocalSouce INSTANCE = null;
    private final ActivityGroupDAO dao;


    public static ActivityGroupLocalSouce getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ActivityGroupLocalSouce();
        }
        return INSTANCE;
    }

    private ActivityGroupLocalSouce() {
        Context context = Collect.getInstance();
        PracticalActionDatabase database = PracticalActionDatabase.getDatabase(context);//todo inject context
        this.dao = database.getActivityGroupDAO();
    }


    @Override
    public Completable save(Activitygroup... items) {
        return Completable.fromAction(() -> dao.insert(items));
    }

    @Override
    public Completable save(ArrayList<Activitygroup> items) {
        return Completable.fromAction(() -> dao.insert(items));
    }
}
